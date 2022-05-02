// import java.util.ArrayList;

public class LCSRecursion {
    
    static{
        System.out.println("\nTesting LCS using Recursion... [DP]");
    }

    // private static ArrayList<Character> LCS = new ArrayList<Character>();

    public static void main(String[] args) {
        
        String S1 = "abcdgh";
        String S2 = "abedfhr";

        int N = S1.length();
        int M = S2.length();

        int L = LCS(S1, S2, N, M);
        System.out.println("\nLCS length: " + L);
        // System.out.print("\nLCS: ");
        // for(Character X: LCS){
        //     System.out.println(X);
        // }
    }

    private static int LCS(String S1, String S2, int N, int M) {

        if(N == 0 || M == 0){
            return 0;
        }

        if(S1.charAt(N-1) == S2.charAt(M-1)){
            // LCS.add(S1.charAt(N-1));
            return 1 + LCS(S1, S2, N-1, M-1);
        }
        else{
            return Math.max(LCS(S1, S2, N, M-1), LCS(S1, S2, N-1, M));
        }
    }
}
