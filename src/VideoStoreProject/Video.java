package VideoStoreProject;

/**
 * @author Steven Hogenson on 10/4/2022
 */
public class Video {
    private String title;
    private String id;

    public Video(String title, String id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Video{" +
                "title='" + title + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
