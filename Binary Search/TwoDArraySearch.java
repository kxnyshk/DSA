import java.util.Random;
import java.util.Scanner;

public class TwoDArraySearch {
    
    static{
    
        System.out.println("Searching for an element in a 2D array in Linear time. BS");
    }
    private static final int ROW = 4;
    private static final int COL = 4;
    public static void main(String[] args){
    
        int[][] array = {{10, 20, 30, 40},
                         {15, 25, 35, 45},
                         {27, 29, 37, 48},
                         {32, 33, 39, 50}};

        Random randNum = new Random();
        int x = array[randNum.nextInt(ROW)][randNum.nextInt(COL)];      // generates random value from the 2D array
        
        int[] IDX = new int[2];
        IDX = TwoDSearch(array, x);
        System.out.println("\n" + x + " : [" + IDX[0] + "][" + IDX[1] + "]");

        System.out.print("Press 1:Re-run | 0:Exit _");
        reRunExit();
    }
    private static int[] TwoDSearch(int[][] array, int x) {
        int i = 0;
        int j = COL-1;
        int[] idx = new int[2];
        int[] ERROR = {-1};
        
        while(i>=0 && i<ROW && j>=0 && j<COL){
            if(x == array[i][j]){
                idx[0] = i;
                idx[1] = j;
                return idx;
            }
            else if(x < array[i][j]){
                j--;
            }
            else{
                i++;
            }
        }
        return ERROR;
    }

    private static void reRunExit() {
        Scanner scan = new Scanner(System.in);
        int key = scan.nextInt();

        if(key == 1){
            main(null);
        }
        else if(key == 0){
            System.exit(0);
        }
        else{
            System.out.print("\nEnter only 1 or 0. _");
            reRunExit();
        }
        
        scan.close();
    }

}
