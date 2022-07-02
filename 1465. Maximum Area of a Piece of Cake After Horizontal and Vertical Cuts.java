You are given a rectangular cake of size h x w and two arrays of integers horizontalCuts and verticalCuts where:

horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly, and
verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.
Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the arrays horizontalCuts and 
verticalCuts. Since the answer can be a large number, return this modulo 109 + 7.

Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
Output: 4 
Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. 
After you cut the cake, the green piece of cake has the maximum area.



code : 

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int hLength = horizontalCuts.length;
        int vLength = verticalCuts.length;
                
        int maxHeight = Math.max(horizontalCuts[0]-0, h - horizontalCuts[hLength-1]);
        for (int i = 1;i<hLength; i++){
            int diff = horizontalCuts[i] - horizontalCuts[i-1];
            maxHeight = Math.max(maxHeight, diff);
        }
        
        
        int maxWidth = Math.max(verticalCuts[0]-0, w - verticalCuts[vLength-1]);
        for (int i = 1;i<vLength; i++){
            int diff = verticalCuts[i] - verticalCuts[i-1];
            maxWidth = Math.max(maxWidth, diff);
        }
        
        long ans = 1L * maxHeight * maxWidth;
        
        return  (int) (ans % 1000000007);
    }
}
