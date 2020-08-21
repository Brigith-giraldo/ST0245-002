
public class taller4 {
    public static int max(int nums[]){
        return max(0,nums);
    }

    public static int max(int index,int nums[]){
        if (index == nums.length){
            return Integer.MIN_VALUE;
        }else{
            return Math.max(nums[index], max(index+1,nums));
        }
    }

    public static boolean groupSum(int index, int nums[], int target){
        if (target == 0){
            return true;
        }else if(index == nums.length){
            return false;
        }else {
            return groupSum(index+1, nums, target-nums[index]) || groupSum(index+1, nums, target);
        }
    }

    public static int fibonacci(int n){
        if (n == 1){
            return 1;
        }else if(n < 1){
            return 0;
        }else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}