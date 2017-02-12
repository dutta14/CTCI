package StacksAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Created by Anindya on 1/31/2017.
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


public class Stack<T> {
    Node<T> top;
    int size;
    int length;

    Stack() {
        top = null;
        size = Integer.MAX_VALUE;
        length = 0;
    }

    Stack(int size) {
        this.size = size;
        length = 0;
    }

    boolean isEmpty() {
        return top==null;
    }

    boolean isFull() {
        return size!=Integer.MAX_VALUE && length==size;
    }

    void push(T data) {
        if(isFull())
            throw new StackOverflowError();
        if(top == null) {
            top = new Node<T>(data);
        } else {
            Node node = new Node<T>(data,top);
            top = node;
        }
        length++;
    }

    T pop() {
        if(top == null) {
            throw new EmptyStackException();
        } else {
            T val = top.data;
            top = top.next;
            length--;
            return val;
        }
    }

    T peek() {
        return top.data;
    }
}
