import java.util.*; 
import java.lang.*; 
import java.io.*; 
public class main2 {
	public static void main (String[] args) 
    { 
        /* Let us create the following weighted graph 
           10 
        (0)------->(3) 
        |         /|\ 
        5 |          | 
        |          | 1 
        \|/         | 
        (1)------->(2) 
           3           */
        int graph[][] = { {0,   5,  99999, 10,0}, 
                          {99999, 0,   3, 99999,0}, 
                          {99999, 99999, 0,   1,0}, 
                          {99999, 99999, 99999, 0,0},
                          {99999, 99999, 99999, 0,0} 
                        }; 
        AllPairShortestPath a = new AllPairShortestPath(); 
  
        // Print the solution 
        a.floydWarshall(graph); 
    } 
} 
