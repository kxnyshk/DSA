import java.util.Random;
import java.util.Scanner;

public class ElementInInfiniteArray {

    static{
    
        System.out.println("\nFinding an element in an infinite sorted array.");
    }
    private static final int MIN_LIMIT = -100;
    private static final int MAX_LIMIT = 100;
    public static void main(String[] args){
    
        int[] array = {-97,-86,-77,-65,-54,-42,-33,-22,-11,-1,10,17,23,34,45,56,62,76,84,92,100};
        int n = array.length;

        Random randNum = new Random();
        int x = (randNum.nextInt(MAX_LIMIT-MIN_LIMIT) + MIN_LIMIT);     // generates random number between -10

        int idx;
        idx = elementInfinite(array, n, x);
        System.out.println("\n" + x + " : Index " + idx);

        reRunExit();
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

    private static int elementInfinite(int[] array, int n, int x) {
        int start = 0;
        int end = 1;
        while(x>array[end]){
            start = end;
            end = end*2;
        }

        int idx = -1;
        idx = BinSearch(array, start, end, x);
        return idx;
    }

    private static int BinSearch(int[] array, int start, int end, int x) {
        int low = start;
        int high = end;

        while(low<=high){
            int mid = (low + (high-low)/2);
            if(x == array[mid]){
                return mid;
            }
            else if(x > array[mid]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }    
}