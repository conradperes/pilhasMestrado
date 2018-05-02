package pilhaEncadeada;

public class Nodo {
	private String valor;
	private Nodo anterior;

	// Define nó anterior
	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}

	// Retorna nó anterior.
	public Nodo getAnterior() {
		return anterior;
	}

	// Define valor do nó
	public void setValor(String valor) {
		this.valor = valor;
	}

	// Retorna valor do nó
	public String getValor() {
		return valor;
	}
}