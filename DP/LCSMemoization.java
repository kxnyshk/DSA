import java.util.Arrays;

public class LCSMemoization {
    
    static{
        System.out.println("\nTesting LCS using Memoization (Top-Down)... [DP]");
    }

    public static void main(String[] args) {
        
        String S1 = "abcdgh";
        String S2 = "abedfhr";

        int N = S1.length();
        int M = S2.length();

        int[][] T = new int[N+1][M+1];
        for(int i=0; i<N+1; i++){
            Arrays.fill(T[i], -1);
        }

        int L = LCS(S1, S2, N, M, T);
        System.out.println("\nLCS length: " + L);
    }

    private static int LCS(String S1, String S2, int N, int M, int[][] T) {

        if((N == 0) || M == 0){
            return 0;
        }

        if(T[N][M] != -1){
            return T[N][M];
        }
        else if(S1.charAt(N-1) == S2.charAt(M-1)){
            return T[N][M] = 1 + LCS(S1, S2, N-1, M-1, T);
        }
        else{
            return T[N][M] = Math.max(LCS(S1, S2, N, M-1, T), LCS(S1, S2, N-1, M, T));
        }
    }
}
