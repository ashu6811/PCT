import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private Integer V; // number of vertices
    public LinkedList<Integer> adj[]; // neighbour of each vertex;

    Graph(Integer v)
    {
        V = v;
        adj = new LinkedList[v];
        for(int i =0; i<v; i++)
        {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(Integer v, Integer w)
    {
        adj[v].add(w);
    }

    void DFSUtil(Integer v, boolean visited[])
    {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext())
        {
            int n = i.next();
            if(!visited[n])
                DFSUtil(n,visited);
        }
    }
    void DFS (Integer v)
    {
        boolean visited[] = new boolean[V];
        DFSUtil ( v, visited);
    }

    void BFSUtil( boolean visited[], Queue<Integer> queue)
    {
        Integer v = queue.poll();
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext())
        {
            int n = i.next();
            if(!visited[n])
            {
                queue.add(n);
                visited[n]=true;
            }

        }
        if(queue.peek()!=null)
            BFSUtil(visited,queue);
    }
    void BFS (Integer v)
    {
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        BFSUtil ( visited, queue);
    }

    public static void main (String[] args)
    {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.DFS(2);

        System.out.println("\nFollowing is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);
    }
}
