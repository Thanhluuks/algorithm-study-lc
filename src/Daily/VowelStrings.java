package Daily;

import java.util.HashSet;
import java.util.Set;

public class VowelStrings {
    static int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('u');
        vowels.add('e');
        vowels.add('o');
        vowels.add('a');
        vowels.add('i');
        int[] cal = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            if (vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length()-1))) {
                cal[i] = i==0 ? 1 : cal[i-1] +1;
            } else cal[i] = i==0 ? 0 : cal[i-1];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = l == 0 ? cal[r] : cal[r] - cal[l-1];
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"aba","bcb","ece","aa","e"};
        int[][] queries = {{0,2},{1,4},{1,1}};
        System.out.println(vowelStrings(words,queries));
    }
}
