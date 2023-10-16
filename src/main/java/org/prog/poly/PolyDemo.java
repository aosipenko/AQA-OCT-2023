package org.prog.poly;

public class PolyDemo {
    public static void main(String[] args) {
        GasCar gasCar = new GasCar();
        ElectricCar electricCar = new ElectricCar();
        Bike bike = new Bike();
        Human human = new Human();
        GasTruck gasTruck = new GasTruck();
        HugeTruck hugeTruck = new HugeTruck();

//        followTheRoute(gasCar);
//        followTheRoute(electricCar);
//        followTheRoute(bike);
//        followTheRoute(human);
//        followTheRoute(gasTruck);
       followTheRoute(hugeTruck);

        System.out.println("==========================");

        gasCar.goTo("Kyiv", "Odessa");
        gasCar.goTo("Kharkiv", "Uman", "Kyiv");
        gasTruck.goTo("Lviv", "Odessa", "Ivano-Frankivs'k", 5);
        gasCar.goTo("Odessa", "Kyiv", "Uman", 3, 12)0;

    }

    public static void followTheRoute(IMovable iCar) {
        System.out.println("==========================");
        iCar.accelerate();
        iCar.turnLeft();
        iCar.accelerate();
        iCar.stop();
        iCar.turnRight();
        iCar.accelerate();
    }
}
