Given the root of a binary tree, return the average value of the nodes on each level in 
the form of an array. Answers within 10-5 of the actual answer will be accepted.
  
 //  Solution: use BFS traversal
  code: 

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> al  = new ArrayList<>(); 
        if(root == null) return al; 
        
        Queue<TreeNode> q = new  LinkedList<>(); 
        q.offer(root); 
        while(!q.isEmpty()){
            int s = q.size(); 
            double sum = 0 ; 
            for(int i = 0 ; i < s ; i++){
                TreeNode curr = q.poll(); 
                sum+= curr.val; 
                if(curr.left != null) q.offer(curr.left); 
                if(curr.right != null) q.offer(curr.right);
            }
            al.add(sum/s);
        }
        return al;
    }
}
 
