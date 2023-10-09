package org.prog.poly;

public class Bike implements IMovable {
    @Override
    public int currentSpeed() {
        return 0;
    }

    @Override
    public void turnLeft() {
        System.out.println("Bike turns left");
    }

    @Override
    public void turnRight() {
        System.out.println("Bike turns right");
    }

    @Override
    public void accelerate() {
        System.out.println("Bike accelerates");
    }

    @Override
    public void stop() {
        System.out.println("Bike slows down");
    }
}
