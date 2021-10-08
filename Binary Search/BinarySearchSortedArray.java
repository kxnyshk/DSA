import java.util.Scanner;

public class BinarySearchSortedArray {
    
    static{
    
        System.out.println("This program traverses a Binary Search for an elemment in an array.\n");
    }
    public static void main(String[] args){
    
        int[] array = {1,5,13,20,33,40,44,53,61,77,87};
        int n = array.length;
        
        System.out.println("Enter input:");
        Scanner scan = new Scanner(System.in);
        int search = scan.nextInt();
        scan.close();

        binarySearch(array, n, search);
    }

    public static void binarySearch(int[] array, int n, int m) {
        
        int left = 0;
        int right = n-1;
        boolean found = false;
        while(left<=right){
            
            int mid = (left+(right-left)/2);
            if(m == array[mid]){
                System.out.println(m + " --> " + "Index " + mid + "\n");
                found = true;
                break;
            }
            else if(m<array[mid]){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        if(found==false){
            System.out.println(m + " not present in array.\n");
        }
    }
}
