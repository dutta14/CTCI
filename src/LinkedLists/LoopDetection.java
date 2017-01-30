package LinkedLists;

import java.util.Scanner;

/**
 * Created by Anindya on 1/29/2017.
 */
public class LoopDetection {
    LinkedList<Character> list;

    LoopDetection(LinkedList<Character> list) {
        this.list = list;
    }

    private char detectLoop() {
        Node<Character> slow = list.head, fast = list.head.next;
        while(slow.data != fast.data) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast.data;
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        LinkedList<Character> list = new LinkedList<>();
        for(int i=0; i<n; i++) {
            list.add(s.next().charAt(0));
        }
        int m = s.nextInt();
        Node node = list.get(m);
        list.add(node);

        LoopDetection obj = new LoopDetection(list);
        System.out.println(obj.detectLoop());
    }
}
