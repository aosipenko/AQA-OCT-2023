package org.prog.poly;

public class Human implements IMovable {
    @Override
    public int currentSpeed() {
        return 0;
    }

    @Override
    public void turnLeft() {
        System.out.println("Human walks left");
    }

    @Override
    public void turnRight() {
        System.out.println("Human walks right");
    }

    @Override
    public void accelerate() {
        System.out.println("Human walks faster");
    }

    @Override
    public void stop() {
        System.out.println("Human walks slower");
    }
}
