import java.util.Scanner;

public class BusiestBusRow {
    static int[] busiestRow(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int busiestIndex = 0;
        int busiestTotal = 0;

        for (int i = 0; i < rows; i++) {
            int rowTotal = 0;

            for (int j = 0; j < cols; j++) {
                rowTotal += grid[i][j];
            }

            if (i == 0 || rowTotal > busiestTotal) {
                busiestTotal = rowTotal;
                busiestIndex = i;
            }
        }

        return new int[] {busiestIndex, busiestTotal};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] grid = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);

        sc.close();
    }
}