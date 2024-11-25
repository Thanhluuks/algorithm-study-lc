package ArrString;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {
    static String encode(List<String> strs) {
        if (strs.isEmpty()) return "";
        List<Integer> sizes = new ArrayList<>();
        for(String str : strs) {
            sizes.add(str.length());
        }
        StringBuilder des = new StringBuilder();
        for(int size : sizes) {
            des.append(size).append(",");
        }
        des.append("|");
        for (String str : strs) {
            des.append(str);
        }
        return des.toString();
    }

    static List<String> decode(String str) {
        if (str.isEmpty()) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        String indexs = str.substring(0, str.indexOf("|"));
        String[] in = indexs.split(",");
        int index= str.indexOf("|")+1;
        for(String e : in) {
            ans.add(str.substring(index, index+ Integer.parseInt(e)));
            index+= Integer.parseInt(e);
        }

        return ans;
    }

    public static void main(String[] args) {
        List<String> strs= List.of("nguyen", "thanh", "luu");
        String encoded = encode(strs);

        System.out.println(decode(encoded));
    }
}
