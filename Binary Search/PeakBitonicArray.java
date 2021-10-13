public class PeakBitonicArray {
    
    static{
    
        System.out.println("\nFinding peak in a Bitonic array\n[Bitonic: first monotonically inc then dec (only once)]");
    }
    public static void main(String[] args){
    
        int[] array = {1,3,8,12,4,2,0};
        int n = array.length;
        printArray(array);

        int bitonicPeak;
        bitonicPeak = Bitonic(array, n);
        System.out.println("\nBitonic peak: [" + bitonicPeak + "]");
    }

    private static int Bitonic(int[] array, int n) {
        int start = 0;
        int end = n-1;
        int peak = -1;

        // Bitonic array req atleast 3 elements for monotonically inc then dec
        // if index 0 > index 1 --> not a Bitonic array [is decreasing first]
        // if index n-1 > index n-2 --> not a Bitonic array [is increasing later]
        if(n<3 || array[start]>array[start+1] || array[end]>array[end-1]){
            return -1;
        }
        else{
            while(start<=end){
                int mid = (start + (end-start)/2);
                int prev = mid-1;
                int next = mid+1;

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
