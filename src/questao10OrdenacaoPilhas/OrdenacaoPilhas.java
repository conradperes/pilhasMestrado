package questao10OrdenacaoPilhas;

/**
 *
 * @author Conrad
 */
public class OrdenacaoPilhas {
	public static int tamanhoPilha = 5;
	public static int[] pilha1 = new int[tamanhoPilha];
	public static int[] pilha2 = new int[tamanhoPilha];
	public static int topo = -1;
	public static int topoB = -1;

	/**
	 * Complexidade O(1)
	 * 
	 * @param valor
	 */
	public static void push(int valor) { // função para inserir na pilha A
		if (topo < tamanhoPilha) {
			topo++;
			pilha1[topo] = valor;
		}
	}// fim função push A

	/**
	 * Complexidade O(1)
	 * 
	 * @param vlr
	 */
	public static void pushB(int vlr) { // função para inserir na pilha B
		if (topoB < tamanhoPilha) {
			topoB++;
			pilha2[topoB] = vlr;
		}
	}// fim função push B

	/**
	 * Complexidade O(N)
	 * 
	 * @return
	 */
	public static String exibePilha() { // função para exibir a pilha A
		String str = "";

		for (int i = topo; i > -1; i--) {
			str += pilha1[i];
		}
		return str;
	}

	/**
	 * Complexidade O(N2)
	 * 
	 * @param str
	 * @return
	 */
	public static String ordStr(String str) { // função para ordenar
		int aux;
		String strR = "";
		int[] v = new int[5];

		for (int i = topo; i > -1; i--) { // transfere os elementos da pilha para o vetor
			v[i] += pilha1[i];
		}

		for (int i = 0; i < v.length; i++) { // ordena os elementos
			for (int j = i + 1; j < v.length; j++) {
				if (v[i] > v[j]) {
					aux = v[i];
					v[i] = v[j];
					v[j] = aux;
				} // fim if
			} // fim for j
		} // fim for i

		for (int i = 0; i < v.length; i++) {// transfere os elementos para uma string
			int a = v[i];
			pushB(a);
		}
		for (int i = 0; i < v.length; i++) {// transfere os elementos para uma string
			strR += pilha2[i];
		}
		return strR; // retorna a string ordenada
	}

	/**
	 * Complexidade O(N2)
	 * @param args
	 */
	public static void main(String[] args) {
		// Variaveis locais
		String str;
		String strOrd;

		// pilha A
		push(3);
		push(4);
		push(1);
		push(5);
		push(2);

		// uso das funções
		str = exibePilha(); // retorna a pilha A
		strOrd = ordStr(str); // retorna a pilha B

		System.out.println("Pilha A: " + str);
		System.out.println( "Pilha B: " + strOrd);

	} // fim do main
} // fim da classe
