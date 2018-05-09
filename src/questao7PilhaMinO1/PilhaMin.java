package questao7PilhaMinO1;

import deque.Deque;

public class PilhaMin extends Deque {

	public Deque getPilha() {
		return pilha;
	}



	public void setPilha(Deque pilha) {
		this.pilha = pilha;
	}



	Deque pilha;
	
	public PilhaMin(String elemento) {
		super();
		this.pilha = new Deque();
		pilha.inserirInicio(elemento);
	}
	public PilhaMin() {
		super();
		this.pilha = new Deque();
	}

	/**
	 * Complexidade O(1)
	 * @param elemento
	 */
	public void queue(String elemento) {
		String topo = pilha.topo();
		if(topo.isEmpty())
			pilha.inserirInicio(elemento);
		else
		if(!elemento.isEmpty() && !topo.isEmpty() && Integer.parseInt(elemento)<=Integer.parseInt(topo))
			pilha.inserirInicio(elemento);
	}
	
	
	
	public String retornaElementoComMenorChave(Deque pilha) {
		return pilha.topo();
	}
}
