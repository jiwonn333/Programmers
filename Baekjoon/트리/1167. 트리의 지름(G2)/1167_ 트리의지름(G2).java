import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n; // 노드의 개수
    static ArrayList<Node>[] tree; // 트리의 인접리스트
    static boolean[] visited; // 방문 체크 배열
    static int maxDistance = 0; // 트리의 지름
    static int farthestNode = 0; // 가장 먼 노드

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());


        // 트리 초기화
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // 입력 처리
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());

            while (true) {
                int target = Integer.parseInt(st.nextToken());
                if (target == -1) break; // -1이 나오면 종료
                int weight = Integer.parseInt(st.nextToken());
                tree[index].add(new Node(target, weight));
            }
        }

        // 임의의 노드(1번)에서 가장 먼 노드 찾기
        visited = new boolean[n + 1];
        dfs(1, 0);

        // 가장 먼 노드에서 dfs 실행
        visited = new boolean[n + 1];
        maxDistance = 0; // 트리 지름 초기화
        dfs(farthestNode, 0);

        System.out.println(maxDistance);

    }

    static void dfs(int currentNode, int distance) {
        visited[currentNode] = true;

        // 최대 거리 갱신
        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = currentNode;
        }

        // 현재 노드와 연결된 모든 노드 탐색
        for (Node next : tree[currentNode]) {
            if (!visited[next.node]) {
                dfs(next.node, distance + next.weight);
            }
        }
    }

    static class Node {
        private int node;
        private int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}