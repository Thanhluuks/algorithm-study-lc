package Daily;


public class CountPrefixSuffixPairs {
    static int countPrefixSuffixPairs(String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length-1; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i],words[j])) ans++;
            }
        }
        return ans;
    }
     static boolean isPrefixAndSuffix(String str1, String str2) {
        int length = str1.length();
        if (length > str2.length()) return false;
        String prefix = str2.substring(0,length);
        String suffix = str2.substring(str2.length()-length);
        return str1.equals(prefix) && str1.equals(suffix);
     }

    public static void main(String[] args) {
        String[] words = {"pa","papa","ma","mama"};
        System.out.println(countPrefixSuffixPairs(words));
    }
}
