package ArraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Anindya on 1/28/2017.
 */
public class CheckPermutation {
    char[] str1, str2;

    CheckPermutation(String str1, String str2) {
        this.str1 = str1.toCharArray();
        this.str2 = str2.toCharArray();
    }

    private boolean checkPermBySort() {
        if(str1.length != str2.length)
            return false;
        Arrays.sort(str1);
        Arrays.sort(str2);
        return new String(str1).equals(new String(str2));
    }

    private boolean checkPermHashSet() {
        if(str1.length != str2.length)
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char i: str1) {
            map.put(i, map.getOrDefault(i,0)+1);
        }
        for(char i: str2) {
            map.put(i, map.getOrDefault(i,0)-1);
            if(map.get(i) == 0)
                map.remove(i);
        }
        return map.isEmpty();
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str1 = s.nextLine(),
                str2 = s.nextLine();

        CheckPermutation obj = new CheckPermutation(str1, str2);
        boolean isPerm = obj.checkPermBySort();
        System.out.println(isPerm);
        isPerm = obj.checkPermHashSet();
        System.out.println(isPerm);
    }
}
