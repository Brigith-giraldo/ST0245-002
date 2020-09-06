public class maxSpan {
    //O(n)
    public static int maxSpan(int[] nums) {
        int start[] = new int[20];
        int end[] = new int[20];
        int exist[] = new int[20];
        for (int i = 0; i < nums.length; i++){
            if (exist[nums[i]] != 1){
                exist[nums[i]] = 1;
                start[nums[i]] = i;
            }else {
                end[nums[i]] = i;
            }
        }
        int max = 0;
        for (int i = 0; i < 20; i++){
            if (exist[i] == 1){
                max = Math.max(max,(end[i]-start[i]+1));
            }
        }
        return max;
    }
      

    public static void main(String[] args) {
        System.out.println(maxSpan(new int[] {3,3,3}));
    }
}
