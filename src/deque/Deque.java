package deque;

import java.util.Scanner;

import fila.Fila;
import pilhaEncadeada.EmptyStackException;
import pilhaEncadeada.Pilha;

public class Deque {

	private static final int PILHA_ENCADEADA = 2;
	private static final int PILHA_SEQUENCIAL = 1;
	private String elementos[];
	private Deque proximo;
	private static final int MAX = 10;
	private int contador;

	public String[] getElementos() {
		return elementos;
	}

	public void setElementos(String[] elementos) {
		this.elementos = elementos;
	}
	

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public Deque() {
		super();
		contador = 0;
		elementos = new String[MAX];
	}

	public Deque getProximo() {
		return proximo;
	}

	public void setProximo(Deque proximo) {
		this.proximo = proximo;
	}

	public static void main(String[] args) {
		Deque d = new Deque();
		Pilha pilhaEncadeada = new Pilha();
		Scanner sc = new Scanner(System.in);
		System.out.println("\tEscolha Pilha : 1- Sequencial 2- Encadeada");
		int tipoPilha = sc.nextInt();
		if (tipoPilha == PILHA_SEQUENCIAL) {
			menuPilhaSequencial();
			while (sc.hasNext())
				d.escolheOperacoesSequenciais(d, sc);
		} else if (tipoPilha == PILHA_ENCADEADA) {
			menuPilhaEncadeada();
			while (sc.hasNext())
				d.escolheOperacoesEncadeada(sc, pilhaEncadeada);
		}
	}

	private void escolheOperacoesEncadeada(Scanner sc, Pilha pilha) {
		int op = sc.nextInt();
		switch (op) {
		case 1:
			pilha.empilha(sc.next());
			break;
		case 2:
			pilha.desempilha();
			break;
		case 3:
			System.out.println("\t\nTopo/�ltimo da Pilha Encadeada=" + pilha.topo());
			break;
		case 4:
			System.out.println("\t\nTamanho=\t" + pilha.Listar().size());
			break;
		case 5:
			System.out.println("\t\nObt�m primeiro=\t" + pilha.obtemPrimeiroElemento());
			break;
		case 6:
			System.out.println("\t\nListar tudo=\t" + pilha.Listar());
			break;
		default:
			System.out.println("De 1 a 6 somente!");
			break;
		}
	}

	private static void menuPilhaSequencial() {
		System.out.println("\tDigite a opera��o:\n\t1-Inserir Inicio" + "\n\t2-Inserir no fim\n\t3-Remover Início"
				+ "\n\t4-Remover Fim\n\t5-Varrer pilha" + "\n\t6-Obter Primeiro \n\t7-Obter Último");
	}

	private static void menuPilhaEncadeada() {
		System.out.println("\tDigite a opera��o:\n\t1-Inserir pilha encadeada" + "\n\t2-Desempilhar\n\t3-Topo"
				+ "\n\t4-Tamanho\n\t5-Obtem Primeiro" + "\n\t6-Listar ");
	}

	private void escolheOperacoesSequenciais(Deque d, Scanner sc) {
		int op = sc.nextInt();
		switch (op) {
		case 1:
			System.out.println("\t\n Inserir no início do Deque\n");
			d.inserirInicio(sc.next());
			break;
		case 2:
			System.out.println("\t\n Inserir no fim do Deque\n");
			d.inserirFim(sc.next());
			break;
		case 3:
			System.out.println("\t\nRemove Início");
			d.removeInicio();
			break;
		case 4:
			System.out.println("\t\nRemove Fim");
			d.removeFim();
			break;
		case 5:
			System.out.println("\t\n Varrendo tudo:");
			d.imprimePilha();
			break;
		case 6:
			System.out.println("\t\nTopo\t" + d.topo());
			break;
		case 7:
			System.out.println("\t\nObter último\t" + d.ultimo());
			break;

		default:
			System.out.println("Escolha de 1-7");
			break;
		}

	}

	public void imprimePilha() {
		for (String c : this.elementos) {
			if (c != null)
				System.out.println(c);
		}
	}

	public void inserirInicio(String valor) {
		elementos[contador] = valor;
		contador++;
	}

	/**
	 * Quest�o 2 que insere elementos na Pilha utilizando duas filas como estruturas
	 * auxiliares
	 * 
	 * @param fila1
	 *            Fila 1 auxiliar
	 * @param fila2
	 *            Fila 2 auxiliar
	 * @param elemento
	 *            Elemento a inserir nas Filas
	 */
	public void inserirUsandoFila(Fila fila1, Fila fila2, String elemento) {
		fila1.inserirNaFila(elemento);
		fila2.inserirNaFila(elemento);
		fila1.exibirFila();
		fila2.exibirFila();
		System.out.println("Copiando elementos da Fila para Pilha");
		this.elementos = fila1.getFila();
		// System.out.println("Imprimindo Pilha!");
		// imprimePilha();
		// fila1.setFila(elementos);
		// fila2.setFila(elementos);
	}

	public void inserirFim(String valor) {
		if (elementos != null && elementos.length > 0) {
			int indiceFinal = 0;
			for (int i = 0; i < elementos.length; i++) {
				if (i == elementos.length)
					indiceFinal = i;
			}
			elementos[indiceFinal + 1] = valor;
		}
	}

