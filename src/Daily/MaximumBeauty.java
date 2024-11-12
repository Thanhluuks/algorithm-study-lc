package Daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumBeauty {
    public static int[] maximumBeauty(int[][] items, int[] queries) {
        int[] ans  = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int maxBea = 0;
            for (int[] item : items) {
                if (item[0] <= queries[i]) {
                    maxBea = Math.max(maxBea, item[1]);
                }
            }
            ans[i] = maxBea;
        }
        return ans;
    }

    public static int[] solution(int[][] items, int[] queries) {
        int[] ans  = new int[queries.length];
        List<int[]> res = new ArrayList<>();
        res.add(new int[] {0,0});
        Arrays.sort(items, (o1, o2) -> o1[0] - o2[0]);
        for (int[] item : items) {
            int[] lastBeau = res.get(res.size()-1);
            if (item[1] > lastBeau[1]) {
                res.add(new int[] {item[0], item[1]});
            }
        }
        for (int j = 0; j < queries.length; j++) {
            int x = queries[j];
            for (int i = res.size() - 1; i >= 0; i--) {
                if (res.get(i)[0] <= x) {
                    ans[j] = res.get(i)[1];
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] items = {{1,2},{3,2},{2,4},{5,6},{3,5}};
        int[] queries = {1,2,3,4,5,6};
//        solution(items, queries);
        System.out.println(Arrays.toString(solution(items, queries)));
    }
}
