package deque;

import br.edu.fasul.lac.estruturas.Pilha;

public class PilhaOrdenada extends Pilha {
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

	public PilhaOrdenada() {
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
	public void queue(Pilha pilhaAux, PilhaOrdenada ordered) {
		// String topoAux = pilhaAux.topo();
		// if (!menorPreenchido) {
		// pilhaOrdenada.inserirInicio(menorElemento);
		// menorPreenchido = true;
		// } else {
		// String topoOrdenado = pilhaOrdenada.topo();
		// if (!elemento.isEmpty() && !menorElemento.isEmpty()
		// && Integer.parseInt(menorElemento) <= Integer.parseInt(elemento)) {
		// pilhaOrdenada.inserirInicio(elemento);
		// // pilhaAux.removeInicio();
		// }
		// }
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
		//p.getPilha().removerDoInicio();
		aux = Integer.parseInt(p.retira().toString());
//		int i=0;
		while (!p.isVazia()) {
			dado = Integer.parseInt(p.retira().toString());
//			i++;
//			if(!p.getPilha().isVazia() && p.getPilha().listar().size()==i)
//				ordenada.insere(p.getPilha().verificarInicio());
//			else
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
