package Daily;

public class CanConstruct {
    static boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int odd_fre = 0;
        for (int count : freq) {
            if (count % 2 != 0) odd_fre++;
        }
        return odd_fre <= k;
    }
}
