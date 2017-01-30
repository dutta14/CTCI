package LinkedLists;

import java.util.Scanner;

/**
 * Created by Anindya on 1/29/2017.
 */
public class KthToLast {

    LinkedList<Integer> list;
    int k;

    KthToLast(LinkedList<Integer> list, int k) {
        this.list = list;
        this.k = k;
    }

    private int find() {
        int i=0;
        Node<Integer> fast = list.head;
        Node<Integer> slow = list.head;
        while(i++ < k) {
            fast = fast.next;
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }

    public static void main(String args[]) {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i=0; i<n; i++) {
            list.add(s.nextInt());
        }
        int k = s.nextInt();

        KthToLast obj = new KthToLast(list,k);
        int solution = obj.find();
        System.out.println(solution);

    }
}
