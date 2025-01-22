import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        // N, M, R
        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수
        int r = Integer.parseInt(st.nextToken()); // 시작점

        // 0 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 무방향 그래프 간선 양쪽에 넣어주기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            graph.get(left).add(right);
            graph.get(right).add(left);
        }

        // 오름차순 정렬
        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        int[] visited = new int[n + 1];

        count = 1; // 1부터 시작

        bfs(graph, visited, r);

        for (int i = 1; i < visited.length; i++) {
            sb.append(visited[i] + "\n");
        }

        System.out.println(sb);
    }

    private static void bfs(List<List<Integer>> graph, int[] visited, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = count;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int nextNode : graph.get(node)) {
                if (visited[nextNode] == 0) {
                    queue.add(nextNode);
                    count++;
                    visited[nextNode] = count;
                }
            }
        }
    }
}