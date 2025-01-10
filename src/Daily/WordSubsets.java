package Daily;

import java.util.*;

public class WordSubsets {
    static List<String> wordSubsets(String[] words1, String[] words2) {
        Map<Character, Integer> ws2 = new HashMap<>();
        for (String w : words2) {
            Map<Character, Integer> wSet = new HashMap<>();
            for (int i = 0; i < w.length(); i++) {
                wSet.put(w.charAt(i),wSet.getOrDefault(w.charAt(i),0) +1);
            }
            for (Map.Entry<Character, Integer> entry : wSet.entrySet()) {
                Integer maxPresent = ws2.containsKey(entry.getKey()) ? Math.max(entry.getValue(), ws2.get(entry.getKey())) : entry.getValue();
                ws2.put(entry.getKey(),maxPresent);
            }

        }
        List<String> ans = new ArrayList<>();
        for(String w : words1) {
            boolean isSubset = true;
            Map<Character, Integer> ws1 = new HashMap<>();
            for (int i = 0; i < w.length(); i++) {
                ws1.put(w.charAt(i),ws1.getOrDefault(w.charAt(i),0) +1);
            }
            for (Map.Entry<Character, Integer> entry : ws2.entrySet()) {
                if (!ws1.containsKey(entry.getKey()) || (ws1.get(entry.getKey()) < entry.getValue())) {
                    isSubset = false;
                    break;
                }
            }
            if (isSubset) ans.add(w);
        }
        return ans;
    }
    static List<String> solution(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];
        for (String b : words2) {
            int[] freq = new int[26];
            for(char c : b.toCharArray()) {
                freq[c - 'a']++;
            }
            for(int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }

        // Step 2: For each word in words1, check if it meets the maxFreq requirements
        List<String> ans = new ArrayList<>();
        for(String a : words1){
            int[] freq = new int[26];
            for(char c : a.toCharArray()) {
                freq[c - 'a']++;
            }
            boolean isUniversal = true;
            for(int i = 0; i < 26; i++) {
                if(freq[i] < maxFreq[i]){
                    isUniversal = false;
                    break;
                }
            }
            if(isUniversal) ans.add(a);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] w1 = {"amazon","apple","facebook","google","leetcode"};
        String[] w2 = {"lo","eo"};
        System.out.println(wordSubsets(w1,w2));
    }
}
