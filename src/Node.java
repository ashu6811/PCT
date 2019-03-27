public class Node {
    public Integer value;
    public Node left;
    public Node right;



    Node ()
    {
        this.value = -1;
        this.left = null;
        this.right= null;

    }

    // Constructor to initialize a new node using integer as the value.

    Node (Integer value)
    {
        this.value = value;
        this.left = null;
        this.right= null;

    }
// Node class represents each Dynamic node for the trees and the graphs


    // Find a node reference for a particular integer value
    // Note: Remember this deals only for the unique integer values.
    public Node getAddress(Node root, Integer value)
    {
        if(root!= null)
        {
            if (root.value== value)
            {
                return root;
            }
            else if (value<root.value)
            {
                return getAddress(root.left,value);
            }
            else
            {
                return getAddress(root.right,value);
            }
        }
        else
        {
            return null;
        }
    }

    // Add node to the root tree using Integer value.
    // Addition using BST format
    public void addNode ( Node root, Integer value)
    {
        if(value<=root.value)
        {
            if(root.left == null)
            {
                Node temp = new Node(value);
                root.left = temp;
            }
            else
            {
                addNode(root.left, value);
            }

        }
        else
        {
            if(root.right == null)
            {
                Node temp = new Node(value);
                root.right = temp;
            }
            else
            {
                addNode(root.right, value);
            }
        }
    }

    // Add node to the root tree using Node as the value.
    // Addition using BST format
    public void addNode ( Node root, Node nodeToBeAdded)
    {
        if(nodeToBeAdded!= null && root!=null)
        {
            if(nodeToBeAdded.value<=root.value)
            {
                if(root.left == null)
                {
                    root.left = nodeToBeAdded;
                }
                else
                {
                    addNode(root.left, nodeToBeAdded);
                }
            }
            else
            {
                if(root.right == null)
                {
                    root.right = nodeToBeAdded;
                }
                else
                {
                    addNode(root.right,nodeToBeAdded);
                }
            }
        }
    }

    // Printing preorder traversal with no unwanted spaces.
    public void preorder (Node root)
    {
        if(root != null)
        {
            System.out.print(root.value);
           if (root.left != null)
           {
               System.out.print(" ");
           }
            preorder(root.left);
            if (root.right != null)
            {
                System.out.print(" ");
            }
            preorder(root.right);

        }

    }

    // Printing postorder traversal with no unwanted spaces.
    public void postorder (Node root)
    {
        if(root != null)
        {
            postorder(root.left);
            if (root.left != null)
            {
                System.out.print(" ");
            }
            postorder(root.right);
            if (root.right != null)
            {
                System.out.print(" ");
            }
            System.out.print(root.value);
        }
    }

    // Printing inorder traversal with no unwanted spaces.
    public void inorder (Node root)
    {
        if(root != null)
        {

            inorder(root.left);
            if (root.left != null)
            {
                System.out.print(" ");
            }
            System.out.print(root.value);
            if (root.right != null)
            {
                System.out.print(" ");
            }
            inorder(root.right);
        }
    }

    public Node getParent( Node root, Integer value, Node parent)
    {
        if(root != null)
        {
            if(root.value == value)
            {
                return parent;
            }
            else if ( value<root.value)
            {
                return getParent(root.left, value, root);
            }
            else
            {
                return getParent(root.right,value,root);
            }
        }
        else
        {
            return null;
        }
    }

    // Delete the node from the BST
    // It re-adds the other nodes back to the BST : first left child of the deleted node then the right child.
    public void deleteNode (Node root, Integer value)
    {
        if(root != null)
        {
            Node nodeToBeDeleted = getAddress(root, value);
            Node parentOfTheNode = getParent(root,value,null);
            if(parentOfTheNode.left == nodeToBeDeleted)
            {
                parentOfTheNode.left=null;
            }
            else
            if(parentOfTheNode.right == nodeToBeDeleted)
            {
                parentOfTheNode.right=null;
            }
            else
            {
                System.out.print("Something is wrong while deleting");
            }
            addNode(root, nodeToBeDeleted.left);
            addNode(root,nodeToBeDeleted.right);

        }
    }

    //calculate height of the BST or say any tree
    public Integer calculateHeight (Node root)
    {
        if(root == null)
        {
            return 0;
        }
        else
        {
            return Integer.max(calculateHeight(root.left), calculateHeight(root.right) + 1);
        }
    }

    // print at a particular level
    public void printAtLevel (Node root, Integer level)
    {
        if (root == null)
        {
            return;
        }
        if (level == 1)
        {
            System.out.print(root.value + " ");
        }
        else if (level>1)
        {
            printAtLevel(root.left,level-1);
            printAtLevel(root.right,level-1);
        }
    }

    //Level Order Traversal
    // We need two functions :
    // 1. to calculate the total number of levels
    // 2. print all the nodes at each level
    public void levelOrder(Node root)
    {
        Integer i;
        for (i=1; i<=calculateHeight(root); i++)
        {
            printAtLevel(root, i);
        }
    }

    // Print the tree
    public void printTree (Node root)
    {
        if(root != null)
        {
            Integer height = calculateHeight(root);
            Integer i;
            for(i=0; i<height; i++)
            {
                System.out.print(" ");
            }
            System.out.println(root.value);

        }
    }

    public void horizontalPostion(Node root, Integer value, Integer pos)
    {
        if(root == null)
            return ;
        else
        {
            if(root.value == value)
            {
                System.out.print(pos);
            }
            else
            {
                horizontalPostion(root.left,value,pos-1);
                horizontalPostion(root.right, value, pos+1);
            }

        }

    }

    //horizontal max min count
    void findMaxMin(Node root, Data data,Integer pos)
    {
        if(root == null)
            return;

        if (pos<data.min)
        {
            data.min = pos;
        }
        else if (pos>data.max)
        {
                data.max= pos;
        }
        findMaxMin(root.left,data,pos-1);
        findMaxMin(root.right,data,pos+1);
    }

    //Print Vertical view for a particular horizontal distance
    public  void printVertical(Node root, Integer lineNo, Integer pos)
    {
        if (root == null)
            return;
        if ( lineNo==pos)
        {
            System.out.print(root.value + " ");
        }
        printVertical(root.left,lineNo,pos-1);
        printVertical(root.right,lineNo,pos+1);

    }

    // Vertical order traversal
    public void verticalOrder(Node root, Data data)
    {
        findMaxMin(root, data, 0);
        int i;
        for(i= data.min;i<=data.max;i++)
        {
            printVertical(root,i,0);
            System.out.print("\n");
        }
    }

    // print first element available from the top at particular horizontal distance
    public  void printFirstVertical(Node root, Integer lineNo, Integer pos)
    {
        if (root == null)
            return;
        if ( lineNo==pos)
        {
            System.out.print(root.value + " ");
            return;
        }
        printVertical(root.left,lineNo,pos-1);
        printVertical(root.right,lineNo,pos+1);

    }

    //Top view of the tree
    public void topView(Node root, Data data)
    {
        findMaxMin(root, data, 0);

        int i;
        for(i= data.min;i<=data.max;i++)
        {
            printFirstVertical(root,i,0);
        }
    }

    boolean isBalanced(Node node)
    {
        int lh; /* for height of left subtree */

        int rh; /* for height of right subtree */

        /* If tree is empty then return true */
        if (node == null)
            return true;

        /* Get the height of left and right sub trees */
        lh = calculateHeight(node.left);
        rh = calculateHeight(node.right);

        if (Math.abs(lh - rh) <= 1
                && isBalanced(node.left)
                && isBalanced(node.right))
            return true;

        /* If we reach here then tree is not height-balanced */
        return false;
    }




}
