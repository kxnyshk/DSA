public class RodCuttingProblem {
    
    static{
        System.out.println("\nTesting the Rod cutting problem... [DP]");
    }

    private static int[] Length = {1,2,3,4,5,6,7,8};
    private static int[] Price = {1,5,8,9,10,17,17,20};
    private static int Rod = 8;
    private static int N = Length.length;
    private static int[][] T = new int[N+1][Rod+1];

    public static void main(String[] args) {
     
        for(int i=0; i<N+1; i++){
            T[i][0] = 0;
        }
        for(int j=0; j<Rod+1; j++){
            T[0][j] = 0;
        }

        System.out.print("\nLength []: ");
        for(int x: Length){
            System.out.print(x + " ");
        }
        System.out.print("\nPrice []: ");
        for(int x: Price){
            System.out.print(x + " ");
        }
        System.out.println("\nRod length: " + Rod);

        System.out.println("\nMax profit: " + Knapsack(Length, Price, Rod));
    }

    private static int Knapsack(int[] L, int[] P, int R) {
        
        for(int i=1; i<N+1; i++){

            for(int j=1; j<Rod+1; j++){

                if(L[i-1] <= j){
                    T[i][j] = Math.max(P[i-1] + T[i][j - L[i-1]], T[i-1][j]);
                }
                else{
                    T[i][j] = T[i-1][j];
                }
            }
        }

        return T[N][R];
    }
}
