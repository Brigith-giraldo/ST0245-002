public class splitArray {
    /**
     * Given an array of ints, is it possible to divide
     *  the ints into two groups, so that the sums of the
     * two groups are the same. Every int must be in one
     * group or the other. Write a recursive helper method
     * that takes whatever arguments you like, and make
     * the initial call to your recursive helper from
     * splitArray(). (No loops needed.)
    */

    public boolean splitArray(int[] nums) {
        return splitArray(0, nums, 0, 0);
    }
      
    public boolean splitArray(int index,int[] nums, int s1, int s2) {
        if (index == nums.length){
          return s1==s2;
        }
        return splitArray(index+1, nums, s1+nums[index], s2) || splitArray(index+1, nums, s1, s2+nums[index]);
    }  
}