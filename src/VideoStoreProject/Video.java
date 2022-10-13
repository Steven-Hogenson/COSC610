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

    /*
        @Override
        public String toString() {
            return "Video{" +
                    "title='" + title + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }

     */
    public void setAvailable(boolean b) {
        isAvailable = b;
    }
    public boolean getAvailable(){
        return isAvailable;
    }

    @Override
    public String toString() {
        if (isAvailable) {
            return "[" + id + "] " + title ;
        } else {
            return "[" + id + "] " + title;
        }

    }
}
