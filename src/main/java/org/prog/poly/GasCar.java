package org.prog.poly;

public class GasCar implements IMovable {

    public void fuelCar() {

    }

    @Override
    public int currentSpeed() {
        return 0;
    }

    @Override
    public void turnLeft() {
        System.out.println("Gas car turns left");
    }

    @Override
    public void turnRight() {
        System.out.println("Gas car turns right");
    }

    @Override
    public void accelerate() {
        System.out.println("Gas car goes faster");
    }

    @Override
    public void stop() {
        System.out.println("Gas car slows down");
    }

    public void goTo(String city, String destination) {
        goTo(city, destination, "no additional stops");
    }

    public void goTo(String city, String destination, String passingThrough) {
        goTo(city, destination, passingThrough, 0);
    }

    public void goTo(String city, String destination, String passingThrough, int passengers) {
        System.out.println("Car is going from " + city + " to " + destination +
                " passing through " + passingThrough + " with " + passengers + " passengers on board");
    }

    //TODO: add one more overload, add split fuel payment
}
