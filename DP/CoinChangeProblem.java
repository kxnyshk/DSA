public class CoinChangeProblem {
     
    static{
        System.out.println("\nTesting the Coin change problem... [DP]");
    }

    private static int[] Coins = {1,2,3};
    private static int A = 4;                       // amount
    private static int N = Coins.length;
    private static int[][] T = new int[N+1][A+1];

    public static void main(String[] args) {
        
        for(int i=0; i<N+1; i++){
            T[i][0] = 1;
        }
        for(int j=0; j<A+1; j++){
            T[0][j] = 0;
        }

        System.out.print("\nCoins[]: ");
        for(int x: Coins){
            System.out.print(x + " ");
        }
        System.out.println("\nAmount: " + A);

        System.out.println("\nNo. of ways: " + Knapsack(Coins, N, A));
    }

    private static int Knapsack(int[] C, int N, int A) {
        
        for(int i=1; i<N+1; i++){
      
            for(int j=1; j<A+1; j++){
              
              if(C[i-1] <= j){
                T[i][j] = T[i][j - C[i-1]] + T[i-1][j];
              }
              else{
                T[i][j] = T[i-1][j];
              }
            }
          }
          
          return T[N][A];
    }
}
