// import java.util.ArrayList;
// import java.util.Collections;

public class LongestRepeatingSubSeq {
    
    static{
        System.out.println("\nFinding out Longest repeating sub-sequence... [DP]\n");
    }

    public static void main(String[] args) {
        
        // String S1 = "aabebcdd";
        // String S1 = "axxxy";
        // String S1 = "abebacdd";
        // String S1 = "aabddb";
        // String S1 = "abcddcba";
        // String S1 = "abbacc";
        // String S1 = "aaabgbcdd";
        // String S1 = "aababcd";
        // String S1 = "axczoab";
        String S1 = "adzcb";
        String S2 = S1;

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

        int LCS = LCS(S1, S2, N, M, T);
        System.out.println("\nLongest Repeating Sub-seq length: " + LCS);

        // int X = N;
        // int Y = M;
        // ArrayList<Character> L = new ArrayList<Character>();
        // while(X>0 && Y>0){
        //     if(S1.charAt(X-1) == S2.charAt(Y-1)){
        //         L.add(S1.charAt(X-1));
        //         X--;
        //         Y--;
        //     }

        //     else if(T[X-1][Y] >= T[X][Y-1]){
        //         X--;
        //     }

        //     else{
        //         Y--;
        //     }
        // }

        // Collections.reverse(L);
        // System.out.print("Longest Repeating Sub-seq: ");
        // for(Character C: L){
        //     System.out.print(C + "");
        // }
    }

    private static int LCS(String S1, String S2, int N, int M, int[][] T) {

        for(int i=1; i<N+1; i++){

            for(int j=1; j<M+1; j++){

                if(S1.charAt(i-1) == S2.charAt(j-1) && i != j){
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
