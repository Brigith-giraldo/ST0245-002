public class seriesUp {
    //O(n^2)
    public int[] seriesUp(int n) {
        int nums[] = new int[n*(n + 1)/2];
        int index = 0;
        for (int i  = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                nums[index] = j;
                index += 1;
            }
        }
        return nums;
    }      
}
