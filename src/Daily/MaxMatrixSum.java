package Daily;

import java.util.Arrays;

public class MaxMatrixSum {
    static long maxMatrixSum(int[][] matrix) {
        int[] flatArr = Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .toArray();
        long negativeNums = Arrays.stream(flatArr)
                .filter(num -> num < 0)
                .count();
        flatArr = Arrays.stream(flatArr)
                .map(operand -> operand < 0 ? operand * -1 : operand)
                .toArray();
        boolean isPerfect = negativeNums % 2 == 0;
        int min = Arrays.stream(flatArr)
                .min().orElse(0);
        min = isPerfect ? 0 : min;

        long sum = Arrays.stream(flatArr).sum();
        return sum - 2*min;

    }
    static long solution(int[][] matrix) {
        long sum = 0;
        int minAbsValue = Integer.MAX_VALUE;
        int negativeCount = 0;

        // Process the matrix in a single pass
        for (int[] row : matrix) {
            for (int num : row) {
                if (num < 0) negativeCount++;
                int absValue = Math.abs(num);
                sum += absValue;
                minAbsValue = Math.min(minAbsValue, absValue);
            }
        }

        // If there are an odd number of negatives, subtract twice the smallest absolute value
        if (negativeCount % 2 != 0) {
            sum -= 2L * minAbsValue;
        }

        return sum;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{-1,-2,-3},{1,2,3}};
        System.out.println(maxMatrixSum(matrix));
    }
}
