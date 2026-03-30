import java.util.*;

public class LowestCommonAncestor {
    
    static class TreeNode {
        int val;
        TreeNode left, right;
        
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    // ─────────────────────────────────────────────
    // 1. LCA in a Binary Tree (no BST property)
    // ─────────────────────────────────────────────
    public static TreeNode lcaBinaryTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        
        TreeNode left  = lcaBinaryTree(root.left,  p, q);
        TreeNode right = lcaBinaryTree(root.right, p, q);
        
        if (left != null && right != null) return root; // p and q on opposite sides
        return left != null ? left : right;
    }
    
    // ─────────────────────────────────────────────
    // 2. LCA in a Binary Search Tree
    // ─────────────────────────────────────────────
    public static TreeNode lcaBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        
        if (p.val < root.val && q.val < root.val)
            return lcaBST(root.left, p, q);   // both nodes in left subtree
        if (p.val > root.val && q.val > root.val)
            return lcaBST(root.right, p, q);  // both nodes in right subtree
        
        return root; // split point → this is the LCA
    }
    
    // ─────────────────────────────────────────────
    // 3. LCA using Parent Pointers (iterative)
    // ─────────────────────────────────────────────
    public static TreeNode lcaWithParentMap(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        
        parentMap.put(root, null);
        stack.push(root);
        
        // Build parent map until both p and q are found
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parentMap.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                stack.push(node.right);
            }
        }
        
        // Collect all ancestors of p
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parentMap.get(p);
        }
        
        // First ancestor of q that is also ancestor of p → LCA
        while (!ancestors.contains(q))
            q = parentMap.get(q);
        
        return q;
    }
    
    // ─────────────────────────────────────────────
    // 4. LCA for n-ary Tree (multiple children)
    // ─────────────────────────────────────────────
    static class NaryNode {
        int val;
        List<NaryNode> children;
        NaryNode(int val) { this.val = val; this.children = new ArrayList<>(); }
    }
    
    public static NaryNode lcaNaryTree(NaryNode root, NaryNode p, NaryNode q) {
        if (root == null || root == p || root == q) return root;
        
        List<NaryNode> matches = new ArrayList<>();
        for (NaryNode child : root.children) {
            NaryNode res = lcaNaryTree(child, p, q);
            if (res != null) matches.add(res);
        }
        
        return matches.size() >= 2 ? root : (matches.isEmpty() ? null : matches.get(0));
    }
    
    // ─────────────────────────────────────────────
    // Helper: build a sample BST
    // ─────────────────────────────────────────────
    static TreeNode insertBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left  = insertBST(root.left,  val);
        else                root.right = insertBST(root.right, val);
        return root;
    }
    
    // ─────────────────────────────────────────────
    // Helper: find a node by value
    // ─────────────────────────────────────────────
    static TreeNode findNode(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        TreeNode left = findNode(root.left, val);
        return left != null ? left : findNode(root.right, val);
    }
    
    // ─────────────────────────────────────────────
    // Main — demo all approaches
    // ─────────────────────────────────────────────
    public static void main(String[] args) {
        
        // ── Binary Tree ──────────────────────────────
        //          3
        //        /   \
        //       5     1
        //      / \   / \
        //     6   2 0   8
        //        / \
        //       7   4
        TreeNode btRoot = new TreeNode(3);
        btRoot.left           = new TreeNode(5);
        btRoot.right          = new TreeNode(1);
        btRoot.left.left      = new TreeNode(6);
        btRoot.left.right     = new TreeNode(2);
        btRoot.right.left     = new TreeNode(0);
        btRoot.right.right    = new TreeNode(8);
        btRoot.left.right.left  = new TreeNode(7);
        btRoot.left.right.right = new TreeNode(4);
        
        TreeNode p = btRoot.left;              // node 5
        TreeNode q = btRoot.right;             // node 1
        System.out.println("=== Binary Tree LCA ===");
        System.out.println("LCA(5, 1) = " + lcaBinaryTree(btRoot, p, q).val);  // 3
        
        p = btRoot.left;                       // node 5
        q = btRoot.left.right.right;           // node 4
        System.out.println("LCA(5, 4) = " + lcaBinaryTree(btRoot, p, q).val);  // 5
        
        // ── BST ─────────────────────────────────────
        //         6
        //        / \
        //       2   8
        //      / \
        //     0   4
        //        / \
        //       3   5
        
    }
}

LCA(5, 2) = 1
