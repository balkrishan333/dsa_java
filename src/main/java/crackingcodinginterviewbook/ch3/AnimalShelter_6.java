package crackingcodinginterviewbook.ch3;

import java.util.ArrayDeque;
import java.util.Deque;

public class AnimalShelter_6 {

    private Deque<Dog> dogs = new ArrayDeque<>();
    private Deque<Cat> cats = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        AnimalShelter_6 obj = new AnimalShelter_6();
        obj.enqueue(new Dog());
        Thread.sleep(2);
        obj.enqueue(new Cat());
        Thread.sleep(2);
        obj.enqueue(new Dog());
        Thread.sleep(2);
        obj.enqueue(new Cat());
        Thread.sleep(2);
        obj.enqueue(new Cat());
        Thread.sleep(2);
        obj.enqueue(new Dog());

        System.out.println(obj.dequeueAny());
        System.out.println(obj.dequeueAny());
        System.out.println(obj.dequeueAny());
        System.out.println(obj.dequeueAny());
        System.out.println(obj.dequeueAny());
        System.out.println(obj.dequeueAny());
    }

    public void enqueue(Animal dogOrCat) {
        dogOrCat.time = System.currentTimeMillis();
        if (dogOrCat instanceof Dog) {
            Dog dog = (Dog)dogOrCat;
            dogs.add(dog);
        } else {
            Cat cat = (Cat)dogOrCat;
            cats.add(cat);
        }
    }

    public Animal dequeueAny() {
        if (dogs.size() == 0 && cats.size() == 0) {
            return null;
        }

        if (dogs.size() == 0) {
            return cats.poll();
        }

        if (cats.size() == 0) {
            return dogs.poll();
        }

        if (dogs.peek().time < cats.peek().time) {
            return dogs.poll();
        }

        return cats.poll();
    }

    public Dog dequeueDog() {
        return dogs.poll();
    }

    public Cat dequeueCat() {
        return cats.poll();
    }

    static class Animal {
        long time;
    }

    static class Dog extends Animal {

    }

    static class Cat extends Animal {

    }
}
