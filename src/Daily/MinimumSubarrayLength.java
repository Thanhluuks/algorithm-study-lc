package Daily;

public class MinimumSubarrayLength {
    static int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
//        An array of size 32 that tracks how many times each bit (0 to 31) has been set to 1 in the current sliding window
        int[] bitCount = new int[32];
        int currentOR = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            currentOR |= nums[right];

            for (int bit = 0; bit < 32; bit++) {
                if ((nums[right] & (1 << bit)) != 0) {
                    bitCount[bit]++;
                }
            }

            while (left <= right && currentOR >= k) {
                minLength = Math.min(minLength, right - left + 1);

                int updatedOR = 0;
                for (int bit = 0; bit < 32; bit++) {
                    if ((nums[left] & (1 << bit)) != 0) {
                        bitCount[bit]--;
                    }
                    if (bitCount[bit] > 0) {
                        updatedOR |= (1 << bit);
                    }
                }
                currentOR = updatedOR;
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,8};
        System.out.println(minimumSubarrayLength(nums,10));
    }
}
