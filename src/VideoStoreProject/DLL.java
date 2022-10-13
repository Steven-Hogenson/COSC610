package VideoStoreProject;

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
            System.out.print(current.getElement() + " ");
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

    public void delteByKey(String id) {
        DNode temp = getHeader();
        DNode temp1 = null;
        while (!temp.getElement().equals(id)) {

        }
    }

    public boolean deleteVideo(String id) {
        DNode current = getHeader();
        DNode temp = null;
        Video v = (Video) current.getElement();
        if (v != null && v.getId().equals(id)) {
            setHeader(current.getNext());
            return true;
        }
        while (v != null && !v.getId().equals(id)) {
            temp = current;
            current = current.getNext();
            //current.setPrevious(temp);
            //remove if statement if issue
            if (current != null) {
                v = (Video) current.getElement();
                current.setPrevious(temp);
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
                //current.setPrevious(temp);
                //remove if statement if issue
                if (current != null) {
                    v = (Video) current.getElement();
                    current.setPrevious(temp);
                } else {
                    System.out.println("Unable to perform task.");
                    return false;
                }
            }

            if (temp != null) {
                temp.setNext(current.getNext());
            }

            return true;
        } else if (o instanceof Customer) {
            Customer v = (Customer) current.getElement();
            if (v != null && v.getId().equals(id)) {
                setHeader(current.getNext());
                return true;
            }
            while (v != null && !v.getId().equals(id)) {
                temp = current;
                current = current.getNext();
                //current.setPrevious(temp);
                //remove if statement if issue
                if (current != null) {
                    v = (Customer) current.getElement();
                    current.setPrevious(temp);
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

    public Video getVideo(String id) {
        if (getHeader() == null) {
            return null;
        }

        DNode current = getHeader();
        Video v = (Video) current.getElement();
        while (v != null) {
            if (v.getId().equals(id)) {
                return v;
            }
            //
            if(current.getNext() != null) {
                current = current.getNext();
                v = (Video) current.getElement();
            }


        }
        return null;
    }


    public Customer getCustomer(String id) {
        if (getHeader() == null) {
            return null;
        }

        DNode current = getHeader();
        Customer c = (Customer) current.getElement();
        while (c != null) {
            if (c.getId().equals(id)) {
                return c;
            }
            if(current.getNext()!=null) {
                current = current.getNext();
                c = (Customer) current.getElement();
            }

        }
        return null;
    }


}

