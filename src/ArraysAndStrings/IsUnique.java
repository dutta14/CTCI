package ArraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Anindya on 1/28/2017.
 */
public class IsUnique {

    private char[] input;

    IsUnique(String input) {
        this.input = input.toCharArray();
    }

    private boolean checkIfUniqueHash() {
        HashSet<Character> set = new HashSet<>();
        for(char i: input) {
            if(!set.add(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkIfUniqueSort() {
        Arrays.sort(input);
        for(int i=1; i<input.length; i++) {
            if (input[i] == input[i-1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        IsUnique obj = new IsUnique(input);
        boolean result = obj.checkIfUniqueHash(); //O(N) space. O(N) time.
        System.out.println(result);
        result =  obj.checkIfUniqueSort(); //No space. O(N log n) time,
        System.out.println(result);
    }
}
