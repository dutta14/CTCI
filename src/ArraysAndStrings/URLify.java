package ArraysAndStrings;

import java.util.Scanner;

/**
 * Created by Anindya on 1/28/2017.
 */
public class URLify {

    private String string;

    URLify(String string) {
        this.string = string;
    }

    private char[] URL() {
        int spaces = 0;
        for(int i=0; i<string.length(); i++)
            if(string.charAt(i)==' ')
                spaces++;
        char[] str = new char[string.length()+2*spaces];
        int j = string.length() - 1;
        for(int i=str.length-1; i>=0; i--) {
            if(string.charAt(j) == ' ') {
                str[i--]='0';
                str[i--]='2';
                str[i] = '%';
            } else {
                str[i] = string.charAt(j);
            }
            j--;
        }
        return str;
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        URLify obj = new URLify(str);
        char[] result = obj.URL();
        System.out.println(new String(result));
    }
}
