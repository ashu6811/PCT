package com.levelorder;
import java.util.*;

public class LevelOrder {

    public static void main(String[] args) {
        // write your code here
        Node parentNode=null;
        Scanner input = new Scanner(System.in);
        String raw = input.nextLine();
        String nodeName = input.nextLine();
        Integer dist = input.nextInt();
        //Stack<Character> stack = new Stack<>();
        Stack<Node> parents = new Stack<>();
        Node tempParent, tempNode;
        for(int i =0; i<raw.length(); i++)
        {
            if(raw.charAt(i) == '(' && raw.charAt(i+1) != ')')
            {
                i++;
                if(!parents.isEmpty())
                {
                    tempParent = parents.pop();
                    tempNode = new Node(raw.substring(i,i+1));
                    tempParent.addNode(tempNode);
                    parents.push(tempParent);
                    parents.push(tempNode);
                    tempNode =null;
                    tempParent=null;
                }
                else
                {
                    tempNode= new Node(raw.substring(i,i+1));
                    parents.push(tempNode);
                    parentNode = tempNode;
                    tempNode = null;
                }

            }else if(raw.charAt(i) == ')')
            {
                if(raw.charAt(i-1) == '(')
                {
                    tempParent = parents.pop();
                    tempNode = new Node("#");
                    tempParent.addNode(tempNode);
                    parents.push(tempParent);
                    tempNode = null;
                    tempParent = null;
                }else
                {
                    tempParent = parents.pop();
                    tempParent = null;
                }

            }
        }


        parentNode.handleHash(parentNode, null);

        parentNode.printLevelOrder(parentNode);
        Node nodeToFindDistance = parentNode.getAddress(parentNode, nodeName);
        parentNode.printDistanceNodes(parentNode, nodeToFindDistance, dist);
        parentNode.resetVisited();
        parentNode.printList();

        }


    }



class Node {
    String value;
    Node left;
    Node right;
    public  static TreeMap<String, Integer> finalResult = new TreeMap<String, Integer> ();
    public  static ArrayList<Node> visited = new ArrayList<Node>();
    public  static ArrayList<String> levelOrderList = new ArrayList<String>();

    Node(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    Node() {
        this.value = null;
        this.left = null;
        this.right = null;
    }

    public void addNode(Node child) {
        if (this.left == null)
            this.left = child;
        else
            this.right = child;
    }

    public void printPreorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.value + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public void handleHash(Node root, Node parent) {
        if (root == null)
            return;
        if (root.value.equals("#")) {
            if (parent.left.value.equals("#"))
                parent.left = null;
            else if (parent.right.value.equals("#"))
                parent.right = null;
        } else {
            handleHash(root.left, root);
            handleHash(root.right, root);
        }
    }

    void printOnLevel(Node root, int h) {
        if (root == null)
            return;
        if (h == 1) {
            System.out.print(root.value +" ");
            levelOrderList.add(root.value);
        } else {
            printOnLevel(root.left, h - 1);
            printOnLevel(root.right, h - 1);
        }
    }

    Integer calculateHeight(Node root) {
        if (root == null)
            return 0;
        return Math.max(calculateHeight(root.left), calculateHeight(root.right)) + 1;
    }


    void printLevelOrder(Node root) {
        int height = root.calculateHeight(root);

        for (int i = 1; i <= height; i++) {
            root.printOnLevel(root, i);
        }
    }

    void printheight (Node node, Node parent, int l, Node root)
    {
        if(node == null)
            return;

        if(l == 2 || l==-2)
            System.out.println(node.value);

        printheight(node.left, node, l-1, root);
        printheight(node.right, node, l-1, root);
        printheight(getParent(root, node, null), getParent(root, getParent(root,node,null), null), l+1, root);
    }
    public void printDistanceNodes(Node root, Node node, Integer distPos)
    {

        if(node == null)
            return;
        else
            visited.add(node);


        if(distPos == 0)
        {
            finalResult.put(node.value, 0);
            return;
        }
        else
        {
            Integer temp = distPos -1;
            if(!visited.contains(node.left))
                printDistanceNodes(root, node.left, temp);
            if(!visited.contains(node.right))
                printDistanceNodes(root, node.right, temp);
            if(!visited.contains(getParent(root, node,null)))
                printDistanceNodes(root, getParent(root, node, null), temp);
        }
    }

    public Node getAddress(Node root, String nodeName)
    {
        if(root == null)
        {
            return null;
        }
        else
        {
            if(nodeName.equals(root.value))
            {
                return root;
            }
            else {
                Node left = getAddress(root.left, nodeName);
                Node right = getAddress(root.right, nodeName);
                if(left != null)
                    return left;
                else if(right !=null)
                    return right;
            }
        }
        return null;
    }


    public Node getParent(Node root, Node node, Node parent)
    {
        if(root == null)
            return null;

        if(root == node)
            return parent;
        if(root.left == node)
            return root;
        else if(root.right == node)
            return root;
        Node left = getParent(root.left, node, root);
        Node right = getParent(root.right, node, root);

        if(left != null)
            return left;

        if(right != null)
            return right;

        return null;
    }

    public void printList()
    {
        for (String ans: levelOrderList)
        {
            for(String key: finalResult.keySet())
            {
                if(ans.equals(key))
                    System.out.print(ans +" ");
            }
        }
    }
    public void resetVisited()
    {
        visited.clear();
    }
}

/*

(F(B(A)(D(C)(E)))(G()(I(H))))
D
2

(A(B(D)(E(F)(G)))(C))
F
4

(8(3(13()(7))())(10(1(14)())(6(4)())))
10
1

 */