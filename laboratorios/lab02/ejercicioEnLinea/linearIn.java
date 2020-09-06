public class linearIn {
    public boolean linearIn(int[] outer, int[] inner) {
        int j = 0;
        for (int i = 0; i < inner.length; i++){
            while (true){
                if (j==outer.length || outer[j]>inner[i]){
                    return false;
                }else if (outer[j]==inner[i]){
                    break;
                }else {
                    j++;
                }
            }
        }
        return true;
    }
}