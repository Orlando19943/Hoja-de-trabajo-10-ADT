/**
 * 
 * @author Orlando
 * @author https://dzone.com/articles/camino-mas-corto
 */
public final class Grafo {
	private int nnodos;
	private int nodos[][][];
	private String nombres[];
	/**
	 * 
	 * @post: Contructor
	 * 
	 */
	Grafo(int n) {
		this.nnodos = n;
		this.nodos = new int[nnodos][nnodos][2];
		this.nombres = new String[nnodos];
	}
	/**
	 * @pre: Existen relaciones entre los vertices
	 * @post: Crea las relaciones de los vertices
	 * 
	 */
	public void ingresarArco(int n1, int n2, int peso) {
		this.nodos[n1][n2][0] = peso;
		this.nodos[n2][n1][0] = peso;
		this.nodos[n1][n2][1] = n1;
		this.nodos[n2][n1][1] = n2;
	}
	/**
	 * @pre: Existen vertices
	 * @post: ingresa los vertices en los grafos (no tienen relacion aun)
	 *  
	 */
	public void ingresarNombre(int nodo, String letra) {
		this.nombres[nodo] = letra;
	}
	/**
	 * @pre: Existen vertices con sus relaciones
	 * @post: Realiza los calculos para realizar el grafo
	 * 
	 */
	public void calcular() {
		int i, j, k;
		for (i = 0; i < this.nnodos; i++) {
			for (j = 0; j < this.nnodos; j++) {
				for (k = 0; k < this.nnodos; k++) {
					if (this.nodos[i][k][0] + this.nodos[k][j][0] < this.nodos[i][j][0]) {
						this.nodos[i][j][0] = this.nodos[i][k][0]
								+ this.nodos[k][j][0];
						this.nodos[i][j][1] = k;
					}
				}
			}
		}
	}
	/**
	 * @pre: Existen vertices y relaciones
	 * @post: Devuelve el peso minimo de un vertice a otro
	 * @return el peso minimo de un vertice a otro
	 */
	public int pesominimo(int org, int des) {
		return this.nodos[org][des][0];
	}
	/**
	 * @pre: Existen vertices y relaciones
	 * @post: Devuelve el camino que hay que tomar para tener el peso minimo
	 * @return el camino que hay que tomar para tener el peso minimo
	 */
	public String caminocorto(int org, int des) {
		String cam;
		if (org == des) {
			cam = "->" + nombres[org];
		} else {
			cam = caminocorto(org, this.nodos[org][des][1]) + "->"
					+ nombres[des];
		}
		return cam;
	}
	/**
	 * @pre: Existen vertices
	 * @post: Devuelve el nombre del vertice que se haya escogido
	 * @return el nombre del vertice que se haya escogido
	 */
	public String getNombre(int nodo) {
		return this.nombres[nodo];
	}
}
