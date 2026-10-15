import java.util.Scanner;

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    abstract String getName();

    double getUnits() {
        return getPower() * hours / 1000;
    }

    double getCost() {
        return getUnits() * 8;
    }
}

interface SaverMode {
    double applySaverMode(double units);
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }

    String getName() {
        return "FRIDGE";
    }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    String getName() {
        return "AC";
    }

    public double applySaverMode(double units) {
        return units * 0.75;
    }
}

class Television extends Appliance {
    Television(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }

    String getName() {
        return "TV";
    }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    String getName() {
        return "WASHER";
    }

    public double applySaverMode(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();
            String mode = "";

            if (sc.hasNext()) {
                mode = sc.next();
            }

            Appliance appliance;

            if (type.equals("FRIDGE")) {
                appliance = new Fridge(hours);
            } else if (type.equals("AC")) {
                appliance = new AirConditioner(hours);
            } else if (type.equals("TV")) {
                appliance = new Television(hours);
            } else {
                appliance = new WashingMachine(hours);
            }

            if (mode.equals("SAVER")) {
                if (appliance instanceof SaverMode) {
                    SaverMode saverAppliance = (SaverMode) appliance;
                    double units = saverAppliance.applySaverMode(appliance.getUnits());
                    double cost = units * 8;
                    totalCost += cost;
                    System.out.printf("%s: Units=%.2f Cost=%.2f%n", appliance.getName(), units, cost);
                } else {
                    System.out.println(appliance.getName() + ": saver mode not supported");
                }
            } else {
                double units = appliance.getUnits();
                double cost = appliance.getCost();
                totalCost += cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f%n", appliance.getName(), units, cost);
            }
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}