package Daily;

import java.util.Arrays;

public class Decrypt {
    static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int sum =0;
            if (k == 0) {
                ans[i] = sum;
            } else if (k>0) {
                for (int j=1;j<=k;j++) {
                    int index = i+j < n ? i+j : i+j-n;
                    sum+=code[index];
                }
                ans[i] = sum;
            } else{
                for (int j=1;j<=-k;j++) {
                    int index = i-j >= 0 ? i-j : n+(i-j);
                    sum+=code[index];
                    System.out.println(sum);
                }
                ans[i] = sum;
            }


        }
        return ans;
    }
    public static void main(String[] args) {
        int[] code = {2,4,9,3};
        System.out.println(Arrays.toString(decrypt(code,-2)));
    }
}
