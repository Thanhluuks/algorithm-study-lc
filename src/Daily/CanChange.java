package Daily;


public class CanChange {
    static boolean canChange(String start, String target) {
        char[] startArr = start.toCharArray();
        int index =0;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if (c =='R') {
                if (startArr[index] != 'R') {
                    return false;
                }
            } else if (c == 'L') {
                for (int j = index; j < startArr.length ; j++) {
                    if(startArr[j] == 'L') {
                        char temp = startArr[index];
                        startArr[index] = startArr[j];
                        startArr[j] = temp;
                        break;
                    } else if (startArr[j] == 'R') {
                        return false;
                    } else if (j== startArr.length-1) {
                        return false;
                    }
                }
            } else if (c == '_') {
                for (int j = index; j < startArr.length ; j++) {
                    if(startArr[j] == '_') {
                        char temp = startArr[index];
                        startArr[index] = startArr[j];
                        startArr[j] = temp;
                        break;
                    } else if (startArr[j] == 'L') {
                        return false;
                    } else if (j== startArr.length-1) {
                        return false;
                    }
                }
            }
            index++;
        }
        return true;
    }

    public static void main(String[] args) {
        String start = "_";
        String target = "L";
        System.out.println(canChange(start,target));
    }
}
