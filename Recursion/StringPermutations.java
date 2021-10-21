public class StringPermutations {
    
    static{
    
        System.out.println("\nPrinting all the possible permutations of a string using Recursion..");
    }
    public static void main(String[] args){
    
        String str = "mia";
        String temp = "";

        System.out.println("\nString: " + str);
        Permutations(str, temp);
    }

    private static void Permutations(String str, String temp) {

        if(str.length() == 0){
            System.out.print("\n" + temp);
            return;
        }
        
        for(int i=0; i<str.length(); i++){
            
            char ch = str.charAt(i);
            String left = str.substring(0, i);
            String right = str.substring(i+1);

            String join = left + right;
            Permutations(join, temp+ch);
        }
    }
}
