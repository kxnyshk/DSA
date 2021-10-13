import java.util.Random;
import java.util.Scanner;

public class BitonicSearch {

    static{
    
        System.out.println("Searching element in a Bitonic Array, BS.\n[Bitonic: first monotonically inc then dec (only once)]");
    }
    private static final int MIN_LIMIT = 0;
    private static final int MAX_LIMIT = 15;
    private static final int ERROR = -1;
    public static void main(String[] args){
    
        int[] array = {1,3,8,12,4,2,0};
        int n = array.length;
        printArray(array);

        Random randNum = new Random();
        int x = (randNum.nextInt(MAX_LIMIT-MIN_LIMIT) + MIN_LIMIT);     // generates random number between 0 --> 15
        
        int peakIDX;
        peakIDX = BitonicPeak(array, n);

        int IDX;
        IDX = BitSearch(array, n, x, peakIDX);
        System.out.println("\n" + x + " : [" + IDX + "]");

        System.out.print("Press 1:Re-run | 0:Exit _");
        reRunExit();
    }

    private static int BitSearch(int[] array, int n, int x, int peakIDX) {
        if(x == array[peakIDX]){
            return peakIDX;
        }
        else{
            int start = 0;
            int end = n-1;

            int IDX1, IDX2;
            IDX1 = AscBinSearch(array, start, peakIDX-1, x);
            IDX2 = DescBinSearch(array, peakIDX+1, end, x);

            if(IDX1 == ERROR && IDX2 == ERROR){
                return -1;
            }
            else{
                return IDX1 == ERROR ? IDX2 : IDX1;
            }
        }
    }

    private static int DescBinSearch(int[] array, int start, int end, int x) {
        int n = ((end-start) + 1);
        
        if(n == 1){
            return x == array[start] ? start : -1;
        }
        else{
            while(start<=end){
                int mid = (start + (end-start)/2);

                if(x == array[mid]){
                    return mid;
                }
                else if(x>array[mid]){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
        }

        return -1;
    }

    private static int AscBinSearch(int[] array, int start, int end, int x) {
        int n = ((end-start) + 1);

        if(n == 1){
            return x == array[start] ? start : -1;
        }
        else{
            while(start<=end){
                int mid = (start + (end-start)/2);

                if(x == array[mid]){
                    return mid;
                }
                else if(x>array[mid]){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }

    private static int BitonicPeak(int[] array, int n) {
        int start = 0;
        int end = n-1;
        int peak = -1;

        // Bitonic array req atleast 3 elements to monotonically inc then dec
        // if index 0 > index 1 --> not a Bitonic array [is decreasing first]
        // if index n-1 > index n-2 --> not a Bitonic array [is increasing later]
        if(n<3 || array[start]>array[start+1] || array[end]>array[end-1]){
            return -1;
        }
        else{
            while(start<=end){
                int mid = (start + (end-start)/2);
                int prev = mid-1;
                int next = mid+1;

                if(array[mid]>array[prev] && array[mid]>array[next]){
                    peak = mid;
                    break;
                }
                else if(array[prev]>array[next]){
                    end = prev;
                }
                else if(array[next]>array[prev]){
                    start = next;
                }
            }
        }
        return peak;
    }

    private static void reRunExit() {
        Scanner scan = new Scanner(System.in);
        int key = scan.nextInt();

        if(key == 1){
            main(null);
        }
        else if(key == 0){
            System.exit(0);
        }
        else{
            System.out.print("\nEnter only 1 or 0. _");
            reRunExit();
        }
        
        scan.close();
    }

    private static void printArray(int[] array) {
        System.out.print("\nArray: ");
        for(int x: array){
            System.out.print(x + " ");
        }
    }
}