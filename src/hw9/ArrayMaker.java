package hw9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArrayMaker {
    private List<Person> people = new ArrayList<>();

    public ArrayMaker() {}

    public void addPerson(Person person) {
        people.add(person);
    }

    public void delete(Person person) {
        people.remove(person);
    }

    public void update() throws IOException, ClassNotFoundException{
        try(FileOutputStream fileOutputStream = new FileOutputStream("src/hw9/personData.bin")) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(people);
        }
    }

    public void getData() throws IOException, ClassNotFoundException{
        List<Person> people1;
        try (FileInputStream fileInputStream = new FileInputStream("src/hw9/personData.bin")){
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            people1 = (List<Person>) objectInputStream.readObject();
        }
        System.out.println("data");
        printArray(people1);
    }

    public void getArray() {
        System.out.println("array");
        printArray(people);
    }

    private void printArray(List<Person> people2) {
        StringBuilder builder = new StringBuilder();
        for (Person p : people2) {
            builder.append("[").append(p.getName()).append(", ").append(p.getAge()).append("]\n");
        }
        System.out.println(builder.toString());
    }
}
