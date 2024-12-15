package Daily;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxAverageRatio {
    static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<long[]> minHeap = new PriorityQueue<long[]>((a, b) ->Long.compare((b[1]-b[0])*((a[1]+1)*a[1]),(a[1]-a[0])*((b[1]+1)*b[1])));
        for(int[] clas : classes) {
                minHeap.add(new long[] {clas[0], clas[1]});
        }
        while (extraStudents >0 && !minHeap.isEmpty()){
            long[] clas = minHeap.poll();
            clas[0]++;
            clas[1]++;
            minHeap.add(clas);
            extraStudents--;
        }
        return minHeap.stream().mapToDouble(c ->(double) c[0] / c[1]).average().getAsDouble();

    }

    public static void main(String[] args) {
        int[][] classes = {{2,4},{3,9},{4,5},{2,10}};
        System.out.println(maxAverageRatio(classes,4));
    }
}
