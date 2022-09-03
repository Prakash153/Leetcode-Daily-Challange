Return all non-negative integers of length n such that the absolute difference between every two consecutive digits is k.

Note that every number in the answer must not have leading zeros. For example, 01 has one leading zero and is invalid.

You may return the answer in any order.
  
  
  Input: n = 3, k = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.
  
  
  Solution : 

// we can use DFS method, suppose the number we have to select is 3 digit no. , now we have to check for every possiblity for the number starting from 1. 
 // at one's place if place '1' we will have two option 1+k or 1-k to be placed at 10's place. 


code: 

class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(n == 1 ) 
            return new int[] {0,1,2,3,4,5,6,7,8,9,}; // if n = 1 , every single digit is a number. 
        
        for(int i = 1 ; i <= 9 ; i++){   // checking possiblity for every number starting from 1 to 9 
            dfs(n,k,i,0,i,res);
        }
        int ans[] = new int[res.size()]; 
        for(int i = 0 ; i < res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    
    public void dfs(int n, int k , int curr, int i , int prev, ArrayList<Integer> res){
      
      // 1. curr = curr number , suppose 18 for 181 
      // 2. i = position suppose 10's position for 8 
      // 3. prev = last digit of the curr number 
      
        if(i == n -1  ) {
           res.add(curr);
        return;
        }
        int next = prev+k ; 
        if(next < 10){
            dfs(n,k,curr*10 + next , i+1 , next, res);
        }
        
        next = prev - k ; 
      // k sould not be equal to 0 as the following condition can create duplicates, because  x-0 == x + 0 
        if(k != 0 && next >= 0){
            dfs(n,k,curr*10 + next , i + 1 , next , res);
        }
    }
}
