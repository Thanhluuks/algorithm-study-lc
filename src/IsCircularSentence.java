public class IsCircularSentence {
    static boolean isCircularSentence(String str) {
        String[] strArr =str.split(" ");
        for (int i = 0; i < strArr.length-1; i++) {
            if(strArr[i].charAt(strArr[i].length()-1) != strArr[i+1].charAt(0)){
                return false;
            }
        }
        return str.charAt(0) == str.charAt(str.length() - 1);
    }

    public static void main(String[] args) {
        String str= "Leetcode is cool";
        System.out.println(isCircularSentence(str));;
    }
}
