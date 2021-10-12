import java.util.Random;
import java.util.Scanner;

public class PrevCharElement {

    static{
    
        System.out.println("\nFinding previous char element in a sorted array, BS.");
    }
    private static final int MIN_ASCII = 97;    // ASCII a : 97
    private static final int MAX_ASCII = 122;   // ASCII z : 122
    public static void main(String[] args){
    
        char[] array = {'a','b','d','h','i','r','u'};
        int n = array.length;
        printArray(array);

        Random random = new Random();
        Character randChar = (char) (random.nextInt(MAX_ASCII-MIN_ASCII) + MIN_ASCII);  // random char between a --> z

        char prevChar;
        prevChar = PrevChar(array, n, randChar);
        System.out.println("\nPrev char [" + randChar + "] : " + prevChar);

        reRunExit();
    }
    
    private static char PrevChar(char[] array, int n, Character randChar) {
        int start = 0;
        int end = n-1;
        char prevChar = '#';

        while(start<=end){
            int mid = (start + (end-start)/2);

            if(randChar.equals(array[mid])){
                end = mid-1;
            }
            else if(Character.compare(randChar, array[mid])>0){
                prevChar = array[mid];
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return prevChar;
    }

    private static void printArray(char[] array) {
        System.out.print("\nArray: [ ");
        for(Character x: array){
            System.out.print("'" + x + "'" + " ");
        }
        System.out.print("]");
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
}