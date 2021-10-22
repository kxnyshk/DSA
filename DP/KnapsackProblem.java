public class KnapsackProblem {

    static{
    
        System.out.println("\nSolving a 0-1 Knapsack Problem.\n[Problem statement link: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/]");
    }
    public static void main(String[] args){
    
        int[] V = {60, 100, 120};            // Value
        int[] W = {10, 20, 30};              // Weight

        int n = V.length;
        int Weight = 50;                    // Max Weight of Knapsack

        printValue(V, n);
        printWeight(W, n);
        System.out.println("\nKnapsack W[max]: " + Weight);

        int max;
        max = KnapSack(V, W, n, Weight);
        System.out.println("\nMax profit: " + max);
    }

    private static int KnapSack(int[] v, int[] w, int n, int weight) {

        if(n == 0 || weight == 0){
            return 0;
        }

        if(w[n-1]<=weight){
            return Math.max((v[n-1] + KnapSack(v, w, n-1, weight-w[n-1])), KnapSack(v, w, n-1, weight));
        }

        else if(w[n-1]>weight){
            return KnapSack(v, w, n-1, weight);
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