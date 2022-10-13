package VideoStoreProject;

/**
 * @author Steven Hogenson on 10/3/2022
 */
public class SLL {
    private SLNode head;

    public SLL() {
        head = null;
    }

    public SLNode getHead() {
        if (head == null) {
            return null;
        }
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

    public boolean deleteVideo(String id) {
        SLNode current = getHead();
        SLNode temp = null;
        Video v = (Video) current.getElement();
        if (v != null && v.getId().equals(id)) {
            setHead(current.getNext());
            return true;
        }
        while (v != null && !v.getId().equals(id)) {
            temp = current;
            current = current.getNext();
            //remove if statement if issue
            if (current != null) {
                v = (Video) current.getElement();
            } else {
                System.out.println("Unable to perform task.");
                return false;
            }
        }

        if (temp != null) {
            temp.setNext(current.getNext());
        }

        return true;

    }



    public Video getVideo(String id) {
        if (getHead() == null) {
            return null;
        }

        SLNode current = head;
        Video v = (Video) current.getElement();
        while (v != null) {
            if (v.getId().equals(id)) {
                return v;
            }
            //

            current = current.getNext();
            v = (Video) current.getElement();


        }
        return null;
    }


    public Customer getCustomer(String id) {
        if (getHead() == null) {
            return null;
        }

        SLNode current = head;
        Customer c = (Customer) current.getElement();
        while (c != null) {
            if (c.getId().equals(id)) {
                return c;
            }
            current = current.getNext();
            c = (Customer) current.getElement();

        }
        return null;
    }

    public void deleteCustomer(String id) {
        SLNode current = getHead();
        SLNode temp = null;
        Customer c = (Customer) current.getElement();
        if (c != null && c.getId().equals(id)) {
            setHead(current.getNext());
            return;
        }
        while (c != null && !c.getId().equals(id)) {
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

}
