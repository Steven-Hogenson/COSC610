package VideoStoreProject;

import java.util.NoSuchElementException;

/**
 * @author Steven Hogenson on 10/3/2022
 */
public class SLL {
    private SLNode head;

    public SLL() {
        head = null;
    }

    public SLNode getHead() {
        return head;
    }

    public void setHead(SLNode head) {
        this.head = head;
    }

    /**
     * Prints all Nodes in an SLL in order
     */
    public void print() {
        SLNode current = getHead();
        while (current != null) {
            System.out.println(current.getElement());
            current = current.getNext();
        }
        System.out.println();
    }

    /**
     * Adds a Node to the end of an SLL
     *
     * @param n the Node to add at the end of an SLL
     */
    public void add(SLNode n) {
        if (getHead() == null) {
            setHead(n);
        } else {
            SLNode current = getHead();
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
            SLNode current = getHead();
            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }
            current.setNext(null);
        }
    }

    public void deleteVideo(String id) {
        SLNode current = getHead();
        SLNode temp = null;
        Video v = (Video) current.getElement();
        if (current != null && v.getId().equals(id)) {
            setHead(current.getNext());
            return;
        }
        while (current != null && !v.getId().equals(id)) {
            temp = current;
            current = current.getNext();
            v = (Video) current.getElement();
        }

        if (temp != null) {
            temp.setNext(current.getNext());
        }
    }

    public Video getVideo(String id) {
        SLNode current = getHead();
        SLNode temp = null;
        Video v = (Video) current.getElement();
        if (current != null && v.getId().equals(id)) {
            setHead(current.getNext());
            return v;
        }
        while (current != null&& !v.getId().equals(id)) {
            temp = current;
            current = current.getNext();
            v = (Video) current.getElement();
        }

        if (temp != null) {
            temp.setNext(current.getNext());
        }
        return v;

    }
//TODO make this and getVideo actually work, rn it deletes
    public Customer getCustomer(String id) {
        SLNode current = getHead();
        SLNode temp = null;
        Customer c = (Customer) current.getElement();
        if (current != null && c.getId().equals(id)) {
            setHead(current.getNext());
            return c;
        }
        while (current != null && !c.getId().equals(id)) {
            temp = current;
            current = current.getNext();
            c = (Customer) current.getElement();
        }

        if (temp != null) {
            temp.setNext(current.getNext());
        }
        return c;
    }

    public void deleteCustomer(String id) {
        SLNode current = getHead();
        SLNode temp = null;
        Customer c = (Customer) current.getElement();
        if (current != null && c.getId().equals(id)) {
            setHead(current.getNext());
            return;
        }
        while (current != null && !c.getId().equals(id)) {
            temp = current;
            current = current.getNext();
            c = (Customer) current.getElement();
        }

        if (temp != null) {
            temp.setNext(current.getNext());
        }
    }

    /**
     * Reverses the order of elements in an SLL
     */
    public void reverse() {
        if (getHead() == null) {
            return;
        }
        SLNode current = getHead();
        SLNode previous = null;
        SLNode next;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        setHead(previous);
    }

/*
    public static void main(String[] args) {
        SLNode a = new SLNode(1, null);
        SLNode b = new SLNode(2, null);
        SLNode c = new SLNode(3, null);
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

 */
}
