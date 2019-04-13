import java.util.*;

public class ConnectedGraph {

    public static List<GraphNode2> allNodes = new ArrayList<>();
    public static Map<GraphNode2, Boolean> visited = new HashMap<>();

    public static void reset()
    {
        for(GraphNode2 graphNode2: allNodes)
        {
            visited.put(graphNode2, false);

        }
    }

    public static void visit(GraphNode2 graphNode2)
    {
        if(visited.get(graphNode2) == true)
            return;
        visited.put(graphNode2, true);
        for(GraphNode2 graphNode21 : graphNode2.edges)
        {
            visit(graphNode21);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Integer N = input.nextInt();


        // Graph input and graph preparation.
        for(int i=0; i<N; i++)
        {
            Integer t1 = input.nextInt();
            Integer t2 = input.nextInt();


            GraphNode2 temp1= searchOrMakeNode(t1);
            GraphNode2 temp2 = searchOrMakeNode(t2);

            temp1.addDirectedEdge(temp2);
            temp2.addDirectedEdge(temp1);
        }

        // Graph printing
      graphPrinting();

        //Connected or not
        reset();
        Integer counter =0;
        for(GraphNode2 i: allNodes)
        {
            if(visited.get(i) == false)
            {
                visit(i);
                counter++;
            }
        }
        if(counter==1)
            System.out.println("1 "+counter);
        else
            System.out.println("0 "+counter);


    }


    public static void graphPrinting ()
    {
        for (GraphNode2 graphNode2 : allNodes) {

            System.out.print("Node:" + graphNode2.value + "  Links:");
            for (GraphNode2 node2 : graphNode2.edges) {
                System.out.print(node2.value + " ");

            }
            System.out.println();

        }
    }

    public static GraphNode2 searchOrMakeNode(Integer value)
    {

        if (allNodes != null)
        {
            for (GraphNode2 temp: allNodes) {
                if(temp.value == value)
                    return temp;

            }
        }


        GraphNode2 temp2 = new GraphNode2(value);
        allNodes.add(temp2);
        return temp2;

    }
}

class GraphNode2{

    public Integer value;
    public List<GraphNode2> edges;

    GraphNode2(Integer value)
    {
        this.value = value;
        edges = new ArrayList<>();
    }

    public void addDirectedEdge(GraphNode2 i)
    {
       this.edges.add(i);
    }
}


/*
9
1 2
2 3
3 4
2 4
1 3
2 8
5 7
6 7
5 6


 */