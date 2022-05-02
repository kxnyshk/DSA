public class CountSubsets {
    
    static{
        System.out.println("\nTesting Count of Subsets for a given Sum [DP]...");
    }

    // private static int[] A = {2,3,5,6,8,10};
    private static int[] A = {1,2,3,4,2,1};
    private static int N = A.length;
    // private static int S = 10;
    private static int S = 4;
    private static int[][] T = new int[N+1][S+1];

    public static void main(String[] args) {

        for(int i=0; i<N+1; i++){
            T[i][0] = 1;
        }
        for(int j=1; j<S+1; j++){
            T[0][j] = 0;
        }

        System.out.print("\nA[]: ");
        for(int x: A){
            System.out.print(x + " ");
        }
        System.out.println("\nSum: " + S);

        int C = Count();
        System.out.println("\nSubsets possible: " + C);
    }

    private static int Count() {

        for(int i=1; i<N+1; i++){

            for(int j=1; j<S+1; j++){

                if(A[i-1] <= j){
                    T[i][j] = T[i-1][j - A[i - 1]] + T[i-1][j];
                }

                else{
                    T[i][j] = T[i-1][j];
                }

            }
        }

        return T[N][S];
    }
}
