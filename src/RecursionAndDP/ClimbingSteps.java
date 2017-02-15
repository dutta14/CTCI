package RecursionAndDP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Anindya on 2/13/2017.
 */
public class ClimbingSteps {

    private int countWays(int n) { //normal recursion
        if(n==0)
            return 1;
        if(n<0)
            return 0;
        return countWays(n-1)+countWays(n-2)+countWays(n-3);
    }

    private int countWays(int n, int ways[]) { //DP
        if(n==0)
            return 1;
        if(n<0)
            return 0;
        if(ways[n]>-1)
            return ways[n];
        ways[n] = countWays(n-1,ways)+countWays(n-2,ways) + countWays(n-3,ways);
        return ways[n];
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ClimbingSteps obj = new ClimbingSteps();
        int result = obj.countWays(n);
        System.out.println(result);
        int arr[] = new int[n+1];
        Arrays.fill(arr,-1);
        result = obj.countWays(n,arr);
        System.out.println(result);
    }


}
