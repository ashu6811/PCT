import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Trees");
        Scanner input = new Scanner(System.in);
        Node root = new Node(-1);
        Integer tempInput = input.nextInt();
        if(tempInput != -1)
        {
            root.value= tempInput;

        }

        tempInput = input.nextInt();
        while(tempInput != -1)
        {
            root.addNode(root, tempInput );
            tempInput = input.nextInt();
        }

        root.preorder(root);
    }
}
