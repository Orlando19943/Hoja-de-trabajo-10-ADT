import java.util.*; 
import java.lang.*; 
import java.io.*; 
/**
 * 
 * @author Orlando
 * @author https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/
 */
public class AllPairShortestPath {
	final  int INF = 99999;
	int V = 5; 
	/**
	 * @post: crea la matriz con la cantidad de filas y columnas segun vertices haya
	 * @param V
	 */
	public void setV (int V) {
		this.V = V;
	}
	/**
	 * @pre: Existen una matriz de adyacencia
	 * @post: Devuelve la matriz ya usando el algorito de floyd
	 * @return la matriz 
	 */
    int[][] floydWarshall(int graph[][]) 
    { 
        int dist[][] = new int[V][V]; 
        int i, j, k; 
  
        /* Initialize the solution matrix same as input graph matrix. 
           Or we can say the initial values of shortest distances 
           are based on shortest paths considering no intermediate 
           vertex. */
        for (i = 0; i < V; i++) 
            for (j = 0; j < V; j++) 
                dist[i][j] = graph[i][j]; 
  
        /* Add all vertices one by one to the set of intermediate 
           vertices. 
          ---> Before start of an iteration, we have shortest 
               distances between all pairs of vertices such that 
               the shortest distances consider only the vertices in 
               set {0, 1, 2, .. k-1} as intermediate vertices. 
          ----> After the end of an iteration, vertex no. k is added 
                to the set of intermediate vertices and the set 
                becomes {0, 1, 2, .. k} */
        for (k = 0; k < V; k++) 
        { 
            // Pick all vertices as source one by one 
            for (i = 0; i < V; i++) 
            { 
                // Pick all vertices as destination for the 
                // above picked source 
                for (j = 0; j < V; j++) 
                { 
                    // If vertex k is on the shortest path from 
                    // i to j, then update the value of dist[i][j] 
                    if (dist[i][k] + dist[k][j] < dist[i][j]) 
                        dist[i][j] = dist[i][k] + dist[k][j];
                    if ( dist[i][k] != INF && 
                    	     dist[k][j] != INF && 
                    	     dist[i][k] + dist[k][j] < dist[i][j]
                    	    )
                    	 dist[i][j] = dist[i][k] + dist[k][j];
                } 
            } 
        } 
        return dist;
        }
        
        void printSolution(int dist[][]) 
        { 
            
            
            for (int i=0; i<V; ++i) 
            { 
                for (int j=0; j<V; ++j) 
                { 
                    if (dist[i][j]==999999) 
                        System.out.print("INF "); 
                    else
                        System.out.print(dist[i][j]+"   ");
                    
                } 
                System.out.println(); 
            } 
        } 
    }

