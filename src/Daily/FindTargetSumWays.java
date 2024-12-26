package Daily;

public class FindTargetSumWays {
    static  int totalWays = 0;
    static int findTargetSumWays(int[] nums, int target) {
        calculateWays(nums, 0, 0, target);
        return totalWays;

    }

    private static void calculateWays(int[] nums, int curIndex, int curSum, int target) {
        if (curIndex == nums.length) {
            if (curSum == target) totalWays++;
        } else {
            calculateWays(nums, curIndex+1, curSum + nums[curIndex], target);
            calculateWays(nums,curIndex+1,curSum - nums[curIndex], target);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        System.out.println(findTargetSumWays(nums,3));
    }
}
