import java.util.Random;

public class KnapsackRecursive {
    static{
        System.out.println("\n0/1 Knapsack via Recursion");
    }
    public static void main(String[] args){
    
        Random R = new Random();
        int N = R.nextInt(5) + 5;

        int[] V = new int[N];
        int[] W = new int[N];

        for(int i=0; i<N; i++){
            int Val = R.nextInt(150) + 50;
            int Weight = R.nextInt(40) + 10;
            V[i] = Val;
            W[i] = Weight;
        }

        int MAX = 75;

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
        
        if(W[N-1] <= MAX){
            return Math.max(V[N-1] + Knapsack(V, W, N-1, MAX-W[N-1]), Knapsack(V, W, N-1, MAX));
        }
        else{
            return Knapsack(V, W, N-1, MAX);
        }
    }
}
