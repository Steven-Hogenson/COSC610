import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Steven Hogenson on 9/8/2022
 * @project COSC610
 */
public class MM {
    /**
     *
     * @param args command line arguments
     * @throws IOException throws exception if the specified files are not found
     */
    public static void main(String[] args) throws IOException {
        //List<ArrayList<Integer>> a = readFile("matrixA2.txt");
        //List<ArrayList<Integer>> b = readFile("matrixB2.txt");
        List<ArrayList<Integer>> a = readFile(args[0]);
        List<ArrayList<Integer>> b = readFile(args[1]);
        FileWriter fw = new FileWriter("matrixAnswer.txt");
        int[][] matrixA = new int[a.size()][a.get(0).size()];
        int[][] matrixB = new int[b.size()][b.get(0).size()];
        populateMatrix(a, matrixA);
        populateMatrix(b, matrixB);
        int matrixA_Cols = a.get(0).size();
        int matrixB_Rows = b.size();
        //if valid conditions are met, then multiplications can occur
        if ((matrixA_Cols == matrixB_Rows)) {
            int[][] multMatrix = new int[a.size()][b.get(0).size()];
            int sum = 0;
            for (int i = 0; i < a.size(); i++) {
                for (int j = 0; j < b.get(0).size(); j++) {
                    for (int k = 0; k < b.size(); k++) {
                        sum += matrixA[i][k] * matrixB[k][j];
                    }
                    multMatrix[i][j] = sum;
                    sum = 0;
                }
            }
            for (int i = 0; i < a.size(); i++) {
                for (int j = 0; j < b.get(0).size(); j++) {
                    fw.write(multMatrix[i][j]+ " ");
                    //System.out.print(multMatrix[i][j] + " ");
                }
                //System.out.println();
                fw.write("\n");
            }
        } else {
            //System.out.println("Cannot multiply these 2 matrices.");
            fw.write("Cannot multiply these 2 matrices.");
        }

        fw.flush();
        fw.close();
    }

    public static List<ArrayList<Integer>> readFile(String fileName) throws IOException {
        Scanner input = new Scanner(new File(fileName));
        List<ArrayList<Integer>> a = new ArrayList<>();
        int row = 0;
        String[] cols = input.nextLine().split(" ");
        a.add(row, new ArrayList<>());
        for (String col : cols) {
            try {
                a.get(row).add(Integer.parseInt(col));
            } catch (Exception ignored) {
            }
        }
        row++;

        while (input.hasNextLine()) {
            a.add(row, new ArrayList<>());
            for (int j = 0; j < cols.length; j++) {
                try {
                    a.get(row).add(input.nextInt());
                } catch (java.util.NoSuchElementException ignored) {
                }
            }
            row++;
        }
        return a;
    }

    /**
     * populates the 2d arrays with the appropriate values
     * @param listMatrix the lists generated from readFile()
     * @param twoDimensionMatrix the 2d array to populate
     */
    static void populateMatrix(List<ArrayList<Integer>> listMatrix, int[][] twoDimensionMatrix) {
        for (int i = 0; i < listMatrix.size(); i++) {
            for (int j = 0; j < listMatrix.get(i).size(); j++) {
                twoDimensionMatrix[i][j] = listMatrix.get(i).get(j);
            }
        }
    }
}
