package RecursionAndDP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Anindya on 2/14/2017.
 */
public class PermutationsWithDups {

    ArrayList<String> getPerms(String str) {
        ArrayList<String> result = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        printPerms(map,"",str.length(),result);
        return result;
    }

    void printPerms(HashMap<Character,Integer> map, String prefix, int remaining, ArrayList<String> result) {
        if(remaining == 0) {
            result.add(prefix);
            return;
        }
        for(char c: map.keySet()) {
            int count = map.get(c);
            if(c>0) {
                map.put(c,count-1);
                printPerms(map,prefix+c,remaining-1,result);
                map.put(c,count);
            }
        }
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        PermutationsWithDups obj = new PermutationsWithDups();
        ArrayList<String> perms = obj.getPerms(str);
        System.out.println(perms);
    }
}
