import java.util.ArrayList;

public class cycleDetection{
    static class Edge
    {
        int src ;
        int dest ; 
        Edge(int src , int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(int v , ArrayList<Edge> graph[])
    {
        for(int i = 0 ; i < v ; i++)
        {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        
        graph[6].add(new Edge(6 , 5));


    }

    public static void dfs(ArrayList<Edge> graph[] , boolean vis[] , int curr){

        vis[curr] = true;
        System.out.print(curr+" ");

        for(int i = 0 ; i < graph[curr].size();i++)
        {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest])
            {
                dfs(graph, vis, e.dest);
            }
        }

    }

    public static boolean cycleDetect(ArrayList<Edge> graph[],boolean vis[] ,int curr,int par)
    {
        vis[curr] = true;

        for(int i = 0 ; i < graph[curr].size() ; i++)
        {
            Edge e = graph[curr].get(i);

            if(!vis[e.dest])
            { if(cycleDetect(graph, vis, e.dest, curr))
                return true;
            }
            else if(vis[e.dest] && e.dest != par)
            {   
                return true;
            }
        }

        return false;
    }

    public static void main(String [] args)
    {
        int  v = 7;
        ArrayList<Edge> [] graph = new ArrayList[7];
        createGraph(v, graph);
        boolean vis[] = new boolean[v];
        for(int i = 0 ; i < v ; i++)
        {
            if(!vis[i])
            {
                dfs(graph, vis, i);
            }
        }

        System.out.println(cycleDetect(graph, new boolean[v], 0, -1));

    }
}
