import java.util.Random;
import java.util.Stack;

public class DeleteMidStack {

    static{
    
        System.out.println("\nDeleting Mid of Stack using Recursion..");
    }
    private static final int MIN_LIMIT = 0;
    private static final int RANDOM_LIMIT = 100;
    private static int MAX_LIMIT;
    public static void main(String[] args){
    
        Stack<Integer> stack = new Stack<Integer>();

        StackCreate(stack);
        print(stack);
        
        DeleteMid(stack);
        print(stack);

        // MID ELEMENT IS DEFINED AS: "1 2 3(mid) 4 5" in ODD | "1 2 3(mid) 4" in EVEN
    }

    private static void DelMid(Stack<Integer> stack, int k) {
        if(stack.size() == k+1){                                // when stack.peek() reaches index of the element to be deleted
            stack.pop();
            return;
        }
        
        int temp;
        temp = stack.peek();
        stack.pop();

        DelMid(stack, k);
        stack.push(temp);
    }

    private static void DeleteMid(Stack<Integer> stack) {
        if(MAX_LIMIT == 1){
            System.out.println("No Mid element found..");   // stack with only 1 element. NO MID FOUND!!!
            return;
        }

        int k;
        k = MidElement();

        DelMid(stack, k);
        System.out.println("\nMid deleted..");
    }

    private static int MidElement() {
        int k;
        k = (MAX_LIMIT/2);
        return k;
    }

    private static void StackCreate(Stack<Integer> stack) {
        Random randNum = new Random();
        MAX_LIMIT = (randNum.nextInt(10)+1);
        
        for(int i=MIN_LIMIT; i<MAX_LIMIT; i++){
            int x = randNum.nextInt(RANDOM_LIMIT);
            stack.push(x);
        }
    }

    private static void print(Stack<Integer> stack) {
        System.out.print("\nStack: ");
        for(Integer x: stack){
            System.out.print(x + " ");
        }
        System.out.println("\n[Bottom -> Top]");
    }
}