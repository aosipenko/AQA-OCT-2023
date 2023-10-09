package org.prog.poly;

public class ElectricCar implements IMovable {

    public void chargeCar() {

    }

    @Override
    public int currentSpeed() {
        return 0;
    }

    @Override
    public void turnLeft() {
        System.out.println("ECar turns left");
    }

    @Override
    public void turnRight() {
        System.out.println("ECar turns right");
    }

    @Override
    public void accelerate() {
        System.out.println("ECar accelerates");
    }

    @Override
    public void stop() {
        System.out.println("ECar slows down");
    }
}
