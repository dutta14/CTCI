package RecursionAndDP;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Anindya on 2/14/2017.
 */
public class Parentheses {

    void generateParen(ArrayList<String> result, int lrem, int rrem, char[] str, int index) {
        if(lrem<0 || rrem<lrem)
            return;
        if(lrem==0 && rrem==0)
            result.add(String.copyValueOf(str));
        else {
            str[index] = '(';
            generateParen(result,lrem-1,rrem,str,index+1);
            str[index] = ')';
            generateParen(result,lrem, rrem-1, str, index+1);
        }
    }

    ArrayList<String> generate(int n) {
        char[] str = new char[n*2];
        ArrayList<String> result = new ArrayList<>();
        generateParen(result,n, n, str,0);
        return result;
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Parentheses obj = new Parentheses();
        ArrayList<String> parens = obj.generate(n);
        System.out.println(parens);
    }
}
