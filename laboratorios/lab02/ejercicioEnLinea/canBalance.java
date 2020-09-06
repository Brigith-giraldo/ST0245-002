public class canBalance {
    //O(n)
    public boolean canBalance(int[] nums) {
        int i = -1;
        int j = nums.length;
        int sum1 = 0, sum2 = 0;
        while (i != j){
            if (sum1 == sum2){
                if (j-i == 1){
                    return true;
                }
                i++;
                j--;
                if (j == i){
                    return false;
                }
                sum1 += nums[i];
                sum2 += nums[j];
            }else if(sum1 < sum2){
                i++;
                sum1 += nums[i];
            }else if(sum1 > sum2){
                j--;
                sum2 += nums[j];
            }          
        }
        return false;
    }
      
}
