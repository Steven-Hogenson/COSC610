package VideoStoreProject;

/**
 * @author Steven Hogenson on 10/4/2022
 */
public class Customer {
    private final String name;
    private final String id;
    private SLL rentVideoSLL;
    private DList rentVideoDList;

    public Customer(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }


    public SLL getRentVideoSLL() {
        if (rentVideoSLL == null) {
            return null;
        }
        return rentVideoSLL;
    }


    public DList getRentVideoDList() {
        return rentVideoDList;
    }

    public void addRentSLL(Video v) {
        //rentVideoSLL = new SLL();
        rentVideoSLL.add(new SLNode(new Video(v.getTitle(), v.getId()), null));
    }

    public void createAndAddRentSLL(Video v) {
        rentVideoSLL = new SLL();
        rentVideoSLL.add(new SLNode(new Video(v.getTitle(), v.getId()), null));
    }

    public void removeRentSLL(Video v) {
        rentVideoSLL.deleteVideo(v.getId());
    }

    public void addRentDList(Video v) {
        rentVideoDList = new DList();
        rentVideoDList.addLast(new DNode(new Video(v.getTitle(), v.getId()), null, null));
    }

    /*
        @Override
        public String toString() {
            return "Customer{" +
                    "name='" + name + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }

     */
    @Override
    public String toString() {
        return "[" + id + "] " + name;
    }

    public void printVideos() {
        if (rentVideoSLL != null) {
            rentVideoSLL.print();
        }
        if (rentVideoDList != null) {
            rentVideoDList.print();
        }

    }
}
