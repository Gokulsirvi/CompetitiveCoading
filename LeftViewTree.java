import java.util.LinkedList;
import java.util.Queue;

public class LeftViewTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // Left View using BFS
    public static void leftView(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        System.out.print("Left View: ");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0)
                    System.out.print(node.val + " "); // First node of each level
                if (node.left  != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6
        //             \
        //              7
        TreeNode root = new TreeNode(1);
        root.left        = new TreeNode(2);
        root.right       = new TreeNode(3);
        root.left.left   = new TreeNode(4);
        root.left.right  = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        leftView(root); // 1 2 4 7
    }
}
// ```

// **Output:**
// ```
// Left View: 1 2 4 7
// ```

// **Tree Structure:**
// ```
//         1          ← 1
//        / \
//       2   3        ← 2
//      / \   \
//     4   5   6      ← 4
//              \
//               7    ← 7
