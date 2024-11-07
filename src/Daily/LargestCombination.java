package Daily;

public class LargestCombination {
    static int largestCombination(int[] candidates) {
        int maxCount = 0;
        for (int bit = 0; bit <24 ; bit++) {
            int count = 0;
            for (int num : candidates) {
                if ((num & (1<< bit)) != 0 ) {
                    count++;
                }
            }
            maxCount = Math.max(maxCount,count);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] cans = {1};
        System.out.println(largestCombination(cans));
    }
}
