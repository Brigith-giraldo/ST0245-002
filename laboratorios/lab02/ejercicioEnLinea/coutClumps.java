public class coutClumps {
    //O(n)
    public int countClumps(int[] nums) {
        int clumps = 0;
        int aux = Integer.MIN_VALUE;
        boolean aux2 = false;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == aux){
                if (aux2 == false){
                    aux2 = true;
                    clumps += 1; 
                }
            }else{
                aux2 = false;
            }
            aux = nums[i];
        }
        return clumps;
    }
}
