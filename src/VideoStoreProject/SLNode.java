package VideoStoreProject;

/**
 * @author Steven Hogenson on 10/3/2022
 */
public class SLNode {
    private Object element;
    private SLNode next;

    public SLNode(Object element, SLNode next) {
        this.element = element;
        this.next = next;
    }


    public Object getElement() {
        return element;
    }

    public SLNode getNext() {
        return next;
    }


    public void setElement(Object element) {
        this.element = element;
    }

    public void setNext(SLNode next) {
        this.next = next;
    }




}
