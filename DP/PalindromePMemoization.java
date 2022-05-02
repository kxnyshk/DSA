import java.util.Arrays;

public class PalindromePMemoization {

    static{
        System.out.println("\nTesting Palindrome partitioning via Memoization (Top-Down) using MCM...\n");
    }

    private static final int MAX_LIMIT = 501;
    private static int[][] T = new int[MAX_LIMIT][MAX_LIMIT];

    public static void main(String[] args) {
        
        for(int i=0; i<MAX_LIMIT; i++){
            Arrays.fill(T[i], -1);
        }

        // String S = "NITIN";
        String S = "NITIK";
        // String S = "ababbbabbababa";
        int N = S.length();

        int MIN = PalindromePartition(S, 0, N-1);
        System.out.println("Min. palindrome partitions: " + MIN);
    }

    private static int PalindromePartition(String S, int i, int j){

        if(T[i][j] != -1){
            return T[i][j];
        }
        if(i >= j || isPalindrome(S, i, j)){
            return 0;
        }

        int MIN = Integer.MAX_VALUE;

        for(int k=i; k<j; k++){

            int TEMP = 1 + PalindromePartition(S, i, k) + PalindromePartition(S, k+1, j);

            if(TEMP < MIN){
                MIN = TEMP;
            }
        }

        return T[i][j] = MIN;
    }

    private static boolean isPalindrome(String S, int i, int j) {
        
        while(i < j){
            if(S.charAt(i) != S.charAt(j)){
                return false; 
            }   
            i++;
            j--;
        }
        return true;
    }
}