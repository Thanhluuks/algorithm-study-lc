import java.util.Arrays;

public class MergeSortedArray {
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

    public static void main(String[] args) {
        int[] nums1 = {-1,3,0,0,0,0,0};
        int[] nums2 = {0,0,1,2,3};
        int m = 2;
        int n = 5;
        MergeSortedArray.merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
}
