package pilhaEncadeada;

import java.util.ArrayList;

public class Pilha {
	// Variavel para definição do topo da pilha.
	Nodo topo = null;

	// Método que empilha valores.
	public void empilha(String valor) {
		Nodo novo = new Nodo();
		novo.setValor(valor);
		novo.setAnterior(topo);
		topo = novo;
	}

	// Método para desempilhar valores
	public String desempilha() throws EmptyStackException {
		if (topo == null) {
			throw new EmptyStackException("A pilha está vazia");
		} else {
			String valor = topo.getValor();
			topo = topo.getAnterior();
			return valor;
		}
	}

	public String topo() throws EmptyStackException {
		if (topo == null) {
			throw new EmptyStackException("Pilha vazia");
		} else
			return topo.getValor();
	}

	public String anterior() throws EmptyStackException {
		if (topo == null) {
			throw new EmptyStackException("Pilha vazia");
		} else
			return topo.getAnterior().getValor();
	}

	public String anterior(int qtde) throws Exception {
		String elemento = null;
		if (topo == null) {
			throw new EmptyStackException("Pilha vazia");
		} else {
			for (int i = 0; i < qtde; i++)
				if(topo.getAnterior().getAnterior().getAnterior()!=null)
					elemento = topo.getAnterior().getAnterior().getAnterior().getValor();
		}
		return elemento;
	}

	// Método para listar pilha. Percorre os nós da pilha atribuindo seus valores em
	// um ArrayList
	public ArrayList<String> Listar() throws EmptyStackException {
		if (topo == null) {
			throw new EmptyStackException("A pilha está vazia");
		} else {
			ArrayList<String> listar = new ArrayList<String>();
			Nodo aux = topo;
			while (aux != null) {
				listar.add(aux.getValor());
				aux = aux.getAnterior();
			}
			return listar;
		}
	}

	public void print() {
		ArrayList<String> lista = Listar();
		if (lista.isEmpty())
			System.out.println("Pilha Vazia");
		else
		for (String elemento : lista)
			System.out.println(elemento);
	}

	// Método para listar pilha. Percorre os nós da pilha atribuindo seus valores em
	// um ArrayList
	public String obtemPrimeiroElemento() throws EmptyStackException {
		if (topo == null) {
			throw new EmptyStackException("A pilha está vazia");
		} else {
			ArrayList<String> listar = new ArrayList<String>();
			Nodo aux = topo;
			while (aux != null) {
				listar.add(aux.getValor());
				aux = aux.getAnterior();
			}
			int i = 0;
			for (String elemento : listar) {
				i++;
				if (i == listar.size())
					return elemento;

			}
			return null;
		}
	}
}
