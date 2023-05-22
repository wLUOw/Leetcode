class Solution {
    private int limit;

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        this.limit = limit;
        boolean b = dfs(root, 0);
        if (!b) return null;
        return root;
    }

    private boolean dfs(TreeNode node, int sum){
        sum += node.val;
        if (node.left == null && node.right == null) {
            return sum >= limit;
        }
        boolean left = false;
        boolean right = false;
        if (node.left != null) {
            left = dfs(node.left, sum);
            if (!left) node.left = null;
        }
        if (node.right != null) {
            right = dfs(node.right, sum);
            if (!right) node.right = null;
        }
        return left || right;
    }
}