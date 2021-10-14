public class PrintUptoN {

    static{
    
        System.out.println("\nPrinting numbers upto N using recursion..\n");
    }
    public static void main(String[] args){
    
        int N = 100;
        
        print(N);
    }

    private static void print(int N) {
        if(N == 1){
            System.out.print(N + "\n");
            return;
        }
        print(N-1);
        System.out.print(N + "\n");
    }
}