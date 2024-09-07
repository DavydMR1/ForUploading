package hw9;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("aaaa", 22);
        Person person1 = new Person("bbbb", 23);
        Person person2 = new Person("cccc", 24);
        Person person3 = new Person("dddd", 25);

        ArrayMaker arrayMaker = new ArrayMaker();

        arrayMaker.addPerson(person);
        arrayMaker.addPerson(person1);
        arrayMaker.addPerson(person2);
        arrayMaker.getArray();
        arrayMaker.update();
        arrayMaker.getData();
        arrayMaker.delete(person2);
        arrayMaker.addPerson(person3);
        arrayMaker.getArray();
        arrayMaker.getData();
    }
}
