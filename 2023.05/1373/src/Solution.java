class Solution {
    int max = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return max;
    }

    private SubTree dfs(TreeNode node){
        if (node.left == null && node.right == null) {
            max = Math.max(max, node.val);
            return new SubTree(node.val, node.val, node.val);
        }
        if (node.right == null) {
            SubTree le = dfs(node.left);
            if (le == null) return null;
            if (le.maxVal >= node.val) return null;
            else {
                le.sum += node.val;
                le.maxVal = node.val;
                max = Math.max(max, le.sum);
                return le;
            }
        }
        if (node.left == null) {
            SubTree ri = dfs(node.right);
            if (ri == null) return null;
            if (ri.minVal <= node.val) return null;
            else {
                ri.sum += node.val;
                ri.minVal = node.val;
                max = Math.max(max, ri.sum);
                return ri;
            }
        }
        SubTree le = dfs(node.left);
        SubTree ri = dfs(node.right);
        if (le == null || ri == null) return null;
        if (le.maxVal < node.val && ri.minVal > node.val) {
            max = Math.max(max, le.sum + ri.sum + node.val);
            return new SubTree(le.sum + ri.sum + node.val, ri.maxVal, le.minVal);
        }
        return null;
    }

    class SubTree {
        int sum;
        int maxVal;
        int minVal;

        public SubTree(int sum, int maxVal, int minVal) {
            this.sum = sum;
            this.maxVal = maxVal;
            this.minVal = minVal;
        }
    }
}
