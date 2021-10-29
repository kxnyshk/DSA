public class KnapsackProblem {

    static{
    
        System.out.println("\nSolving a 0-1 Knapsack Problem [Memoization].\n[Problem statement link: https://bit.ly/0-1KnapsackMemoizaion]");
    }
    public static void main(String[] args){
    
        int[] V = {60, 100, 120};                       // Value
        int[] W = {10, 20, 30};                         // Weight

        int n = V.length;
        int Weight = 50;                                // Max Weight of Knapsack

        int[][] table = new int[n+1][Weight+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<Weight+1; j++){
                table[i][j] = -1;                       // Initializing -1 in all entries of the memoized table
            }
        }

        printValue(V, n);
        printWeight(W, n);
        System.out.println("\nKnapsack W[max]: " + Weight);

        int max;
        max = KnapSack(V, W, n, Weight, table);
        System.out.println("\nMax profit: " + max);
    }

    private static int KnapSack(int[] v, int[] w, int n, int weight, int[][] table) {

        if(n == 0 || weight == 0){
            return 0;
        }

        if(table[n][weight] != -1){
            return table[n][weight];
        }

        if(w[n-1]<=weight){
            return table[n][weight] = Math.max((v[n-1] + KnapSack(v, w, n-1, weight-w[n-1], table)), KnapSack(v, w, n-1, weight, table));
        }

        else if(w[n-1]>weight){
            return table[n][weight] = KnapSack(v, w, n-1, weight, table);
        }

        return -1;
    }

    private static void printWeight(int[] W, int n) {
        System.out.print("\nWeight: [ ");
        int i=0;
        while(i<n){
            System.out.print(W[i++] + " ");
        }
        System.out.print("]");
    }

    private static void printValue(int[] V, int n) {
        System.out.print("\nValue: [ ");
        int i=0;
        while(i<n){
            System.out.print(V[i++] + " ");
        }
        System.out.print("]");
    }
}