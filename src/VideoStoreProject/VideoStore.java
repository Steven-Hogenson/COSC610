package VideoStoreProject;

import java.util.Scanner;

/**
 * @author Steven Hogenson on 10/4/2022
 */
public class VideoStore {
    private Video videoInStore;
    private Customer customer;
    private static String typeOfList = "";
    private static int videoCount = 0;
    private static int customerCount = 0;
    private static int requestCount = 0;
    static SLL videoSLL;
    static SLL customerSLL;
    static DList videoDList;
    static DList customerDList;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
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

        switch (typeOfList) {
            case "SLL":
                videoSLL = new SLL();
                customerSLL = new SLL();
                break;
            case "DLL":
                videoDList = new DList();
                customerDList = new DList();
                break;
            default:
                System.out.println("INVALID ARGUMENT");
                System.exit(0);
                break;
        }


        if (args.length == 1) {
            while (true) {
                printOptions();
                int scanInput = sc.nextInt();

                switch (scanInput) {
                    case 1:
                        System.out.print("\nEnter the video name: ");
                        String videoName = sc.nextLine().trim();


                }
            }

        }
    }

    static void printOptions() {
        System.out.println("==============================");
        System.out.println("Select one of the following:");
        System.out.println("1: To add a video");
        System.out.println("2: To delete a video");
        System.out.println("3: To add a customer");
        System.out.println("4: To delete a customer");
        System.out.println("5: To check if a particular video is in store");
        System.out.println("6: To check out a video");
        System.out.println("7: To check in a video");
        System.out.println("8: To print all customers");
        System.out.println("9: To print all videos");
        System.out.println("10: To print in store videos");
        System.out.println("11: To print all rented videos");
        System.out.println("12: To print the videos rented by a customer");
        System.out.println("13: To exit");
        System.out.println("==============================");
    }

    static void setVideoInStore(String movieName, String id) {
        switch (typeOfList) {
            case "SLL":
                videoSLL.add(new SLNode(new Video(movieName, id), null));
                break;
            case "DLL":
                videoDList.addLast(new DNode(new Video(movieName, id), null, null));
                break;
            default:
                break;
        }
    }

    //TODO
    static void deleteVideo(String id) {

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
//TODO add a method in SLL that deletes element with certain id
    static void deleteCustomer(String id) {
        if (typeOfList.equals("SLL")) {
            SLNode temp = customerSLL.getHead();
            Customer custTemp = (Customer) temp.getElement();
            while (temp.getNext() != null){
                if(custTemp.getId().equals(id)){
                    //customerSLL.remove(custTemp);
                }
            }
        }
    }


}
