package RecursionAndDP;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Anindya on 2/14/2017.
 */
public class PermutationsWithoutDups {

    String getString(String word, char first, int i) {
        StringBuilder str = new StringBuilder(word);
        str.insert(i,first);
        return str.toString();
    }

    ArrayList<String> getPerms(String str) {
        if(str == null)
            return null;
        ArrayList<String> perms = new ArrayList<>();
        if(str.length() == 0) {
            perms.add("");
            return perms;
        }
        char first = str.charAt(0);
        String rest = str.substring(1);
        ArrayList<String> words = getPerms(rest);
        for(String word: words) {
            for(int i=0; i<=word.length(); i++) {
                perms.add(getString(word,first,i));
            }
        }
        return perms;
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        PermutationsWithoutDups obj = new PermutationsWithoutDups();
        ArrayList<String> perms = obj.getPerms(str);
        System.out.println(perms);
    }
}
