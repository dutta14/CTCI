package StacksAndQueues;

import java.util.Scanner;

/**
 * Created by Anindya on 1/30/2017.
 */
public class MinStack extends Stack<Integer> {
    Stack<Integer> mins;

    MinStack() {
        mins = new Stack<>();
    }

    public void push(int value) {
        if(value < min())
            mins.push(value);
        super.push(value);
    }

    public Integer pop() {
        int element = super.pop();
        if(element == mins.peek())
            mins.pop();
        return element;
    }

    public int min() {
        return mins.isEmpty()? Integer.MAX_VALUE: mins.peek();
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        MinStack minStack = new MinStack();
        for(int i=0; i<n; i++) {
            minStack.push(s.nextInt());
        }
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();

    }
}
