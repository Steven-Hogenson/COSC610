/**
 * @author Steven Hogenson on 10/3/2022
 */
public class SLL {
    private Node head;

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
        Node current = getHead();
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
        if (getHead() == null) {
            setHead(n);
        } else {
            Node current = getHead();
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
        if (getHead() == null) {
            return;
        }
        if (getHead().getNext() == null) {
            setHead(null);
        } else {
            Node current = getHead();
            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }
            current.setNext(null);
        }
    }

    /**
     * Reverses the order of elements in an SLL
     */
    public void reverse() {
        if (getHead() == null) {
            return;
        }
        Node current = getHead();
        Node previous = null;
        Node next;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        setHead(previous);
    }

    public static void main(String[] args) {
        Node a = new Node(1, null);
        Node b = new Node(2, null);
        Node c = new Node(3, null);
        SLL s = new SLL();
        s.print();
        s.add(a);
        s.add(b);
        s.add(c);
        s.print();
        s.remove();
        s.print();
        s.remove();
        s.print();
        s.remove();
        s.print();
        s.add(a);
        s.add(b);
        s.add(c);
        s.print();
        s.reverse();
        s.print();

    }
}
