// import java.util.Scanner;

public class SeqPattern_ {
    
    static{
        System.out.println("\nTesting Sequence pattern matching... [DP]");
    }

    // private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        
        String S1 = "AXY";
        String S2 = "ADYCPX";

        int N = S1.length();
        int M = S2.length();

        int[][] T = new int[N+1][M+1];
        for(int i=0; i<N+1; i++){
            T[i][0] = 0;
        }
        for(int j=0; j<M+1; j++){
            T[0][j] = 0;
        }

        System.out.println("String 1: " + S1);
        System.out.println("String 2: " + S2);

        int LCS = LCS(S1, S2, N, M, T);
        boolean found = false;
        
        if(S1.length() == LCS){
            found = true;
        }
        System.out.println("Match found: " + found);
    }

    private static int LCS(String S1, String S2, int N, int M, int[][] T) {

        for(int i=1; i<N+1; i++){

            for(int j=1; j<M+1; j++){

                if(S1.charAt(i-1) == S2.charAt(j-1)){
                    T[i][j] = 1 + T[i-1][j-1];
                }

                else{
                    T[i][j] = Math.max(T[i][j-1], T[i-1][j]);
                }
            }
        }

        return T[N][M];
    }
}
