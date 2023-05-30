import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    List<TreeNode> list = new ArrayList<>();
    Set<Integer> to_delete = new HashSet<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int i = 0; i < to_delete.length; i++) {
            this.to_delete.add(to_delete[i]);
        }
        dfs(root, true);
        return list;
    }

    private TreeNode dfs(TreeNode node, boolean isRoot){
        if (node == null) return null;
        boolean del = to_delete.contains(node.val);
        node.left = dfs(node.left, del);
        node.right = dfs(node.right, del);
        if (del) {
            return null;
        } else {
            if (isRoot) {
                list.add(node);
            }
            return node;
        }
    }
}