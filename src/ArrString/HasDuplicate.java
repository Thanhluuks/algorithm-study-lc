package ArrString;

import java.util.HashSet;
import java.util.Set;

public class HasDuplicate {
    static boolean hasDuplicate(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!numsSet.add(nums[i])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(hasDuplicate(nums));
    }
}
