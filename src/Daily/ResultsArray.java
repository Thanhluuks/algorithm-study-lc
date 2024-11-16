package Daily;

import java.util.Arrays;

public class ResultsArray {
    static int[] resultsArray(int[] nums, int k) {
        int size = nums.length-k +1;
        int[] ans = new int[size];
        int l=0;
        while (l<size) {
            int max=0;
            System.out.println(l);
            for (int i = l; i <l+k; i++) {
                if((i+1 < l+k ) && nums[i+1] -nums[i] != 1) {
                    ans[l] = -1;
                    break;
                }
                max = Math.max(max,nums[i]);
            }
            ans[l] = ans[l] == -1 ? -1: max;
            l++;
        }
        return ans ;
    }
    static int[] solution(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new int[0];
        }

        int[] arr =new int[nums.length-k+1];
        int i=0;
        int j=k-1;
        int a=0;
        while(j<nums.length){
            if(solved(nums,i,j)){
                arr[a]=nums[j];
            }
            else{
                arr[a]=-1;
            }
            i++;
            j++;
            a++;
        }
        return arr;
    }

    static boolean solved(int nums[],int start,int end){
        for(int i=start;i<end;i++){
            if(nums[i]+1!=nums[i+1]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,4};
        System.out.println(Arrays.toString(resultsArray(nums, 2)));
    }
}
