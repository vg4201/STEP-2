import java.util.Scanner;

abstract class Room {
    abstract double getBill(int units);
    abstract String getType();
}

class SingleRoom extends Room {
    double getBill(int units) {
        return units * 8;
    }

    String getType() {
        return "SINGLE";
    }
}

class SharedRoom extends Room {
    int occupants;

    SharedRoom(int occupants) {
        this.occupants = occupants;
    }

    double getBill(int units) {
        return (units * 6.0) / occupants;
    }

    String getType() {
        return "SHARED";
    }
}

class ACRoom extends Room {
    double getBill(int units) {
        return units * 10 + 200;
    }

    String getType() {
        return "AC";
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Room room;

            if (type.equals("SINGLE")) {
                room = new SingleRoom();
            } else if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                room = new SharedRoom(occupants);
            } else {
                room = new ACRoom();
            }

            double bill = room.getBill(units);
            total += bill;
            System.out.printf("%s: %.2f%n", room.getType(), bill);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}