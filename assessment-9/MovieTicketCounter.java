import java.util.Scanner;

abstract class Ticket {
    int count;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPricePerTicket();

    double getAmount() {
        return (getPricePerTicket() + 20) * count;
    }

    abstract String getSeatType();
}

class RegularTicket extends Ticket {
    RegularTicket(int count) {
        super(count);
    }

    double getPricePerTicket() {
        return 150;
    }

    String getSeatType() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) {
        super(count);
    }

    double getPricePerTicket() {
        return 250;
    }

    String getSeatType() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) {
        super(count);
    }

    double getPricePerTicket() {
        return 400;
    }

    String getSeatType() {
        return "RECLINER";
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();
            Ticket ticket;

            if (seat.equals("REGULAR")) {
                ticket = new RegularTicket(count);
            } else if (seat.equals("PREMIUM")) {
                ticket = new PremiumTicket(count);
            } else {
                ticket = new ReclinerTicket(count);
            }

            double amount = ticket.getAmount();
            total += amount;
            System.out.printf("%s: %.2f%n", ticket.getSeatType(), amount);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}