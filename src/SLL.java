/**
 * @author Steven Hogenson on 10/3/2022
 */
public class SLL {
    Node head;

    public SLL() {
        head = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * Prints all Nodes in an SLL in order
     */
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getElement() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    /**
     * Adds a Node to the end of an SLL
     *
     * @param n the Node to add at the end of an SLL
     */
    public void add(Node n) {
        if (head == null) {
            head = n;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(n);
        }


    }

    /**
     * Removes the last Node of an SLL from the SLL
     */
    public void remove() {
        if (head == null) {
            return;
        }
        if (head.getNext() == null) {
            head = null;
        } else {
            Node current = head;
            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }
            current.setNext(null);
        }
    }

    /**
     * Reverses the order of elements in an SLL
     */
    public void reverseList() {
        if (head == null) {
            return;
        }
        Node current = head;
        Node previous = null;
        Node next;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = previous;
    }
}
