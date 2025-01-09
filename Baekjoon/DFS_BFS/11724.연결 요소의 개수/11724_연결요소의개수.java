import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M
        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수


        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            graph.get(left).add(right);
            graph.get(right).add(left);
        }


        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                count++;
            }
        }

        System.out.print(count);

    }

    static void dfs(List<List<Integer>> graph, boolean[] visited, int startNode) {
        visited[startNode] = true;

        for (int nextNode : graph.get(startNode)) {
            if (!visited[nextNode]) {
                dfs(graph, visited, nextNode);
            }
        }
    }
}