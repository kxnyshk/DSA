import java.util.Stack;

public class minInStack {
    
    static{
    
        System.out.println("\n Finding the min element in stack using an another stack.");
    }
    private static Stack<Integer> stack = new Stack<Integer>();
    private static Stack<Integer> minstack = new Stack<Integer>();
    public static void main(String[] args){
        
        getMin();
        pop();
        push(10);
        push(20);
        push(5);
        getMin();
        pop();
        getMin();
        pop();
        pop();
        pop();
        getMin();
    }

    private static void getMin(){
        if(minstack.isEmpty()){
            System.out.println("Empty stack!");
        }

        else{
            System.out.println("Min: " + minstack.peek());
        }
    }

    private static void pop(){
        if(stack.isEmpty()){
            System.out.println("Underflow!");
        }

        else{
            int pop = stack.peek();
            stack.pop();
            if(pop == minstack.peek()){
                minstack.pop();
            }
            System.out.println("stack popped..");
        }
    }

    private static void push(int x){
        if(minstack.isEmpty() || x<=minstack.peek()){
            minstack.push(x);
        }

        stack.push(x);
        System.out.println(x + " pushed in stack..");
    }
}
