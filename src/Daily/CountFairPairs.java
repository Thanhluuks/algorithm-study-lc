package Daily;


import java.util.Arrays;

public class CountFairPairs {
    static long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j <n ; j++) {
                int sum = nums[i] + nums[j];
                if ( sum >= lower && sum <= upper) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static long solution(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);
        int l =1;
        int r = n-1;
        long res =0;
        for(int i =0 ;i<n-1;i++){
            if(i>=r) break;
            while(r>i &&nums[r]>upper-nums[i]){
                r--;
            }
            l=i+1;
            while(l<=r && nums[l]<lower -nums[i]){
                l++;
            }
            res+=r-l+1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,7,10,15};
        System.out.println((countFairPairs(nums,5,13)));

    }
}
