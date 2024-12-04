package Daily;

public class CanMakeSubsequence {
    static boolean canMakeSubsequence(String str1, String str2) {
        int str1In = 0;
        int str2In = 0;
        while (str2In<str2.length() && str1In<str1.length()) {
            char check = str2.charAt(str2In);
            for (int i = str1In; i < str1.length(); i++) {
                if (isNextChar(str1.charAt(i), check)) {
                    str1In=i+1;
                    break;
                } else if (i==str1.length()-1) {
                    return false;
                }
            }
            str2In++;
        }
        return str2In == str2.length();
    }
    static boolean isNextChar(char a, char b) {
        return a == b || a +1 == b || (a== 'z' && b =='a');
    }

    public static void main(String[] args) {
        String s1= "abc";
        String s2 = "ad";
        System.out.println(canMakeSubsequence(s1,s2));
    }
}
