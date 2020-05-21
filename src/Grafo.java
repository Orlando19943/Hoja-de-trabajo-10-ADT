public final class Grafo {
	private int nnodos;
	private int nodos[][][];
	private String nombres[];
	Grafo(int n) {
		this.nnodos = n;
		this.nodos = new int[nnodos][nnodos][2];
		this.nombres = new String[nnodos];
	}
	public void ingresarArco(int n1, int n2, int peso) {
		this.nodos[n1][n2][0] = peso;
		this.nodos[n2][n1][0] = peso;
		this.nodos[n1][n2][1] = n1;
		this.nodos[n2][n1][1] = n2;
	}
	public void ingresarNombre(int nodo, String letra) {
		this.nombres[nodo] = letra;
	}
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
	public int pesominimo(int org, int des) {
		return this.nodos[org][des][0];
	}
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
	public String getNombre(int nodo) {
		return this.nombres[nodo];
	}
}
