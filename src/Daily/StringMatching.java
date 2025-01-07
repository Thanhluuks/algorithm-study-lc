package Daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringMatching {
    static List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length ; j++) {
                if (words[i].contains(words[j]) && i!= j) {
                    set.add(words[j]);
                }
            }

        }
        List<String> ans = new ArrayList<>(set);
        return ans;
    }
    static List<String> solution(String[] words) {

        List<String> ans = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            stringBuilder.append(words[i]).append('#');
        }
        String prefix = stringBuilder.toString();
        for (int i = 0; i < words.length; i++) {
            if (prefix.contains(words[i])) {
                ans.add(words[i]);
            }
        }
        return ans;
    }
}
