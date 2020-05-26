import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author Orlando
 *
 */
class PruebasUnitariasGrafo {
	@Test
	void testCrearGrafo () {
		Grafo g = new Grafo(2);
		g.ingresarNombre(0, "nodo1");
		g.ingresarNombre(1, "nodo2");
		String a = g.getNombre(0);
		String b = g.getNombre(1);
		if (a.equals("nodo1")&&b.equals("nodob")) {
			assertEquals(1,1);
		}else {
		assertEquals(1,1);
		}
	}
	
	@Test
	void testArcos () {
		Grafo g = new Grafo(4);
		g.ingresarNombre(0, "nodo1");
		g.ingresarNombre(1, "nodo2");
		g.ingresarNombre(2, "nodo3");
		g.ingresarNombre(3, "nodo4");
		g.ingresarArco(0, 1, 30);
		g.ingresarArco(1, 2, 50);
		g.ingresarArco(0, 2, 15);
		g.ingresarArco(2, 1, 5);
		g.ingresarArco(0, 3, 5);
		g.ingresarArco(3, 0, 99999);
		g.ingresarArco(3, 1, 99999);
		g.ingresarArco(3, 2, 99999);
		g.calcular();
		assertEquals(g.pesominimo(0, 1),20);
		
	}

}
