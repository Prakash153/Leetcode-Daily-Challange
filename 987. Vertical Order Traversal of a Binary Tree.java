Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1)
  respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting 
from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.
  
  
  code: 

class Solution {
    class Pair{
        int hd;
        TreeNode node;
        Pair(int hd, TreeNode node){
            this.hd = hd;
            this.node = node;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));
        
        while(!q.isEmpty()){
            int size = q.size();
            Map<Integer, List<Integer>> levelMap = new HashMap<>();
            while(size-- > 0){
                Pair curr = q.poll();
                int dist = curr.hd;
                List<Integer> nodeList = levelMap.getOrDefault(dist, new ArrayList<>());
                nodeList.add(curr.node.val);
                Collections.sort(nodeList);
                levelMap.put(dist, new ArrayList<>(nodeList));
                
                if(curr.node.left != null)
                    q.add(new Pair(dist-1, curr.node.left));
                if(curr.node.right != null)
                    q.add(new Pair(dist+1, curr.node.right));
            }
            for(Map.Entry<Integer, List<Integer>> entry: levelMap.entrySet()){
                List<Integer> nodeList = map.getOrDefault(entry.getKey(), new ArrayList<>());
                nodeList.addAll(entry.getValue());
                map.put(entry.getKey(), nodeList);
            }
        }
        return new ArrayList<>(map.values());
    }
}

 

