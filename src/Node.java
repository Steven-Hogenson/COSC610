/**
 * @author Steven Hogenson on 10/3/2022
 */
public class Node {
    Object element;
    Node next;

    public Node(Object element, Node next) {
        this.element = element;
        this.next = next;
    }

    //Getters
    public Object getElement() {
        return element;
    }

    public Node getNext() {
        return next;
    }

    //Setters
    public void setElement(Object element) {
        this.element = element;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
