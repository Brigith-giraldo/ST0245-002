public class splitOdd10 {
/**
 * Given an array of ints, is it possible to divide the ints 
 * into two groups, so that the sum of one group is a multiple 
 * of 10, and the sum of the other group is odd. Every int 
 * must be in one group or the other. Write a recursive helper
 * method that takes whatever arguments you like, and make the
 * initial call to your recursive helper from splitOdd10(). 
 * (No loops needed.)
*/

    public boolean splitOdd10(int[] nums) {
        return splitOdd10(0, nums, 0, 0);
    }
      
    public boolean splitOdd10(int index, int[] nums, int s1, int s2) {
        if (index == nums.length){
            return s1%10 == 0 && s2%2 > 0;
        }
        return splitOdd10(index+1, nums, s1+nums[index], s2) || splitOdd10(index+1,nums, s1, s2+nums[index]);
    }
}