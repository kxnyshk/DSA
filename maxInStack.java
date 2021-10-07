import java.util.Stack;

public class maxInStack {
    
    static{
    
        System.out.println("\nFinding max element in stack using supplementary stack.");
    }
    private static Stack<Integer> stack = new Stack<Integer>();
    private static Stack<Integer> maxstack = new Stack<Integer>();
    public static void main(String[] args){
    
        getMax();
        pop();
        push(30);
        push(20);
        push(40);
        getMax();
        pop();
        getMax();
        pop();
        pop();
        pop();
        getMax();
    }

    private static void getMax(){
        if(maxstack.isEmpty()){
            System.out.println("Stack empty!");
        }

        else{
            System.out.println("Max: " + maxstack.peek());
        }
    }

    private static void pop(){
        if(stack.isEmpty()){
            System.out.println("Underflow!");
        }

        else{
            int pop = stack.peek();
            stack.pop();
            if(pop == maxstack.peek()){
                maxstack.pop();
            }
            System.out.println("stack popped..");
        }
    }

    private static void push(int x){
        if(maxstack.isEmpty() || x>=maxstack.peek()){
            maxstack.push(x);
        }

        stack.push(x);
        System.out.println(x + " pushed in stack..");
    }
}
