import java.util.Random;

public class KnapsackBottomUp {

    static{
        System.out.println("\n0/1 Knapsack via Bottom-Up approach");
    }

    private static Random R = new Random();
    private static int N = R.nextInt(5) + 5;
    private static int MAX = 125;
    private static int[][] T = new int[N+1][MAX+1];

    public static void main(String[] args){
        for(int i=0; i<N+1; i++){
            T[i][0] = 0;
        }
        for(int j=0; j<MAX+1; j++){
            T[0][j] = 0;
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
        for(int i=1; i<N+1; i++){

            for(int j=1; j<MAX+1; j++){

                if(W[i-1] <= j){
                    T[i][j] = Math.max(V[i-1] + T[i-1][j-W[i-1]], T[i-1][j]);
                }

                else{
                    T[i][j] = T[i-1][j];
                }
            }
        }

        return T[N][MAX];
    }
}
