public class TowerOfHanoi {

    static{
    
        System.out.println("Implementing Tower of Hanoi using Recursion..");
    }
    private static int count = 0;
    public static void main(String[] args){
    
        int n = 4;

        // Towers A(start) B(aux) C(end)
        char start = 'A';
        char aux = 'B';
        char end = 'C';

        Hanoi(n, start, end, aux);
        System.out.println("\nTransfer completed in " + count + " steps.");
    }

    private static void Hanoi(int n, char source, char dest, char help) {
        if(n == 1){
            System.out.println("\nDisc " + n + " moved from " + source + " to " + dest);
            count++;
            return;
        }

        int m = n-1;
        Hanoi(m, source, help, dest);

        System.out.println("\nDisc " + n + " moved from " + source + " to " + dest);
        count++;

        Hanoi(m, help, dest, source);
    }
}