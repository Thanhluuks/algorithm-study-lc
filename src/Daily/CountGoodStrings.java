package Daily;

public class CountGoodStrings {
    static int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high +1];
        dp[0] = 1;
        int mod = 1_000_000_007;
        for (int i = 0; i <= high ; i++) {
            if (i>= zero) {
                dp[i]+=dp[i-zero];
            }
            if (i>= one) {
                dp[i]+= dp[i-one];
            }
            dp[i]%=mod;
        }
        int rs =0;
        for (int i = low; i <=high ; i++) {
            rs+=dp[i];
            rs%=mod;
        }

        return rs;
    }

    public static void main(String[] args) {
        System.out.println(countGoodStrings(3,3,1,1));
    }
}
