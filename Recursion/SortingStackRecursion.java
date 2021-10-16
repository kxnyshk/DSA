import java.util.Random;
import java.util.Stack;

public class SortingStackRecursion {
    
    static{
    
        System.out.println("\nSorting stack using Recursion..");
    }
    private static final int MIN_LIMIT = 0;
    private static final int MAX_LIMIT = 10;
    private static final int RANDOM_LIMIT = 100;
    public static void main(String[] args){
    
        Stack<Integer> stack = new Stack<Integer>();

        UnSorted(stack);
        print(stack);
        
        Sort(stack);
        print(stack);
    }

    private static void Sort(Stack<Integer> stack) {
        if(stack.size() == 1){
            return;
        }
        
        int temp;
        temp = stack.peek();
        stack.pop();

        Sort(stack);

        Swapping(stack,temp);
    }

    private static void Swapping(Stack<Integer> stack, int temp) {
        if(stack.isEmpty() || temp>=stack.peek()){
            stack.push(temp);
        }
        else{
            int x = stack.peek();
            stack.pop();

            Swapping(stack, temp);
            stack.push(x);
        }
    }

    private static void UnSorted(Stack<Integer> stack) {
        for(int i=MIN_LIMIT; i<MAX_LIMIT; i++){
            Random randNum = new Random();
            int x = randNum.nextInt(RANDOM_LIMIT);

            stack.push(x);
        }
    }

    private static void print(Stack<Integer> stack) {
        System.out.print("\nStack: ");
        for(Integer x: stack){
            System.out.print(x + " ");
        }
    }
}
