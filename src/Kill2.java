/**
 * @author Steven Hogenson on 9/2/2022
 */

public class Kill2 {
    public static void main(String[] args) {

        //gets user input from command line as a String
        String remove2 = args[0];
        //condition if the inputted String is less than 2 characters in length, and exits the program
        if (remove2.length() < 2) {
            System.out.println("WARNING: Not enough characters.");
            System.exit(0);
        }
        //duplicates original String and then removes the 2nd character, and then prints that new String
        StringBuilder sb = new StringBuilder(remove2);
        sb.deleteCharAt(1);
        System.out.println(sb);
    }
}
