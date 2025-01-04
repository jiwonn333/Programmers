import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n; // 컴퓨터의 수
    static int pair; // 연결된 컴퓨터 쌍의 수
    static List<List<Integer>> tree; // 트리 선언
    static boolean[] visited; // 방문 체크 배열
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 컴퓨터의 수 7
        pair = Integer.parseInt(br.readLine()); // 연결된 쌍 6

        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < pair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            tree.get(left).add(right);
            tree.get(right).add(left);
        }

        visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1);
        System.out.println(count);
    }

    static void dfs(int node) {
        for (int nodes : tree.get(node))
            if (!visited[nodes]) {
                visited[nodes] = true;
                count++;
                dfs(nodes);
            }
    }
}