package ArrString;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        while (!s.isEmpty()) {
            String c = String.valueOf(s.charAt(0));
            if(!t.contains(c)) {
                return false;
            }
            t=t.replaceFirst(c,"");
            s=s.replaceFirst(c,"");
        }
        return true;
    }
    static boolean solution(String s, String t) {
        Map<Character, Integer> charCount = new HashMap<>();
        Map<Character, Integer> charCountt = new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            if(charCount.containsKey(c)){
                charCount.put(c, charCount.get(c) +1);
            }else {
                charCount.put(c, 1);
            }
        }
        for (int i = 0; i <t.length() ; i++) {
            char c = t.charAt(i);
            if(charCountt.containsKey(c)){
                charCountt.put(c, charCountt.get(c) +1);
            }else {
                charCountt.put(c, 1);
            }
        }
        return charCount.equals(charCountt);
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(solution(s,t));
    }
}
