Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.
  
  
  // Solution:for the path root <= X , we need to get the prev max and compare with each node. 
  
  
  code: 

class Solution {
    int count = 0 ; 
    public int inorder(TreeNode root , int prev_max){
        if(root == null) return 0 ; 
        
        if(root.val >= prev_max) count++;
        
        prev_max = Math.max(root.val,prev_max);
        inorder(root.left,prev_max);
        inorder(root.right,prev_max);
        return count;
    }
    
    public int goodNodes(TreeNode root) {
        return inorder(root,root.val);
    }
}
