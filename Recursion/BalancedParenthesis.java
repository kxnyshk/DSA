import java.util.ArrayList;

public class BalancedParenthesis{
    
    static{
    
        System.out.println("\nGenerating Balanced Parenthesis..");
    }
    private static ArrayList<String> list = new ArrayList<String>();
    public static void main(String[] args){
    
        int n = 3;
        int open = 1;
        int close = 0;

        String temp = "(";

        balancedParenthesis(temp, open, close, n);
        print(list);
    }

    private static void balancedParenthesis(String temp, int open, int close, int n) {

        if(temp.length() == (n*2)){
            list.add(temp);
            return;
        }
        
        if(open<n){
            balancedParenthesis(temp+"(", open+1, close, n);
        }

        if(close<open){
            balancedParenthesis(temp+")", open, close+1, n);
        }
    }

    private static void print(ArrayList<String> list) {
        for(String x: list){
            System.out.print("\n" + x);
        }
    }
}
