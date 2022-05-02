import java.util.Arrays;

public class MCM_Memoization {
    
    static{
        System.out.println("\nTesting MCM via Memoization (Top-Down)...");
    }

    private static final int MAX_LIMIT = 1001;
    private static int[][] T = new int[MAX_LIMIT][MAX_LIMIT];

    public static void main(String[] args) {
        
        for(int i=0; i<MAX_LIMIT; i++){
            Arrays.fill(T[i], -1);
        }

        int[] A ={3,7,2,9};
        int N = A.length;

        int MIN = MCM(A, 1, N-1);
        System.out.println("\nMin steps for Matrix multiplication: " + MIN);
    }

    private static int MCM(int[] A, int i, int j){

        if(i >= j){
            return 0;
        }

        if(T[i][j] != -1){
            return T[i][j];
        }

        int MIN = Integer.MAX_VALUE;

        for(int k=i; k<j; k++){

            int TEMP = MCM(A, i, k) + MCM(A, k+1, j) + A[i-1]*A[k]*A[j];

            if(TEMP < MIN){
                MIN = TEMP;
            }
        }

        return T[i][j] = MIN;
    }
}
