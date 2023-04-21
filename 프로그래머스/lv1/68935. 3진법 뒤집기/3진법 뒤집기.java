import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 3);
            n = n / 3;
        }
        for (int i = 1; i <= list.size(); i++) {
            answer += list.get(list.size()-i) * Math.pow(3, i-1);
        }

        return answer;
    }
}