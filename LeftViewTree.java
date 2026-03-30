public class LeftViewTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static int maxLevel = 0;

    // Left View using Recursion
    public static void leftView(TreeNode node, int level) {
        if (node == null) return;

        if (level > maxLevel) {
            System.out.print(node.val + " ");
            maxLevel = level;
        }

        leftView(node.left,  level + 1);
        leftView(node.right, level + 1);
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

        System.out.print("Left View: ");
        leftView(root, 1);
        System.out.println();
    }
}
// ```

// **Output:**
// ```
// Left View: 1 2 4 7
