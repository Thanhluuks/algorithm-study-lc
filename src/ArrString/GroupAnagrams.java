package ArrString;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortStrs = new HashMap<>();
        for(String str : strs) {
            char[] charArr= str.toCharArray();
            Arrays.sort(charArr);
            String sorted = new String(charArr);
            if (sortStrs.containsKey(sorted)) {
                sortStrs.get(sorted).add(str);
            } else sortStrs.put(sorted, new ArrayList<>(Arrays.asList(str)));
        }
        List<List<String>> ans = new ArrayList<>();
        for(String key: sortStrs.keySet()) {
            ans.add(sortStrs.get(key));
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"act","pots","tops","cat","stop","hat"};
        groupAnagrams(strs);
    }
}
