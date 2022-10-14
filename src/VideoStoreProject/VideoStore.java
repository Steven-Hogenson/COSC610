package VideoStoreProject;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author Steven Hogenson on 10/4/2022
 */
public class VideoStore {

    private static String typeOfList = "";
    static SLL videoSLL = new SLL();
    static SLL storeVideosSLL = new SLL();
    static SLL customerSLL = new SLL();
    static DLL videoDLL = new DLL();
    static DLL storeVideoDLL = new DLL();
    static DLL customerDLL = new DLL();
    private static long videoIdCounter = 0;
    private static long customerIdCounter = 0;
    private static final Video v = new Video("", "");
    private static final Customer c = new Customer("", "");

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        /*
        if()
        if (args.length == 1) {
            typeOfList = args[0];
        } else if (args.length == 4) {
            typeOfList = args[0];
            videoCount = Integer.parseInt(args[1]);
            customerCount = Integer.parseInt(args[2]);
            requestCount = Integer.parseInt(args[3]);
        } else {
            System.out.println("INVALID ARGUMENTS");
            System.exit(0);
        }

        if (typeOfList.equals("SLL")) {
            videoSLL = new SLL();
            customerSLL = new SLL();
        } else if (typeOfList.equals("DLL")) {
            videoDList = new DList();
            customerDList = new DList();
        } else {
            System.out.println("INVALID ARGUMENT");
            System.exit(0);
        }

         */
        System.out.print("Type of list... SLL or DLL: ");
        //typeOfList = sc.nextLine();
        typeOfList = "SLL";
        int scanInput;
        while (true) {
            printOptions();
            scanInput = Integer.parseInt(sc.nextLine());

            switch (scanInput) {
                case 1 -> {
                    System.out.print("Enter title of video: ");
                    String videoName = sc.nextLine().trim();
                    setVideoInStore(videoName, createVideoID());
                }
                case 2 -> {
                    System.out.print("Enter ID of video to delete: ");
                    String videoID = sc.nextLine().trim();
                    if (getVideo((videoID)) != null && getVideo(videoID).isAvailable()) {
                        deleteVideo(videoID);
                    } else {
                        System.out.println("Could not delete video");
                    }

                }
                case 3 -> {
                    System.out.print("Enter name of customer: ");
                    String customerName = sc.nextLine().trim();
                    addCustomer(customerName, createCustomerID());
                }
                case 4 -> {
                    System.out.print("Enter customer id to delete: ");
                    String customerID = sc.nextLine().trim();
                    deleteCustomer(customerID);
                }
                case 5 -> {
                    System.out.print("Enter video id to check for: ");
                    String vidID3 = sc.nextLine().trim();
                    //System.out.println(checkInStore(vidID3));
                    if (typeOfList.equals("SLL"))
                        if (checkInStoreSLL(vidID3)) {
                            System.out.println("In store");
                        } else {
                            System.out.println("Not in store");
                        }
                    else if (checkInStoreDLL(vidID3))
                        System.out.println("In store");
                    else
                        System.out.println("Not in store");
                }
                case 6 -> {
                    System.out.print("Enter ID of customer: ");
                    String custID = sc.nextLine().trim();
                    System.out.print("Enter ID of video: ");
                    String vidID = sc.nextLine().trim();
                    checkOutVideo(custID, vidID);
                }
                case 7 -> {
                    System.out.print("Enter ID of video: ");
                    String videID = sc.nextLine().trim();
                    checkInVideo(videID);
                }
                case 8 -> printAllCustomers();
                case 9 -> printAllVideos();
                case 10 -> printInStore2();
                case 11 -> printRented();
                case 12 -> {
                    System.out.print("Enter ID of customer: ");
                    String customerID2 = sc.nextLine().trim();
                    if (getCustomer(customerID2) != null)
                        getCustomer(customerID2).printVideos();
                }
                case 13 -> System.exit(0);
            }
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

    static void setVideoInStore(String movieName, String id) {
        if (typeOfList.equals("SLL")) {
            videoSLL.add(new SLNode(new Video(movieName, id), null));
            storeVideosSLL.add((new SLNode(new Video(movieName, id), null)));
        } else if (typeOfList.equals("DLL")) {
            videoDLL.addLast(new DNode(new Video(movieName, id), null, null));
            storeVideoDLL.addLast(new DNode(new Video(movieName, id), null, null));
        } else {
            System.out.println("invalid");
        }

    }


    static void deleteVideo(String id) {
        switch (typeOfList) {
            case "SLL" -> {
                storeVideosSLL.deleteVideo(id);
                videoSLL.deleteVideo(id);
            }
            case "DLL" -> {
                storeVideoDLL.deleteDLL(id, v);
                videoDLL.deleteDLL(id, v);
            }
        }
    }


    static void deleteCustomer(String id) {
        if (Objects.equals(typeOfList, "SLL")) {
            customerSLL.deleteCustomer(id);
        } else if (Objects.equals(typeOfList, "DLL")) {
            customerDLL.deleteDLL(id, c);
        } else {
            System.out.println("Invalid");
        }
    }

    static void printAllVideos() {
        if (typeOfList.equals("SLL")) {
            videoSLL.print();
        } else if (typeOfList.equals("DLL")) {
            videoDLL.print();
        }
    }

    static void printAllCustomers() {
        if (typeOfList.equals("SLL")) {
            customerSLL.print();
        } else if (typeOfList.equals("DLL")) {
            customerDLL.print();
        }
    }

    private static Customer getCustomer(String id) {
        if (typeOfList.equals("SLL")) {
            return customerSLL.getCustomer(id);
        } else {
            return customerDLL.getCustomer(id);
        }
    }

    private static Video getVideo(String id) {
        if (typeOfList.equals("SLL")) {
            return videoSLL.getVideo(id);
        } else {
            return videoDLL.getVideo(id);
        }
    }

    static void addCustomer(String name, String id) {
        if (typeOfList.equals("SLL")) {
            customerSLL.add(new SLNode(new Customer(name, id), null));
        } else if (typeOfList.equals("DLL")) {
            customerDLL.addLast(new DNode(new Customer(name, id), null, null));
        } else {
            System.out.println("invalid");
        }
    }


    /**
     * Creates a unique id for each video that is added to the store
     *
     * @return a String representation of an id number
     */
    static String createVideoID() {
        return String.valueOf(videoIdCounter++);
    }

    /**
     * Creates a unique id for each customer that is added to the store
     *
     * @return a String representation of an id number
     */
    static String createCustomerID() {
        return String.valueOf(customerIdCounter++);
    }


    static void checkOutVideo(String customerID, String videoID) {
        switch (typeOfList) {
            case "SLL":
                if (getCustomer(customerID).getRentVideoSLL() == null) {
                    if (storeVideosSLL.deleteVideo(videoID)) {
                        getCustomer(customerID).createAndAddRentSLL(getVideo(videoID));
                        getVideo(videoID).setAvailable(false);
                    }

                } else {
                    if (storeVideosSLL.deleteVideo(videoID)) {
                        getCustomer(customerID).addRentSLL(getVideo(videoID));
                        getVideo(videoID).setAvailable(false);
                    }
                }
                break;
            case "DLL":
                if (getCustomer(customerID).getRentVideoDLL() == null) {
                    if (storeVideoDLL.deleteDLL(videoID, v)) {
                        getCustomer(customerID).createAndAddRentDLL(getVideo(videoID));
                        getVideo(videoID).setAvailable(false);
                        //getVideo(videoID).setAvailable(false);

                    }
                } else {
                    if (storeVideoDLL.deleteDLL(videoID, v)) {
                        getCustomer(customerID).addRentDLL(getVideo(videoID));
                        getVideo(videoID).setAvailable(false);
                    }
                }
                break;
        }
    }


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
                    storeVideoDLL.addLast((new DNode(new Video(getVideo(videoID).getTitle(), videoID), null, null)));
                    getVideo(videoID).setAvailable(true);
                }
            }

        }
    }

    static void printRented() {
        for (int i = 0; i < customerIdCounter; i++) {
            //System.out.println(getCustomer(String.valueOf(i)).getRentVideoSLL().);
            getCustomer(String.valueOf(i)).printVideos();
        }

    }

    static void printInStore2() {
        if (typeOfList.equals("SLL")) {
            storeVideosSLL.print();
        } else if (typeOfList.equals("DLL")) {
            storeVideoDLL.print();
        }
    }


    static boolean checkInStoreSLL(String id) {
        SLNode current = storeVideosSLL.getHead();
        Video v;
        if (current == null) {
            return false;
        } else {
            v = (Video) current.getElement();
        }
        while (true) {
            if (Objects.equals(v.getId(), id)) {
                return true;
            } else {
                current = current.getNext();
                if (current != null) {
                    v = (Video) current.getElement();
                } else {
                    return false;
                }
            }
        }

    }

    static boolean checkInStoreDLL(String id) {
        DNode current = storeVideoDLL.getHeader();
        Video v;
        if (current == null) {
            return false;
        } else {
            v = (Video) current.getElement();
        }
        while (true) {
            if (Objects.equals(v.getId(), id)) {
                return true;
            } else {
                //v = (Video) current.getElement();
                current = current.getNext();
                if (current != null) {
                    v = (Video) current.getElement();
                } else {
                    return false;
                }
            }
        }

    }

}
