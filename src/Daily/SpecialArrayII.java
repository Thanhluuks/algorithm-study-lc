package Daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpecialArrayII {
    static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        List<Integer> falseIndex = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i-1] + nums[i]) % 2 == 0) {
                falseIndex.add(i);
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];
            ans[i] = !bs(start+1, end,falseIndex);
        }
        return ans;
    }

    private static boolean bs(int start, int end, List<Integer> falseIndex) {
        int l = 0;
        int r = falseIndex.size() -1;
        while (l <= r){
            int mid = l + (r-l)/2;
            if (falseIndex.get(mid) < start) {
                l = mid + 1;
            } else if (falseIndex.get(mid) > end ) {
                r = mid -1;
            } else return true;
        }
        return false;
    }

    static boolean[] solution(int[] nums, int[][] queries) {
        boolean[] ans=new boolean[queries.length];
        int[] prefixSum=new int[nums.length];
        for(int i=1;i<nums.length;i++){
            prefixSum[i]=prefixSum[i-1];
            if(nums[i]%2==nums[i-1]%2){
                prefixSum[i]+=1;
            }
        }
        int count=0;
        for(int[] q:queries){
            int from=q[0];
            int to=q[1];
            ans[count]=prefixSum[to]-prefixSum[from]==0 ? true:false;
            count++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {4,3,1,6,9,8,9,9,9,8,8,8};
        int[][] queries = {{0,2},{2,3}};
        System.out.println(Arrays.toString(solution(nums,queries)));
    }
}
