You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 Example 1:

Input: properties = [[5,5],[6,3],[3,6]]
Output: 0
Explanation: No character has strictly greater attack and defense than the other.
Example 2:

Input: properties = [[2,2],[3,3]]
Output: 1
Explanation: The first character is weak because the second character has a strictly greater attack and defense.
Example 3:

Input: properties = [[1,5],[10,4],[4,3]]
Output: 1
Explanation: The third character is weak because the second character has a strictly greater attack and defense.
 
  
  code: 
class Solution {
public int numberOfWeakCharacters(int[][] properties) {
        int result =0;
        int min= Integer.MIN_VALUE;
        
        //Here a[0] == b[0] means attacking powers are same , then we sort elements in decreasing
        //defensive power.Else we can sort in increasing attacking power.
        Arrays.sort(properties,(a,b) -> a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);
        
        for(int i=properties.length-1;i>=0;i--){// iterate backwards
            int[] arr = properties[i];
            int attack = arr[0];
            int defense = arr[1];
            //when defense of current is < min , definitley a week character
            if(defense < min){
                result++;
            }
            //so that min stays at max defense
            min=Math.max(min,defense);
        }
        return result;
    }
}
