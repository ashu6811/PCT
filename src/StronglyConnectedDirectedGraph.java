import java.util.*;

public class StronglyConnectedDirectedGraph {
   public static Stack<GNode> gNodeStack = new Stack<>();
   public static TreeMap<String, Integer> result = new TreeMap<>();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Integer numOfVertices, numOfEdges;
        numOfVertices = input.nextInt();
        numOfEdges = input.nextInt();


        ArrayList<GNode> graphVertices = new ArrayList<GNode>(numOfVertices);
        //ArrayList<GNode> graphVerticesT = new ArrayList<GNode>(numOfVertices); //transpose of graph

        for(int i =0; i<numOfVertices; i++)
        {
            graphVertices.add(new GNode(i));
           // graphVerticesT.add(new GNode(i));
        }

        Integer[] fromNode = new Integer[numOfEdges];
        Integer[] toNode = new Integer[numOfEdges];

        for(int i =0; i<numOfEdges; i++)
        {
            fromNode[i] = input.nextInt();
            toNode[i] = input.nextInt();

            graphVertices.get(fromNode[i]).addNode(graphVertices.get(toNode[i]));
           // graphVerticesT.get(toNode).addNode(graphVerticesT.get(fromNode));


        }




        for(int k=0; k<numOfVertices; k++)
        {
            DFS(graphVertices.get(k), graphVertices);

            //transpose graph
            for(int i =0; i<numOfEdges; i++)
            {
                graphVertices.get(fromNode[i]).adjacents.remove(graphVertices.get(toNode[i]));
                graphVertices.get(toNode[i]).addNode(graphVertices.get(fromNode[i]));
            }

            //reset only those which are visited
            for(GNode i: graphVertices)
            {
                if(i.visit == true)
                    i.visit =false;
                else
                    i.visit = true;
            }

            //print strongly connected components
//            while(!gNodeStack.isEmpty())
//            {
//
//                DFS2(gNodeStack.pop(), graphVertices);
//            }

            DFS2(graphVertices.get(k), graphVertices);

            //retranspose
            for(int i =0; i<numOfEdges; i++)
            {
                graphVertices.get(toNode[i]).adjacents.remove(graphVertices.get(fromNode[i]));
                graphVertices.get(fromNode[i]).addNode(graphVertices.get(toNode[i]));
            }
            //for loop ends....
        }


        for(String key: result.keySet())
            System.out.println(key);

    }

    public static void DFS(GNode node , List<GNode> graphVertices)
    {
        //reset visited
        for(GNode i: graphVertices)
            i.visit =false;
        DFSUtil(node);
    }

    public static void DFSUtil(GNode node)
    {
        node.visit =true;
        gNodeStack.push(node);
        for(GNode adj: node.adjacents)
        {
            if(adj.visit == false)
            {
                DFSUtil(adj);
            }
        }
    }

    public static void DFS2(GNode node , List<GNode> graphVertices)
    {
        //reset visited


        ArrayList<Integer> strongComponents = new ArrayList<>();
        DFSUtil2(node, strongComponents);
        strongComponents.sort(Integer::compareTo);
        if(!strongComponents.isEmpty())
        {

            result.put(strongComponents.toString(), 1);
        }
    }

    public static void DFSUtil2(GNode node, ArrayList<Integer> strongComponents)
    {
        if(node.visit == false)
        {
            node.visit =true;
            strongComponents.add(node.value);
        }
        else
            return;

        for(GNode adj: node.adjacents)
        {
            if(adj.visit == false)
            {
                DFSUtil2(adj, strongComponents);
            }
        }
    }
}

class GNode{

    Integer value;
    List<GNode> adjacents;
    boolean visit;
    GNode(Integer value)
    {
        this.value = value;
        this.adjacents = new ArrayList<GNode>();
    }

    void addNode(GNode gNode)
    {
        this.adjacents.add(gNode);
    }

}


/*

6
7
2 0
0 4
4 2
1 4
1 5
3 1
5 3



7
10
2 3
0 2
6 3
1 2
3 4
3 5
0 1
1 3
0 3
5 6


*/