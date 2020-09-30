package Practice;

import java.util.HashMap;

public class CarModel {
    private String brand;
    private String model;
    private String year;
    private int mileage;
    private String plateNumber;
    private String color;
    private String ownerName;

    public void drive(int speed) {
        System.out.printf("The %s running\n", this.brand);
    }

    public void changeOwner(String newName) {
        this.ownerName = newName;
    }
}