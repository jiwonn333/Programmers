import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N개의 회의
        int count = 0;
        int end = 0;
        int[][] time = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); // ex) 1 4 저장
            // 시작 시간 저장
            time[i][0] = Integer.parseInt(st.nextToken()); // ex) 1 저장
            // 종료 시간 저장
            time[i][1] = Integer.parseInt(st.nextToken()); // ex) 4 저장
        }

        // time 오름차순 정렬 (끝나는 시간을 기준으로 함)
        Arrays.sort(time, (o1, o2) -> {
            if (o1[1] == o2[1]) { // 종료 시간이 같을경우 시작시간이 빠른 순서로 정렬시킴
                return o1[0] - o2[0]; // 시작 시간으로 정렬
            }
            return o1[1] - o2[1]; // 종료 시간으로 정렬
        });


        // 앞에 회의의 끝나는 시간이 다음 회의의 시작시간과 같거나 작을때 카운트
        for (int i = 0; i < N; i++) {
            if (end <= time[i][0]) {
                // ex) 4 <= 5
                count++;
                end = time[i][1]; // 끝시간 저장해주기
            }
        }
        System.out.println(count);
    }
}