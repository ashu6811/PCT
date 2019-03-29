import java.util.*;

public class GraphNode {
    public Integer ID;
    public LinkedList<GraphNode> edge;
    public boolean visited;

    GraphNode(Integer id)
    {
        this.ID = id;
       edge = new LinkedList<>();
       visited = false;

    }

    public void addEdge(GraphNode graphNode)
    {
        this.edge.add(graphNode);
    }

    public void printGraphEdges()
    {
        Iterator<GraphNode> i = this.edge.listIterator();
        while(i.hasNext())
        {
            System.out.println(i.next().ID);
        }

    }

    public void resetVisited(GraphNode graphNode)
    {
        graphNode.visited = false;

        Iterator<GraphNode> i = graphNode.edge.listIterator();
        while (i.hasNext())
        {
            GraphNode tempGraphNode = i.next();
            resetVisited(tempGraphNode);
        }
    }
    public void printDFS(GraphNode graphNode)
    {
        resetVisited(graphNode);
        DFSUtil(graphNode);

    }

    public void DFSUtil (GraphNode graphNode)
    {
        System.out.print(graphNode.ID + " ");
        graphNode.visited = true;

        Iterator<GraphNode> i = graphNode.edge.listIterator();

        while (i.hasNext())
        {
            GraphNode tempGraphNode = i.next();
            if (tempGraphNode.visited == false)
                DFSUtil(tempGraphNode);
        }
    }

    public  void BFSUtil( Queue<GraphNode> queue)
    {
        GraphNode tempGraphNode = queue.poll();
        while(tempGraphNode != null)
        {
            System.out.print(tempGraphNode.ID + " ");
            tempGraphNode.visited = true;
            Iterator<GraphNode> i = tempGraphNode.edge.listIterator();

            while (i.hasNext())
            {
                GraphNode tempGraphNode2 = i.next();
                if (tempGraphNode2.visited == false)
                    queue.add(tempGraphNode2);
            }

            tempGraphNode = queue.poll();

        }


    }
    public void printBFS(GraphNode graphNode)
    {
        resetVisited(graphNode);
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(graphNode);
        BFSUtil(queue);




    }
    public static void main(String[] args) {

        //Scanner input = new Scanner()


        GraphNode graph = new GraphNode(0);



        for(int i =0; i<5; i++)
        {
           GraphNode tempGraph = new GraphNode(i+1);
            graph.addEdge(tempGraph);
        }
        GraphNode graph11 = new GraphNode(11);
        GraphNode graph12 = new GraphNode(12);
        graph11.addEdge(graph);
        graph11.addEdge(graph12);

        graph.printGraphEdges();
        graph.printDFS(graph11);

        System.out.println("");
        graph.printBFS(graph11);


    }
}
