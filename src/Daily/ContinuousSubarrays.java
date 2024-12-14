package Daily;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class ContinuousSubarrays {
    static long continuousSubarrays(int[] nums) {
        long rs=0;
        Queue<Integer> minHeap = new PriorityQueue<>((a,b) -> nums[a]- nums[b]);
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> nums[b] - nums[a]);
        int l=0;
        int r =0;
        while (r< nums.length) {
            minHeap.add(r);
            maxHeap.add(r);
            while (l< r && (nums[maxHeap.peek()] - nums[minHeap.peek()]) >2) {
                l++;
                if (!minHeap.isEmpty() && minHeap.peek() < l) {
                    minHeap.poll();
                }
                if (!maxHeap.isEmpty() && maxHeap.peek() < l) {
                    maxHeap.poll();
                }
            }
            rs += r-l+1;
            r++;
        }
        return rs;
    }

    static long solution(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        long rs = 0;
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            // Add the current element to the map
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            // Shrink the window until the condition (max - min <= 2) is met
            while (map.lastKey() - map.firstKey() > 2) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }

            // All subarrays ending at 'r' and starting from indices >= 'l' are valid
            rs += r - l + 1;
        }

        return rs;
    }
    public static void main(String[] args) {
        int[] nums = {5,4,2,4};
        System.out.println(continuousSubarrays(nums));
    }

}
