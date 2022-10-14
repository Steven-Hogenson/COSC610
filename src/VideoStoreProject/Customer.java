package VideoStoreProject;

/**
 * @author Steven Hogenson on 10/4/2022
 */
public class Customer {
    private final String name;
    private final String id;
    private SLL rentVideoSLL;
    private DLL rentVideoDLL;

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


    public DLL getRentVideoDLL() {
        if (rentVideoDLL == null) {
            return null;
        }
        return rentVideoDLL;
    }

    public void addRentSLL(Video v) {
        rentVideoSLL.add(new SLNode(new Video(v.getTitle(), v.getId()), null));
    }

    public void createAndAddRentSLL(Video v) {
        rentVideoSLL = new SLL();
        rentVideoSLL.add(new SLNode(new Video(v.getTitle(), v.getId()), null));
    }

    public void removeRentSLL(Video v) {
        rentVideoSLL.deleteVideo(v.getId());
    }

    public void addRentDLL(Video v) {
        rentVideoDLL.addLast(new DNode(new Video(v.getTitle(), v.getId()), null, null));
    }

    public void createAndAddRentDLL(Video v) {
        rentVideoDLL = new DLL();
        rentVideoDLL.addLast(new DNode(new Video(v.getTitle(), v.getId()), null, null));
    }

    public void removeRentDLL(Video v) {
        rentVideoDLL.deleteDLL(v.getId(), v);
    }


    @Override
    public String toString() {
        return "[" + id + "] " + name;
    }

    public void printVideos() {
        if (rentVideoSLL != null) {
            rentVideoSLL.print();
        } else if (rentVideoDLL != null) {
            rentVideoDLL.print();
        }

    }
}
