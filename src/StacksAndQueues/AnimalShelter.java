package StacksAndQueues;

import LinkedLists.LinkedList;

/**
 * Created by Anindya on 2/11/2017.
 */
public class AnimalShelter {}

abstract class Animal {
    private int order;
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isOlderThan(Animal o) {
        return this.order < o.getOrder();
    }

    public int getOrder() {
        return order;
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }
}

class AnimalQueue {
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();

    private int order = 0;

    void enqueue(Animal a) {
        a.setOrder(order);
        order++;
        if(a instanceof Cat)
            cats.add((Cat)a);
        else if(a instanceof Dog)
            dogs.add((Dog)a);
    }

    Dog dequeueDogs() {
        return dogs.poll();
    }

    Cat dequeueCats() {
        return cats.poll();
    }

    Animal dequeueAny() {
        if(dogs.isEmpty())
            return cats.poll();
        if(cats.isEmpty())
            return dogs.poll();
        Dog d = dogs.peek();
        Cat c = cats.peek();
        if(d.getOrder() <  c.getOrder())
            return dogs.poll();
        return cats.poll();
    }


}