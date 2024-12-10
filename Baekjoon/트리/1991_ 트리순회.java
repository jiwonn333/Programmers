import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class TreeNode {
        char value;
        TreeNode left;
        TreeNode right;

        public TreeNode(char value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeNode head = new TreeNode('A', null, null); // head 설정

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            insertNode(head, root, left, right);
        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);

    }

    static void insertNode(TreeNode treeNode, char root, char left, char right) {
        if (treeNode.value == root) {
            treeNode.left = left == '.' ? null : new TreeNode(left, null, null);
            treeNode.right = right == '.' ? null : new TreeNode(right, null, null);
        } else {
            if (treeNode.left != null)
                insertNode(treeNode.left, root, left, right);
            if (treeNode.right != null)
                insertNode(treeNode.right, root, left, right);
        }
    }


    // 전위
    static void preOrder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 중위
    static void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    // 후위
    static void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }
}