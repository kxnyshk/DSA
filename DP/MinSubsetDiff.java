import java.util.ArrayList;
import java.util.stream.IntStream;

public class MinSubsetDiff {
    
    static{
        System.out.println("\nTesting Minimun Subset Difference [DP]...");
    }

    private static int[] A = {1,5,6};
    private static int N = A.length;
    private static int S = IntStream.of(A).sum();
    private static ArrayList<Integer> L = new ArrayList<Integer>();

    public static void main(String[] args) {
        
        System.out.print("\nA[]: ");
        for(int x: A){
            System.out.print(x + " ");
        }

        int MIN = MSD();
        System.out.println("\nMinimum Difference: " + MIN);
    }

    private static int MSD() {

        L.add(S);
        for(int i=1; i<=S/2; i++){
            SubsetSum(i);
        }

        int MIN = Integer.MAX_VALUE;
        for(int i=0; i<L.size(); i++){
            if(L.get(i) < MIN){
                MIN = L.get(i);
            }
        }

        return MIN;
    }

    private static void SubsetSum(int Sum) {
        
        boolean[][] T = new boolean[N+1][Sum+1];
        for(int i=0; i<N+1; i++){
            T[i][0] = true;
        }
        for(int j=1; j<Sum+1; j++){
            T[0][j] = false;
        }

        for(int i=1; i<N+1; i++){

            for(int j=1; j<Sum+1; j++){

                if(A[i-1] <= j){
                    T[i][j] = T[i-1][j - A[i - 1]] || T[i-1][j];
                }

                else{
                    T[i][j] = T[i-1][j];
                }

            }
        }

        if(T[N][Sum]){
            L.add(S - (2*Sum));
        }
    }
}
