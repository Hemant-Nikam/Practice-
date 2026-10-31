import java.util.ArrayList;
import java.util.PriorityQueue;

public class dijkstra {
    
     static class Edge
    {
        int src ;
        int dest ;
        int wt; 
        Edge(int src , int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(int v , ArrayList<Edge> graph[])
    {
        for(int i = 0 ; i < v ; i++)
        {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1,2));
        graph[0].add(new Edge(0, 2 ,4));

        graph[1].add(new Edge(1, 2,1));
        graph[1].add(new Edge(1, 3,7));

        graph[2].add(new Edge(2, 4 ,3));

        graph[3].add(new Edge(3, 5 ,1));

        graph[4].add(new Edge(4, 3 ,2));
        graph[4].add(new Edge(4, 5,5));

    }
    static class Pair implements Comparable<Pair>{
        int node;
        int wt;
        Pair(int node , int wt)
        {
            this.node = node;
            this.wt = wt;
        }
        
        @Override 
        public int compareTo(Pair p2)
        {       
            return this.wt - p2.wt ;

        }

    }

    public static void dj( ArrayList<Edge> graph[] , boolean vis[] , int curr , int dis[] , int V)
    {
        for(int i = 0 ; i < V ; i ++)
        {
            if(curr != i)
            {
                dis[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue <Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(curr, 0));

        while(!pq.isEmpty())
        {
            Pair p = pq.remove();
            
            vis[p.node] = true;

            for(int i = 0 ; i < graph[p.node].size();i++)
            {
                Edge e = graph[p.node].get(i);
                int  u = e.src;
                int  v = e.dest;

                if(dis[u] + e.wt < dis[v])
                {
                    dis[v] = dis[u] + e.wt ;
                    pq.add(new Pair(v , dis[v]));
                }
            }
        }

        for(int i = 0 ; i < V ; i ++)
        {
            System.out.print(dis[i]+ " ");
        }
    }
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(6, graph);
        dj(graph, new boolean[v], 0, new int[v], v);
    }
}
