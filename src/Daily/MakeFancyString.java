package Daily;

public class MakeFancyString {
    static String makeFancyString(String s) {
        StringBuilder str = new StringBuilder(s);
        int i=0;
        while (i<str.length()-2){
            if(str.charAt(i) == str.charAt(i+1) && str.charAt(i+2) == str.charAt(i)) {
                str.deleteCharAt(i+2);
            }
            else i++;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s="aab";
        System.out.println(makeFancyString(s));
    }
}
