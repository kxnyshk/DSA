import java.util.Arrays;
import java.util.Collections;

public class AllocateMinPages {
    
    static{
    
        System.out.println("\nAllocating minimum number of pages to students in a library system.");
    }
    public static void main(String[] args){
    
        Integer[] array = {12, 34, 67, 90};
        int n = array.length;
        printArray(array);

        int max = Collections.max(Arrays.asList(array));
        int sum;
        sum = sumArray(array, n);

        int key = 2;

        int minPages;
        minPages = AllocatePages(array, n, max, sum, key);
        System.out.println("\nStudents.. " + key + "\nMin pages allocated [S1].. " + minPages);
        System.out.println();
    }

    private static void printArray(Integer[] array) {
        System.out.print("\nArray: ");
        for(int x: array){
            System.out.print(x + " ");
        }
        System.out.println();
    }

    private static boolean isValid(Integer[] array, int n, int mid, int key){
        int students = 1;
        int pages = 0;

        for(int i=0; i<n; i++){
            if(pages + array[i] > mid){
                students++;
                pages = array[i];
            }
            else{
                pages = pages + array[i];
            }
        }
        return students<=key;
    }

    private static int AllocatePages(Integer[] array, int n, int max, int sum, int key) {
        int start = max;
        int end = sum;
        int minPages = -1;

        if(key>n){
            return -1;
        }
        while(start<=end){
            int mid = (start + (end-start)/2);

            if(isValid(array, n, mid, key)){
                minPages = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return minPages;
    }

    private static int sumArray(Integer[] array, int n) {
        int sum = 0;
        for(int i=0; i<n; i++){
            sum = sum + array[i];
        }
        return sum;
    }
}
