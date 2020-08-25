public class bunnyEars {
    /*
        We have a number of bunnies and each bunny has two big floppy ears.
        We want to compute the total number of ears across all the bunnies recursively
    */
    
    public static int bunnyEars(int bunnies) {
        if (bunnies == 0){
          return 0;
        }
        return bunnyEars(bunnies-1) + 2;
    }
}