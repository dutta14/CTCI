package RecursionAndDP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Anindya on 2/13/2017.
 */

class Point {
    int x, y;

    Point(int x, int y) {
        this.x=x;
        this.y=y;
    }

    public String toString() {
        return "("+x+","+y+")";
    }
}

public class RobotInAGrid {

    ArrayList<Point> getPath(boolean[][] arr) {  //recursion
        if(arr==null || arr.length==0)
            return null;
        ArrayList<Point> points = new ArrayList<>();
        if(getPath(arr,arr.length-1,arr[0].length-1,points))
            return points;
        return null;
    }

    private boolean getPath(boolean[][] arr, int r, int c, ArrayList<Point> points) { //recursion
        if(c<0 || r<0 || !arr[r][c])
            return false;
        boolean isAtOrigin = (r==0) && (c==0);
        if(isAtOrigin || getPath(arr, r-1,c,points) || getPath(arr,r,c-1,points)) {
            Point p = new Point(r,c);
            points.add(p);
            return true;
        }
        return false;
    }

    ArrayList<Point> getPathDP(boolean[][] arr) {  //DP
        if(arr==null || arr.length==0)
            return null;
        ArrayList<Point> points = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<>();
        if(getPath(arr,arr.length-1,arr[0].length-1,points,failedPoints))
            return points;
        return null;
    }

    private boolean getPath(boolean[][] arr, int r, int c, ArrayList<Point> points, HashSet<Point> failedPoints) { //DP
        if(c<0 || r<0 || !arr[r][c])
            return false;
        Point p = new Point(r,c);
        if(failedPoints.contains(p))
            return false;

        boolean isAtOrigin = (r==0) && (c==0);
        if(isAtOrigin || getPath(arr, r-1,c,points,failedPoints) || getPath(arr,r,c-1,points,failedPoints)) {
            points.add(p);
            return true;
        }
        failedPoints.add(p);
        return false;
    }



    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt(), n = s.nextInt();
        boolean[][] arr = new boolean[m][n];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                arr[i][j] = s.nextBoolean();

        RobotInAGrid obj = new RobotInAGrid();
        ArrayList<Point> points = obj.getPathDP(arr);
        System.out.println(points);
    }
}
