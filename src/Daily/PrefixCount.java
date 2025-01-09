package Daily;

public class PrefixCount {
    static int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String word : words) {
            if (word.startsWith(pref)) ans++;
        }
        return ans;
    }
}
