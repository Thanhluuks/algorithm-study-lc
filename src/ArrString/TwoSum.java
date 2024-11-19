package ArrString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length -1 ; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0, 0};
    }

    static int[] solution(int[] nums, int target) {
        Map<Integer, Integer> valInd = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];
            if (valInd.containsKey(nums[i])) {
                return new int[] {valInd.get(nums[i]), i};
            }
            valInd.put(dif, i );
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,5,6,4};
        System.out.println(Arrays.toString(solution(nums, 8)));
    }
}
