import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarraySumEqualsK {

    static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumFrequency =
                new HashMap<>();

        prefixSumFrequency.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int number : nums) {
            currentSum += number;

            int requiredSum = currentSum - k;

            if (prefixSumFrequency.containsKey(requiredSum)) {
                count += prefixSumFrequency.get(requiredSum);
            }

            prefixSumFrequency.put(
                    currentSum,
                    prefixSumFrequency.getOrDefault(currentSum, 0) + 1
            );
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter k: ");
        int k = scanner.nextInt();

        int result = subarraySum(nums, k);

        System.out.println("Number of subarrays: " + result);

        scanner.close();
    }
}