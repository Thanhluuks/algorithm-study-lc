package Daily;

import java.util.Arrays;

public class ShiftingLetters {
    static String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shiftOperations = new int[n + 1]; // Use a size of n+1 to handle ranges.

        // Process each shift operation efficiently.
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2] == 0 ? -1 : 1;

            // Mark the start and end+1 for range manipulation.
            shiftOperations[start] += direction;
            shiftOperations[end + 1] -= direction;
        }

        // Compute the cumulative shift at each position.
        int cumulativeShift = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            cumulativeShift += shiftOperations[i];
            result.append(shiftCharacter(s.charAt(i), cumulativeShift));
        }

        return result.toString();
    }
    static char shiftCharacter(char c, int operations) {
        int totalLetters = 26;
        // Normalize operations to handle cases where operations > 26 or < -26.
        int effectiveShift = (operations % totalLetters + totalLetters) % totalLetters;
        return (char) ('a' + (c - 'a' + effectiveShift) % totalLetters);
    }

    public static void main(String[] args) {
        String s = "dztz";
        int[][] shifts = {{0,0,0},{1,1,1}};
        System.out.println(shiftingLetters(s, shifts));

    }
}
