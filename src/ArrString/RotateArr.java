package ArrString;

import java.util.ArrayList;
import java.util.List;

public class RotateArr {
    static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            sorted[(i+k) % n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = sorted[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums,3);
    }
}
