public class RotationsArray {

    static{
    
        System.out.println("\nFinding out the no. of rotations a sorted array has undergone.\n(Left --> Right)");
    }
    public static void main(String[] args){
    
        int[] array = {23,45,2,7,10,14};
        // int[] TestArray = {12,7};
        int n = array.length;

        printArray(array);

        int rotations;
        rotations = Rotations(array, n);
        System.out.println("\nRotations: " + rotations);
    }

    private static int Rotations(int[] array, int n) {
        int start = 0;
        int end = n-1;
        int left = start;
        int right = end;
        if(array[start]<=array[end] || n==1){                           // sorted array or only 1 indices                             
            return start;
        }
        else if(n==2){
            return array[start]<array[end] ? start : end;               // only 2 index
        }
        else{                                                           // >2 index            
            while(start<=end){
                int mid = (start + (end-start)/2);
                int prev = ((mid+n-1)%n);                               // reverting back to last index (n-1) if mid = 0
                int next = ((mid+1)%n);                                 // reverting back to first index 0 if mid = n-1
                if(array[mid]<array[prev] && array[mid]<array[next]){
                    return mid;
                }
                else if(array[mid]>=array[left]){
                    start = mid+1;
                }
                else if(array[mid]<=array[right]){
                    end = mid-1;
                }
            }
        }
        return -1;
    }

    private static void printArray(int[] array) {
        System.out.print("\nRotated Array: ");
        for(int x: array){
            System.out.print(x + " ");
        }
    }
}