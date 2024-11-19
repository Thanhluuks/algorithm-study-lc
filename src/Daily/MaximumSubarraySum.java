package Daily;

import java.util.HashSet;
import java.util.Set;

public class MaximumSubarraySum {
    static long maximumSubarraySum(int[] nums, int k) {
        long max = 0;
        for (int i = 0; i <= nums.length-k; i++) {
            long sum=0;
            Set<Integer> check = new HashSet<>();
            for (int j = i; j <i+k ; j++) {
                if (!check.add(nums[j])) {
                    sum=0;
                    break;
                } else {
                    sum+=nums[j];
                }
            }
            max=Math.max(max,sum);
        }
        return max;
    }

    static long solution(int[] nums, int k) {
        int n = nums.length;
        long max = 0, sum = 0;
        int l = 0, r = 0;
        Set<Integer> set = new HashSet<>();
        while (r < n) {
            while (set.contains(nums[r]) || r - l + 1 > k) {
                sum -= nums[l];
                set.remove(nums[l]);
                l++;
            }
            sum += nums[r];
            set.add(nums[r]);
            if (r - l + 1 == k) max = Math.max(max, sum);
            r++;
        }
        return max;

    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,7,8,9};
        System.out.println(solution(nums,3));
    }

}
