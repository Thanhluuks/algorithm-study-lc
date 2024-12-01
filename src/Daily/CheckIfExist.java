package Daily;

import java.util.HashSet;
import java.util.Set;

public class CheckIfExist {
    static boolean checkIfExist(int[] arr) {
        Set<Integer> present = new HashSet<>();
        for (int i = 0; i < arr.length-1; i++) {
            present.add(arr[i]);
            if (present.contains(2*arr[i+1]) || (present.contains(arr[i+1] / 2) && arr[i+1] % 2 == 0)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,14,11};
        System.out.println(checkIfExist(arr));
    }
}
