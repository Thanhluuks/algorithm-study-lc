package Daily;

public class FindLengthOfShortestSubarray {
    static int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        // Step 1: Find the left non-decreasing part
        int left = 0;
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }

        // Early return if the entire array is already sorted
        if (left == n - 1) {
            return 0;
        }

        // Step 2: Find the right non-decreasing part
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        // Step 3: Calculate the minimum subarray to remove
        // Option 1: Remove all elements from right side or left side
        int result = Math.min(n - left - 1, right);

        // Option 2: Try to merge left and right parts
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,3,4,10,1,4,2,35,1};
        System.out.println(findLengthOfShortestSubarray(arr));
    }
}
