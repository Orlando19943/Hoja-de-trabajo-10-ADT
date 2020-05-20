import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
	public static void main(String[] args) throws FileNotFoundException, IOException  {
		// TODO Auto-generated method stub
		int n1 = 0; //Contador para la posicion de la primera coma
		int n2 = 0; //Contador para la separacon de las palabras
		int n3 = 0; //Contador para guardar desde la linea donde empiezan las palabras
		ArrayList <Node> nodos = new ArrayList<Node>();
		Graph graph = new Graph();
		Scanner teclado = new Scanner (System.in);
		//Cambiar esto para que le de al usuario la opcion de ingresar el nombre de los documentos (cuando ya este listo el programa)
		System.out.println("Introduzca el nombre del primer documento (Spanish.txt)"); 
		String documento;	
		String vertice1 = " "; //String que guarda el primer vertice de cada linea
		 
		String vertice2 = " "; //String que guarda el segundo vertice de cada linea
		int costo = 0;	//Variable que guarda el costo de ir de un vertice a otro 
		//String traduccion; //String que guarda la traduccion
		documento = teclado.nextLine();
		
		//------------------Leer el archivo y ordenar los pacientes por prioridad----------------------
	    try {
	      FileReader fr = new FileReader("guategrafo");
	      BufferedReader br = new BufferedReader(fr);
	      String linea;	      
	      while((linea = br.readLine()) != null) {	
	    	  n1 = 0;
	    	  n2 = 0;
	    	  for (int i = 0; i<linea.length(); i++) {
	    		  //Obtengo la posicion del primer espacio (la separacion no son espacios, son tabs (ーー;) ), para empezar a copiar desde ahi la traduccion
	    		  if (linea.substring(i,i+1).equals(" ")){
	    			 n1 = i; 
	    		  }
	    		//Obtengo la posicion del segundo espacio
	    		  else if (linea.substring(i,i+1).equals(" ") && n1!=0){
	    			  n2 = i;		    			  
	    			  break;
	    		  }
	    	  }
	    	  vertice1 = linea.substring(0,n1);
	    	  vertice2 = linea.substring(n1+1,n2);
	    	  costo = Integer.parseInt(linea.substring(n2+1, linea.length()));
	    	  
	    	  

	      }
	      	        
	      fr.close();
	    }
	    catch(Exception e) {
	      System.out.println("Excepcion leyendo fichero "+ documento + ": " + e);
	    }
	   
	    
	}
	

}
