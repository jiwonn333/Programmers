import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<Integer>[] tree;
    static int root;
    static int remove;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent != -1) {
                tree[parent].add(i);
            } else {
                root = i;
            }
        }
        remove = Integer.parseInt(br.readLine());
        dfs(remove);
        System.out.println(result);

    }

    public static void dfs(int delete) {
        Stack<Integer> stack = new Stack<>();
        stack.add(root);

        if (delete == root) return;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            int count = 0;

            for (int child : tree[node]) {
                if (child != delete) {
                    stack.add(child);
                    count++;
                }
            }

            if (count == 0) result++;
        }
    }
}