import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[][] snail = new int[n][n];

        // 전체 사이즈
        int size = n * (n+1) / 2;

        // 시작 지점
        int x = -1, y = 0;
        int cnt = 1;

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (i % 3 == 0) {
                    ++x; // 세로
                } else if (i % 3 == 1) {
                    ++y; // 가로
                } else if (i % 3 == 2) {
                    // 대각선
                    --x;
                    --y;
                }
                snail[x][y] = cnt++;
            }
        }

        int answer[] = new int[size];
        int idx = 0;
       for (int i = 0; i < snail.length; i++) {
           for (int j = 0; j <= i; j++) {
               answer[idx] = snail[i][j];
               idx++;
           }
       }

        return answer;
    }
}