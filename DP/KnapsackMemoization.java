import java.util.Arrays;
import java.util.Random;

public class KnapsackMemoization {

    static{
        System.out.println("\n0/1 Knapsack via Memoization (Top Down)");
    }

    private static Random R = new Random();
    private static int N = R.nextInt(5) + 5;
    private static int MAX = 100;
    private static int[][] T = new int[N+1][MAX+1];

    public static void main(String[] args){
        for(int i=0; i<N+1; i++){
            Arrays.fill(T[i], -1);
        }

        int[] V = new int[N];
        int[] W = new int[N];

        for(int i=0; i<N; i++){
            int Val = R.nextInt(150) + 50;
            int Weight = R.nextInt(40) + 10;
            V[i] = Val;
            W[i] = Weight;
        }

        System.out.print("\nVal[] : { ");
        for(int x: V){
            System.out.print(x + " ");
        }
        System.out.println("}");

        System.out.print("\nWeight[] : { ");
        for(int x: W){
            System.out.print(x + " ");
        }
        System.out.println("}");

        System.out.println("\nMax Weight: " + MAX);

        System.out.println("\nMax Profit: " + Knapsack(V, W, N, MAX));
    }

    private static int Knapsack(int[] V, int[] W, int N, int MAX) {
        if((N == 0) || (MAX == 0)){
            return 0;
        }
        
        if(T[N][MAX] != -1){
            return T[N][MAX];
        }
        
        if(W[N-1] <= MAX){
            return T[N][MAX] = Math.max(V[N-1] + Knapsack(V, W, N-1, MAX-W[N-1]), Knapsack(V, W, N-1, MAX));
        }
        else{
            return T[N][MAX] = Knapsack(V, W, N-1, MAX);
        }
    }
}
