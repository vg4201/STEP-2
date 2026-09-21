import java.util.Scanner;

public class MinimumInRotatedArray {

    static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] > nums[right]) {
               
                left = middle + 1;
            } else {
               
                right = middle;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter rotated sorted array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int result = findMin(nums);

        System.out.println("Minimum Element: " + result);

        scanner.close();
    }
}