There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.


Candy
The idea is to first allocate atleast 1 candy to each child. then distribute according to neighbours.

traverse left to right to check wether the i'th elelement has ratings more than i-1'th element. if yes. increase the count og candies by 1, since we have to return minimum candiies.

similarly traverse from right to left and check for i+1'th element.

TC = O(n);
SC = O(N);

code :


class Solution {
    public int candy(int[] ratings) {
        int candies[] = new int[ratings.length];
        for(int i = 0 ; i < candies.length; i++)
        {
            candies[i] = 1;
        }
        // checking for left to right
        for(int i = 1 ; i< ratings.length ; i++){
            if(ratings[i] > ratings[i-1] && candies[i] <= candies[i-1])
                candies[i] = candies[i-1] + 1;
        }
        //checking for right to left
        for(int i= ratings.length - 2 ; i >=0 ; i--){
            if(ratings[i] > ratings[i+1] && candies[i] <= candies[i+1])
                candies[i] = candies[i+1] + 1;
        }
        
        int tot_candy = 0 ; 
        for(int i = 0 ; i< candies.length ; i++)
        {
            tot_candy+=candies[i];
        }
        return tot_candy;
    }
}
