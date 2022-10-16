package VideoStoreProject;

import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Steven Hogenson on 10/4/2022
 */
public class VideoStore {

    private static String typeOfList = "";
    private static SLL videoSLL;
    private static SLL storeVideosSLL;
    private static SLL customerSLL;
    private static DLL videoDLL;
    private static DLL storeVideosDLL;
    private static DLL customerDLL;
    private static long videoIdCounter = 0;
    private static long customerIdCounter = 0;
    private static final Video v = new Video("", "");
    private static final Customer c = new Customer("", "");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int videoCount = 0;
        int customerCount = 0;
        int operationCount = 0;
        //check length of args in order to set values appropriately
        if (args.length == 1) {
            typeOfList = args[0];
        } else if (args.length == 4) {
            typeOfList = args[0];
            videoCount = Integer.parseInt(args[1]);
            customerCount = Integer.parseInt(args[2]);
            operationCount = Integer.parseInt(args[3]);
        } else {
            System.out.println("INVALID ARGUMENTS");
            System.exit(0);
        }
        //checks args[0] for the type of list to use for the program, and initializes respective objects
        if (typeOfList.equals("SLL")) {
            videoSLL = new SLL();
            customerSLL = new SLL();
            storeVideosSLL = new SLL();
        } else if (typeOfList.equals("DLL")) {
            videoDLL = new DLL();
            customerDLL = new DLL();
            storeVideosDLL = new DLL();
        } else {
            System.out.println("INVALID ARGUMENT");
            System.exit(0);
        }
        //if there is no automatic populating (only type of list was specified)
        if (args.length == 1) {
            int scanInput;
            while (true) {
                printOptions();
                scanInput = Integer.parseInt(sc.nextLine());

                switch (scanInput) {
                    case 1 -> {
                        System.out.print("Enter title of video: ");
                        String videoName = sc.nextLine().trim();
                        addVideo(videoName, createVideoID());
                    }
                    case 2 -> {
                        System.out.print("Enter ID of video to delete: ");
                        String videoID = sc.nextLine().trim();
                        if (getVideo((videoID)) != null && getVideo(videoID).isAvailable())
                            deleteVideo(videoID);
                        else
                            System.out.println("Could not delete video");
                    }
                    case 3 -> {
                        System.out.print("Enter name of customer: ");
                        String customerName = sc.nextLine().trim();
                        addCustomer(customerName, createCustomerID());
                    }
                    case 4 -> {
                        System.out.print("Enter customer id to delete: ");
                        String customerID = sc.nextLine().trim();
                        if (getCustomer(customerID) != null)
                            deleteCustomer(customerID);
                        else
                            System.out.println("Could not delete customer");
                    }
                    case 5 -> {
                        System.out.print("Enter video id to check for: ");
                        String videoID = sc.nextLine().trim();
                        System.out.println(checkInStore(videoID));
                    }
                    case 6 -> {
                        System.out.print("Enter ID of customer: ");
                        String customerID = sc.nextLine().trim();
                        System.out.print("Enter ID of video: ");
                        String videoID = sc.nextLine().trim();
                        checkOutVideo(customerID, videoID);
                    }
                    case 7 -> {
                        System.out.print("Enter ID of video: ");
                        String videoID = sc.nextLine().trim();
                        checkInVideo(videoID);
                    }
                    case 8 -> printAllCustomers();
                    case 9 -> printAllVideos();
                    case 10 -> printInStore();
                    case 11 -> printRented();
                    case 12 -> {
                        System.out.print("Enter ID of customer: ");
                        String customerID = sc.nextLine().trim();
                        if (getCustomer(customerID) != null)
                            getCustomer(customerID).printVideos();
                    }
                    case 13 -> {
                        System.out.println("Goodbye.");
                        sc.close();
                        System.exit(0);
                    }
                }
            }
        } else {
            //automatic populating with the specified args values
            //populate lists and operationStack
            for (int i = 0; i < videoCount; i++)
                addVideo("Video Name: " + i, String.valueOf(i));
            for (int i = 0; i < customerCount; i++)
                addCustomer("Customer Name: " + i, String.valueOf(i));
            Stack<Integer> operationStack = new Stack<>();
            //operationStack is populated with random ints 5, 6, and 7 for the relevant actions/method calls
            int randomInt;
            for (int i = 0; i < operationCount; i++) {
                randomInt = ThreadLocalRandom.current().nextInt(5, 8);
                operationStack.push(randomInt);
            }

            int operation, randomVideo, randomCustomer;
            //start time
            long startTime = System.nanoTime();
            while (operationStack.size() > 0) {
                operation = operationStack.pop();
                if (operation == 5) {
                    randomVideo = ThreadLocalRandom.current().nextInt(0, videoCount);
                    checkInStore(String.valueOf(randomVideo));
                } else if (operation == 6) {
                    randomCustomer = ThreadLocalRandom.current().nextInt(0, customerCount);
                    randomVideo = ThreadLocalRandom.current().nextInt(0, videoCount);
                    checkOutVideo(String.valueOf(randomCustomer), String.valueOf(randomVideo));
                } else {
                    randomVideo = ThreadLocalRandom.current().nextInt(0, videoCount);
                    checkInVideo(String.valueOf(randomVideo));
                }
            }
            //end time
            long endTime = System.nanoTime();
            System.out.println("Total Service Time in ms: " + (endTime - startTime) / 1000000.0);
        }
    }

    static void printOptions() {
        System.out.println("""
                ===============================
                Select one of the following:
                1: To add a video
                2: To delete a video
                3: To add a customer
                4: To delete a customer
                5: To check if a particular video is in store
                6: To check out a video
                7: To check in a video
                8: To print all customers
                9: To print all videos
                10: To print in store videos
                11: To print all rented videos
                12: To print the videos rented by a customer
                13: To exit
                ===============================""");
    }

    /**
     * Adds a video object to data structure (used 2 lists for ease of use)
     *
     * @param movieName the name of movie as a String
     * @param id        the id that is auto generated and assigned to the movie
     */
    static void addVideo(String movieName, String id) {
        switch (typeOfList) {
            case "SLL" -> {
                videoSLL.add(new SLNode(new Video(movieName, id), null));
                storeVideosSLL.add(new SLNode(new Video(movieName, id), null));
            }
            case "DLL" -> {
                videoDLL.addLast(new DNode(new Video(movieName, id), null, null));
                storeVideosDLL.addLast(new DNode(new Video(movieName, id), null, null));
            }
        }
    }

    /**
     * Removes a video object from a data structure
     *
     * @param id the id inputted by the user to determine which video to delete
     */
    static void deleteVideo(String id) {
        switch (typeOfList) {
            case "SLL" -> {
                storeVideosSLL.deleteSLL(id, v);
                videoSLL.deleteSLL(id, v);
            }
            case "DLL" -> {
                storeVideosDLL.deleteDLL(id, v);
                videoDLL.deleteDLL(id, v);
            }
        }
    }

    /**
     * Adds a customer object to a data structure
     *
     * @param name the name of the customer to add to data structure
     * @param id   id number that is auto generated and assigned to a customer
     */
    static void addCustomer(String name, String id) {
        switch (typeOfList) {
            case "SLL" -> customerSLL.add(new SLNode(new Customer(name, id), null));
            case "DLL" -> customerDLL.addLast(new DNode(new Customer(name, id), null, null));
        }
    }

    /**
     * Removes a customer object from a data structure
     *
     * @param id the id inputted by the user to determine which customer to delete
     */
    static void deleteCustomer(String id) {
        switch (typeOfList) {
            case "SLL" -> customerSLL.deleteSLL(id, c);
            case "DLL" -> customerDLL.deleteDLL(id, c);
        }
    }

    /**
     * Prints all video object's data (id and name)
     */
    static void printAllVideos() {
        switch (typeOfList) {
            case "SLL" -> videoSLL.print();
            case "DLL" -> videoDLL.print();
        }
    }

    /**
     * Prints all customer object's data (id and name)
     */
    static void printAllCustomers() {
        switch (typeOfList) {
            case "SLL" -> customerSLL.print();
            case "DLL" -> customerDLL.print();
        }
    }

    /**
     * Return a customer object, used for getting a customer's videos
     *
     * @param id the customer's id to check for
     * @return a customer object whose ID number matches param id
     */
    private static Customer getCustomer(String id) {
        if (typeOfList.equals("SLL"))
            return customerSLL.getCustomer(id);
        else
            return customerDLL.getCustomer(id);
    }

    /**
     * Returns a given video from a data structure given an id number
     *
     * @param id the video's id to check for
     * @return a video object whose ID number matches param id
     */
    private static Video getVideo(String id) {
        if (typeOfList.equals("SLL"))
            return videoSLL.getVideo(id);
        else
            return videoDLL.getVideo(id);
    }

    /**
     * Creates a unique id for each video that is added to the store
     *
     * @return a String representation of an id number
     */
    private static String createVideoID() {
        return String.valueOf(videoIdCounter++);
    }

    /**
     * Creates a unique id for each customer that is added to the store
     *
     * @return a String representation of an id number
     */
    private static String createCustomerID() {
        return String.valueOf(customerIdCounter++);
    }

    /**
     * Adds video to a customer's rented list, and removes the video from being in store
     *
     * @param customerID the customer's id that is checking out
     * @param videoID    the video's id that the customer will check out
     */
    static void checkOutVideo(String customerID, String videoID) {
        switch (typeOfList) {
            case "SLL" -> {
                if (getCustomer(customerID).getRentVideoSLL() == null) {
                    if (storeVideosSLL.deleteSLL(videoID, v)) {
                        getCustomer(customerID).createAndAddRentSLL(getVideo(videoID));
                        getVideo(videoID).setAvailable(false);
                    }
                } else {
                    if (storeVideosSLL.deleteSLL(videoID, v)) {
                        getCustomer(customerID).addRentSLL(getVideo(videoID));
                        getVideo(videoID).setAvailable(false);
                    }
                }
            }
            case "DLL" -> {
                if (getCustomer(customerID).getRentVideoDLL() == null) {
                    if (storeVideosDLL.deleteDLL(videoID, v)) {
                        getCustomer(customerID).createAndAddRentDLL(getVideo(videoID));
                        getVideo(videoID).setAvailable(false);
                    }
                } else {
                    if (storeVideosDLL.deleteDLL(videoID, v)) {
                        getCustomer(customerID).addRentDLL(getVideo(videoID));
                        getVideo(videoID).setAvailable(false);
                    }
                }
            }
        }
    }

    /**
     * Adds the video back to being in store, and removes it from customer's rented list if they possess the video
     *
     * @param videoID the video's id to check in/ return to store
     */
    static void checkInVideo(String videoID) {
        if (typeOfList.equals("SLL")) {
            for (int i = 0; i < customerIdCounter; i++) {
                if (getCustomer(String.valueOf(i)).getRentVideoSLL() != null && !getVideo(videoID).isAvailable()) {
                    getCustomer(String.valueOf(i)).removeRentSLL(getVideo(videoID));
                    storeVideosSLL.add((new SLNode(new Video(getVideo(videoID).getTitle(), videoID), null)));
                    getVideo(videoID).setAvailable(true);
                }
            }
        } else if (typeOfList.equals("DLL")) {
            for (int i = 0; i < customerIdCounter; i++) {
                if (getCustomer(String.valueOf(i)).getRentVideoDLL() != null && !getVideo(videoID).isAvailable()) {
                    getCustomer(String.valueOf(i)).removeRentDLL(getVideo(videoID));
                    storeVideosDLL.addLast((new DNode(new Video(getVideo(videoID).getTitle(), videoID), null, null)));
                    getVideo(videoID).setAvailable(true);
                }
            }
        }
    }

    /**
     * Prints all videos that are currently being rented out
     */
    static void printRented() {
        for (int i = 0; i < customerIdCounter; i++)
            getCustomer(String.valueOf(i)).printVideos();
    }

    /**
     * Prints all videos that are currently not being rented out
     */
    static void printInStore() {
        switch (typeOfList) {
            case "SLL" -> storeVideosSLL.print();
            case "DLL" -> storeVideosDLL.print();
        }
    }

    /**
     * Checks for a SLNode matching the video's id that is in store
     *
     * @param id video's id to check for
     * @return boolean if the video is not currently being rented
     */
    private static boolean checkInStoreSLL(String id) {
        return storeVideosSLL.checkInStoreSLL(id, storeVideosSLL.getHead());
    }

    /**
     * Checks for a DNode matching the video's id that is in store
     *
     * @param id video's id to check for
     * @return boolean if the video is not currently being rented
     */
    private static boolean checkInStoreDLL(String id) {
        return storeVideosDLL.checkInStoreDLL(id, storeVideosDLL.getHeader());
    }

    /**
     * If the data structure is an SLL, it checks for a SLNode matching the video's properties; likewise for DLL
     *
     * @param id the video's id to check if in stock
     */
    static boolean checkInStore(String id) {
        if (typeOfList.equals("SLL")) {
            return checkInStoreSLL(id);
        } else if (typeOfList.equals("DLL")) {
            return checkInStoreDLL(id);
        }
        return false;
    }
}
