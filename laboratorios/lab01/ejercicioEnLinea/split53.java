public class split53 {
    /**
     * Given an array of ints, is it possible to divide the 
     * ints into two groups, so that the sum of the two groups 
     * is the same, with these constraints: all the values 
     * that are multiple of 5 must be in one group, and all 
     * the values that are a multiple of 3 (and not a multiple of 5) 
     * must be in the other. (No loops needed.)
    */
    public boolean split53(int[] nums) {
        return split53(0, nums, 0, 0);
    }
    
    public boolean split53(int index, int[] nums, int g1, int g2) {
        if (index == nums.length){
            return g1 == g2;
        }else if(nums[index] % 5 == 0){
            return split53(index+1, nums, g1 + nums[index], g2);
        }else if(nums[index] % 3 == 0){
            return split53(index+1, nums, g1, g2 + nums[index]);
        }else {
            return split53(index+1, nums, g1 + nums[index], g2) || split53(index+1, nums, g1, g2 + nums[index]);
        }
    }  
}