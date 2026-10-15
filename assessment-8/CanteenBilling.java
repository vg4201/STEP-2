import java.util.Scanner;

abstract class Customer {
    abstract double getFinalAmount(double amount);
    abstract String getType();
}

class Student extends Customer {
    double getFinalAmount(double amount) {
        return amount * 0.90;
    }

    String getType() {
        return "STUDENT";
    }
}

class Staff extends Customer {
    double getFinalAmount(double amount) {
        return amount * 0.95;
    }

    String getType() {
        return "STAFF";
    }
}

class Guest extends Customer {
    double getFinalAmount(double amount) {
        return amount + 10;
    }

    String getType() {
        return "GUEST";
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Customer customer;

            if (type.equals("STUDENT")) {
                customer = new Student();
            } else if (type.equals("STAFF")) {
                customer = new Staff();
            } else {
                customer = new Guest();
            }

            double finalAmount = customer.getFinalAmount(amount);
            total += finalAmount;
            System.out.printf("%s: %.2f%n", customer.getType(), finalAmount);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}