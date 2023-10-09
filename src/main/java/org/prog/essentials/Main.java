package org.prog.essentials;

public class Main {

    public static void main(String[] args) {
        Car car = new Car();
        car.printNumber();
        car.color = "red";

        Crossover crossover = new Crossover();
        Humvee humvee = new Humvee();

        crossover.color = "green";
        crossover.printNumber();
        crossover.set4X4();

        humvee.color = "green";
        humvee.set4X4();
        humvee.printNumber();
        humvee.lebedka();
    }
}
