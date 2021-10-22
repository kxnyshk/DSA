import java.util.Vector;

public class JosephusProblem {

    static{
    
        System.out.println("\nSolving Josephus Problem.. [Link: https://practice.geeksforgeeks.org/problems/game-of-death-in-a-circle1840/1]\n");
    }
    private static Vector<Integer> list = new Vector<Integer>();
    public static void main(String[] args){
    
        int n = 40;                         // 'n' Soldiers
        int k = 1;                          // killing 'k'th adjacent soldier
        int start = 0;                      // start at soldier 1, index 0

        CreateVector(list, n);

        int ans = -1;
        int pos = Solve(k, start, ans);
        System.out.println("\nLast person standing: Soldier " + pos);
    }

    private static int Solve(int k, int start, int ans) {
        if(list.size() == 1){
            ans = list.get(0);
            return ans;
        }

        int next;
        next = ((start+k)%(list.size()));
        
        if(next == 0){
            System.out.println("Soldier " + list.get(start) + " kills Soldier " + list.get(next) + "..");
            list.remove(next);
            return Solve(k, ((start)%(list.size())), ans);
        }
        else{
            System.out.println("Soldier " + list.get(start) + " kills Soldier " + list.get(next) + "..");
            list.remove(next);
            return Solve(k, ((start+1)%(list.size())), ans);
        }
    }

    private static void CreateVector(Vector<Integer> list, int n) {
        for(int i=0; i<n; i++){
            list.add(i+1);
        }
    }
}