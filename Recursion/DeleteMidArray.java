import java.util.Random;

public class DeleteMidArray {
    
    static{
    
        System.out.println("\nDeleting Mid of array using Recursion..");
    }
    private static final int SIZE_MAX = 10;
    private static final int VAL_MAX = 100;
    private static Random randNum = new Random();
    public static void main(String[] args){
    
        int n = (randNum.nextInt(SIZE_MAX)+1);
        int[] array = new int[n];

        createArray(array, n);
        print(array, n);

        DeleteMid(array, n);
        print(array, n-1);

        // MID ELEMENT IS DEFINED AS: "1 2 3(mid) 4 5" in ODD | "1 2 3(mid) 4" in EVEN
        // SINCE ARRAYS ARE STATIC, ONE CAN'T DELETE ELEMENTS FROM THEM. IF YOU WANNA DO THAT ONE CAN USE ARRAYLISTS
        // HERE WE ARE JUST TAKING THE MID ELEMENT TO THE END AND PRINTING (N-1) ELEMENTS
    }

    private static void DelMid(int[] array, int n, int k) {
        if(k == n-1){                                           // when mid reaches end
            return;
        }

        Swap(array, k);

        DelMid(array, n, k+1);
    }

    private static void Swap(int[] array, int k) {              // swapping with next value until mid reaches end
        int temp;
        temp = array[k];
        array[k] = array[k+1];
        array[k+1] = temp;
    }

    private static void DeleteMid(int[] array, int n) {
        if(n == 1){
            System.out.println("No Mid element found..");       // array with only 1 element. NO MID FOUND!!!
            return;
        }

        int k;
        k = MidElement(n);

        DelMid(array, n, k);
        System.out.println("\nMid deleted..");
    }

    private static int MidElement(int n) {
        int k;
        k = n/2;
        return k;
    }

    private static void createArray(int[] array, int n) {
        for(int i=0; i<n; i++){
            int val = randNum.nextInt(VAL_MAX);
            array[i] = val;
        }
    }

    private static void print(int[] array, int n) {
        System.out.print("\nArray: ");
        for(int i=0; i<n; i++){
            System.out.print(array[i] + " ");
        }
    }
}
