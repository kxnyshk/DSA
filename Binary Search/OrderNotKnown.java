import java.util.Scanner;

public class OrderNotKnown {
    
    static{
    
        System.out.println("\nImplementing binary search for an unknown sort.");
    }
    public static void main(String[] args){
    
        int[] array1 = {1};
        int n1 = array1.length;

        int[] array2 = {1,1,1};
        int n2 = array2.length;
        
        int[] array3 = {1,2,5,7};
        int n3 = array3.length;

        int[] array4 = {8,4,3,0};
        int n4 = array4.length;

        printArray(array1);
        System.out.println("\n" + binSearch(array1, n1));
        printArray(array2);
        System.out.println("\n" + binSearch(array2, n2));
        printArray(array3);
        System.out.println("\n" + binSearch(array3, n3));
        printArray(array4);
        System.out.println("\n" + binSearch(array4, n4));
        
        // return 0 --> single indices array
        // return -1 --> value not found
        // return -2 --> array with all duplicates values
        // return -3 --> invalid binSearch()
    }

    private static void printArray(int[] array) {
        System.out.print("\nArray: ");
        for(int x: array){
            System.out.print(x + " ");
        }
    }

    private static int binSearch(int[] array, int n){
        if(n == 1){
            return 0;
        }

        else if(n>1){
            if(array[0]<array[n-1]){
                System.out.print("\nElement to search: ");
                Scanner scan = new Scanner(System.in);
                int value = scan.nextInt();

                int start = 0;
                int end = n-1;
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
                return -1;
            }

            else if(array[0]>array[n-1]){
                System.out.print("\nElement to search: ");
                Scanner scan = new Scanner(System.in);
                int value = scan.nextInt();

                int start = 0;
                int end = n-1;
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
                return -1;
            }

            else if(array[0] == array[n-1]){
                return -2;
            }
        }
        return -3;
    }
}
