/**
 * @author Steven Hogenson on 10/3/2022
 */
public class Test {
    public static void main(String args[]) {
        Node a = new Node(1, null);
        Node b = new Node(2, null);
        Node c = new Node(3, null);

        SLL s = new SLL();
        s.add(a);
        s.add(b);
        s.add(c);

        DNode a1 = new DNode(1, null, null);
        DNode b1 = new DNode(2, null, null);
        DNode c1 = new DNode(3, null, null);

        DList d = new DList();
        d.addFirst(b1);
        d.addFirst(a1);
        d.addLast(c1);
        d.print();

        d.remove(b1);
        d.remove(a1);
        //d.remove(c1);
        d.print();
    }
}