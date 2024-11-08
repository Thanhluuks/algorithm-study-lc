package Daily;

import java.util.Arrays;

public class GetMaximumXor {
    static int[] getMaximumXor(int[] nums, int maximumBit) {
        int maxK = (1 << maximumBit) - 1;
        int totalXOR = 0;
        for (int num : nums) {
            totalXOR ^= num;
        }

        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            answer[i] = totalXOR ^ maxK;

            totalXOR ^= nums[nums.length - 1 - i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,1,3};
        int max = 2;
        System.out.println(Arrays.toString(getMaximumXor(nums, max)));
    }
}
