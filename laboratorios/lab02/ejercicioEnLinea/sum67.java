public class sum67 {
    //O(n)
    public int sum67(int[] nums) {
        int sum = 0;
        boolean six = false;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 6){
                six = true;
            }
            if (!six){
                sum += nums[i];
            }
            if (nums[i]==7){
                six = false;
            }
        }
        return sum;
    }      
}
