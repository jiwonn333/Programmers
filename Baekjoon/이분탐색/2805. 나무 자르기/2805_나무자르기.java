import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 나무 개수
        int m = Integer.parseInt(st.nextToken()); // 집으로 가져갈 나무 길이


        // 나무들의 높이 입력
        st = new StringTokenizer(br.readLine());
        int[] tree = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);

        System.out.println(binary(tree, m));
    }

    public static long binary(int[] tree, int m) {
        int start = 0;
        int end = Arrays.stream(tree).max().getAsInt(); // tree에서 가장 큰 값 가져오기
        int mid;
        long cutting;


        while (start <= end) {
            mid = (start + end) / 2;
            cutting = cuttingHeight(tree, mid);

            if (cutting < m) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    public static long cuttingHeight(int[] tree, int mid) {
        long cutting = 0;

        for (int height : tree) {
            if (height > mid) {
                cutting += (height - mid); // mid보다 큰 나무만 자름
            }
        }
        return cutting;
    }
}