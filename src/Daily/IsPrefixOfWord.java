package Daily;

public class IsPrefixOfWord {
    static int isPrefixOfWord(String sentence, String searchWord) {
        String[] word = sentence.split(" ");
        for (int i = 0; i < word.length; i++) {
            if (word[i].startsWith(searchWord)) return i+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        String sen = "";
        System.out.println(isPrefixOfWord(sen, ""));
    }
}
