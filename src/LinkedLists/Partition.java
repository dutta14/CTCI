package LinkedLists;

import java.util.Scanner;

/**
 * Created by Anindya on 1/29/2017.
 */
public class Partition {

    LinkedList<Integer> list;
    int key;

    Partition(LinkedList<Integer> list, int key) {
        this.list = list;
        this.key = key;
    }

    void partition() {
        LinkedList<Integer> small = new LinkedList<>(),
                larger = new LinkedList<>();

        Node<Integer> head = list.head;
        boolean contains = false;
        while(head!=null) {
            if(head.data < key)
                small.add(head.data);
            else if(head.data > key)
                larger.add(head.data);
            else
                contains = true;
            head = head.next;

        }
        if(contains) {
            small.add(key);
        }
        small.add(larger);
        list = small;

    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0; i<n; i++) {
            list.add(s.nextInt());
        }
        int k = s.nextInt();

        Partition obj = new Partition(list,k);
        obj.partition();
        System.out.println(obj.list);

    }
}
