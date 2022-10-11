package VideoStoreProject;

import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

/**
 * @author Steven Hogenson on 10/4/2022
 */
public class VideoStore {
    private static SLNode n;
    private Video videoInStore;
    private Customer customer;
    private static String typeOfList = "";
    private static final int videoCount = 0;
    private static final int customerCount = 0;
    private static final int requestCount = 0;
    static SLL videoSLL = new SLL();
    static SLL customerSLL = new SLL();
    static DList videoDList = new DList();
    static DList customerDList = new DList();
    private static long videoIdCounter = 0;
    private static long customerIdCounter = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        /*
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
        if (args.length == 1 || !typeOfList.equals("")) {
            while (true) {
                printOptions();
                scanInput = Integer.parseInt(sc.nextLine());

                switch (scanInput) {
                    case 1:
                        System.out.print("Enter the video name to add: ");
                        String videoName = sc.nextLine().trim();
                        setVideoInStore(videoName, createVideoID());
                        break;
                    case 2:
                        System.out.print("Enter ID of video to delete: ");
                        String videoID = sc.nextLine().trim();
                        deleteVideo(videoID);
                        break;
                    case 3:
                        System.out.print("Enter customer's name to add: ");
                        String customerName = sc.nextLine().trim();
                        addCustomer(customerName, createCustomerID());
                        break;
                    case 4:
                        System.out.print("Enter customer id to delete: ");
                        String customerID = sc.nextLine().trim();
                        deleteCustomer(customerID);
                        break;
                    case 5:
                        break;
                    case 6:
                        System.out.print("Enter customer ID to check out: ");
                        String custID = sc.nextLine().trim();
                        System.out.print("Enter video ID to check out: ");
                        String vidID = sc.nextLine().trim();
                        checkOutVideo(custID, vidID);
                        break;
                    case 7:
                        System.out.print("Enter customer ID to check in: ");
                        String custoID = sc.nextLine().trim();
                        System.out.print("Enter video ID to check in: ");
                        String videID = sc.nextLine().trim();
                        checkInVideo(custoID, videID);
                        break;
                    case 8:
                        printAllCustomers();
                        break;
                    case 9:
                        printAllVideos();
                        break;
                    case 13:
                        System.exit(0);
                        break;

                }
            }

        }

    }

    static void printOptions() {
        System.out.println("===============================\n" +
                "Select one of the following:\n" +
                "1: To add a video\n" +
                "2: To delete a video\n" +
                "3: To add a customer\n" +
                "4: To delete a customer\n" +
                "5: To check if a particular video is in store\n" +
                "6: To check out a video\n" +
                "7: To check in a video\n" +
                "8: To print all customers\n" +
                "9: To print all videos\n" +
                "10: To print in store videos\n" +
                "11: To print all rented videos\n" +
                "12: To print the videos rented by a customer\n" +
                "13: To exit\n" +
                "===============================");
    }

    static void setVideoInStore(String movieName, String id) {
        if (typeOfList.equals("SLL")) {
            videoSLL.add(new SLNode(new Video(movieName, id), null));
        } else if (typeOfList.equals("DLL")) {
            videoDList.addLast(new DNode(new Video(movieName, id), null, null));

        } else {
            System.out.println("invalid");
        }

    }


    static void deleteVideo(String id) {
        videoSLL.deleteVideo(id);

    }

    static void deleteCustomer(String id) {
        customerSLL.deleteCustomer(id);
    }

    static void printAllVideos() {
        videoSLL.print();
    }

    static void printAllCustomers() {
        customerSLL.print();
    }

    private static Customer getCustomer(String id) {
        return customerSLL.getCustomer(id);
    }

    private static Video getVideo(String id) {
        return videoSLL.getVideo(id);
    }

    static void addCustomer(String name, String id) {
        if (typeOfList.equals("SLL")) {
            customerSLL.add(new SLNode(new Customer(name, id), null));
        } else if (typeOfList.equals("DLL")) {
            customerDList.addLast(new DNode(new Customer(name, id), null, null));

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

    private static void printAtElement(int id) {

    }

    static void checkOutVideo(String customerID, String videoID) {
        getCustomer(customerID).addRentSLL(getVideo(videoID));
        //deleteVideo(videoID);
        //videoSLL.deleteVideo(videoID);
    }

    static void checkInVideo(String customerID, String videoID){
        getCustomer(customerID).removeRentSLL(getVideo(videoID));
        videoSLL.add(new SLNode(new Video(getVideo(videoID).getTitle(), getVideo(videoID).getId()), null));

    }


}


