import java.util.Random;
import java.util.Stack;

public class ReverseStackRecursion {
    
    static{
    
        System.out.println("\nReversing a Stack using Recursion..");
    }
    private static final int SIZE_MAX = 10;
    private static final int VAL_MAX = 100;
    private static int count = 0;
    private static Random randNum = new Random();
    public static void main(String[] args){
    
        Stack<Integer> stack = new Stack<Integer>();

        CreateStack(stack);
        print(stack);

        if(stack.size() == 1){
            System.out.println("\nOnly 1 element found. Reverse not possible..");       // only 1 element in stack. NO REVERSE POSSIBLE!!!
            return;
        }
        ReverseStack(stack);
        print(stack);
    }

    private static void ReverseStack(Stack<Integer> stack) {
        if(count == (stack.size()-1)){
            System.out.println("\nStack reversed successfully..");                      // Reversal stops when count (reverse iterations) reaches [stack.size()-1]
            return;
        }

        int temp;
        temp = stack.peek();
        stack.pop();

        count++;                                                                        // count incremented before first reversal
        ReOrder(stack, temp, count);

        ReverseStack(stack);
    }

    private static void ReOrder(Stack<Integer> stack, int temp, int count) {
        int x;
        x = stack.peek();
        
        if(stack.size() == count){                                                     // pop only till current value of count, below it its already reversed
            stack.pop();
            stack.push(temp);
            stack.push(x);
            return;
        }
        stack.pop();

        ReOrder(stack, temp, count);
        stack.push(x);
    }

    private static void print(Stack<Integer> stack) {
        System.out.print("\nStack: ");
        for(int x: stack){
            System.out.print(x + " ");
        }
    }

    private static void CreateStack(Stack<Integer> stack) {
        int MAX_LIMIT = (randNum.nextInt(SIZE_MAX)+1);

        for(int i=0; i<MAX_LIMIT; i++){
            int x = randNum.nextInt(VAL_MAX);
            stack.push(x);
        }
    }
}
