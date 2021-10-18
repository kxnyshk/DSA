import java.util.Random;

public class ReverseArrayRecursion {
    
    static{
    
        System.out.println("\nReversing an Array using Recursion..");
    }
    private static final int MAX_LIMIT = 10;
    private static final int MAX_VAL = 100;
    private static Random randNum = new Random();
    public static void main(String[] args){
    
        int n = (randNum.nextInt(MAX_LIMIT)+1);
        int[] array = new int[n];

        CreateArray(array, n);
        print(array);

        int start = 0;                                                      // initializing start at Array IDX 0
        int end = n-1;                                                      // initializing end at Array IDX (n-1)

        Reverse(array, n, start, end);
        print(array);
    }

    private static void Reverse(int[] array, int n, int start, int end) {
        if(start>=end){
            System.out.println("\nArray reversal successful..");            // Recursion stops when pointers either reaches the mid element
            return;                                                         // (Case: n = ODD) or while crossing each other (Case: n = EVEN)
        }

        Swap(array, start, end);

        start++;                                                            // bringing pointers close and swapping each other recursively
        end--;                                                              // until return statement hits

        Reverse(array, n, start, end);
    }

    private static void Swap(int[] array, int start, int end) {
        int temp;
        temp = array[end];
        array[end] = array[start];
        array[start] = temp;
    }

    private static void CreateArray(int[] array, int n) {
        for(int i=0; i<n; i++){
            int x = randNum.nextInt(MAX_VAL);
            array[i] = x;
        }
    }

    private static void print(int[] array) {
        System.out.print("\nArray: ");
        for(int x: array){
            System.out.print(x+ " ");
        }
    }
}
