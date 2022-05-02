public class MCMRecursive {
    
    static{
        System.out.println("\nTesting MCM via Recursion...");
    }

    public static void main(String[] args) {
        
        int[] A = {40, 20, 30, 10, 30};
        int N = A.length;

        int MIN = MCM(A, 1, N-1);
        System.out.println("\nMin steps for Matrix multiplication: " + MIN);
    }

    private static int MCM(int[] A, int i, int j){

        if(i >= j){
            return 0;
        }

        int MIN = Integer.MAX_VALUE;

        for(int k=i; k<j; k++){

            int TEMP = MCM(A, i, k) + MCM(A, k+1, j) + A[i-1]*A[k]*A[j];

            if(TEMP < MIN){
                MIN = TEMP;
            }
        }

        return MIN;
    }
}
