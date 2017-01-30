package LinkedLists;

/**
 * Created by Anindya on 1/29/2017.
 */

class Node<T> {
    T data;
    Node next;

    Node(T data) {
        this.data = data;
        next = null;
    }

    Node (T data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class LinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int length;

    LinkedList() {
        head = tail = null;
        length = 0;
    }

    void add(T data) {
        Node temp = new Node(data);
        if(head == null)
            head = tail = temp;
        else {
            tail.next = temp;
            tail = temp;
        }
        length++;
    }

    void add(Node data) {
        if(head == null)
            head = tail = data;
        else {
            tail.next = data;
            tail = data;
        }
        length++;
    }

    void add(LinkedList<T> list) {
        tail.next = list.head;
        length+=list.length;
    }

    Node<T> get(int i) {
        int c = 1;
        Node temp = head;
        while(c++ < i) {
            temp = temp.next;
        }
        return temp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node temp = head;
        while(temp!=null) {
            sb.append(temp.data).append(", ");
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
