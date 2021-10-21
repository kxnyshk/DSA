public class StringSubsets {
    
    static{
    
        System.out.println("\nPrinting the subsets of a string using Recursion..");
    }
    public static void main(String[] args){
    
        String str = "Anna";
        String temp = "";
        int i = 0;

        System.out.println("\nString: '" + str + "'");
        Subsets(str, temp, i);
    }

    private static void Subsets(String str, String temp, int i) {
        
        if(i == str.length()){
            System.out.print("\n" + temp);
            return;
        }
        
        Subsets(str, (temp + str.charAt(i)), (i + 1));
        Subsets(str, temp, (i + 1));
    }
}
