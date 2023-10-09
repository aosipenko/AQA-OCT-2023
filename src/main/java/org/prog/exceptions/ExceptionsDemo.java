package org.prog.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionsDemo {

    //TODO: write catch for null pointer exception
    //TODO: write method that will cause NPE

    public static void main(String[] args) {

        equalsA("b");
        equalsA("a");
        equalsA("");
        equalsA(null);
//
//        try {
//            doSmth();
//            doAnother();
//        } catch (Throwable e) {
//            System.out.println("This is another exception");
//        } finally {
//            System.out.println("this code is always executed");
//        }
//        System.out.println("test2");
    }

    public static void doSmth() throws FileNotFoundException {
        FileReader reader = new FileReader(new File("C:\\test.txt"));
        System.out.println("test");
    }

    public static void doAnother() throws Exception {
        throw new Exception("another exception");
    }

    public static void printStuffLength(String value) {
        System.out.println(value.length());
    }

    public static void equalsA(String value) {
        System.out.println("a".equals(value));
    }
}
