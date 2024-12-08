package Daily;

import java.util.*;

public class MaxTwoEvents {
    static int maxTwoEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(x -> x[0]));
        int max =0, maxVal = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int[] event : events) {
            while (!pq.isEmpty() && pq.peek()[0] < event[0]) {
                maxVal = Math.max(maxVal, pq.peek()[1]);
                pq.poll();
            }
            max = Math.max(max,maxVal + event[2]);
            pq.add(new int[]{event[1], event[2]});
        }
        return max;
    }
    public static void main(String[] args) {
        int[][] events = {{1,3,2},{4,5,2},{2,4,3}};
        System.out.println(maxTwoEvents(events));
    }
}
