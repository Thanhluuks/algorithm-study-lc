package Daily;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarray {
    static int shortestSubarray(int[] nums, int k) {
        int ans = nums.length+1;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum>= k) return 1;
            for (int j = i+1; j < nums.length ; j++) {
                sum+=nums[j];
                if (sum >= k) {
                    ans = Math.min(ans,j-i+1);
                    break;
                }
            }
        }
        return ans ==nums.length+1 ? -1 : ans;
    }

    static int solution(int[] nums, int k) {
        // Deque to store pairs (prefix_sum, index)
        Deque<long[]> queue = new ArrayDeque<>();
        long sumSofar = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sumSofar += nums[i];

            // If the running sum itself satisfies the condition
            if (sumSofar >= k) {
                ans = Math.min(ans, i + 1);
            }

            // Maintain monotonicity: Remove elements with larger prefix sums
            while (!queue.isEmpty() && sumSofar <= queue.peekLast()[0]) {
                queue.pollLast();
            }

            // Check for valid subarrays
            while (!queue.isEmpty() && sumSofar - queue.peekFirst()[0] >= k) {
                ans = Math.min(ans, i - (int) queue.pollFirst()[1]);
            }

            // Add the current sum and index to the queue
            queue.offerLast(new long[]{sumSofar, i});
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        int[] nums = {48,99,37,4,-31};
        System.out.println(shortestSubarray(nums,140));
    }
}
