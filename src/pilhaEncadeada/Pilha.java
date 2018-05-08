package pilhaEncadeada;

import java.util.ArrayList;

public class Pilha {
	// Variavel para definição do topo da pilha.
	Nodo topo = null;

	/**
	 *  M�todo que empilha valores.
	 *  Complexidade O(1)
	 * @param valor
	 */
	public void empilha(String valor) {
		Nodo novo = new Nodo();
		novo.setValor(valor);
		novo.setAnterior(topo);
		topo = novo;
	}

	/**
	 *  M�todo para desempilhar valores
	 *  Complexidade O(1)
	 * @return
	 * @throws EmptyStackException
	 */
	public String desempilha() throws EmptyStackException {
		if (topo == null) {
			throw new EmptyStackException("A pilha est� vazia");
		} else {
			String valor = topo.getValor();
			topo = topo.getAnterior();
			return valor;
		}
	}

	/**
	 * Complexidade O(1)
	 * 
	 * @return
	 * @throws EmptyStackException
	 */
	public String topo() throws EmptyStackException {
		if (topo == null) {
			throw new EmptyStackException("Pilha vazia");
		} else
			return topo.getValor();
	}

	/**
	 * Complexidade O(1)
	 * 
	 * @return
	 * @throws EmptyStackException
	 */
	public String anterior() throws EmptyStackException {
		if (topo == null) {
			throw new EmptyStackException("Pilha vazia");
		} else
			return topo.getAnterior().getValor();
	}

	/**
	 * Complexidade O(N)
	 * 
	 * @param qtde
	 * @return
	 * @throws Exception
	 */
	public String anterior(int qtde) throws Exception {
		String elemento = null;
		if (topo == null) {
			throw new EmptyStackException("Pilha vazia");
		} else {
			for (int i = 0; i < qtde; i++)
				if (topo.getAnterior().getAnterior().getAnterior() != null)
					elemento = topo.getAnterior().getAnterior().getAnterior().getValor();
		}
		return elemento;
	}

	/**
	 * M�todo para listar pilha. Percorre os nas da pilha atribuindo seus valores em
	 * um ArrayList 
	 * Complexidade O(N)
	 * 
	 * @return
	 * @throws EmptyStackException
	 */
	public ArrayList<String> Listar() throws EmptyStackException {
		if (topo == null) {
			throw new EmptyStackException("A pilha est� vazia");
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

	/**
	 * Complexidade O(N)
	 */
	public void print() {
		ArrayList<String> lista = Listar();
		if (lista.isEmpty())
			System.out.println("Pilha Vazia");
		else
			for (String elemento : lista)
				System.out.println(elemento);
	}

	/**
	 * M�todo para listar pilha. 
	 * Percorre os n�s da pilha atribuindo seus valores
	 * em um ArrayList
	 * Complexidade O(N)
	 * 
	 * @return
	 * @throws EmptyStackException
	 */

	public String obtemPrimeiroElemento() throws EmptyStackException {
		if (topo == null) {
			throw new EmptyStackException("A pilha est� vazia");
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
