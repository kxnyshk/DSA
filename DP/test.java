import java.util.ArrayList;

public class test {
    
    static{

    }

    public static void main(String[] args) {
        
        ArrayList<Character> L = new ArrayList<Character>();
        System.out.println(L);


        String S1 = "agbcba";
        String S2 = new StringBuilder(S1).reverse().toString();
        System.out.println(S1 + " " + S2);

        String S = "NITIN";
        String R = new StringBuilder(S).reverse().toString();
        if(S.equals(R)){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
        System.out.println(S.substring(0, 5));
    }
}
