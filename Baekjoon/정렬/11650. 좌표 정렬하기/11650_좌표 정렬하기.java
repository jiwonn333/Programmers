import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // i번점의 위치 x(i)와 y(i) 입력
        int[][] plane = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()); // ex) 3 4 저장
            // x(i) 저장
            plane[i][0] = Integer.parseInt(st.nextToken()); // ex) 3 저장
            // y(i) 저장
            plane[i][1] = Integer.parseInt(st.nextToken()); // ex) 4 저장
        }

        // x기준으로 오름차순 정렬, 만약 같다면 y기준으로 오름차순 정렬
        Arrays.sort(plane, (o1, o2) -> {
            if (o1[0] == o2[0]) { // x가 같을경우 y기준 오름차순 정렬
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < 2; y++) {
                System.out.print(plane[x][y] + " ");
            }
            System.out.println();
        }
    }
}