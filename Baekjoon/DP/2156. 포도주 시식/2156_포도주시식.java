import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n개의 포도주
        int[] table = new int[n + 1]; // 포도주가 올라간 테이블 배열 생성

        for (int i = 1; i <= n; i++) {
            table[i] = Integer.parseInt(br.readLine()); // 포도주의 양 입력
        }

        int[] wine = new int[n + 1];
        int drink = 0;

        // 기저 조건 if문 설정
        wine[1] = table[1];
        if (n > 1) {
            wine[2] = table[1] + table[2];
        }
        for (int i = 3; i <= n; i++) {
            wine[i] = Math.max(Math.max(wine[i - 1], wine[i - 2] + table[i]), wine[i - 3] + table[i - 1] + table[i]);
        }
        System.out.println(wine[n]);
    }
}