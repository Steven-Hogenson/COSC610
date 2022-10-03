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

    public void print() {
        DNode current = header;
        while (current != null) {
            System.out.print(current.getElement() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public void addFirst(DNode n) {
        if (header == null) {
            header = n;
            trailer = n;
        } else {
            n.setNext(header);
            header.setPrevious(n);
            header = n;
        }
    }

    public void addLast(DNode n) {
        if (header == null) {
            header = n;
        } else {
            n.setPrevious(trailer);
            trailer.setNext(n);
        }
        trailer = n;
    }


//TODO CLEAN UP

    /**
     * @param n
     */
    public void remove(DNode n) {
        if (header.getNext() == null && trailer.getPrevious() == null) {
            header = null;
            trailer = null;
        } else {
            DNode temp = header;

            while (n.getElement() != temp.getElement()) {
                temp = temp.getNext();
            }

            DNode pre = temp.getPrevious();
            DNode pos = temp.getNext();

            if (header == temp) {
                pos.setPrevious(null);
                header = pos;
            } else if (trailer == temp) {
                pre.setNext(null);
                trailer = pre;
            } else {
                pre.setNext(pos);
                pos.setPrevious(pre);
            }
        }
    }

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

