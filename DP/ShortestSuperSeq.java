import java.util.ArrayList;
import java.util.Collections;

public class ShortestSuperSeq {
    
    static{
        System.out.println("\nTesting out Shortest Super Sequence... [DP]\n");
    }

    public static void main(String[] args) {
        
        String S1 = "AGGTBA";
        String S2 = "GXTXAYB";

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
        int SSS = N + M - LCS;
        System.out.println("\nShortest Super Seq. length: " + SSS);

        int X = N;
        int Y = M;
        ArrayList<Character> L = new ArrayList<Character>();
        while(X>0 && Y>0){
            if(S1.charAt(X-1) == S2.charAt(Y-1)){
                L.add(S1.charAt(X-1));
                X--;
                Y--;
            }

            else if(T[X-1][Y] >= T[X][Y-1]){
                L.add(S1.charAt(X-1));
                X--;
            }

            else{
                L.add(S2.charAt(Y-1));
                Y--;
            }
        }
        while(X>0){
            L.add(S1.charAt(X-1));
            X--;
        }
        while(Y>0){
            L.add(S2.charAt(Y-1));
            Y--;
        }

        Collections.reverse(L);
        System.out.print("Shortest Super Seq: ");
        for(Character C: L){
            System.out.print(C + "");
        }
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
