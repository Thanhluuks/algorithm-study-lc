package Daily;

import java.util.Arrays;

public class MinOperations {
    static int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int totalOpe = 0;
            for (int j = 0; j < i; j++) {
                if (boxes.charAt(j) == '1') {
                    totalOpe+=i-j;
                }
            }
            for (int j = i+1; j <n ; j++) {
                if (boxes.charAt(j) == '1') {
                    totalOpe+=j-i;
                }
            }
            ans[i] = totalOpe;

        }

        return ans;
    }
    static int[] solution(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
//        Left traversal
        int leftBalls = 0;
        int leftOperations = 0;
        for (int i = 0; i < n; i++) {
            leftOperations+=leftBalls;
            if (boxes.charAt(i) == '1') leftBalls++;
            ans[i] += leftOperations;
        }
//        Right traversal
        int rightBalls = 0;
        int rightOperations = 0;
        for (int i = n-1; i >=0 ; i--) {
            rightOperations+= rightBalls;
            if (boxes.charAt(i) == '1') rightBalls++;
            ans[i] +=rightOperations;
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(minOperations("1")));
    }
}
