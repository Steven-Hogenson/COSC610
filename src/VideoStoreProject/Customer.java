package VideoStoreProject;

/**
 * @author Steven Hogenson on 10/4/2022
 */
public class Customer {
    private String name;
    private String id;
    private Video rentVideo;

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

    public Video getRentVideo() {
        return rentVideo;
    }

    public void setRentVideo(Video rentVideo) {
        this.rentVideo = rentVideo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", rentVideo=" + rentVideo +
                '}';
    }
}
