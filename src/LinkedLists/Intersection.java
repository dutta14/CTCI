package LinkedLists;

import java.util.Scanner;

/**
 * Created by Anindya on 1/29/2017.
 */
public class Intersection {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int m = s.nextInt();

        LinkedList<Integer> list1 = new LinkedList<>();
        for(int i=0; i<n1; i++)
            list1.add(s.nextInt());

        LinkedList<Integer> list2 = new LinkedList<>();
        for(int i=0; i<n2; i++)
            list2.add(s.nextInt());

        for(int i=0; i<m; i++) {
            Node<Integer> n = new Node<Integer>(s.nextInt());
            list1.add(n);
            list2.add(n);
        }

        LinkedList longer = list1.length > list2.length? list1:list2;
        Node<Integer> h = longer.head;
        Node<Integer> sh = longer == list1? list2.head: list1.head;
        int c = Math.abs(list1.length - list2.length);
        while(c-->0) {
            h = h.next;
        }
        while(h.data != sh.data) {
            h = h.next;
            sh = sh.next;
        }
        System.out.println(h.data);
    }
}
