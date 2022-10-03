import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * @author Steven Hogenson on 9/26/2022
 * project: COSC610 Arrays
 */
public class MM {
    /**
     * @param args command line arguments
     * @throws IOException throws exception if the specified files are not found
     */
    public static void main(String[] args) throws IOException {
        String matrixA = "matrixA.txt";
        String matrixB = "matrixB.txt";
        int rowsA = getRows(matrixA);
        int colsA = getColumns(matrixA);
        int rowsB = getRows(matrixB);
        int colsB = getColumns(matrixB);
        //Condition to determine validity
        if (colsA != rowsB) {
            System.out.println("Invalid matrix dimensions; cannot multiply");
            System.exit(0);
        }
        int[][] arrayA = new int[rowsA][colsA];
        populateMatrix(matrixA, arrayA);
        int[][] arrayB = new int[rowsB][colsB];
        populateMatrix(matrixB, arrayB);
        //Multiplying the 2 matrices
        int[][] arrayMultiply = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    arrayMultiply[i][j] += arrayA[i][k] * arrayB[k][j];
                }
            }
        }
        //Writing output to file
        FileWriter fw = new FileWriter("matrixAnswer.txt");
        for (int[] i : arrayMultiply) {
            for (int j : i) {
                fw.write(j + " ");
            }
            fw.write("\n");
        }
        fw.flush();
        fw.close();
    }

    /**
     * Gets the total number of rows from the matrix from the text file
     *
     * @param fileName the text file that contains a matrix
     * @return integer of the amount of rows
     */
    public static int getRows(String fileName) {
        List<String> rows;
        try {
            rows = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return rows.size();
    }

    /**
     * Gets the length of a row (number of columns) from the text file that contains a matrix
     *
     * @param fileName the text file that contains a matrix
     * @return integer of the number of columns
     * @throws FileNotFoundException if file not found
     */
    public static int getColumns(String fileName) throws FileNotFoundException {
        int columns;
        BufferedReader br = new BufferedReader((new FileReader(fileName)));
        String columnTemp;
        try {
            columnTemp = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        columns = columnTemp.replaceAll("\s+", "").length();
        return columns;
    }

    /**
     * Populates the matrices with values from the text files
     *
     * @param fileName name of the text file to get matrix from
     * @param array    the 2d array to populate
     * @throws FileNotFoundException if file is not found
     */
    public static void populateMatrix(String fileName, int[][] array) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = sc.nextInt();
            }
        }
    }
}