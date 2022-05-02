public class PalindromePartitionRecursive {
    
    static{
        System.out.println("\nTesting Palindrome partitioning by Recursion using MCM...\n");
    }

    public static void main(String[] args) {
        
        // String S = "NITIN";
        String S = "NITIK";
        // String S = "ababbbabbababa";
        int N = S.length();

        int MIN = PalindromePartition(S, 0, N-1);
        System.out.println("Min. palindrome partitions: " + MIN);
    }

    private static int PalindromePartition(String S, int i, int j){

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

        return MIN;
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
