public class BinaryInfiniteArray {

    static{
    
        System.out.println("\nImplementing Binary[1] search in an infinite binary sorted array.");
    }
    private static final int BINARY = 1;
    public static void main(String[] args){
    
        int[] array = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1};
        int n = array.length;

        int idx;
        idx = BinaryInfinite(array, n);
        System.out.print("\n[" + BINARY + "] (initial) : Index " + idx);
    }

    private static int BinaryInfinite(int[] array, int n) {
        int start = 0;
        int end = start+1;
        while(BINARY>array[end]){
            start = end;
            end = end*2;
        }

        int idx = -1;
        idx = FirstOcc(array, start, end);
        return idx;
    }

    private static int FirstOcc(int[] array, int start, int end) {
        int low = start;
        int high = end;
        int idx = -1;

        while(low<=high){
            int mid = (low + (high-low)/2);

            if(BINARY == array[mid]){
                idx = mid;
                high = mid-1;
            }
            else if(BINARY>array[mid]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return idx;
    }
}