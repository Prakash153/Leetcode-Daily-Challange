Given the root of a binary tree, construct a string consisting of parenthesis and integers from a binary tree with the preorder traversal way, and return it.

Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string and the original binary tree.


  
  code : 

class Solution {
    String res;
    public String tree2str(TreeNode root) {
        res = new String();
        traverseTree(root);
        return res;
    }
    private void traverseTree(TreeNode root) {
        if(root == null) {
            return;
        }
        res += root.val;
        if(root.left == null) {
            if(root.right != null) {
                res += "()";
            }
        } else {
            res += '(';
            traverseTree(root.left);
            res += ')';
        }
        if(root.right != null) {
            res += '(';
            traverseTree(root.right);
            res += ')';
        }
    }
}
