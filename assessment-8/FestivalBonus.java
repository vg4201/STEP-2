import java.util.Scanner;

abstract class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double getBonus();
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double getBonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double getBonus() {
        return salary * 0.05;
    }
}

class Intern extends Employee {
    Intern(String name, double salary) {
        super(name, salary);
    }

    double getBonus() {
        return 2000;
    }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            Employee employee;

            if (type.equals("FULLTIME")) {
                employee = new FullTimeEmployee(name, salary);
            } else if (type.equals("PARTTIME")) {
                employee = new PartTimeEmployee(name, salary);
            } else {
                employee = new Intern(name, salary);
            }

            double bonus = employee.getBonus();
            total += bonus;
            System.out.printf("%s: %.2f%n", employee.name, bonus);
        }

        System.out.printf("Total Bonus: %.2f%n", total);
        sc.close();
    }
}