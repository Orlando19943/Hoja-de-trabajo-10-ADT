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
	ArrayList<String> nodos;
	ArrayList<String> costos;
	/**
	 * @pre: Existen vertices
	 * @post: Devuelve la matriz asociada con las relaciones de los vertices
	 * @return la matriz 
	 */
	public int[][] obtenerMatriz() {
		return matriz;
	}
	/**
	 * @pre: Existen vertices
	 * @post: Devuelve los vertices
	 * @return los vertices
	 */
	public ArrayList<String> obtenerVertices() {
		return listaNodos;
	}
	/**
	 * @pre: Existen vertices
	 * @post: Crea los datos necesarios para hacer la matriz
	 * 
	 */
	public void vertices(ArrayList<String> nodos,ArrayList<String> costos) {
		listaNodos = new ArrayList<String>(new HashSet<String>(nodos));   
		this.nodos = (ArrayList<String>) nodos.clone();
		this.costos = (ArrayList<String>) costos.clone();
	    int n3 = listaNodos.size();
	    crearMatriz(n3,nodos,listaNodos,costos);
	}
	/**
	 * @pre: Existen vertices
	 * @post: Crea la matriz
	 * 
	 */
	public void crearMatriz (int n3,ArrayList<String> nodos,ArrayList<String> listaNodos,ArrayList<String> costos) {
		int n1,n2,n4 = 0,p,peso;
		matriz = new int [n3][n3];	
		String vertice1;
		n1 = 0;
	    for (int i = 0; i < listaNodos.size(); i++) {
	    	n2 =0;	    	
	    	vertice1 = listaNodos.get(i);
	    	for (int j = 0; j<nodos.size();j = j+2) {
	    		if (n1 == n2) {
	    			matriz [i][i] = -1;
	    		}else if(vertice1.compareTo(nodos.get(j))==0) {
	    			p = listaNodos.indexOf(nodos.get(j+1));
	    			peso = Integer.parseInt(costos.get(j/2));
	    			matriz [i][p] = peso;
	    			
	    			n4++;
	    		}
	    		n2++;
	    		
	    	}
	    	
	    	n4 = 0;
	    	n1++;
		}
	    
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
	    matriz = a.floydWarshall(matriz);	    	     
	}
	/**
	 * @pre: Existen vertices
	 * @post: Devuelve el centro del grafo
	 * @return el centro del grafo 
	 */
	public String centroGrafo () {
		ArrayList<Integer> centros = new ArrayList<Integer>();
		int menor = matriz[0][1];
		int n = 0,n1 =0;
		String centro = "";
		for (int i =0; i<listaNodos.size();i++) {
			if (matriz[0][i] !=0) {
			menor = matriz[0][i];
			}
			for (int j =0; j<listaNodos.size();j++) {
			    if (menor < matriz[j][i]&& i != j) {
			    	menor = matriz[j][i];			    	
			    }
			   }
			centros.add(menor);
		   }
		n = centros.get(0);
		for (int i =0; i<centros.size();i++) {
			if (n > centros.get(i)) {
		    	n = centros.get(i);
		    }
		   }
		n1 = centros.indexOf(n);
		centro = listaNodos.get(n1);
		return "El centro del grafo es: " + centro;
	}
	/**
	 * @pre: Existen vertices
	 * @post: Crea el grafo
	 * @return el camino corto entre dos vertices
	 */
		public String crearGrafo (int l, int h) {
			int p,peso = 0;
			boolean estado = false;
			String caminoCorto = "";
		    Grafo g = new Grafo(listaNodos.size());
		    for (int i =0; i<listaNodos.size();i++) {
		    	g.ingresarNombre(i, listaNodos.get(i));
		    }
		    for (int i = 0; i < listaNodos.size(); i++) {
		    	String vertice1 = listaNodos.get(i);
		    	for (int j = 0; j < nodos.size();j = j+2) {
		    		if(vertice1.equals(nodos.get(j))) {
		    			estado = true;		    			
		    		}else {
		    			estado = false;
		    		}
		    	}
		    	for (int j = 0; j < nodos.size();j = j+2) {
		    		if(vertice1.equals(nodos.get(j) ) && estado) {
		    			p = listaNodos.indexOf(nodos.get(j+1));
		    			peso = Integer.parseInt(costos.get(j/2));
		    			g.ingresarArco(i, p, peso);			    			
		    		}else if (!vertice1.equals(nodos.get(j)) && !estado) {
		    			p = listaNodos.indexOf(nodos.get(j+1));
		    			g.ingresarArco(i, p, 999999);		
		    		}
		    	}
			}	    
		    g.calcular();
		    caminoCorto = g.caminocorto(l, h);
		    return caminoCorto;



	    }
	

}
