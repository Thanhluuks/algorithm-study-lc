public class MinChanges {
    static int minChanges(String s) {
        int count = 0;
        for (int i = 0; i < s.length()-1; i=i+2) {
            if (s.charAt(i) != s.charAt(i+1)) {
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        String s= "0000";
        System.out.println(minChanges(s));
    }
}
