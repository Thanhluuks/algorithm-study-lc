package Daily;

public class ReverseString {
    public static String reverseByArr(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = str.length() -1; i >=0; i--) {
            result.append(str.charAt(i));
        }
        return result.toString();

    }
    
    public static String reverseBy2Point(String str) {
        int left=0;
        int right = str.length() -1;
        StringBuilder result = new StringBuilder(str);
//        swap char until left > right
        while (left < right) {
            char temp = str.charAt(left);
            result.setCharAt(left, str.charAt(right));
            result.setCharAt(right,str.charAt(left));
            left++;
            right--;
            
        }
        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(ReverseString.reverseByArr("uhsnamiH"));
        System.out.println(ReverseString.reverseBy2Point("uhsnamiH"));
    }

}
