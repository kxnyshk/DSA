public class RainWaterTrapping {

    static{
    
        System.out.println("\nSolving the Rain water trapping problem.");
    }
    private static final int ARR_LIMIT = 6;
    private static int[] maxLeft = new int[ARR_LIMIT];
    private static int[] maxRight = new int[ARR_LIMIT];
    private static int[] water = new int[ARR_LIMIT];
    public static void main(String[] args){
    
        Integer[] array = {3,0,0,2,0,4};
        int n = array.length;

        printArray(array, n);

        int rainWater;
        rainWater = totalRainWater(array);
        System.out.println("\nTotal rain water trapped: " + rainWater);
    }

    private static void printArray(Integer[] array, int n) {
        System.out.println("\nArray:");
        for(int i=0; i<n; i++){
            System.out.print(array[i] + " " + "-".repeat(array[i]) + "\n");
        }
    }

    private static int totalRainWater(Integer[] array) {
        maxInLeft(array);

        maxInRight(array);

        waterTrapped(array);

        int sum=0;
        for(int i=0; i<ARR_LIMIT; i++){
            sum = sum + water[i];
        }

        return sum;
    }

    private static void waterTrapped(Integer[] array) {
        for(int i=0; i<ARR_LIMIT; i++){
            water[i] = (Math.min(maxLeft[i], maxRight[i]) - array[i]);
        }
    }

    private static void maxInRight(Integer[] array) {
        maxRight[ARR_LIMIT-1] = array[ARR_LIMIT-1];
        for(int i=ARR_LIMIT-2; i>=0; i--){
            maxRight[i] = Math.max(array[i], maxRight[i+1]);
        }
    }

    private static void maxInLeft(Integer[] array) {
        maxLeft[0] = array[0];
        for(int i=1; i<ARR_LIMIT; i++){
            maxLeft[i] = Math.max(array[i], maxLeft[i-1]);
        }
    }
}