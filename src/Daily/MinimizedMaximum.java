package Daily;


public class MinimizedMaximum {
    static int minimizedMaximum(int n, int[] quantities) {
      int l = 1;
      int r = 100000;
      int ans = 1;
      int mid;
      while (l<=r) {
          mid = l + (r-l)/2;
          if(isDistribute(mid, n, quantities)) {
              ans = mid;
              r=mid-1;
          } else {
              l = mid +1;
          }
      }
      return ans;
    }

    private static boolean isDistribute(int mid, int n, int[] quantities) {
        int cnt=0;
        for(int qo:quantities) {
            cnt+= (qo+mid-1)/mid;
        }
        return cnt<=n;
    }

    public static void main(String[] args) {
        int[] quantities = {25,11,29,6,24,4,29,18,6,13,25,30};
        System.out.println(minimizedMaximum(22, quantities));
    }
}
