package LinkedLists;


import java.util.Scanner;

/**
 * Created by Anindya on 1/29/2017.
 */
public class SumLists {

    LinkedList<Integer> l1, l2;

    SumLists(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        this.l1 = l1;
        this.l2 = l2;
    }

    private LinkedList<Integer> sum() {
        LinkedList<Integer> result = new LinkedList<>();
        int carry = 0;
        Node<Integer> temp1 = l1.head, temp2 = l2.head;
        while (temp1!=null || temp2!=null) {
            int sum = (temp1==null?0:temp1.data) + (temp2==null?0:temp2.data) + carry;
            carry = sum/10;
            sum%=10;
            result.add(sum);
            if(temp1 !=null)
                temp1 = temp1.next;
            if(temp2 != null)
                temp2 = temp2.next;
        }
        if(carry != 0)
            result.add(carry);
        return result;
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        LinkedList<Integer> l1 = new LinkedList<>();
        for(int i=0; i<n1; i++) {
            l1.add(s.nextInt());
        }

        int n2 = s.nextInt();
        LinkedList<Integer> l2 = new LinkedList<>();
        for(int i=0; i<n2; i++) {
            l2.add(s.nextInt());
        }

        SumLists obj = new SumLists(l1,l2);
        LinkedList<Integer> sum = obj.sum();
        System.out.println(sum);
    }
}
