package ArrString;

import java.util.HashMap;

public class MajorityElement {
    static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> numFre = new HashMap<Integer, Integer>();
        int num =nums[0];
        int refer = 0;
        for (int j : nums) {
            if (numFre.containsKey(j)) {
                numFre.put(j, numFre.get(j) + 1);
            } else numFre.put(j, 0);
            if (numFre.get(j) > refer) {
                refer = numFre.get(j);
                num = j;
            }
        }
        return num;

    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
System.out.println(majorityElement(nums));
    }
}
