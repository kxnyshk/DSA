import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MaxAreaHistogram {

    static{
    
        System.out.println("\nFinding Max area of Histogram using Stacks.");
    }
    private static Stack<Integer> rightStack = new Stack<Integer>();
    private static Stack<Integer> leftStack = new Stack<Integer>();
    private static List<Integer> rightIdx = new ArrayList<Integer>();
    private static List<Integer> leftIdx = new ArrayList<Integer>();
    private static List<Integer> width = new ArrayList<Integer>();
    private static final int pseudoIdxR = 7;
    private static final int pseudoIdxL = -1;
    public static void main(String[] args){
    
        int[] array = {6,2,5,4,5,1,6};
        int n = array.length;

        System.out.println("\nArray bars at index:");
        for(int i=0; i<n; i++){
            System.out.print(i + " " + "-".repeat(array[i]) + " [" + array[i] + "]" + "\n");
        }

        maxArea(array, n);
    }

    private static void maxArea(int[] array, int n) {
        if(n == 0){
            return;
        }

        nextSmallerToRight(array, n);
        System.out.println();
        nextSmallerToLeft(array, n);

        for(int i=0; i<n; i++){
            width.add(i, (rightIdx.get(i)-(leftIdx.get(i))-1));
        }

        // System.out.println();
        // for(int x: width){
        //     System.out.print(x + " ");
        // }

        System.out.println("Max area under Histogram for index:");
        for(int i=0; i<n; i++){
            int maxArea = array[i]*width.get(i);
            System.out.print(i + " : " + maxArea + "\n");
        }
    }

    private static void nextSmallerToRight(int[] array, int n) {
        for(int i=n-1; i>=0; i--){
            if(rightStack.isEmpty()){
                rightIdx.add(pseudoIdxR);
            }

            else if(!rightStack.isEmpty() && rightStack.peek()<array[i]){
                rightIdx.add(i+1);
            }

            else if(!rightStack.isEmpty() && rightStack.peek()>=array[i]){
                int Count = rightStack.indexOf(rightStack.peek());
                while(Count>pseudoIdxL && array[i]<=rightStack.get(Count)){
                    Count--;
                }

                rightIdx.add(n-(Count)-1);
            }

            rightStack.push(array[i]);
        }

        Collections.reverse(rightIdx);
        // for(int x: rightIdx){
        //     System.out.print(x + " ");
        // }
    }

    private static void nextSmallerToLeft(int[] array, int n) {
        for(int i=0; i<n; i++){
            if(leftStack.isEmpty()){
                leftIdx.add(pseudoIdxL);
            }

            else if(!leftStack.isEmpty() && leftStack.peek()<array[i]){
                leftIdx.add(i-1);
            }

            else if(!leftStack.isEmpty() && leftStack.peek()>=array[i]){
                int Count = leftStack.indexOf(leftStack.peek());
                while(Count>pseudoIdxL && array[i]<=leftStack.get(Count)){
                    Count--;
                }

                leftIdx.add(Count);
            }

            leftStack.push(array[i]);
        }

        // for(int x: leftIdx){
        //     System.out.print(x + " ");
        // }        
    }
}