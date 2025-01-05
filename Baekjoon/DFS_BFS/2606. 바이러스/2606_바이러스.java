import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수 7
        int pair = Integer.parseInt(br.readLine()); // 연결된 쌍 6

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < pair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            graph.get(left).add(right);
            graph.get(right).add(left);
        }

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        // DFS 실행 및 결과 출력
        int count = dfs(graph, visited, 1);
        System.out.println(count);
    }

    static int dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        int count = 0;

        for (int nextNode : graph.get(node)) {
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                count += 1 + dfs(graph, visited, nextNode);
            }
        }

        return count;
    }
}