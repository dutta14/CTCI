package ArraysAndStrings;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Anindya on 1/28/2017.
 */
public class PalindromePermutation {
    String str;

    PalindromePermutation(String str) {
        this.str = str.toLowerCase();
    }

    private boolean checkPerm() {
        HashSet<Character> set = new HashSet<>();
        for(char i: str.toCharArray()) {
            if(i==' ')
                continue;
            if(!set.add(i))
                set.remove(i);
        }
        return set.size() <2;
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        PalindromePermutation obj = new PalindromePermutation(str);
        boolean result = obj.checkPerm();
        System.out.println(result);
    }
}
