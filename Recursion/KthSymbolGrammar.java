public class KthSymbolGrammar {
    
    static{
    
        System.out.println("\nFinding 'K'th symbol in grammar..");
    }
    public static void main(String[] args){
    
        int[][] array = {{0},
                         {0,1},
                         {0,1,1,0},
                         {0,1,1,0,1,0,0,1}};                         // Grammar Table

        int n,k;
        n = 4;
        k = 4;
        System.out.println("\nSymbol at (" + n + "," + k + "):");

        int symbol;
        symbol = Solve(array, n, k);
        System.out.print("\n(" + n + "," + k + ") --> " + symbol);
    }

    private static int Solve(int[][] array, int n, int k) {
        if(n == 1 && k == 1){                                       // base condition
            System.out.println("\nSolving..");
            return 0;
        }

        int length, mid;
        length = (int) Math.pow(2, n-1);
        mid = length/2;                                             // length & mid of the row

        int symbol = -1;
        if(k<=mid){
            symbol = Solve(array, n-1, k);                          // symbol same as above row
        }
        else if(k>mid){
            symbol = 1-(Solve(array, n-1, k-mid));                  // symbol complement of above row, col-mid
        }

        return symbol;
    }
}
