import java.util.Arrays;

public class MergeSortedArray {
//    Good memory, bad runtime
//    O(mxn)
    public static void merge(int[] nums1, int m, int[] nums2, int n ) {
        if (n == 0) return;
        for (int i = 0; i < nums2.length; i++) {
            {
                for (int j = 0; j < nums1.length; j++) {
                    if (nums2[i] < nums1[j]) {
                        for (int k = nums1.length - 1; k > j; k--) {
                            nums1[k] = nums1[k - 1];
                        }
                        nums1[j] = nums2[i];
                        break;
                    }
                    if (nums1[j] == 0 && j >= m + i) {
                        nums1[j] = nums2[i];
                        break;
                    }

                }
            }

        }
    }
//Good runtime, bad memory
//    O(m+n)
    public static void merge3Pointer(int[] nums1, int m, int[] nums2, int n ) {

        int p1 = m-1;
        int p2 = n-1;
        int p = m+n-1;
        while (p1 >= 0 && p2 >=0) {
            if(nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
        while (p2>=0) {
            nums1[p] = nums2[p2];
            p--;
            p2--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        int m = 0;
        int n = 1;
        MergeSortedArray.merge3Pointer(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
}
