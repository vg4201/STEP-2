import java.util.Scanner;

abstract class Parcel {
    double weight;
    double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double getCharge();

    abstract String getType();

    double getInsurance() {
        return 0;
    }

    double getTotal() {
        return getCharge() + getInsurance();
    }
}

interface Insurable {
    double getInsurance(double declaredValue);
}

class StandardParcel extends Parcel {
    StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double getCharge() {
        return 40 + weight * 10;
    }

    String getType() {
        return "STANDARD";
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double getCharge() {
        return 80 + weight * 15;
    }

    String getType() {
        return "EXPRESS";
    }

    public double getInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }

    double getInsurance() {
        return getInsurance(declaredValue);
    }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double getCharge() {
        return 40 + weight * 10 + 50;
    }

    String getType() {
        return "FRAGILE";
    }

    public double getInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }

    double getInsurance() {
        return getInsurance(declaredValue);
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();
            Parcel parcel;

            if (type.equals("STANDARD")) {
                parcel = new StandardParcel(weight, declaredValue);
            } else if (type.equals("EXPRESS")) {
                parcel = new ExpressParcel(weight, declaredValue);
            } else {
                parcel = new FragileParcel(weight, declaredValue);
            }

            double charge = parcel.getCharge();
            double insurance = parcel.getInsurance();
            double total = parcel.getTotal();
            grandTotal += total;

            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", parcel.getType(), charge, insurance, total);
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}