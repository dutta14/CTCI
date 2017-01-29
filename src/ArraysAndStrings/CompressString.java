package ArraysAndStrings;

import java.util.Scanner;

/**
 * Created by Anindya on 1/28/2017.
 */
public class CompressString {

    String str;

    CompressString(String str) {
        this.str = str;
    }

    private String compress() {
        int count = 1;
        StringBuilder result = new StringBuilder();
        int i;
        for(i=1; i<str.length(); i++) {
            if(str.charAt(i) != str.charAt(i-1)) {
                result.append(str.charAt(i-1));
                result.append(count);
                count=1;
            } else {
                count++;
            }
        }
        result.append(str.charAt(i-1));
        result.append(count);
        return new String(result);
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        CompressString obj = new CompressString(str);
        String solution = obj.compress();
        System.out.println(solution);
    }
}
