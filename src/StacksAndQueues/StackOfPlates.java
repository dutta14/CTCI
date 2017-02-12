package StacksAndQueues;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Anindya on 1/31/2017.
 */

class Plate {}

public class StackOfPlates {

    ArrayList<Stack<Plate>> stacks;
    int size;

    StackOfPlates(int size) {
        stacks = new ArrayList<>();
        this.size = size;
    }

    void push(Plate p) {
        if(stacks.size() == 0 || stacks.get(stacks.size()-1).isFull()) {
            stacks.add(new Stack(size));
        }
        getLastStack().push(p);
    }

    Plate pop() {
        if(stacks.isEmpty())
            return null;
        Plate p = (Plate) getLastStack().pop();
        if(getLastStack().isEmpty())
            stacks.remove(stacks.get(stacks.size()-1));
        return p;
    }

    public Stack getLastStack() {
        return stacks.get(stacks.size()-1);
    }

    public static void main() {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        StackOfPlates obj = new StackOfPlates(size);
    }


}
