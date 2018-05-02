package deque;

public class PilhaMin extends Deque {

	/**
	 * Tem que rescrever esse retorno com a complexidade O(1) fazer a inserção com
	 * outra pilha, e ir inserindo com outra pilha e olhar sempre o topo da pilha
	 * auxiliar, e ir comparando e salvar sempre o elemento menor no topo da Pilha
	 * @param pilha
	 * @return
	 */
	public String retornaElementoComMenorChave(Deque pilha) {
		String[] elementos = pilha.getElementos();
		int indiceComMenorChave = 0;
		int maiorContagem = pilha.getContador();
		for (int i = 0; i < elementos.length; i++) {
			if (i < maiorContagem)
				indiceComMenorChave = i;
		}
		return elementos[indiceComMenorChave];
	}
}
