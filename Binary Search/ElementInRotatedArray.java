import java.util.Scanner;

public class ElementInRotatedArray {
    
    static{
    
        System.out.println("\nSearching element in a rotated sorted array\n(Left --> Right)");
    }
    public static void main(String[] args){
    
        int[] array = {23,34,47,56,87,2,7,10,12,17,20};
        int n = array.length;

        printArray(array);

        System.out.print("\nelement: ");
        Scanner scan = new Scanner(System.in);
        int search = scan.nextInt();

        int minIdx;
        minIdx = rotations(array, n);

        int index;
        index = BSrotated(array, n, minIdx, search);
        System.out.println("\nIndex: " + index);

        scan.close();
    }

    private static int BSrotated(int[] array, int n, int minIdx, int search) {
        int start = 0;
        int end = n-1;

        if(search == array[minIdx]){
            return minIdx;
        }
        else if(search == array[start]){
            return start;
        }
        else if(search == array[end]){
            return end;
        }
        else if(search>=array[start+1] && search<=array[minIdx-1]){
            return BinarySearch(array, start+1, minIdx-1, search);
        }
        else if(search<=array[end-1] && search>=array[minIdx+1]){
            return BinarySearch(array, minIdx+1, end-1, search);
        }
        return -1;
    }

    private static int BinarySearch(int[] array, int startIdx, int endIdx, int search) {
        int start = startIdx;
        int end = endIdx;

        while(start<=end){
            int mid = (start + (end-start)/2);
            
            if(array[mid] == search){
                return mid;
            }
            else if(search<array[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }

    private static int rotations(int[] array, int n) {
        int start = 0;
        int end = n-1;
        
        if(n == 1 || array[start]<=array[end]){
            return start;
        }
        
        else if(n==2){
            return array[start]<array[end] ? start : end;
        }

        else{
            while(start<=end){
                int mid = (start + (end-start)/2);
                int prev = ((mid + (n-1))%n);
                int next = ((mid+1)%n);

                if(array[mid]<array[prev] && array[mid]<array[next]){
                    return mid;
                }
                else if(array[mid]>=array[0]){
                    start = mid+1;
                }
                else if(array[mid]<=array[end]){
                    end = mid-1;
                }
            }
        }
        return -1;
    }

    private static void printArray(int[] array) {
        System.out.print("\nArray: ");
        for(int x: array){
            System.out.print(x + " ");
        }
    }
}
