import java.util.ArrayList;
import java.util.HashSet;

/**
 * 
 */

/**
 * @author Orlando
 *
 */
public class Controlador {
	int[][] matriz;
	ArrayList<String> listaNodos;
	
	public int[][] obtenerMatriz() {
		return matriz;
	}
	public ArrayList<String> obtenerVertices() {
		return listaNodos;
	}
	public void vertices(ArrayList<String> nodos,ArrayList<String> costos) {
		listaNodos = new ArrayList<String>(new HashSet<String>(nodos));
	    for (int i = 0; i<listaNodos.size();i++) {
	  		  System.out.println("Las ciudades registradas son: " + listaNodos.get(i));
	  	  }	    
	    int n3 = listaNodos.size();
	    System.out.println("La cantidad de vertices es: " + n3);
	    crearMatriz(n3,nodos,listaNodos,costos);
	}
	public void crearMatriz (int n3,ArrayList<String> nodos,ArrayList<String> listaNodos,ArrayList<String> costos) {
		int n1,n2,p,peso;
		matriz = new int [n3][n3];
		String vertice1;
		n1 = 0;
	    for (int i = 0; i < n3; i++) {
	    	n2 =0;
	    	vertice1 = listaNodos.get(i);
	    	for (int j = 0; j<nodos.size();j = j+2) {
	    		if (n1 == n2) {
	    			matriz [i][i] = -1;
	    		}else if(vertice1.equals(nodos.get(j))) {
	    			vertice1 = nodos.get(j+1);
	    			p = listaNodos.indexOf(vertice1);
	    			peso = Integer.parseInt(costos.get(j/2));
	    			matriz [i][p] = peso;
	    		}
	    		n2++;
	    	}
	    	n1++;
		}
	    matriz[n3-1][n3-1] = -1;
	    
	    for (int i = 0; i < n3; i++) {
	    	for (int j = 0; j < n3; j++) {
	    		if(matriz[i][j]==0) {
		    		matriz[i][j] = 999999;
		    	}	
	    	}	    		    	
		}
	    for (int i = 0; i < n3; i++) {
	    	matriz[i][i] = 0;	    		    	
		}
	    AllPairShortestPath a = new AllPairShortestPath(); 
	    a.setV(n3);
	    a.floydWarshall(matriz); 
	}
	

}
