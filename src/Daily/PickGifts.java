package Daily;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PickGifts {
    static long pickGifts(int[] gifts, int k) {
        while (k>0) {
            int max = gifts[0];
            int index =0;
            for (int i = 0; i < gifts.length; i++) {
                if (gifts[i] >= max ) {
                    max = gifts[i];
                    index=i;
                }
            }
            gifts[index] = (int)Math.floor(Math.sqrt(gifts[index]));
            k--;
        }

        return Arrays.stream(gifts)
                .mapToLong(g->g)
                .sum();
    }
    static long solution(int[] gifts, int k) {
        Queue<Integer> queue  = new PriorityQueue<>((a, b) -> b-a );
        for(int num : gifts) {
            queue.add(num);
        }
        while (k>0){
            queue.add((int) Math.floor(Math.sqrt(queue.poll())));
            k--;
        }
        long sum=0;
        while (!queue.isEmpty()) {
            sum+= queue.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] gifts = {25,64,9,4,100};
        System.out.println(solution(gifts,4));
    }
}
