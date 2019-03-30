import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//Uses GraphNode as the Base Class
public class DeadlockDetection {

    public  void cycleDetection ( GraphNode graphNode)
    {
        boolean IsCycle =false;
        graphNode.resetVisited(graphNode);
        cycleDetectionUtil(graphNode, IsCycle);

    }

    public  void cycleDetectionUtil(GraphNode graphNode, boolean IsCycle)
    {
        graphNode.visited = true;

        Iterator<GraphNode> i = graphNode.edge.listIterator();
        while (i.hasNext())
        {
            GraphNode temp = i.next();
            if (temp.visited == true)
            {
                IsCycle = true;
                return;
            }
            else
            {
                
            }

        }
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Integer N = input.nextInt();

        Integer tempProcessID, tempHaveResource, tempWantResource;
        //ProcessID -> WantResource
        //HaveResource -> ProcessID
        //all nodes are considered same

        List<Integer> processes = new LinkedList<>();
        List<Integer> resources = new LinkedList<>();
        List<GraphNode> processNodes = new LinkedList<GraphNode>();
        List<GraphNode> resourceNodes = new LinkedList<GraphNode>();
        for(int i =0; i<N; i++)
        {
            tempProcessID = input.nextInt();
            tempHaveResource = input.nextInt();
            tempWantResource = input.nextInt();



            if(!processNodes.contains(tempProcessID))
            {
                // processID appears for the first time
                //make a new node
                GraphNode tempProcessNode = new GraphNode(tempProcessID);
                // add processID to the process list
                processes.add(tempProcessID);
                processNodes.add(tempProcessNode);

                // make nodes for the resources
                if(tempWantResource != -1 )
                {
                    if(!resources.contains(tempWantResource))
                    {
                        GraphNode tempWantResourceNode = new GraphNode(tempWantResource);
                        tempProcessNode.addEdge(tempWantResourceNode);
                        resources.add(tempWantResource);
                        resourceNodes.add(tempWantResourceNode);
                    }
                    else
                    {
                        GraphNode tempWantResourceNode =null;

                        // search the node from the processNodes
                        Iterator<GraphNode> j = resourceNodes.listIterator();
                        while(j.hasNext())
                        {
                            GraphNode temp = j.next();
                            if(temp.ID == tempWantResource)
                            {
                                tempWantResourceNode = temp;
                            }
                        }
                        tempProcessNode.addEdge(tempWantResourceNode);
                    }

                }


                if(tempHaveResource != -1)
                {
                    if(!resources.contains(tempHaveResource))
                    {
                        GraphNode tempHaveResourceNode = new GraphNode(tempHaveResource);
                        tempHaveResourceNode.addEdge(tempProcessNode);
                        resources.add(tempHaveResource);
                        resourceNodes.add(tempHaveResourceNode);
                    }
                    else
                    {
                        GraphNode tempHaveResourceNode =null;

                        // search the node from the processNodes
                        Iterator<GraphNode> j = resourceNodes.listIterator();
                        while(j.hasNext())
                        {
                            GraphNode temp = j.next();
                            if(temp.ID == tempHaveResource)
                            {
                                tempHaveResourceNode = temp;
                            }
                        }
                        tempHaveResourceNode.addEdge(tempProcessNode);
                    }


                }
            }
            else
            {
                GraphNode tempProcessNode =null;

                // search the node from the processNodes
                Iterator<GraphNode> j = processNodes.listIterator();
                while(j.hasNext())
                {
                    GraphNode temp = j.next();
                    if(temp.ID == tempProcessID)
                    {
                        tempProcessNode = temp;
                    }
                }

                // make nodes for the resources
                if(tempWantResource != -1 )
                {

                    GraphNode tempWantResourceNode = new GraphNode(tempWantResource);
                    tempProcessNode.addEdge(tempWantResourceNode);
                    resources.add(tempWantResource);
                }

                if(tempHaveResource != -1)
                {
                    GraphNode tempHaveResourceNode = new GraphNode(tempHaveResource);
                    tempHaveResourceNode.addEdge(tempProcessNode);
                    resources.add(tempHaveResource);
                }


            }


        } // Graph is ready

        GraphNode top = processNodes.get(0);
        top.printDFS(top);
        top.printBFS(top);

    }
}

/*
5
101 7 8
101 9 -1
102 -1 7
102 8 -1
103 -1 9

 */