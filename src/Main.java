import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
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
		int m,n,n1,n2,n3,peso = 0; //Contador para la posicion de la primera coma
		String cadena,cadena2="";
		ArrayList <String> nodos = new ArrayList<String>();
		ArrayList <String> costos = new ArrayList<String>();
		Scanner teclado = new Scanner (System.in);
		//Cambiar esto para que le de al usuario la opcion de ingresar el nombre de los documentos (cuando ya este listo el programa)
		System.out.println("Introduzca el nombre del primer documento (Spanish.txt)"); 
		String documento;
		Controlador controlador;
		documento = teclado.nextLine();
		int matriz[][];
		ArrayList<String> listaNodos;
	
		
		//------------------Leer el archivo y ordenar los pacientes por prioridad----------------------
	    try {
	      FileReader fr = new FileReader("guategrafo.txt");
	      BufferedReader br = new BufferedReader(fr);
	      String linea;	      
	      while((linea = br.readLine()) != null) {	
	    	  n1 = 0;
	    	  n2 = 0;
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
	      
	    }

	    
	    nodos.remove(nodos.size()-1);
	    controlador = new Controlador();
	    controlador.vertices(nodos, costos);
	    matriz = controlador.obtenerMatriz();
	    n = 0;
	    while (n<4) {
			do {
				try {
					System.out.println("Que desea hacer?");
		    	
					System.out.println("1.Viajar\n2.Ver ciudad del centro\n3.Modificar rutas\n4.Salir");
		    	
					n = teclado.nextInt();
					
					if (n == 1) {
						listaNodos =  (ArrayList<String>) controlador.obtenerVertices().clone();
						cadena2 = "Las ciudades registradas son: ";
						for (int i = 0; i < listaNodos.size(); i++) {
							cadena2 = cadena2 + "\n" + listaNodos.get(i);
							}
						System.out.println(cadena2);
						System.out.println("Cual es su ciudad de origen?");
						teclado.nextLine();
						cadena = teclado.nextLine();
						System.out.println("Hacia que ciudad desea ir?");
						cadena2 = teclado.nextLine();
						matriz = controlador.obtenerMatriz();
						n1 = listaNodos.indexOf(cadena);
						n2 = listaNodos.indexOf(cadena2);
						if (n1 >=0 && n2 >=0) {
							peso = matriz[n1][n2];
							if (peso == 999999) {
								System.out.println("No se tiene ningun registro de que sea posible viajar desde "+ cadena + " hasta " + cadena2);
							}else {
							System.out.println("La distancia entre las ciudades " + cadena + " y " + cadena2 + " es: " + peso);
							}
						}else {
							System.out.println("Una de las ciudades que ingreso no se encuentra registrada. Recuerde verificar Mayusculas, signos u ortografia");
						}
			    	}
			    	if (n == 2) {
			    		
			    		
			    	}
			    	if (n == 3) {
			    		
			    			System.out.println("1.Interrupcion en el trafico\n2.Nueva ruta");
				    		m = teclado.nextInt();
				    		if (m == 1) {
				    			
				    			

				    		}//Mostrar las cartas ordenadas por tipo
				    		if (m == 2) {
				    			
				    		} 
			    		
			    		
			    	}
					
				}catch (Exception e) {
					System.out.println("Introduzca correctamente el numero");
					teclado.nextLine();
				}
			}while (n>4||n<0);
	    
	    
        
        
	    
	    //--------------------------------------------------
	    
	    
	    //
}
}
}
