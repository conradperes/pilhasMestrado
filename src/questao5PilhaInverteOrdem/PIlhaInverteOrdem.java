package questao5PilhaInverteOrdem;

import java.util.Stack;

import br.edu.fasul.lac.estruturas.Pilha;
import deque.Deque;
import deque.PilhaMinAuxiliar;

public class PIlhaInverteOrdem extends Pilha {
	Pilha pilhaOrdenada;
	String elementoInicial;
	boolean menorPreenchido = false;
	Deque pilhaBase;
	Pilha min;

	public String getElementoInicial() {
		return elementoInicial;
	}

	public void setElementoInicial(String elementoInicial) {
		this.elementoInicial = elementoInicial;
	}

	public PIlhaInverteOrdem() {
		super();
		min = new Pilha();
	}

	/**
	 * Insere elementos ordenados usando a PilhaMin como base para pegar o menor
	 * elemento e inserir no primeiro elemento dessa nova pilha ordenada
	 * 
	 * @param elemento
	 * @param pilhaMin
	 * @param pilhaAux
	 */
	public void queue(Pilha pilhaAux, PIlhaInverteOrdem ordered) {
		
		String topoAux = (String) pilhaAux.verificarFinal();
		ordered.insere(topoAux);
		pilhaAux.retira();
	}

	// void pilha_ordenar_itens( pilha_t * p ){
	// for( int i = 0; i < p->qtd; i++ ){
	// for( int j = i + 1; j < p->qtd; j++ ){
	// if( p->item[i] > p->item[j] ){
	// int aux = p->item[i];
	// p->item[i] = p->item[j];
	// p->item[j] = aux;
	// }
	// }
	// }
	// }
	
	public Stack ordenar(Stack pilha) {
		Stack ordenados = new Stack<>();
		for (int i = 0; i < pilha.size(); i++) {
			for (int j = i+1; j < pilha.size(); j++) {
				if(new Integer(pilha.elementAt(i).toString())>new Integer(pilha.elementAt(j).toString())) {
					int aux = new Integer(pilha.elementAt(i).toString());
					ordenados.insertElementAt(pilha.elementAt(j),i);
					//ordenados.remove(i);
				}
			}
		}
		return ordenados;
	}
	
	
	/**
	 * Algoritmo O(N) que pega os elementos de uma pilha e 
	 * adiciona na pilha Ordenada
	 * @param p
	 * @param ordenada
	 * @return
	 */
	public Pilha inverteOrdem(Pilha p, Pilha ordenada) {
		if (p.isVazia())
			return ordenada;
		int dado, aux = 0;
		aux = Integer.parseInt(p.retira().toString());
		ordenada.insere(aux);
		while (!p.isVazia()) {
			dado = Integer.parseInt(p.retira().toString());
			if (aux <= dado) {
				aux = dado;
				ordenada.insere(aux);
			} else {
				ordenada.insere(dado);
			}

		}
		return ordenada;
	}

	public String menorElementoPilha() {
		PilhaMinAuxiliar aux = new PilhaMinAuxiliar();
		return aux.testRetornaMenorElemento();
	}

	public Deque getPilhaMin() {
		PilhaMinAuxiliar aux = new PilhaMinAuxiliar();
		return aux.inserirPilhaMin();
	}

	public String getMenor(Pilha a) {
		for (String e : a.getPilha().listar()) {
			queue(e);
		}
		return (String) min.verificarFinal();
	}

	public Pilha ordenacao(Pilha p, Pilha ordenada) {
		if (p.isVazia())
			return ordenada;
		int dado, aux = 0;
		ordenada.insere(getMenor(p));
		aux = Integer.parseInt(p.retira().toString());
		while (!p.isVazia()) {
			dado = Integer.parseInt(p.retira().toString());
			if (aux <= dado) {
				aux = dado;
				ordenada.insere(aux);
			} else {
				ordenada.insere(dado);
			}
		}
		return ordenada;
	}
	

	public void queue(String elemento) {
		String topo ="";
		if (min.isVazia())
			min.insere(elemento);
		else
			 topo = (String) min.getPilha().verificarInicio();
		if (!elemento.isEmpty() && !topo.isEmpty() && Integer.parseInt(elemento) <= Integer.parseInt(topo))
			min.insere(elemento);
	}

}
