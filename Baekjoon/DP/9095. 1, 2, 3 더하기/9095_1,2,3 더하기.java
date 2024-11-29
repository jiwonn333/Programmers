1import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n개
        int[] nList = new int[n+1];
        // n 입력
        for (int i = 1; i <= n; i++) {
            nList[i] = Integer.parseInt(br.readLine());
        }

        int[] result = new int[11];

        for (int i = 4; i < 11; i++) {
            result[i] = dp(i - 1, result) + dp(i - 2, result) + dp(i - 3, result);
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(result[nList[i]]);
        }
    }

    public static int dp(int i, int[] result) {
        if (i <= 2) return i;
        if (i == 3) return 4;
        if (result[i] == 0) result[i] = dp(i - 1, result) + dp(i - 2, result) + dp(i - 3, result);

        return result[i];
    }
}