import java.util.Scanner;

public class SeatingGridOptimizer {

    private static double rowAverage(int[] row) {
        if (row.length == 0) {
            return 0.0;
        }

        int total = 0;

        for (int score : row) {
            total += score;
        }

        return (double) total / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            double average = rowAverage(seatingScores[i]);

            String zone;

            if (average < threshold) {
                zone = "Quiet Zone";
            } else {
                zone = "Buzzing Zone";
            }

            result.append("Row ")
                    .append(i)
                    .append(": ")
                    .append(zone);

            if (i < seatingScores.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();

        int[][] seatingScores = new int[rows][];

        for (int i = 0; i < rows; i++) {
            System.out.print("Enter number of scores in row "
                    + i + ": ");

            int columns = scanner.nextInt();
            seatingScores[i] = new int[columns];

            System.out.println("Enter scores for row " + i + ":");

            for (int j = 0; j < columns; j++) {
                seatingScores[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter threshold: ");
        int threshold = scanner.nextInt();

        System.out.println(classifyRows(seatingScores, threshold));

        scanner.close();
    }
}