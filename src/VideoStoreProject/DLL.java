package VideoStoreProject;

import java.util.Objects;

/**
 * @author Steven Hogenson on 10/3/2022
 */
public class DLL {
    private DNode header;
    private DNode trailer;

    public DLL() {
    }

    public DNode getHeader() {
        return header;
    }

    public DNode getTrailer() {
        return trailer;
    }

    public void setHeader(DNode header) {
        this.header = header;
    }

    public void setTrailer(DNode trailer) {
        this.trailer = trailer;
    }

    /**
     * Prints all elements of a DList in order
     */
    public void print() {
        DNode current = getHeader();
        while (current != null) {
            System.out.println(current.getElement());
            current = current.getNext();
        }
        System.out.println();
    }

    /**
     * Inserts a DNode to the first position of a DList
     *
     * @param n the DNode to add to the first position of a DList
     */
    public void addFirst(DNode n) {
        if (getHeader() == null) {
            setHeader(n);
            setTrailer(n);
        } else {
            n.setNext(getHeader());
            getHeader().setPrevious(n);
            setHeader(n);
        }
    }

    /**
     * Inserts a DNode to the last position of a DList
     *
     * @param n the DNode to add to the last position of a DList
     */
    public void addLast(DNode n) {
        if (getHeader() == null) {
            setHeader(n);
        } else {
            n.setPrevious(getTrailer());
            getTrailer().setNext(n);
        }
        setTrailer(n);
    }

    /**
     * Deletes a specified DNode from a DList
     *
     * @param n the DNode to delete
     */
    public boolean remove(DNode n) {
        if (getHeader() == null || n == null) {
            return false;
        }
        if (getHeader() == n) {
            setHeader(getHeader().getNext());
        }
        if (n.getNext() != null) {
            n.getNext().setPrevious(n.getPrevious());
        }
        if (n.getPrevious() != null) {
            n.getPrevious().setNext(n.getNext());
        }
        return true;
    }

    /**
     * Will delete an object from a DLL based on if it is a Video or Customer object
     *
     * @param id the id of either customer or video
     * @param o  the object (customer or video)
     * @return boolean if the node was deleted
     */
    public boolean deleteDLL(String id, Object o) {
        DNode current = getHeader();
        DNode temp = null;
        if (o instanceof Video) {
            Video v = (Video) current.getElement();
            if (v != null && v.getId().equals(id)) {
                setHeader(current.getNext());
                return true;
            }
            while (v != null && !v.getId().equals(id)) {
                temp = current;
                current = current.getNext();
                if (current != null) {
                    v = (Video) current.getElement();
                    current.setPrevious(temp);
                } else {
                    //System.out.println("Unable to perform task.");
                    return false;
                }
            }
            if (temp != null) {
                temp.setNext(current.getNext());
            }
            return true;
        } else if (o instanceof Customer) {

            if (current == null) {
                return false;
            }
            Customer v = (Customer) current.getElement();
            if (v != null && v.getId().equals(id)) {
                setHeader(current.getNext());
                return true;
            }
            while (v != null && !v.getId().equals(id)) {
                temp = current;
                current = current.getNext();
                if (current != null) {
                    v = (Customer) current.getElement();
                    current.setPrevious(temp);
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
     * Reverses the order of elements in a DList
     */
    public void reverse() {
        DNode temp = null;
        DNode current = header;
        while (current != null) {
            temp = current.getPrevious();
            current.setPrevious(current.getNext());
            current.setNext(temp);
            current = current.getPrevious();
        }
        if (temp != null) {
            header = temp.getPrevious();
        }
    }

    /**
     * Checks a DLL for a Video matching param id, and returns that Video
     *
     * @param id the video's id number
     * @return a video whose ID number matches param id in a DLL
     */
    public Video getVideo(String id) {
        if (getHeader() == null) {
            return null;
        }
        DNode current = getHeader();
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
     * Checks a DLL for a Customer matching param id, and returns that Customer
     *
     * @param id the customer's id number
     * @return a customer whose ID number matches param id in a DLL
     */
    public Customer getCustomer(String id) {
        if (getHeader() == null) {
            return null;
        }
        DNode current = getHeader();
        Customer c = (Customer) current.getElement();
        while (current != null) {
            if (c.getId().equals(id)) {
                return c;
            }
            current = current.getNext();
            if (current != null) {
                c = (Customer) current.getElement();
            }

        }
        return null;
    }

    /**
     * Checks for a DNode matching the video's id that is in store
     *
     * @param id video's id to check for
     * @return boolean if the video is not currently being rented
     */
    public boolean checkInStoreDLL(String id, DNode d) {
        DNode current = d;
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