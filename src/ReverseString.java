public class ReverseString {
    public static String reverseString(String str) {
        StringBuilder result = new StringBuilder();
        char[] strArr = str.toCharArray();
        for (int i = strArr.length-1; i >0; i--) {
            result.append(strArr[i]);
        }
        return result.toString();

    }

    public static void main(String[] args) {
        System.out.println(ReverseString.reverseString("uhsnamiH"));
    }

}
