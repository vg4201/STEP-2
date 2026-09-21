import java.util.Scanner;

public class PayrollAccount {

    private double basicSalary;
    private double bonus;

    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println(
                    "Warning: Negative salary is not allowed.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }

        this.bonus = 0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println(
                    "Invalid bonus: amount must be positive.");
        } else {
            bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println(
                    "Invalid tax: percent must be between 0 and 100.");
        } else {
            basicSalary -= basicSalary * percent / 100;
            System.out.println("Tax deducted: " + percent + "%");
        }
    }

    public double getNetSalary() {
        return basicSalary + bonus;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter basic salary: ");
        double basicSalary = scanner.nextDouble();

        PayrollAccount account =
                new PayrollAccount(basicSalary);

        System.out.print("Enter bonus: ");
        double bonus = scanner.nextDouble();
        account.creditBonus(bonus);

        System.out.print("Enter tax percentage: ");
        double taxPercent = scanner.nextDouble();
        account.deductTax(taxPercent);

        System.out.println("Net salary: Rs "
                + account.getNetSalary());

        scanner.close();
    }
}