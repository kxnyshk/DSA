// import java.util.Random;

public class SubsetSum {

    static{
    
        System.out.println("\nSubset Sum Problem (Knapsack)");
    }

    // private static Random R = new Random();
    private static int N = 5;
    private static int SUM = 32;
    private static boolean[][] T = new boolean[N+1][SUM+1];

    public static void main(String[] args){

        for(int i=0; i<N+1; i++){
            T[i][0] = true;
        }
        for(int j=1; j<SUM+1; j++){
            T[0][j] = false;
        }

        int[] A = {2, 3, 7, 8, 10};
        System.out.print("\nA[]: ");
        for(int x: A){
            System.out.print(x + " ");
        }
        System.out.println("\nSum: " + SUM);

        System.out.print("\nSubset Sum possible: ");
        if(Knapsack(A, N, SUM)){
            System.out.println("TRUE");
        }
        else{
            System.out.println("FALSE");
        }
    }

    private static boolean Knapsack(int[] A, int N, int SUM) {
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
