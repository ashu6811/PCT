import java.util.Scanner;

public class BSTStructureCompare {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Integer N =input.nextInt();

        //tree 1
        Node2 temp1 = new Node2(input.nextInt());
        Node2 temp2;
        Integer tempInput = input.nextInt();
        while (tempInput != -1 )
        {
            temp1.addNode(temp1, tempInput);
            tempInput = input.nextInt();
        }

        for(int i =1; i<N; i++)
        {

            //tree2
            temp2 = new Node2(input.nextInt());
            tempInput = input.nextInt();
            while (tempInput != -1 )
            {
                temp2.addNode(temp2, tempInput);
                tempInput = input.nextInt();
            }

            // do check
            compBST(temp1, temp2);

            // assign tree2 as null;

            temp2 = null;
        }


    }

    public static Integer flagCOMP(Node2 temp1 , Node2 temp2)
    {
        if(temp1 != null)
        {
            if(temp2 == null)
            {
                //
                return 0;
            }
            else {
                Integer tempFlag1 = flagCOMP(temp1.left, temp2.left);
                Integer tempFlag2 = flagCOMP(temp1.right, temp2.right);
                if(tempFlag1 == 1 && tempFlag2 == 1)
                    return 1;
                else
                    return 0;
            }
        }
        else if(temp1 == null)
            {
                if(temp2 != null)
                    return 0;
            }
        return 1;

    }
    public static void compBST(Node2 temp1 , Node2 temp2)
   {
       int flag = flagCOMP(temp1, temp2);

       //printing
       if(flag == 0)
       {
           Integer difference = height(temp1) - height(temp2);
           if(difference <0)
               difference = -1*difference;
           System.out.println("NO " + difference);
       }
       else {
           System.out.println("YES " +(height(temp1) - height(temp2)));
       }
   }

    public static Integer height(Node2 temp1)
    {
        if(temp1 == null)
            return 0;
        else
        {
            return (Integer.max(height(temp1.left), height(temp1.right)) +1);
        }
    }

}

class Node2{

    public Integer value;
    public Node2 left;
    public  Node2 right;

    Node2(Integer value)
    {
        this.value = value;
        left = null;
        right = null;
    }

    Node2()
    {
        this.value =null;
        left = null;
        right = null;
    }
    public void addNode(Node2 root, Integer value)
    {
        if(root ==null)
        {
            return ;
        }
        else
        {
            if(root.value <= value)
            {
                if(root.left ==null)
                {
                    Node2 temp = new Node2(value);
                    root.left = temp;
                }
                else
                {
                    addNode(root.left, value);
                }
            }
            else
            {
                if(root.right ==null)
                {
                    Node2 temp = new Node2(value);
                    root.right = temp;
                }
                else
                {
                    addNode(root.right, value);
                }
            }


        }
    }
}


/*
5
1 3 2 4 -1
4 1 2 3 -1
3 2 1 4 -1
4 3 2 1 -1
1 3 4 2 -1

 */