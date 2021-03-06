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
		int m,n,n1,n2,n3,peso = 0; //Contadores que utilizo para varias funciones
		String cadena,cadena2,cadena3="";//Cadenas donde guardo temporarmente datos
		ArrayList <String> nodos = new ArrayList<String>();//Los nodos
		ArrayList <String> costos = new ArrayList<String>();//Los costos o las distancias (miralo como quieras :) )
		Scanner teclado = new Scanner (System.in);
		//Cambiar esto para que le de al usuario la opcion de ingresar el nombre de los documentos (cuando ya este listo el programa)
		System.out.println("Introduzca el nombre del primer documento (guategrafo.txt)"); 
		String documento;
		Controlador controlador;
		documento = teclado.nextLine();
		int matriz[][];
		ArrayList<String> listaNodos;
		
		//------------------Leer el archivo y sacar los vertices----------------------
	    try {
	      FileReader fr = new FileReader(documento);
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
	      System.out.println("No se encontro el archivo");
	    }    
	    controlador = new Controlador();
	    controlador.vertices(nodos, costos);
	    listaNodos =  controlador.obtenerVertices();
	    matriz = controlador.obtenerMatriz();
	    n = 0;
	    while (n<5) {
			do {
				try {
					System.out.println("Que desea hacer?");
		    	
					System.out.println("1.Viajar\n2.Ver ciudad del centro\n3.Modificar rutas\n4.Ver matriz\n5.Salir");
		    	
					n = teclado.nextInt();
					if (n == 1) {
						listaNodos =  controlador.obtenerVertices();
						cadena2 = "Las ciudades registradas son: ";
						for (int i = 0; i < listaNodos.size(); i++) {
							cadena2 = cadena2 + "\n" + listaNodos.get(i);
							}
						System.out.println(cadena2);
						System.out.println("Cual es su ciudad de origen?(escriba el nombre exactamente igual)");
						teclado.nextLine();
						cadena = teclado.nextLine();
						System.out.println("Hacia que ciudad desea ir?(escriba el nombre exactamente igual)");
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
							System.out.println(controlador.crearGrafo(n1, n2));
							}
						}else {
							System.out.println("Una de las ciudades que ingreso no se encuentra registrada. Recuerde verificar Mayusculas, signos u ortografia");
						}
			    	}
			    	if (n == 2) {
			    		controlador.vertices(nodos, costos);
			    	    listaNodos =  controlador.obtenerVertices();
			    	    matriz = controlador.obtenerMatriz();
			    	    AllPairShortestPath a = new AllPairShortestPath(); 
			    	    a.setV(listaNodos.size());
			    	    matriz = a.floydWarshall(matriz);
			    	    System.out.println(controlador.centroGrafo());
			    	}
			    	if (n == 3) {
			    			
			    			System.out.println("1.Interrupcion en el trafico\n2.Nueva ruta");
				    		m = teclado.nextInt();
				    		if (m == 1) {
				    			n1 = 1;
				    			for (int i =0; i<nodos.size();i = i+2) {
				    				cadena = nodos.get(i);
				    				cadena2 = nodos.get(i+1);
				    				peso = Integer.parseInt(costos.get(i/2));
				    				System.out.println(n1 +"." + cadena + "->" + cadena2 +" "+ peso);
				    				n1++;
				    			}
				    			System.out.println("Que ruta desea cambiar?");
				    			n2 = teclado.nextInt();
				    			System.out.println("Que distancia nueva desea cambiarle? (si desea bloquear esta ruta, escriba 'eliminar'");
				    			teclado.nextLine();
				    			cadena = teclado.nextLine();
				    			if (cadena.equals("eliminar")) {
				    				costos.remove(n2-1);
				    				nodos.remove((n2-1)*2);
				    				nodos.remove((n2-1)*2);
				    			}else {
				    				costos.set(n2-1, cadena);
				    			}
				    			controlador.vertices(nodos, costos);
				    		    listaNodos =  controlador.obtenerVertices();
				    		    matriz = controlador.obtenerMatriz();
				    			 

				    		}
				    		else if (m == 2) {
				    			System.out.println("Ingrese la nueva ruta");
				    			System.out.println("Ciudad inicial: ");
				    			teclado.nextLine();
				    			cadena = teclado.nextLine();
				    			System.out.println("Ciudad destino: ");
				    			cadena2 = teclado.nextLine();
				    			System.out.println("Distancia entre cada una: ");
				    			cadena3 = teclado.nextLine();
				    			nodos.add(cadena);
				  	    	    nodos.add(cadena2);
				  	    	    costos.add(cadena3);
				  	    	    controlador.vertices(nodos, costos);
				    		    listaNodos =  controlador.obtenerVertices();
				    		    matriz = controlador.obtenerMatriz();
				    		} 
			    		
			    		
			    	}
			    	if (n == 4) {
			    		listaNodos = controlador.obtenerVertices();
			    		System.out.println("El numero representa la fila/columna en la que se encuentra la ciudad de izquierda a derecha");
			    		for (int i = 0; i< listaNodos.size();i++) {
			    			System.out.println(i+1 +"." +listaNodos.get(i));
			    		}
			    		AllPairShortestPath a = new AllPairShortestPath();
			    		matriz = controlador.obtenerMatriz();
			    	    a.setV(listaNodos.size());
			    	    a.floydWarshall(matriz);
			    	    a.printSolution(matriz);	
			    	}
					
				}catch (Exception e) {
					System.out.println("Introduzca correctamente el numero " + e);
					teclado.nextLine();
				}
			}while (n>5||n<0);
	    
	    
        
        
	    
	    //--------------------------------------------------
	    
	    
	    //
}
}
	
}
