// import java.util.Random;
import java.util.stream.IntStream;

public class EqualSumPartition {

    static{
        System.out.println("\nTesting Equal Sum Partition problem [DP]..");
    }

    // private static Random R = new Random();
    private static int[] A = {1, 5, 11, 0, 7, 8};              // only +ve values [>= 0]
    private static int N = A.length;
    private static int Sum = IntStream.of(A).sum();
    private static int S = Sum/2;
    private static boolean[][] T = new boolean[N+1][S+1];

    public static void main(String[] args) {
        
        System.out.print("\nA[]: ");
        for(int x: A){
            System.out.print(x + " ");
        }
        System.out.println("\nSum: " + Sum);

        if(Sum%2 != 0){
            System.out.println("\nEqual sum partition: FALSE");
        }

        else{
            for(int j=0; j<S+1; j++){
                T[0][j] = false;
            }
            for(int i=1; i<N+1; i++){
                T[i][0] = true;
            }

            boolean Res = EqualSum(A, S);
            if(Res){
                System.out.println("\nEqual sum partition: TRUE [of " + S + "]");
            }
            else{
                System.out.println("\nEqual sum partition: FALSE");
            }
        }
    }

    private static boolean EqualSum(int[] A, int S) {
        
        return SubsetSum(A, N, S);
    }

    private static boolean SubsetSum(int[] A, int N, int SUM) {
        for(int i=1; i<N+1; i++){

            for(int j=1; j<SUM+1; j++){

                if(A[i-1] <= j){
                    T[i][j] = T[i-1][j - A[i - 1]] || T[i-1][j];
                }

                else{
                    T[i][j] = T[i-1][j];
                }

            }
        }

        return T[N][SUM];
    }
}