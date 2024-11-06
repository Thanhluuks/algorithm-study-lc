import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate {
    static int removeDuplicated(int[] nums) {
        int left=0, right =0;
        while (right < nums.length) {
            if(nums[right] != nums[left]) {
                left=left+1;
                nums[left] = nums[right];

            }
            right++;
        }
        return left+1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int k = removeDuplicated(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}
