public class MirrorTree {
    
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }
    
    public static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.val == right.val)
            && isMirror(left.left, right.right)
            && isMirror(left.right, right.left);
    }
    
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }
    
    public static void main(String[] args) {
        //     1
        //    / \
        //   2   2
        //  / \ / \
        // 3  4 4  3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        
        System.out.println("Is Mirror (Symmetric): " + isSymmetric(root)); // true

        //     1
        //    / \
        //   2   2
        //    \   \
        //     3   3
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);
        
        System.out.println("Is Mirror (Symmetric): " + isSymmetric(root2)); // false
    }
}
```

**Output:**
```
// Is Mirror (Symmetric): true
// Is Mirror (Symmetric): false
