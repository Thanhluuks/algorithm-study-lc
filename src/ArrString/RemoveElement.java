package ArrString;

import java.util.Arrays;

public class RemoveElement {
    static int removeElement(int[] nums, int val) {
        int k = 0;  // Pointer for the position to place non-val elements

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;  // Increment `k` only when a valid element is placed
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int k = removeElement(nums, 3);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));

    }
}
