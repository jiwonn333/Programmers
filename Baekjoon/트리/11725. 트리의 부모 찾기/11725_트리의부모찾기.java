import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());    //노드의 개수

        List<List<Integer>> tree = new ArrayList<>(); // 트리 선언
        // 1번 인덱스부터 시작할 예정, 총 8개의 방 필요하므로 n+1
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }

        // 문제 입력 조건에서 n-1개의 줄이 주어지므로 n-1
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            tree.get(left).add(right);
            tree.get(right).add(left);
        }

        // queue 사용 및 기본 설정
        int[] parent = new int[n + 1];
        boolean[] isVisited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); // root = 1 지정 (문제 조건)
        isVisited[1] = true;


        // 비어 있을 때까지 반복
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int child : tree.get(node)) {
                if (!isVisited[child]) {
                    isVisited[child] = true;
                    parent[child] = node;
                    queue.add(child);
                }
            }
        }

        // 출력
        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }

    }
}