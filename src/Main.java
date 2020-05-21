import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Orlando
 *
 */
public class Main {

	/**
	 * @param args
	 */
	@SuppressWarnings("null")
	public static void main(String[] args) throws FileNotFoundException, IOException  {
		// TODO Auto-generated method stub
		int n1,n2,n3 = 0; //Contador para la posicion de la primera coma
		ArrayList <String> nodos = new ArrayList<String>();
		ArrayList<String> listaNodos = new ArrayList<String>();
		ArrayList <String> costos = new ArrayList<String>();
		Scanner teclado = new Scanner (System.in);
		//Cambiar esto para que le de al usuario la opcion de ingresar el nombre de los documentos (cuando ya este listo el programa)
		System.out.println("Introduzca el nombre del primer documento (Spanish.txt)"); 
		String documento, nombre;	
		String vertice1 = " "; //String que guarda el primer vertice de cada linea
		String vertice2 = " "; //String que guarda el segundo vertice de cada linea
		int costo,o = 0,p,peso = 0;	//Variable que guarda el costo de ir de un vertice a otro 
		int numeroDeVertices = 0;
		documento = teclado.nextLine();
		Grafo g;
		int [][] matriz;
	
		
		//------------------Leer el archivo y ordenar los pacientes por prioridad----------------------
	    try {
	      FileReader fr = new FileReader("guategrafo.txt");
	      BufferedReader br = new BufferedReader(fr);
	      String linea;	      
	      while((linea = br.readLine()) != null) {	
	    	  n1 = 0;
	    	  n2 = 0;
	    	  o = 0;
	    	  for (int i = 0; i<linea.length(); i++) {
	    		  if (linea.substring(i,i+1).equals(" ")&& n1==0){
	    			 n1 = i; 
	    			 
	    		  }
	    		  else if (linea.substring(i,i+1).equals(" ") && n1!=0){
	    			  n2 = i;		    			  
	    			  break;
	    		  }
	    	  }
	    	  nodos.add(linea.substring(0,n1));
	    	  nodos.add(linea.substring(n1+1,n2));
	    	  costos.add(linea.substring(n2+1,linea.length()));

	      }
	      
	      fr.close();
	    }
	    catch(Exception e) {
	      System.out.println("Excepcion leyendo fichero "+ documento + ": " + e);
	    }

	    //Hago una lista solamente con los nodos que va a tener el grafo 
	    nodos.remove(nodos.size()-1);
	    listaNodos = new ArrayList<String>(new HashSet<String>(nodos));
	    for (int i = 0; i<listaNodos.size();i++) {
	  		  System.out.println("Los vertices son: " + listaNodos.get(i));
	  	  }
	    
	    //--------------------------------------------------
	    n3 = listaNodos.size();
	    System.out.println("La cantidad de vertices es: " + n3);
	    g = new Grafo(n3);
	    matriz = new int [n3][n3];
	    //Ingreso los nodos al grafo
	    for (int i = 0; i < n3; i++) {			
			g.ingresarNombre(i, listaNodos.get(i));
		}
	    //--------------------------------------------------
	    //Saco las parejas y hago las uniones entre cada uno junto con sus costos
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
	    
	    
	    
        // Print the solution 
        
	    
	    //--------------------------------------------------
	    
	    
	    //
}
}
