package VideoStoreProject;

/**
 * @author Steven Hogenson on 10/4/2022
 */
public class Video {
    private final String title;
    private final String id;
    private boolean isAvailable;


    public Video(String title, String id) {
        this.title = title;
        this.id = id;
        this.isAvailable = true;

    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }


    @Override
    public String toString() {
        return "[" + id + "] " + title;

    }
}
