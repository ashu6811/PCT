import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Trees");
        Scanner input = new Scanner(System.in);
        Node root = new Node(-1);
//        Integer tempInput = input.nextInt();
//        if(tempInput != -1)
//        {
//            root.value= tempInput;
//
//        }
//
//        tempInput = input.nextInt();
//        while(tempInput != -1)
//        {
//            root.addNode(root, tempInput );
//            tempInput = input.nextInt();
//        }

        root.value=4;
        root.addNode(root,2);
        root.addNode(root,6);
        root.addNode(root,3);
        root.addNode(root,5);
        root.addNode(root,7);
        root.addNode(root,1);



        //Preorder traversal
        root.preorder(root);
        System.out.print("\n");

        //Inorder traversal
        root.inorder(root);
        System.out.print("\n");

        //Postorder traversal
        root.postorder(root);
        System.out.print("\n");

        //Levelorder Traversal
        root.levelOrder(root);
        System.out.print("\n");

        // Horizontal postion considering root node as 0;
        root.horizontalPostion(root,7,0);
        System.out.print("\n");

        //Range of horizontal distance
        // Data object is used to save the min and max count for recursive calls
        Data data = new Data();
        root.findMaxMin(root, data, 0);
        System.out.print(data.min +" " + data.max);
        System.out.print("\n");

        //Verticalorder Traversal
        root.verticalOrder(root,data);
        System.out.print("\n");

        //Top View
        root.topView(root,data);
        System.out.print("\n");

        //Check whether the BST is AVL or Not.
        if(root.isBalanced(root))
            System.out.println("BST is AVL");
        else
            System.out.println("BST is NOT AVL");



    }
}
