import java.util.*;

class Solution {
    public int[] solution(String s) {
        int binaryCount = 0;
        int zeroCount = 0;
        String reNumber = "";
        
        while (!s.equals("1")) {
            while (s.contains("0")) {
                s = s.replaceFirst("0", "");
                zeroCount++;
            }
            int share = s.length();
            s ="";
            while (share > 0) {
                s += share % 2;
                share /= 2;
            }
            binaryCount++;
        }

        return new int[]{binaryCount, zeroCount};
    }
}