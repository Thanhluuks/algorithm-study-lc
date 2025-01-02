package Daily;

public class MaxScore {
    static int maxScore(String s) {
        String[] arr = s.split("");
        int max = 0;
        int contZero = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i].equals("0")) contZero++;
            int countOne = 0;
            for (int j = i+1; j <arr.length ; j++) {
                if (arr[j].equals("1")) countOne++;
            }
            max= Math.max(max, contZero +countOne);
        }
        return max;
    }

    static int solution(String s) {
        int max = 0;
        String[] arr = s.split("");
        if (arr[0].equals("0")) max =1;
        for (int i = 1; i <arr.length ; i++) {
            if (arr[i].equals("1")) max++;
        }
        int temp = max;
        for (int i = 1; i <arr.length-1 ; i++) {
            if (arr[i].equals("0")) temp++;
            if (arr[i].equals("1")) temp--;
            max= Math.max(max, temp);
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(solution("00"));
    }
}
