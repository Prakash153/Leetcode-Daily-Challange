Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

A subtree of a node node is node plus every node that is a descendant of node.

 code: 

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return dive(root)?null:root;
    }
    
    boolean dive(TreeNode node) {
        if (node==null) return true;
        boolean left = dive(node.left);
        boolean right = dive(node.right);
        if (left) node.left=null;
        if (right) node.right=null;
        return left&&right&&node.val==0;        
    }
}
