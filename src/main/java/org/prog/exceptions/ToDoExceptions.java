package org.prog.exceptions;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ToDoExceptions {
        public static void main(String[] args) {
            equalsA("b");
            equalsA("a");
            equalsA("");
            equalsA(null);

            try {
                doSmth();
                doAnother();
                causeNullPointerException(); // Вызываем новый метод
            } catch (NullPointerException e) {
                System.out.println("caught a NullPointerException: " + e.getMessage());
            } catch (Throwable e) {
                System.out.println("this is another exception");
            } finally {
                System.out.println("this code is always executed");
            }
            System.out.println("test2");
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

        public static void causeNullPointerException() {
            String str = null;
            System.out.println(str.length()); // Вызываем NullPointerException
        }
    }