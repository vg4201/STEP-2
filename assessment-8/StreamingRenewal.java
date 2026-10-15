import java.util.Scanner;
import java.time.LocalDate;

abstract class Plan {
    abstract int getValidityDays();
}

class BasicPlan extends Plan {
    int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends Plan {
    int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends Plan {
    int getValidityDays() {
        return 365;
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String planType = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());
            Plan plan;

            if (planType.equals("BASIC")) {
                plan = new BasicPlan();
            } else if (planType.equals("STANDARD")) {
                plan = new StandardPlan();
            } else {
                plan = new PremiumPlan();
            }

            LocalDate renewalDate = startDate.plusDays(plan.getValidityDays());
            System.out.println(name + ": " + renewalDate);
        }

        sc.close();
    }
}