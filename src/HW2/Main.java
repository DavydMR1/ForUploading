package HW2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        boolean pineapple = true;
        int animal;
        int action;
        Random random = new Random();
        //int wait = 1000;
        Cat cat = new Cat("Tom");
        Eagle eagle = new Eagle("Innokenty");
        Turtle turtle = new Turtle("Natasha");
        Duck duck = new Duck(" ");

        System.out.println(cat.name);

        while (pineapple){
            //Thread.sleep(wait);
            animal = random.nextInt(4);
            action = random.nextInt(3);
            if (animal == 0) {
                if (action == 0) {cat.fly();}
                if (action == 1) {cat.walk();}
                if (action == 2) {cat.swim();}
            }
            if (animal == 1) {
                if (action == 0) {eagle.fly();}
                if (action == 1) {eagle.walk();}
                if (action == 2) {eagle.swim();}
            }
            if (animal == 2) {
                if (action == 0) {turtle.fly();}
                if (action == 1) {turtle.walk();}
                if (action == 2) {turtle.swim();}
            }
            if (animal == 3) {
                if (action == 0) {duck.fly();}
                if (action == 1) {duck.walk();}
                if (action == 2) {duck.swim();}
            }
        }
    }
}