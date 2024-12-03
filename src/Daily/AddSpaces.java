package Daily;

public class AddSpaces {
    static String addSpaces(String s, int[] spaces) {
        StringBuilder str = new StringBuilder();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if(index < spaces.length && i == spaces[index]) {
                str.append(" ");
                index++;
            }
            str.append(s.charAt(i));
        }

        return str.toString();
    }

    public static void main(String[] args) {
        String s= "LeetcodeHelpsMeLearn";
        int[] spaces = {8,13,15};
        System.out.println(addSpaces(s,spaces));
    }
}
