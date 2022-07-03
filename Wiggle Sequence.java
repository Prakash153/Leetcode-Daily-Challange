A wiggle sequence is a sequence where the differences between successive numbers strictly alternate
between positive and negative. The first difference (if one exists) may be either positive or negative. 
A sequence with one element and a sequence with two non-equal elements are trivially wiggle sequences.

For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3) alternate between positive and negative.
In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences. The first is not because its first two differences 
are positive, and the second is not because its last difference is zero.
A subsequence is obtained by deleting some elements (possibly zero) from the original sequence, leaving the remaining elements in their original order.

Given an integer array nums, return the length of the longest wiggle subsequence of nums.



a wiggle sequence in inc-dec-inc-dec-inc-dec 

/\/\/\/\/\
solution : 
the idea is to use two variables to comute the length of longest subsequence: increase and decrease. 
initially they will be 1. 
as the first element could be anything inc to dec.

dry run : 

 nums = [1,17,5,10,13,15,10,5,16,8]

inc = 1 , dec = 1 
at i = 1 : nums[i] > nums[i-1] => inc = dec + 1 = 1+1 = 2
at i = 2 : nums[i] < nums[i-1] => dec = inc + 1 = 2+1 = 3
at i = 3 : nums[i] > nums[i-1] => inc = dec + 1 = 3+1 = 4
at i = 4 : nums[i] > nums[i-1] => inc = dec + 1 = 3+1 = 4
at i = 5 : nums[i] > nums[i-1] => inc = dec + 1 = 3+1 = 4
at i = 6 : nums[i] < nums[i-1] => dec = inc + 1 = 4+1 = 5
at i = 7 : nums[i] < nums[i-1] => dec = inc + 1 = 4+1 = 5
at i = 8 : nums[i] > nums[i-1] => inc = dec + 1 = 5+1 = 6
at i = 9 : nums[i] < nums[i-1] => dec = inc + 1 = 6+1 = 7


max(inc,dec) => (6,7) => 7
ans;


code: 


class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2) return 1;
        int inc = 1 , dec = 1; 
        for(int i = 1 ; i< nums.length ; i++ )
        {
            if(nums[i] >  nums[i-1])
                inc = dec + 1;
            else if(nums[i] < nums[i-1])
                dec = inc + 1;
        }
        return Math.max(inc,dec);
    }
}
