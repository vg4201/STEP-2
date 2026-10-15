import java.util.Scanner;

public class ExamScoreBandCounter {
    static int firstIndexAtLeast(int[] scores, int low) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (scores[mid] >= low) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    static int firstIndexGreaterThan(int[] scores, int high) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (scores[mid] > high) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    static int countInBand(int[] scores, int low, int high) {
        int start = firstIndexAtLeast(scores, low);
        int end = firstIndexGreaterThan(scores, high);

        return end - start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        int low = sc.nextInt();
        int high = sc.nextInt();

        System.out.println(countInBand(scores, low, high));

        sc.close();
    }
}