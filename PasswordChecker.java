import java.util.Scanner;

public class PasswordChecker {

    private final String password;

    public PasswordChecker(String password) {
        if (password == null) {
            this.password = "";
        } else {
            this.password = password;
        }
    }

    public String getStrength() {
        int length = password.length();

        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        PasswordChecker checker =
                new PasswordChecker(password);

        System.out.println("Password strength: "
                + checker.getStrength());

        scanner.close();
    }
}