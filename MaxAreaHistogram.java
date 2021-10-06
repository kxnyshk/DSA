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
    private static List<Integer> area = new ArrayList<Integer>();
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

        width(n);
        areaHistogram(array, n);
        int maxArea = maxAreaHistogram(array, n);
        System.out.println("Max Area: " + maxArea);
    }

    private static int maxAreaHistogram(int[] array, int n) {
        int maxArea = 0;
        for(int i=0; i<n; i++){
            if(maxArea<area.get(i)){
                maxArea = area.get(i);
            }
        }
        return maxArea;
    }

    private static void areaHistogram(int[] array, int n) {
        // System.out.println("Area under Histogram for index:");
        for(int i=0; i<n; i++){
            int Area = array[i]*width.get(i);
            area.add(i, Area);
        }
    }

    private static void width(int n) {
        for(int i=0; i<n; i++){
            width.add(i, (rightIdx.get(i)-(leftIdx.get(i))-1));
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
    }
}