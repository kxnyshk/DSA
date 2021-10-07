import java.util.Stack;

public class minStackConstTS {
    
    static{
    
        System.out.println("\nFinding min in a stack in O(1) of time and space.");
    }
    private static Stack<Integer> stack = new Stack<Integer>();
    private static int minElement;
    public static void main(String[] args){
    
        top();
        getMin();
        pop();
        push(10);
        push(20);
        push(5);
        top();
        getMin();
        pop();
        top();
        getMin();
        pop();
        pop();
        pop();
        top();
        getMin();
    }

    private static void getMin(){
        if(stack.isEmpty()){
            System.out.println("Stack empty!");
        }

        else{
            System.out.println("min: " + minElement);
        }
    }

    private static void top(){
        if(stack.isEmpty()){
            System.out.println("Stack empty!");
        }

        else if(stack.peek()>=minElement){
            System.out.println("top: " + stack.peek());
        }

        else if(stack.peek()<minElement){
            System.out.println("top: " + minElement);
        }
    }

    private static void pop(){
        if(stack.isEmpty()){
            System.out.println("Underflow!");
        }

        else if(stack.peek()>=minElement){
            stack.pop();
            System.out.println("stack popped..");
        }

        else if(stack.peek()<minElement){
            minElement = ((2*minElement)-stack.peek());
            stack.pop();
            System.out.println("stack popped..");
        }
    }

    private static void push(int x){
        if(stack.isEmpty()){
            stack.push(x);
            minElement = x;
        }

        else if(x>=minElement){
            stack.push(x);
        }

        else if(x<minElement){
            stack.push((2*x)-minElement);
            minElement = x;
        }

        System.out.println(x + " pushed in stack..");
    }
}
