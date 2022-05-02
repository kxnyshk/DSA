public class UnboundedKnapsack {
    
    static{
        System.out.println("\nTesting an Unbounded Knapsack problem... [DP]");
    }

    private static int[] W = {1,3,4,5};
    private static int[] V = {1,4,5,7};
    private static int N = V.length;
    private static int MAX = 8; 
    private static int[][] T = new int[N+1][MAX+1];

    public static void main(String[] args) {
        
        for(int i=0; i<N+1; i++){
            T[i][0] = 0;
        }
        for(int j=0; j<MAX+1; j++){
            T[0][j] = 0;
        }
        
        System.out.println(Knapsack(V, W, N, MAX));
    }

    private static int Knapsack(int[] V, int[] W, int N, int MAX) {
        
        for(int i=1; i<N+1; i++){
      
            for(int j=1; j<MAX+1; j++){
              
              if(W[i-1] <= j){
                T[i][j] = Math.max((V[i-1] + T[i][j - W[i-1]]), (T[i-1][j]));
              }
              else{
                T[i][j] = T[i-1][j];
              }
            }
          }
          
          return T[N][MAX];
    }
}
