package LinkedLists;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Anindya on 1/29/2017.
 */
public class RemoveDups {
    LinkedList<Integer> list;

    RemoveDups(LinkedList<Integer> list) {
        this.list = list;
    }

    private void removeSet() {
        HashSet<Integer> values = new HashSet<>();
        for(int i=0; i<list.size(); i++) {
            if (!values.add(list.get(i)))
                list.remove(i);
        }
    }

    private void remove() {
        for(int i=0; i<list.size()-1; i++) {
            for(int j=i+1; j<list.size(); j++) {
                if(list.get(i) == list.get(j))
                    list.remove(j);
            }
        }
    }

    public static void main(String args[]) {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i=0; i<n; i++) {
            list.add(s.nextInt());
        }

        RemoveDups obj = new RemoveDups(list);
        obj.removeSet();
        System.out.println(list);
    }
}
