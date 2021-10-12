import java.util.Random;
import java.util.Scanner;

public class MinDiffElement {
    
    static{
    
        System.out.println("\nFinding the min diff element in a sorted array, BS.");
    }
    private static final int MIN_LIMIT = -20;
    private static final int MAX_LIMIT = 20;
    public static void main(String[] args){
    
        int[] array = {-18,-15,-12,-9,-6,-3,1,4,7,11,15,18};
        int n = array.length;

        Random randNum = new Random();
        int x = (randNum.nextInt(MAX_LIMIT-MIN_LIMIT) + MIN_LIMIT);         // generates random number between -20 to 20

        int minDiffElement;
        minDiffElement = MinDifference(array, n, x);
        
        System.out.println("\nMin diff [" + x + "] : " + minDiffElement);

        reRunExit();
    }

    private static int MinDifference(int[] array, int n, int x) {
        int ceil, floor;

        ceil = Ceil(array, n, x);
        floor = Floor(array, n, x);

        if(ceil == -1){
            return floor;
        }
        else if(floor == -1){
            return ceil;
        }
        else{
            int ceilDiff = ceil - x;
            int floorDiff = x - floor;
            
            return floorDiff<=ceilDiff ? floor : ceil;
        }
    }

    private static int Floor(int[] array, int n, int x) {
        int start = 0;
        int end = n-1;
        int floor = -1;

        while(start<=end){
            int mid = (start + (end-start)/2);

            if(x == array[mid]){
                return array[mid];
            }
            else if(x>array[mid]){
                floor = array[mid];
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return floor;
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
