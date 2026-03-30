import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static void levelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left  != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    public static void main(String[] args) {
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6

        TreeNode root        = new TreeNode(1);
        root.left            = new TreeNode(2);
        root.right           = new TreeNode(3);
        root.left.left       = new TreeNode(4);
        root.left.right      = new TreeNode(5);
        root.right.right     = new TreeNode(6);

        System.out.print("Level Order: ");
        levelOrder(root);
        System.out.println();
    }
}
// ```

// **Output:**
// ```
// Level Order: 1 2 3 4 5 6
Level Order: 1 2 3 4 5 6
