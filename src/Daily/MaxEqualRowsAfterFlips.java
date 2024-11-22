package Daily;

import java.util.HashMap;
import java.util.Map;

public class MaxEqualRowsAfterFlips {
    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String,Integer> countMap = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder pattern = new StringBuilder().append("*");
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[i][j-1]) {
                    pattern.append("|*");
                } else {
                    pattern.append("*");
                }
            }
            countMap.put(pattern.toString(), countMap.getOrDefault(pattern.toString(),0) +1);
        }
        int max = countMap.values().stream()
                        .max(Integer::compareTo)
                                .orElseThrow(() -> new RuntimeException("Map is empty"));

        return max;
    }

    public static void main(String[] args) {
        int[][] matrix ={{0,0,0},{0,0,1},{1,1,0}};
        System.out.println(maxEqualRowsAfterFlips(matrix));
    }
}
