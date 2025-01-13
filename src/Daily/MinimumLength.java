package Daily;

public class MinimumLength {
//    TLE
    static int minimumLength(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        int i = 1;
        while (i< stringBuilder.length()) {
            String c = String.valueOf(stringBuilder.charAt(i));
            String left = stringBuilder.substring(0,i);
            String right = stringBuilder.substring(i+1);
            if (left.contains(c) && right.contains(c)) {
                stringBuilder.deleteCharAt(stringBuilder.indexOf(c,0));
                stringBuilder.deleteCharAt(stringBuilder.indexOf(c,i));
            } else i++;
        }
        return stringBuilder.length();
    }
    static int solution(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int rs = 0;
        for (int count : freq) {
            if (count <= 2) {
                rs+= count;
                continue;
            }
            else if  (count%2 == 0) {
                count = 2;
            } else count =1;
            rs+=count;
        }
        return rs;
    }

    public static void main(String[] args) {
        String s = "abaacbcbb";
        System.out.println(minimumLength(s));
    }
}