	public String removeInicio() {
		contador--;
		elementos[contador] = "\0";
		return elementos[contador];

	}

	public void removeFim() {
		int indiceFinal = 0;
		if (elementos != null && elementos.length > 0) {
			for (int i = 0; i < elementos.length; i++) {
				if (elementos[i] != null)
					indiceFinal = i;
			}
		}
		elementos[indiceFinal] = "\0";
	}

	/**
	 * Obtém o primeiro elemento da pilha
	 * 
	 * @return
	 */
	public String topo() {
		if (elementos[contador] != null)
			return elementos[contador];
		if (elementos[contador - 1] != null)
			return elementos[contador - 1];
		return "";
	}

	/**
	 * Obtém último elemento da pilha
	 * 
	 * @return
	 */
	public String ultimo() {
		int indiceFinal = 0;
		if (elementos != null && elementos.length > 0) {
			for (int i = 0; i < elementos.length; i++) {
				if (elementos[i] != null)
					return elementos[i];
			}
		}
		return elementos[indiceFinal];
	}

	/**
	 * Algoritmo da quest�o 4 com 1 Pilha e uma Fila que inverte a ordem dos seus
	 * elementos - letra a
	 * 
	 * @param pilha
	 *            Pilha que ser� usada como par�metro para a invers�o de elementos
	 * @param fila
	 *            Fila que servir� de estrutura auxiliar para inverter os elementos
	 * @return Array de Strings com os elementos invertidos
	 * @throws EmptyStackException
	 */
	public String[] inverteElementos(Deque pilha, Fila fila) throws EmptyStackException {
		String elementosAuxiliares[] = pilha.elementos;
		for (int i = elementosAuxiliares.length - 1; i >= 0; i--) {
			fila.inserirNaFila(elementosAuxiliares[i]);
		}
		return fila.getFila();
	}

	/**
	 * Algoritmo da quest�o 4 com 2 Pilhas que inverte a ordem dos seus elementos -
	 * letra b
	 * 
	 * @param pilha
	 *            Pilha que ser� usada como par�metro para a invers�o de elementos
	 * @param pilha2
	 *            Pilha que servir� de estrutura auxiliar para inverter os elementos
	 * @return Array de Strings com os elementos invertidos
	 * @throws EmptyStackException
	 */
	public String[] inverteElementos(Deque pilha, Deque pilha2) throws EmptyStackException {
		String elementosAuxiliares[] = pilha.elementos;
		for (int i = elementosAuxiliares.length - 1; i >= 0; i--) {
			pilha2.inserirInicio(elementosAuxiliares[i]);
		}
		return pilha2.getElementos();
	}

	public String[] inverteElementos(Deque pilha) throws EmptyStackException {
		// String elementosAuxiliares[] = pilha.elementos;
		String elementosInvertidos[] = inverte(pilha.elementos, 0, pilha.elementos.length - 1);
		// for (int i = elementosAuxiliares.length - 1; i >= 0; i--) {
		// elementosInvertidos[i] = (elementosAuxiliares[i]);
		// }
		return elementosInvertidos;
	}
	/**
	 * Questão 5 letra a
	 * @param fila
	 * @param pilha
	 * @return
	 * @throws EmptyStackException
	 */
	public String[] inverteElementos(Fila fila, Deque pilha) throws EmptyStackException {
		String elementosAuxiliares[] = fila.getFila();
		for (int i = elementosAuxiliares.length - 1; i >= 0; i--) {
		 pilha.inserirInicio(elementosAuxiliares[i]);
		 }
		return pilha.getElementos();
	}
	/**
	 * Algoritmo recursivo de inversão de elementos:
	 * 1-Quando o índice for maior ou igual ao tamanho do vetor,  then retornará o vetor
	 * 2-caso contrário a valor auxiliar recebe o elemento passado por parâmetro,
	 * 3-A posição correspondente ao índice passado por parâmetro recebe o último elemento,
	 * trocando assim de posição,
	 * 4- E o último recebe o auxiliar, ou seja, o índice atual, então
	 * isso acontece recursivamente até que o índice seja zero e o tamanho do vetor seja zero
	 * @param v Vetor de Strings a ser invertido
	 * @param indice indice a percorrer
	 * @param tamanho tamanho máximo do vetor em questão
	 * @return Array de Strings invertido
	 */
	public static String[] inverte(String[] v, int indice, int tamanho) {
		String aux;
		if (indice >= tamanho) {
			return v;
		} else {
			aux = v[indice];
			v[indice] = v[tamanho];
			v[tamanho] = aux;
			return inverte(v, indice + 1, tamanho - 1);
		}
	}
	
	/**
	 * Algoritmo da questão 5  com 2 Filas que inverte a ordem dos seus
	 * elementos - letra b
	 * 
	 * @param fila
	 *            Fila que será usada como par�metro para a invers�o de elementos
	 * @param fila2
	 *            Fila que servirá de estrutura auxiliar para inverter os elementos
	 * @return Array de Strings com os elementos invertidos
	 * @throws EmptyStackException
	 */
	public String[] inverteElementos(Fila fila, Fila fila2) throws EmptyStackException {
		String elementosAuxiliares[] = fila.getFila();
		for (int i = elementosAuxiliares.length - 1; i >= 0; i--) {
			fila2.inserirNaFila(elementosAuxiliares[i]);
		}
		return fila2.getFila();
	}

}
