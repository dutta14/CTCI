package StacksAndQueues;

import java.util.Scanner;

/**
 * Created by Anindya on 2/11/2017.
 */
public class SortStack {
    Stack<Integer> stk;

    void sort() {
        Stack<Integer> s2 = new Stack<>();
        while(!stk.isEmpty()) {
            int temp = stk.pop();
            while(!s2.isEmpty() && s2.peek()> temp)
                stk.push(s2.pop());
            s2.push(temp);
        }
        while(!s2.isEmpty()) {
            stk.push(s2.pop());
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        while(!stk.isEmpty()) {
            s.append(stk.pop()+" ");
        }
        return s.toString();
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        SortStack obj = new SortStack();

        int n = s.nextInt();
        obj.stk = new Stack<>(n);
        for(int i=0; i<n; i++)
            obj.stk.push(s.nextInt());
        obj.sort();
        System.out.println(obj);
    }
}
