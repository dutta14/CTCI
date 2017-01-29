package ArraysAndStrings;

import java.util.Scanner;

/**
 * Created by Anindya on 1/29/2017.
 */
public class StringRotation {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        StringBuilder build = new StringBuilder(str);
        build.append(str);

        String subs = s.nextLine();

        System.out.println(build.indexOf(subs) != -1);
    }
}
