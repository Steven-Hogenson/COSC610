/**
 * @author Steven Hogenson on 9/2/2022
 */

public class Kill2 {
    public static void main(String[] args) {

        String remove2 = args[0];
        if (remove2.length() < 2) {
            System.out.println("WARNING: Not enough characters.");
            System.exit(0);
        }
        StringBuilder sb = new StringBuilder(remove2);
        sb.deleteCharAt(1);
        System.out.println(sb);
    }
}
