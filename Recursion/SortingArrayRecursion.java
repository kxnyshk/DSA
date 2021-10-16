public class SortingArrayRecursion {
    
    static{
    
        System.out.println("\nSorting an array using recursion..");
    }
    public static void main(String[] args){
    
        Integer[] array = {23,12,56,34,78,67,90,89,1,100,0,5};
        int n = array.length;

        printArray(array);

        Sort(array, n);
        printArray(array);
    }

    private static void Sort(Integer[] array, int n) {
        if(n == 1){
            return;
        }

        Swapping(array, n);

        Sort(array, n-1);
    }

    private static void Swapping(Integer[] array, int n) {
        int temp;
        int maxIDX = -1;
        maxIDX = MaxArray(array, n, maxIDX);

        temp = array[n-1];
        array[n-1] = array[maxIDX];
        array[maxIDX] = temp;
    }

    private static int MaxArray(Integer[] array, int n, int maxIDX) {
        int max = -1;
        for(int i=0; i<n; i++){
            if(array[i]>max){
                max = array[i];
                maxIDX = i;
            }
        }
        return maxIDX;
    }

    private static void printArray(Integer[] array) {
        System.out.print("\nArray: ");
        for(Integer x: array){
            System.out.print(x + " ");
        }
    }
}
