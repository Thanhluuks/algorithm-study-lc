package Daily;

public class CompressedString {
    static String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int count  = 0;
        int letf =0, right = 0;
        while (letf < word.length()) {
                while (right <word.length() && word.charAt(letf) == word.charAt(right) && count < 9)  {
                    count++;
                    right++;
                }
            comp.append(count).append(word.charAt(letf));
            letf=letf+count;
            count=0;
        }

        return comp.toString();
    }

    public static void main(String[] args) {
        String word = "aaaaaaaaaaaaaabb";
        System.out.println(compressedString(word));
    }
}
