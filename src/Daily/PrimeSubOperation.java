package Daily;

import java.util.ArrayList;
import java.util.List;

public class PrimeSubOperation {
    static boolean primeSubOperation(int[] nums) {
        nums[0] = nums[0] - findMaxPrime(nums[0]).stream().findFirst().orElse(0);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < findMaxPrime(nums[i]).size(); j++) {
                int temp = nums[i] - findMaxPrime(nums[i]).get(j);
                if (temp > nums[i-1]) {
                    nums[i] = temp;
                    break;
                }
            }
            if(nums[i] <= nums[i-1]){
                return false;
            }
        }
        return true;
    }


    static List<Integer> findMaxPrime(int num){
        List<Integer> primes = new ArrayList<>();
        for (int i = num-1; i > 1 ; i--) {
            boolean isPrime = true;
            for (int j = i-1; j >= Math.sqrt(i) ; j--) {
                if (i % j == 0) isPrime = false;
            }
            if (isPrime) primes.add(i);
        }
        return primes;
    }

    public static void main(String[] args) {
        int[] nums = {2,2};
        System.out.println(primeSubOperation(nums));
    }
}
