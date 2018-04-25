package deque;

public class PilhaMin extends Deque {

	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String retornaElementoComMenorChave(Deque pilha) {
		String []elementos = pilha.getElementos();
		int aux;
		for (int i = 0; i < elementos.length; i++) {
			aux =i;
			elementos[i]=""+elementos.length;
			elementos[elementos.length]=""+aux;
			
		}
		return elementos[0];
	}
}
