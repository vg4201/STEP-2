import java.util.Scanner;

public class DutyRosterRotation {
    static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        String[] result = new String[n];

        k = k % n;

        for (int i = 0; i < n; i++) {
            int newIndex = (i + k) % n;
            result[newIndex] = names[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        String[] rotated = rotateRoster(names, k);

        System.out.print("[");
        for (int i = 0; i < rotated.length; i++) {
            System.out.print(rotated[i]);
            if (i < rotated.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        sc.close();
    }
}