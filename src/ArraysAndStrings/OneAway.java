package ArraysAndStrings;

import java.util.Scanner;

/**
 * Created by Anindya on 1/28/2017.
 */
public class OneAway {
    String str1, str2;

    OneAway(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    private boolean isOneAway() {
        int l1 = str1.length(), l2 = str2.length();
        if(Math.abs(l1-l2) > 1)
            return false;
        String shorter = l1 < l2? str1: str2,
                longer = l1 < l2? str2: str1;

        boolean foundDiff = false;
        int i = 0, j=0;
        l1 = shorter.length();
        l2 = longer.length();
        while(i < l1 && j<l2) {
            if(shorter.charAt(i) != longer.charAt(i)) {
                if(foundDiff)
                    return false;
                foundDiff = true;

                if(l1==l2)
                    i++;
            } else {
                i++;
            }
            j++;
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str1 = s.nextLine(), str2 = s.nextLine();

        OneAway obj = new OneAway(str1, str2);
        boolean result = obj.isOneAway();
        System.out.println(result);
    }

}
