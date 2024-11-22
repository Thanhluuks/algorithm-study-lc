package ArrString;

import java.util.*;

public class TopKFrequent {
    static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num,0) +1);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            int val = count.values().stream().max(Integer::compareTo).orElseThrow(() -> new RuntimeException("No max element"));
            Map.Entry<Integer, Integer> entrySet= count.entrySet().stream()
                    .filter(entry -> entry.getValue() == val)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Not available"));

            int key = entrySet.getKey();
            ans[i] = key;
            count.remove(key);
        }
        return ans;
    }

    static int[] solution(int[] nums, int k) {
        Map<Integer,Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num,0) +1);
        }

        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> count.get(o1)- count.get(o2));
        for (int num : count.keySet()) {
            heap.add(num);
            if (heap.size() > k) heap.poll();
        }
        int[] ans = new int[k];
        for (int i = k-1; i >=0; i--) {
            ans[i] = heap.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,4,4,6,6,6,6};
        System.out.println(Arrays.toString(solution(nums, 1)));
    }
}
