import java.util.Scanner;

public class AllOccurrences {

    static{
    
        System.out.println("\nAll occurences of an element in a sorted array by BS.");
    }
    private static int search;
    public static void main(String[] args){
    
        int[] array = {1,1,2,2,2,5,5,5,5};
        int n = array.length;

        printArray(array);
        Search();

        int first, last;
        first = firstOccurrence(array,n);
        last = lastOccurrence(array,n);

        printOccurrences(first, last);       
    }

    private static void printOccurrences(int first, int last) {
        System.out.print("\n" + search + " --> Index: ");
        while(first<=last){
            System.out.print(first + " ");
            first++;
        }
    }

    private static int lastOccurrence(int[] array, int n) {
        int start = 0;
        int end = n-1;
        int idx = -1;

        while(start<=end){
            int mid = (start+(end-start)/2);
            if(search == array[mid]){
                idx = mid;
                start = mid+1;
            }
            else if(search<array[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return idx;
    }

    private static int firstOccurrence(int[] array, int n) {
        int start = 0;
        int end = n-1;
        int idx = -1;

        while(start<=end){
            int mid = (start+(end-start)/2);
            if(search == array[mid]){
                idx = mid;
                end = mid-1;
            }
            else if(search<array[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return idx;
    }

    private static void Search() {
        System.out.print("\nEnter element: ");
        Scanner scan = new Scanner(System.in);
        search = scan.nextInt();
        scan.close();
    }

    private static void printArray(int[] array) {
        System.out.print("\nArray: ");
        for(int x: array){
            System.out.print(x + " ");
        }
    }
}