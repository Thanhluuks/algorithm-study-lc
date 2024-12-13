package Daily;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class FindScore {
    static long findScore(int[] nums) {
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.add(new int[]{nums[i],i});
        }
        Set<Integer> set = new HashSet<>();
        long ans = 0;
        while (!queue.isEmpty()) {
            int[] num = queue.poll();
            System.out.println(num[0] + " " + num[1]);
            if (!set.contains(num[1])) {
                ans+=num[0];
                set.add(num[1]+1);
                set.add(num[1]-1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,6,6,10};
        System.out.println(findScore(nums));
    }
}
