import java.util.Scanner;

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRatePerKm();

    String getType() {
        return getClass().getSimpleName().toUpperCase();
    }

    double getFare() {
        double fare = km * getRatePerKm();
        if (fare < 100) {
            fare = 100;
        }
        return fare;
    }
}

interface NightService {
    double applyNightCharge(double fare);
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double getRatePerKm() {
        return 10;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double getRatePerKm() {
        return 14;
    }

    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double getRatePerKm() {
        return 18;
    }

    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            Cab cab;

            if (type.equals("MINI")) {
                cab = new Mini(km);
            } else if (type.equals("SEDAN")) {
                cab = new Sedan(km);
            } else {
                cab = new SUV(km);
            }

            if (time.equals("NIGHT")) {
                if (cab instanceof NightService) {
                    NightService nightCab = (NightService) cab;
                    double fare = nightCab.applyNightCharge(cab.getFare());
                    total += fare;
                    System.out.printf("%s: %.2f%n", type, fare);
                } else {
                    System.out.println(type + ": night service not available");
                }
            } else {
                double fare = cab.getFare();
                total += fare;
                System.out.printf("%s: %.2f%n", type, fare);
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}