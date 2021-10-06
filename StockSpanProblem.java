import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanProblem {
    
    static{
    
        System.out.println("\nImplementing Stock span problem using Stacks.");
    }
    private static Stack<Integer> stack = new Stack<Integer>();
    private static List<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args){
    
        int[] array = {100,80,60,70,60,75,85};
        int n = array.length;

        printArray(array, n);

        nearestGreaterToLeft(array, n);

        printList(array, n);
    }

    private static void nearestGreaterToLeft(int[] array, int n) {
        if(n == 0){
            return;
        }

        for(int i=0; i<n; i++){

            if(stack.isEmpty()){
                list.add(i-(-1));
            }

            else if(!stack.empty() && stack.peek()>array[i]){
                list.add(i-(i-1));
            }

            else if(!stack.isEmpty() && stack.peek()<=array[i]){
                int count = stack.indexOf(stack.peek());
                while(array[i]>=stack.get(count)){
                    count--;
                }

                if(stack.isEmpty()){
                    list.add(i-(i-1));
                }
                else{
                    list.add(i-count);
                }
            }

            stack.push(array[i]);
        }
    }

    private static void printList(int[] array, int n) {
        System.out.print("\nStock span (lesser than equal to in past): ");
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
