import java.util.Scanner;

public class OrderNotKnown {
    
    static{
    
        System.out.println("\nBinary search [Sort order unknown]");
    }
    private static int value;
    public static void main(String[] args){
    
        int[] array1 = {1,12,34,56,80};
        int n1 = array1.length;

        printArray(array1);
        System.out.print("\nIndex: " + binSearch(array1, n1));
    }

    private static void printArray(int[] array) {
        System.out.print("\nArray: ");
        for(int x: array){
            System.out.print(x + " ");
        }
    }

    private static int binSearch(int[] array, int n){
        int start = 0;
        int end = n-1;
        
        if(n == 1){
            return start;
        }

        else if(array[start] == array[end]){
            System.out.print("\nDuplicate values detected!\nIndex: " + start + " --> (to)");
            return end;
        }

        else{
            Scan();
            
            if(array[start]<array[end]){
                while(start<=end){   
                    int mid = (start+(end-start)/2);
                    if(value == array[mid]){
                        return mid;
                    }
                    else if(value<array[mid]){
                        end = mid-1;
                    }
                    else{
                        start = mid+1;
                    }
                }
            }

            else if(array[start]>array[end]){
                while(start<=end){   
                    int mid = (start+(end-start)/2);
                    if(value == array[mid]){
                        return mid;
                    }
                    else if(value<array[mid]){
                        start = mid+1;
                    }
                    else{
                        end = mid-1;
                    }
                }
            }
        }
        return -1;
    }

    private static void Scan() {
        System.out.print("\nsearch: ");
        Scanner scan = new Scanner(System.in);
        value = scan.nextInt();
        scan.close();
    }
}
