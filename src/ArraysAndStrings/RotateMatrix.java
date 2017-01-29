package ArraysAndStrings;

import java.util.Scanner;

/**
 * Created by Anindya on 1/28/2017.
 */
public class RotateMatrix {

    int[][] matrix;

    RotateMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    private void swapRows() {
        int[] arr;
        for(int i=0, j=matrix.length-1; i<j; i++, j--) {
            arr = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = arr;
        }
    }

    private void transpose() {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<=i;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void rotate() {
        swapRows();
        transpose();
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] matrix = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = s.nextInt();
            }
        }

        RotateMatrix obj = new RotateMatrix(matrix);
        obj.rotate();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }
}
