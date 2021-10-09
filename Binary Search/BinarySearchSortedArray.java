import java.util.Scanner;

public class BinarySearchSortedArray {
    
    static{
    
        System.out.println("\nBinary Search [Sorted array]");
    }
    private static int x;
    public static void main(String[] args){
    
        int[] array = {1,5,13,20,33,40,44,53,61,77,87};
        int n = array.length;
        
        printArray(array);

        int idx;
        idx = binarySearch(array, n);
        System.out.println("\nIndex: " + idx);
    }

    private static Scanner Search() {
        System.out.print("Enter input: ");
        Scanner scan = new Scanner(System.in);
        x = scan.nextInt();
        return scan;
    }

    private static void printArray(int[] array) {
        System.out.print("\nArray: ");
        for(int x: array){
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static int binarySearch(int[] array, int n) {
        int start = 0;
        int end = n-1;
        if(n == 1){
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
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
        }
        return -1;
    }
}
