import java.util.Random;
import java.util.Scanner;

public class NextAlphabetElement {

    static{
    
        System.out.println("\nFinding next alphabetical element in sorted array, BS.");
    }
    private static final int MIN_ASCII = 97;    // ASCII a : 97
    private static final int MAX_ASCII = 122;   // ASCII z : 122
    public static void main(String[] args){
    
        char[] array = {'b','h','i','k','n','s'};
        int n = array.length;
        printArray(array);

        Random randomChar = new Random();
        Character x =  (char) (randomChar.nextInt(MAX_ASCII-MIN_ASCII) + MIN_ASCII);    // random char between a --> z

        char nextChar;
        nextChar = NextChar(array, n, x);
        System.out.println("\nNext char [" + x + "] : '" + nextChar + "'");

        reRunExit();
    }

    private static char NextChar(char[] array, int n, Character x) {
        int start = 0;
        int end = n-1;
        char nextChar = '#';
        
        while(start<=end){
            int mid = (start + (end-start)/2);

            if(x.equals(array[mid])){
                start = mid+1;
            }
            else if(Character.compare(x, array[mid])<0){
                nextChar = array[mid];
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return nextChar;
    }

    private static void reRunExit() {
        System.out.print("\nPress 1 : Re-run | 0 : Exit _");
        Scanner scan = new Scanner(System.in);
        int key = scan.nextInt();
        if(key == 1){
            main(null);
        }
        else if(key == 0){
            System.exit(0);
        }
        else{
            System.out.print("\nEnter only 1 or 0. ");
            reRunExit();
        }
        scan.close();
    }
    
    private static void printArray(char[] array) {
        System.out.print("\nArray: [ ");
        for(char x: array){
            System.out.print("'" + x + "'" + " ");
        }
        System.out.print("]");
    }
}