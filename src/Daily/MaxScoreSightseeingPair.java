package Daily;

public class MaxScoreSightseeingPair {
    static int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0;
        int n = values.length;
        int[] leftScores = new int[n];
        leftScores[0] = values[0];
        for (int i = 1; i < n; i++) {
            int curRightScore = values[i] - i;
            maxScore = Math.max(maxScore, leftScores[i-1] + curRightScore);
            int curLeftScore = values[i] + i;
            leftScores[i] = Math.max(leftScores[i-1], curLeftScore);

        }

        return maxScore;
    }

    public static void main(String[] args) {
        int[] values = {8,1,5,2,6};
        System.out.println(maxScoreSightseeingPair(values));
    }
}
