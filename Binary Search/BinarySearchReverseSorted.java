import java.util.Scanner;

public class BinarySearchReverseSorted {
    
    static{
    
        System.out.println("\nBinary search [Reverse sorted array]");
    }
    private static int x;
    public static void main(String[] args){
    
        int[] array = {20,17,15,12,10,7,4,2,0};
        int n = array.length;

        printArray(array);

        int idx;
        idx = BinSearchReverse(array, n);
        System.out.println("\nIndex: " + idx);
    }

    private static int BinSearchReverse(int[] array, int n) {
        int start = 0;
        int end = n-1;

        if(n==1){
            return start;
        }
        else{
            Scanner scan = Search();
            while(start<=end){
                int mid = (start + (end-start)/2);
    
                if(x == array[mid]){
                    return mid;
                }
                else if(x<array[mid]){
                    start = mid+1;
                }
                else if(x>array[mid]){
                    end = mid-1;
                }
            }
        }
        return -1;
    }

    private static Scanner Search() {
        System.out.print("\nsearch: ");
        Scanner scan = new Scanner(System.in);
        x = scan.nextInt();
        return scan;
    }

    private static void printArray(int[] array) {
        System.out.print("\nArray: ");
        for(int x: array){
            System.out.print(x + " ");
        }
    }
}
