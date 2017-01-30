package LinkedLists;

import java.util.Scanner;

/**
 * Created by Anindya on 1/29/2017.
 */
public class DeleteMiddleNode {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0; i<n; i++)
            list.add(s.nextInt());

        Node random = list.get(s.nextInt());
        random.data = random.next.data;
        random.next = random.next.next;

        System.out.println(list);
    }
}
