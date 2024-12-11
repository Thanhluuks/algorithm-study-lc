package Daily;

import java.util.HashMap;
import java.util.Map;

public class MaximumLength {
     static int maximumLength(String s) {
         Map<String,Integer> count = new HashMap<>();
         for (int i = 0; i < s.length(); i++) {
             StringBuilder cur = new StringBuilder();
             for (int j = i; j < s.length(); j++) {
                 if (cur.isEmpty() || cur.charAt(cur.length()-1) == s.charAt(j)) {
                     cur.append(s.charAt(j));
                     count.put(cur.toString(), count.getOrDefault(cur.toString(),0) +1);
                 } else break;
             }
         }
        int max =0;
        for(String key : count.keySet()) {
            if (count.get(key) >=3) {
                max = Math.max(key.length(), max);
            }
        }
        return max == 0 ? -1 : max;
    }

    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(maximumLength(s));
    }
}
