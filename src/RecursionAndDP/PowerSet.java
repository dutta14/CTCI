package RecursionAndDP;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Anindya on 2/13/2017.
 */
public class PowerSet {

    ArrayList<ArrayList<Integer>> getPowerSet(ArrayList<Integer> set) {
        int n = 1<<set.size();
        ArrayList<ArrayList<Integer>> pSet = new ArrayList<>();
        for(int i=0;  i<n; i++) {
            pSet.add(getSet(i,set));
        }
        return pSet;
    }

    ArrayList<Integer> getSet(int i, ArrayList<Integer> set) {
        int index = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        for(;i>0; i>>=1, index++) {
            if((i&1)==1)
            temp.add(set.get(index));
        }
        return temp;
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n= s.nextInt();
        ArrayList<Integer> set = new ArrayList<>();
        for(int i=0; i<n; i++) {
            set.add(s.nextInt());
        }

        PowerSet obj = new PowerSet();
        ArrayList<ArrayList<Integer>> powerSet = obj.getPowerSet(set);
        System.out.println(powerSet);
    }
}
