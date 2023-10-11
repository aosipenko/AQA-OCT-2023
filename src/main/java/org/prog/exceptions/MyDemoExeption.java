package org.prog.exceptions;

public class MyDemoExeption {
    public MyDemoExeption() {
    }
    public static void main(String[] args) {
        try {
            String str = null;
            System.out.println(((String)str).length());
        } catch (NullPointerException var2) {
            System.out.println("NullPointerException: " + var2.getMessage());
        }

    }
}
