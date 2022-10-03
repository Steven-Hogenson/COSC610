/**
 * @author Steven Hogenson on 10/3/2022
 */
public class DNode {
    Object element;
    DNode previous;
    DNode next;

    public DNode(Object element, DNode previous, DNode next) {
        this.element = element;
        this.previous = previous;
        this.next = next;
    }

    //Getters
    public Object getElement() {
        return element;
    }

    public DNode getPrevious() {
        return previous;
    }

    public DNode getNext() {
        return next;
    }

    //Setters
    public void setElement(Object element) {
        this.element = element;
    }

    public void setPrevious(DNode previous) {
        this.previous = previous;
    }

    public void setNext(DNode next) {
        this.next = next;
    }
}
