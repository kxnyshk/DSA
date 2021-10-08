import java.util.Scanner;

public class BinarySearchReverseSorted {
    
    static{
    
        System.out.println("\nImplementing binary search on a reverse sorted array.");
    }
    private static int search;
    public static void main(String[] args){
    
        int[] array = {20,17,15,12,10,7,4,2,0};
        int n = array.length;

        printArray(array);
        Scanner scan = Search();

        int idx;
        idx = BinSearchReverse(array, n, search);
        System.out.println("Index: " + idx);

        scan.close();
    }

    private static int BinSearchReverse(int[] array, int n, int key) {
        int start = 0;
        int end = n-1;

        while(start<=end){
            int mid = (start + (end-start)/2);

            if(key == array[mid]){
                return mid;
            }
            else if(key<array[mid]){
                start = mid+1;
            }
            else if(key>array[mid]){
                end = mid-1;
            }
        }
        return -1;
    }

    private static Scanner Search() {
        System.out.print("\nElement to search: ");
        Scanner scan = new Scanner(System.in);
        search = scan.nextInt();
        return scan;
    }

    private static void printArray(int[] array) {
        System.out.print("\nArray: ");
        for(int x: array){
            System.out.print(x + " ");
        }
    }
}
