import java.util.Random;
import java.util.Scanner;

public class CeilElementSortedArray {
    
    static{
    
        System.out.println("\nCeil of an element in sorted array, by BS.");
    }
    private static final int MAX_RANDOM = 301;
    private static final int MIN_RANDOM = 150;
    public static void main(String[] args){
    
        int[] array = {-100,-98,-83,-77,-64,-50,-45,-33,-24,-11,-7,0,4,12,22,34,48,56,62,72,84,92,100};
        int n = array.length;

        Random randnum = new Random();
        int x = (randnum.nextInt(MAX_RANDOM)-MIN_RANDOM);   // generates a random number between -150 to 150

        int ceil;
        ceil = Ceil(array, n , x);
        System.out.println("\nCeil [" + x + "] : " + ceil);

        reRunExit();
    }

    private static int Ceil(int[] array, int n, int x) {
        int start = 0;
        int end = n-1;
        int ceil = -1;

        while(start<=end){
            int mid = (start + (end-start)/2);

            if(x == array[mid]){
                return array[mid];
            }
            else if(x<array[mid]){
                ceil = array[mid];
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ceil;
    }

    private static void reRunExit() {
        System.out.print("\nPress 1 : Re-run | 0 : Exit _");
        Scanner scan = new Scanner(System.in);
        int key = scan.nextInt();
        if(key == 1){
            main(null);
        }
        else if(key == 0){
            System.exit(0);
        }
        else{
            System.out.print("\nEnter only 1 or 0. ");
            reRunExit();
        }
        scan.close();
    }
}
