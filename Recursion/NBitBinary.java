import java.util.ArrayList;

public class NBitBinary {
    
    static{
    
        System.out.println("\nPrinting N-bit binary numbers having more 1s than 0s for any prefix");
    }
    private static ArrayList<String> list = new ArrayList<String>();
    public static void main(String[] args){
    
        int n = 4;
        int one = 1;
        int zero = 0;

        String temp = "1";

        nBitBin(temp, one, zero, n);
        print(list, n);
    }

    private static void nBitBin(String temp, int one, int zero, int n) {
        if(one + zero == n){
            list.add(temp);
            return;
        }

        if(one<n){
            nBitBin(temp+"1", one+1, zero, n);
        }

        if(zero<one){
            nBitBin(temp+"0", one, zero+1, n);
        }
    }

    private static void print(ArrayList<String> list, int n) {
        System.out.println("\n" + "n: " + n);
        for(String x: list){
            System.out.print("\n" + x);
        }
    }
}
