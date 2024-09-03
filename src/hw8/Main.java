package hw8;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> myClass = Class.forName("java.lang.String");
        Method[] methods = myClass.getMethods();
        for (Method i: methods) {
            System.out.println(i);
        }
    }
}
