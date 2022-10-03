/**
 * @author Steven Hogenson on 10/3/2022
 */
public class DList {
    DNode header;
    DNode trailer;

    public DList() {
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
            System.out.print(current.getElement() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    /**
     * Inserts a DNode to the first position of a DList
     * @param n the DNode to add to the first position of a DList
     */
    public void addFirst(DNode n) {
        if (header == null) {
            setHeader(n);
            setTrailer(n);
        } else {
            n.setNext(getHeader());
            getHeader().setPrevious(n);
            setHeader(n);
        }
    }

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
     * @param n the DNode to delete
     */
    public void remove(DNode n) {
        if (getHeader() == null || n == null) {
            return;
        }

        if (getHeader() == n) {
            setHeader(n.getNext());
        }

        if (getTrailer() == n) {
            setTrailer(n.getPrevious());
        }

        if (n.getNext() != null) {
            DNode temp = n.getNext();
            temp.setPrevious(n.getPrevious());
        }

        if (n.getPrevious() != null) {
            DNode temp = n.getPrevious();
            temp.setNext(n.getNext());
        }


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
}

