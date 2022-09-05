Given an n-ary tree, return the level order traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).


A BInary Tree with N children 



code : 
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
    if(root == null)
        return ans;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
        long level = queue.size();
        List<Integer> subList = new ArrayList<>();
        while(level-->0){
            Node head = queue.poll();
            subList.add(head.val);
            for(Node j : head.children)
                queue.offer(j);
        }
        ans.add(subList);
    }
    return ans;
    }
}
