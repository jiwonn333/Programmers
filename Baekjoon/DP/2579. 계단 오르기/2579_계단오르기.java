import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N개의 계단
        int[] stairs = new int[N + 1]; // 계단 배열 생성

        // 각 계단에 점수 입력
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int[] score = new int[N + 1];
        // 기저 조건 if문 설정
        score[1] = stairs[1];
        if (N > 1) {
            score[2] = stairs[1] + stairs[2];
        }
        for (int i = 3; i <= N; i++) {
            score[i] = Math.max(score[i - 2], score[i - 3] + stairs[i - 1]) + stairs[i];
        }

        System.out.println(score[N]);
    }
}
