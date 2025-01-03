package Daily;

public class WaysToSplitArray {
    static int waysToSplitArray(int[] nums) {
        int n = nums.length;
        int ans = 0;
        long prefixSum = 0;
        long leftSum = nums[0];
        for (int i = 1; i <n ; i++) {
            prefixSum+=nums[i];
        }
        if (leftSum >= prefixSum) ans++;
        for (int i = 1; i <n-1 ; i++) {
            leftSum+=nums[i];
            prefixSum-=nums[i];
            if (leftSum>= prefixSum) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {10,4,-8,7};
        System.out.println(waysToSplitArray(nums));
    }
}
