public class Node {
    public Integer value;
    public Node left;
    public Node right;

    Node (Integer value)
    {
        this.value = value;
        left = null;
        right= null;

    }

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

    public void postorder (Node root)
    {
        if(root != null)
        {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.value);
        }
    }

    public void inorder (Node root)
    {
        if(root != null)
        {
            inorder(root.left);
            System.out.print(root.value);
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

}
