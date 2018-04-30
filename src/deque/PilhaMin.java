package deque;

public class PilhaMin extends Deque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String retornaElementoComMenorChave(Deque pilha) {
		String[] elementos = pilha.getElementos();
		int indiceComMenorChave = 0;
		int maiorContagem=pilha.getContador();
		for (int i = 0; i < elementos.length; i++) {
			if(i<maiorContagem)
				indiceComMenorChave=i;
		}
		return elementos[indiceComMenorChave];
	}
}
