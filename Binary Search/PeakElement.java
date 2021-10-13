public class PeakElement {

    static{
    
        System.out.println("\nFinding a peak element in an unsorted array\n[Peak : Any element in an array that is greater than its immediate neighbors]");
    }
    public static void main(String[] args){
    
        int[] array = {1,2,0,1,5,4};
        int n = array.length;
        printArray(array);

        int peak;
        peak = Peak(array, n);
        System.out.println("\nPeak: Array[" + peak + "]");
    }

    private static int Peak(int[] array, int n) {
        int start = 0;
        int end = n-1;
        int peak = -1;

        if(n == 1){
            return 0;
        }
        else{
            while(start<=end){
                int mid = (start + (end-start)/2);
                int prev = mid-1;
                int next = mid+1;
    
                if(mid>0 && mid<n-1){
                    if(array[mid]>array[prev] && array[mid]>array[next]){
                        peak = mid;
                        break;
                    }
                    else if(array[prev]>array[next]){
                        end = prev;
                    }
                    else if(array[next]>array[prev]){
                        start = next;
                    }
                }
                else if(mid == 0){
                    return array[mid]>array[next] ? mid : next;
                }
                else if(mid == n-1){
                    return array[mid]>array[prev] ? mid : prev;
                }
            }
        }
        return peak;
    }

    private static void printArray(int[] array) {
        System.out.print("\nArray: ");
        for(int x: array){
            System.out.print(x + " ");
        }
    }    
}