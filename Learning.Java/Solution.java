import java.util.Arrays;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] sums = new int[2];
        boolean sumMark = false;
        System.out.println(sumMark);
        for (int a = 0; a < nums.length -1; a ++) {
            int num1 = nums[a];

            for (int b = 1; b < nums.length; b ++) {
                int num2 = nums[b];

                if ((num1 + num2)== target ) {
                    sums[0] = a;
                    sums[1] = b;
                    sumMark = true;
                    break;
                }

            }
            System.out.println(sumMark);
            System.out.println(Arrays.toString(sums));
            if (sumMark == true) {
                break;
            }
        }
        return sums;
    }

    public static void main(String[] args) {
        int[] numbers = {3,2,4};
        System.out.println(twoSum(numbers, 6));
    }
}
