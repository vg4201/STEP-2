import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeSum {

    static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);

        List<int[]> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }


            if (nums[i] > 0) {
                break;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    triplets.add(new int[]{
                            nums[i], nums[left], nums[right]
                    });

                    left++;
                    right--;

        
                    while (left < right &&
                            nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right &&
                            nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        int[][] result = new int[triplets.size()][];

        for (int i = 0; i < triplets.size(); i++) {
            result[i] = triplets.get(i);
        }

        return result;
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

        int[][] result = threeSum(nums);

        System.out.println("Unique triplets:");

        for (int[] triplet : result) {
            System.out.println(Arrays.toString(triplet));
        }

        scanner.close();
    }
}