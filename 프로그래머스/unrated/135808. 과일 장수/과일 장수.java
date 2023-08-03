import java.util.*;

class Solution {
     private int checkedAppleCount;

    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int apple = score.length;
        checkedAppleCount = apple;
        int box = apple / m;
        if (box == 0) {
            return 0;
        }
        // 오름차순
        Arrays.sort(score); //1,1,1,2,2,3,3

        for (int i = 0; i < box; i++) {
            int[] profitArr = getScore(m, score);
            int profit = profitArr[m-1]; //2
            answer += profit * m;
        }
        return answer;
    }

    public int[] getScore(int m, int[] arrayList) {
        int[] profitArr = new int[m];

        for (int i = 0; i < m; i++) {
            profitArr[i] = arrayList[checkedAppleCount-1];
            checkedAppleCount--;
        }
        
        return profitArr;
    }
}