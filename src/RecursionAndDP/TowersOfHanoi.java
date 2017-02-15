package RecursionAndDP;

import java.util.Scanner;

/**
 * Created by Anindya on 2/13/2017.
 */


public class TowersOfHanoi {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        TowersOfHanoi obj = new TowersOfHanoi();
        obj.move(n,0,2,1);
    }

    private void move(int n, int a, int c, int b) {
        if(n==0)
            return;
        move(n-1,a,b,c);
        System.out.println("Move " + n + "from "+ a +" to "+ c);
        move(n-1,b,c,a);
    }
}
