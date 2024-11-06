package ArrString;

import java.util.Arrays;

public class RemoveDuplicates {
    static int removeDuplicates(int[] nums) {
        int k=0;
        int count=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[k] ==nums[i] && count <2) {
                nums[k+1]= nums[i];
                count++;
                k++;
            }
            if(nums[k] != nums[i]) {
                nums[k+1] = nums[i];
                count=1;
                k++;
            }
        }

        return k+1;
    }
    static int solution(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
