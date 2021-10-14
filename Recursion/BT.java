import java.util.Scanner;

public class BT {
    
    public static void main(String[] args){
    
        node root = Tree();

        System.out.print("\nBT (In-order): ");
        InOrder(root);
        System.out.print("\nBT (Pre-order): ");
        PreOrder(root);
        System.out.print("\nBT (Post-order): ");
        PostOrder(root);
    }

    public static node Tree(){
        node root = null;

        System.out.print("\nEnter data: ");
        Scanner scan = new Scanner(System.in);
        int data = scan.nextInt();
        
        if(data == -1){
            return null;
        }
        root = new node(data);

        System.out.print("\nEnter data for left of " + data);
        root.left = Tree();
        System.out.print("\nEnter data for right of " + data);
        root.right = Tree();

        return root;
    }

    public static void PostOrder(node root){                 // Post-order: L-->R-->N
        if(root == null){
            return;
        }

        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void PreOrder(node root){                 // Pre-order: N-->L-->R
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        PreOrder(root.left);
        PreOrder(root.right);
    }

    public static void InOrder(node root){                 // In-order: L-->N-->R
        if(root == null){
            return;
        }

        InOrder(root.left);
        System.out.print(root.data + " ");
        InOrder(root.right);
    }
}

class node{
    node left, right;
    int data;
    
    public node(int data){
      this.data = data;
    }
  }
