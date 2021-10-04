import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestGreaterToRight {

    static{
    
        System.out.println("\nImplementing Nearest greater value to right using Stack concept.");
    }
    private static Stack<Integer> stack = new Stack<Integer>();
    private static List<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args){
    
        int[] array = {1,3,0,0,2,2,4};
        int n = array.length;

        printArray(array, n);
        
        nearestGreaterToRight(array, n);
        
        printList(n);
    }

    private static void printList(int n) {
        System.out.print("\nNearest greater to right element: ");
        for(int i=n-1; i>=0; i--){
            System.out.print(list.get(i) + " ");
        }
        System.out.println("\n");
    }

    private static void printArray(int[] array, int n) {
        System.out.print("\nInput array: ");
        for(int i=0; i<n; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private static void nearestGreaterToRight(int[] array, int n) {
        if(n==0){
            return;
        }

        for(int i=n-1; i>=0; i--){
            if(stack.isEmpty()){
                list.add(-1);
                stack.push(array[i]);
            }

            else if(!stack.isEmpty() && stack.peek()>array[i]){
                list.add(stack.peek());
                stack.push(array[i]);
            }
            
            else if(!stack.isEmpty() && stack.peek()<=array[i]){
                while(!stack.isEmpty() && stack.peek()<=array[i]){
                    stack.pop();
                }

                if(stack.isEmpty()){
                    list.add(-1);
                }
                else{
                    list.add(stack.peek());
                    stack.push(array[i]);
                }
            }
        }
    }
}