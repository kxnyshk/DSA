import java.util.stream.IntStream;

public class CountSubsetDiff {
    
    static{
        System.out.println("\nCounting the no. of Subsets with the given difference... [DP]");
    }

    private static int[] A = {1,1,2,3};
    private static int N = A.length;
    private static int D = 1;
    private static int Sum = (D + IntStream.of(A).sum())/2;
    private static int[][] T = new int[N+1][Sum+1];

    public static void main(String[] args) {
        
        if(Sum%2 != 0){
            System.out.println(0);
            return;
        }
        
        for(int i=0; i<N+1; i++){
            T[i][0] = 1;
        }
        for(int j=1; j<Sum+1; j++){
            T[0][j] = 0;
        }

        System.out.print("\nA[]: ");
        for(int x: A){
            System.out.print(x + " ");
        }
        System.out.println("\nDifference: " + D);

        int C = Count();
        System.out.println("\nSubsets possible: " + C);
    }

    private static int Count() {

        for(int i=1; i<N+1; i++){

            for(int j=1; j<Sum+1; j++){

                if(A[i-1] <= j){
                    T[i][j] = T[i-1][j - A[i - 1]] + T[i-1][j];
                }

                else{
                    T[i][j] = T[i-1][j];
                }

            }
        }

        return T[N][Sum];
    }
    
}
