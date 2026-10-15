import java.util.Scanner;

abstract class Vehicle {
    abstract double getCharge(int hours);
    abstract String getType();
}

class Bike extends Vehicle {
    double getCharge(int hours) {
        return hours * 10;
    }

    String getType() {
        return "BIKE";
    }
}

class Car extends Vehicle {
    double getCharge(int hours) {
        if (hours == 1) {
            return 30;
        }
        return 30 + (hours - 1) * 20;
    }

    String getType() {
        return "CAR";
    }
}

class Truck extends Vehicle {
    double getCharge(int hours) {
        double charge = hours * 50;
        if (charge < 100) {
            return 100;
        }
        return charge;
    }

    String getType() {
        return "TRUCK";
    }
}

public class ParkingCharge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            Vehicle vehicle;

            if (type.equals("BIKE")) {
                vehicle = new Bike();
            } else if (type.equals("CAR")) {
                vehicle = new Car();
            } else {
                vehicle = new Truck();
            }

            double charge = vehicle.getCharge(hours);
            total += charge;
            System.out.printf("%s: %.2f%n", vehicle.getType(), charge);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}