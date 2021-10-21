import java.util.ArrayList;

public class UniqueStringSubsets {
    
    static{
    
        System.out.println("\nPrinting out only unique subsets of a string using Recursion..");
    }
    private static ArrayList<String> list = new ArrayList<String>();
    public static void main(String[] args){
    
        String str = "Anna";
        String temp = "";
        int i=0;

        System.out.println("\nString: '" + str + "'");
        Subsets(str, temp, i);
        printUniqueSubsets(list);
    }

    private static void printUniqueSubsets(ArrayList<String> list) {
        for(String x: list){
            System.out.print("\n" + x);
        }
    }

    private static void addUniqueSubsets(String temp, ArrayList<String> list) {
        if(list.isEmpty()){
            list.add(temp);
            return;
        }

        if(temp.equals("")){
            list.add("");
            return;
        }

        if(CheckList(temp, list)){
            list.add(temp);
        }
        else{
            return;
        }
    }

    private static boolean CheckList(String temp, ArrayList<String> list) {
        
        for(int i=0; i<list.size(); i++){
            if(temp.equals(list.get(i)) || temp.equals("")){
                return false;
            }
        }
        return true;
    }

    private static void Subsets(String str, String temp, int i) {

        if(i == str.length()){
            // System.out.print("\n" + temp);
            addUniqueSubsets(temp, list);
            return;
        }
        
        Subsets(str, (temp + str.charAt(i)), (i+1));
        Subsets(str, temp, (i+1));
    }
}
