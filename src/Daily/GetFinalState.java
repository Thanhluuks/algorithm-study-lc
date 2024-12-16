package Daily;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class GetFinalState {
    static int[] getFinalState(int[] nums, int k, int multiplier) {
        Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(new int[] {nums[i], i});
        }
        while (k > 0 && !minHeap.isEmpty()) {
            int[] num = minHeap.poll();
            num[0] = num[0]*multiplier;
            minHeap.add(num);
            k--;
        }
        return minHeap.stream().sorted((a,b) -> a[1] - b[1])
                .mapToInt(n -> n[0])
                .toArray();
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3,5,6};
        System.out.println(Arrays.toString(getFinalState(nums, 5, 2)));
    }
}
