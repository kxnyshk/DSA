import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestGreaterToLeft {
    
    static{
    
        System.out.println("\nImplementing Nearest greater value to left using Stack concept.");
    }
    private static Stack<Integer> stack = new Stack<Integer>();
    private static List<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args){
    
        int[] array = {1,3,2,4,0};
        int n =  array.length;

        printArray(array, n);

        nearestGreaterToRight(array, n);

        printList(n);
    }

    private static void nearestGreaterToRight(int[] array, int n) {
        if(n == 0){
            return;
        }

        for(int i=0; i<n; i++){
            if(stack.isEmpty()){
                list.add(-1);
            }

            else if(!stack.isEmpty() && stack.peek()>array[i]){
                list.add(stack.peek());
            }

            else if(!stack.isEmpty() && stack.peek()<=array[i]){
                while (!stack.isEmpty() && stack.peek()<=array[i]) {
                    stack.pop();
                }

                if(stack.isEmpty()){
                    list.add(-1);
                }
                else{
                    list.add(stack.peek());

                }
            }
            stack.push(array[i]);
        }
    }

    private static void printList(int n) {
        System.out.print("\nNearest greatest to left element: ");
        for(int i=0; i<n; i++){
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
}
