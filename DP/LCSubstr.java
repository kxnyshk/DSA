import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class LCSubstr {
    
    static{
        System.out.println("\nTesting Longest Common Substring using Bottom Up... [DP]");
    }

    public static void main(String[] args) {
        
        // String S1 = "abcdgh";
        // String S2 = "abedfhr";
        String S1 = "geeksforgeeks";
        String S2 = "geeksquiz";

        int N = S1.length();
        int M = S2.length();

        int[][] T = new int[N+1][M+1];
        for(int i=0; i<N+1; i++){
            T[i][0] = 0;
        }
        for(int j=0; j<M+1; j++){
            T[0][j] = 0;
        }

        int L = Substring(S1, S2, N, M, T);
        System.out.println("\nLCSubstr length: " + L);
    }

    private static int Substring(String S1, String S2, int N, int M, int[][] T) {

        for(int i=1; i<N+1; i++){

            for(int j=1; j<M+1; j++){

                if(S1.charAt(i-1) == S2.charAt(j-1)){
                    T[i][j] = 1 + T[i-1][j-1];
                }

                else{
                    T[i][j] = 0;
                }
            }
        }

        IntSummaryStatistics stats = Arrays.stream(T).flatMapToInt(Arrays::stream).summaryStatistics();
        int MAX = stats.getMax();

        return MAX;
    }
}
