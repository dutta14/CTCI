package ArraysAndStrings;

import java.util.Scanner;

/**
 * Created by Anindya on 1/29/2017.
 */
public class ZeroMatrix {

    int[][] matrix;
    int m,n;

    ZeroMatrix(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
    }

    private void zeroWithArrays() {
        int[] rows = new int[m],
                columns = new int[n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j]==0) {
                    rows[i] = columns[j] = 1;
                }
            }
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(rows[i]==1 || columns[j]==1)
                    matrix[i][j] = 0;
            }
        }
    }

    private void zeroWithOzero() {
        boolean row=false, col = false;
        for(int j=0; j<n; j++) {
            if(matrix[0][j] == 0) {
                row = true;
                break;
            }
        }
        for(int i=0; i<m; i++) {
            if(matrix[i][0] == 0) {
                col = true;
                break;
            }
        }

        for(int i=1; i<m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][0]==0 || matrix[0][j]==0)
                    matrix[i][j] = 0;
            }
        }

        if(row) {
            for(int j=0; j<n; j++) {
                matrix[0][j] = 0;
            }
        }

        if(col) {
            for(int i=0; i<m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                str.append(matrix[i][j]).append(" ");
            }
            str.append("\n");
        }
        return str.toString();
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt(), n = s.nextInt();
        int[][] matrix = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = s.nextInt();
            }
        }

        ZeroMatrix obj = new ZeroMatrix(matrix);
       // obj.zeroWithArrays();     //O(2N) space.
         obj.zeroWithOzero();        //O(1) space.
        System.out.println(obj);
    }
}
