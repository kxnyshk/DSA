public class Palindrome {
    
    static{
    
        System.out.println("\nChecking if a string is Palindrome or not using Recursion..");
    }
    public static void main(String[] args){
    
        String str1 = "Malayalam";
        String str2 = "Induski";
        
        String string = str1; //str2;
        System.out.println("\nString: " + "'" + string + "'");

        int start = 0;
        int end = (string.length() - 1);

        if(CheckPalindrome(string.toLowerCase(), start, end)){
            System.out.println("\nYes! '" + string + "' is a Palindrome.");
        }
        else{
            System.out.println("\nNo! not a Palindrome.");
        }
    }

    private static boolean CheckPalindrome(String string, int start, int end) {

        if(start>=end){
            return true;
        }

        if(string.charAt(start) == string.charAt(end)){
            return CheckPalindrome(string, start+1, end-1);
        }
            
        return false;
    }
}
