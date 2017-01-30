package LinkedLists;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Anindya on 1/29/2017.
 */
public class Palindrome {

    LinkedList<Integer> list;

    Palindrome(LinkedList<Integer> list) {
        this.list = list;
    }

    private boolean isPalindrome() {
        Stack<Integer> stk = new Stack<>();
        Node<Integer> slow = list.head, fast = list.head;
        while(fast!=null) {
            stk.push(slow.data);
            slow = slow.next;
            if(fast.next!= null)
              fast = fast.next.next;
            else
                fast = fast.next;
        }

        if(list.length % 2 == 1)
            stk.pop();

        while(slow !=null) {
            if(!(slow.data == stk.pop()))
                return false;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0; i<n; i++)
            list.add(s.nextInt());

        Palindrome obj = new Palindrome(list);
        boolean result = obj.isPalindrome();
        System.out.println(result);
    }
}
