import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] tokens = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(tokens[0]);
        int col = Integer.parseInt(tokens[1]);
        String [][] matrix = new String[row][col];
        for (short i = 0; i<row; i++) {
            for (short j = 0; j<col; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append((char) ('a'+i));
                sb.append((char) ('a'+i+j));
                sb.append((char) ('a'+i));
                matrix[i][j]=sb.toString();
            }
        }
        for (int i = 0; i<matrix.length; i++) {
            for (int j = 0; j<matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}