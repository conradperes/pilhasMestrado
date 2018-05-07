package deque;

import br.edu.fasul.lac.estruturas.Pilha;

public class PilhaOrdenada extends Pilha {
	Pilha pilhaOrdenada;
	String elementoInicial;
	boolean menorPreenchido = false;

	public String getElementoInicial() {
		return elementoInicial;
	}

	public void setElementoInicial(String elementoInicial) {
		this.elementoInicial = elementoInicial;
	}

	public PilhaOrdenada() {
		super();
	}

	/**
	 * Insere elementos ordenados usando a PilhaMin como base para pegar o menor
	 * elemento e inserir no primeiro elemento dessa nova pilha ordenada
	 * 
	 * @param elemento
	 * @param pilhaMin
	 * @param pilhaAux
	 */
	public void queue(Pilha pilhaAux,PilhaOrdenada ordered) {
//		String topoAux = pilhaAux.topo();
//		if (!menorPreenchido) {
//			pilhaOrdenada.inserirInicio(menorElemento);
//			menorPreenchido = true;
//		} else {
//			String topoOrdenado = pilhaOrdenada.topo();
//			if (!elemento.isEmpty() && !menorElemento.isEmpty()
//					&& Integer.parseInt(menorElemento) <= Integer.parseInt(elemento)) {
//				pilhaOrdenada.inserirInicio(elemento);
//				// pilhaAux.removeInicio();
//			}
//		}
		String topoAux = (String) pilhaAux.verificarFinal();
		ordered.insere(topoAux);
		pilhaAux.retira();
	}
	publiv int pilhaOrdenada(Pilha p) {
		if(p.isVazia())
			return 0;
		int dado, aux=0;
		aux = Integer.parseInt(p.retira());
		while(!p.isVazia()) {
			dado=Integer.parseInt(p.retira());
			if(aux<=dado)
				aux=dado;
			else
				return 0;
		}
		return 1;
	}
	

}
