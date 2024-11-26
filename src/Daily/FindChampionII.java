package Daily;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindChampionII {
    static int findChampion(int n, int[][] edges) {
        Map<Integer,Integer> counts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            counts.put(i,0);
        }
        for(int[] node : edges) {
            counts.put(node[1], counts.get(node[1]) +1);
        }
        List< Integer> count= counts.entrySet().stream()
                .filter(entry -> entry.getValue() == 0)
                .map(Map.Entry::getKey)
                .toList();

        return count.size() == 1 ? count.get(0) : -1;

    }
    static int solution(int n, int[][] edges) {
       int[] inDegrees = new int[n];
       for (int[] node : edges) {
           inDegrees[node[1]]++;
       }
       int rs = -1;
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                if (rs != -1) {
                    return -1;
                }
            }
            rs = i;
        }
        return rs;

    }

    public static void main(String[] args) {
//        int[][] edges = {{0,2},{1,3},{1,2}};
        int[][] edges = {{1,0}};
        System.out.println(findChampion(2, edges));
    }
}
