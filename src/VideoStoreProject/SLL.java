package VideoStoreProject;

import java.util.Objects;

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

    /**
     * Checks an SLL for a Video matching param id, and returns that Video
     *
     * @param id the video's id number
     * @return a video whose ID number matches param id in an SLL
     */
    public Video getVideo(String id) {
        if (getHead() == null) {
            return null;
        }

        SLNode current = head;
        Video v = (Video) current.getElement();
        while (current != null) {
            if (v.getId().equals(id)) {
                return v;
            }
            current = current.getNext();
            if (current != null) {
                v = (Video) current.getElement();
            }
        }
        return null;
    }

    /**
     * Checks an SLL for a Customer matching param id, and returns that Customer
     *
     * @param id the customer's id number
     * @return a customer whose ID number matches param id in an SLL
     */
    public Customer getCustomer(String id) {
        if (getHead() == null) {
            return null;
        }
        SLNode current = head;
        Customer v = (Customer) current.getElement();
        while (current != null) {
            if (v.getId().equals(id)) {
                return v;
            }
            current = current.getNext();
            if (current != null) {
                v = (Customer) current.getElement();
            }
        }
        return null;
    }

    /**
     * Will delete an object from an SLL based on if it is a Video or Customer object
     *
     * @param id the id of either customer or video
     * @param o  the object (customer or video)
     * @return boolean if the node was deleted
     */
    public boolean deleteSLL(String id, Object o) {
        SLNode current = getHead();
        SLNode temp = null;
        if (o instanceof Customer) {
            Customer c = (Customer) current.getElement();
            if (c != null && c.getId().equals(id)) {
                setHead(current.getNext());
                return true;
            }
            while (c != null && !c.getId().equals(id)) {
                temp = current;
                current = current.getNext();
                if (current != null) {
                    c = (Customer) current.getElement();
                } else {
                    //System.out.println("Unable to perform task.");
                    return false;
                }
            }
            if (temp != null) {
                temp.setNext(current.getNext());
            }
        } else if (o instanceof Video) {
            Video v = (Video) current.getElement();
            if (v != null && v.getId().equals(id)) {
                setHead(current.getNext());
                return true;
            }
            while (v != null && !v.getId().equals(id)) {
                temp = current;
                current = current.getNext();
                if (current != null) {
                    v = (Video) current.getElement();
                } else {
                    //System.out.println("Unable to perform task.");
                    return false;
                }
            }

            if (temp != null) {
                temp.setNext(current.getNext());
            }

            return true;
        }
        return false;
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

    /**
     * Checks for a SLNode matching the video's id that is in store
     *
     * @param id video's id to check for
     * @return boolean if the video is not currently being rented
     */
    public boolean checkInStoreSLL(String id, SLNode s) {
        SLNode current = s;
        Video v;
        if (current == null) {
            return false;
        } else {
            v = (Video) current.getElement();
        }
        while (true) {
            if (Objects.equals(v.getId(), id)) {
                return true;
            } else {
                current = current.getNext();
                if (current != null) {
                    v = (Video) current.getElement();
                } else {
                    return false;
                }
            }
        }
    }
}
