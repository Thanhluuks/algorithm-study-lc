package Daily;

import java.util.HashSet;
import java.util.Set;

public class CountPalindromicSubsequence {
    static int countPalindromicSubsequence(String s) {
        Set<Character> letters = new HashSet<>();
        for(Character letter : s.toCharArray()) {
            letters.add(letter);
        }
        int ans = 0;
        for (Character letter : letters) {
            int i = -1; // first index of letter
            int j = 0; // last index of letter
            for (int k = 0; k < s.length(); k++) {
                if (s.charAt(k) == letter) {
                    if (i==-1) i =k;
                    j = k;
                }
            }
            Set<Character> middle = new HashSet<>();
            for (int k = i+1; k < j; k++) {
                middle.add(s.charAt(k));
            }
            ans+=middle.size();
        }

        return ans;
    }
}
