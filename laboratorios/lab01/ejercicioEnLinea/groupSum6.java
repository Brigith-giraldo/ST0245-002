public class groupSum6 {
    /**
     * Given an array of ints, is it possible to choose a 
     * group of some of the ints, beginning at the start 
     * index, such that the group sums to the given target? 
     * However, with the additional constraint that all 
     * 6's must be chosen. (No loops needed.)
     */

    public boolean groupSum6(int start, int[] nums, int target) {
        if (start == nums.length){
            return target == 0;
        }else{
            if (nums[start] == 6){
                return groupSum6(start + 1, nums, target-6);
            }
            return groupSum6(start + 1, nums, target-nums[start]) || groupSum6(start + 1, nums, target);
        }
    }  
}