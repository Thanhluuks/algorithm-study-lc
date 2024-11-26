package ArrString;

import java.util.Arrays;

public class ProductsofArrayExceptSelf {
    static int[] productExceptSelf(int[] nums) {
        int zeroCount=0;
        int production =1;
        for(int num : nums) {
            if (num!=0) {
                production*=num;
            }else zeroCount++;

        }
        int[] rs = new int[nums.length];
        if (zeroCount>1) return rs;
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount>0) {
                rs[i] = nums[i] == 0 ? production : 0;
            }else rs[i] =(int) production / nums[i];

        }
        return rs;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,6};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
