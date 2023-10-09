package org.prog.poly;

public class GasTruck extends GasCar {



    @Override
    public void turnLeft() {
        System.out.println("Gas truck slows down and turns left");
    }

    @Override
    public void turnRight() {
        System.out.println("Gas truck slows down and turns right");
    }
}
