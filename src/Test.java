import java.util.Arrays;

/**
 * @author Steven Hogenson on 10/3/2022
 */
public class Test {
    public static void main(String[] args) {
        int[][][] x = {{{1, 2}, {3, 4}}, {{5, 6}, {7, 8}}};

        int[][][] y = new int[2][2][];

        y[0] = x[0].clone();
        System.out.println(Arrays.deepToString(y));

        y[1][1] = x[1][1].clone();
        System.out.println(Arrays.deepToString(y));
        x[0][0][0] = 100;

        x[1][1][1] = 200;
        System.out.println(x[0][0][1]);
        System.out.println("x = "+Arrays.deepToString(x));
        System.out.println("y = "+Arrays.deepToString(y));
        System.out.println(y[0][0][0] + " " + y[1][1][1]);
    }
}