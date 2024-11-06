import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CanSortArray {
    static boolean canSortArray(int[] nums) {
        int pmax=0;
        int cmax=0;
        int cmin=0;
        int pbit =0;
        for(int num : nums) {
            int cbit = Integer.bitCount(num);
            if(cbit == pbit) {
                cmax = Math.max(num, cmax);
                cmin = Math.min(num, cmin);
            } else if (cmin < pmax) {
                return false;
                
            }else {
                pbit = cbit;
                pmax = cmax;
                cmin = num;
                cmax = num;

            }
        }
        return cmin >= pmax;

    }

    public static void main(String[] args) {
        int[] nums = {8,4,2,30,15};
        System.out.println(canSortArray(nums));
    }
}
