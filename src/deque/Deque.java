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
	private int n;

	public String[] getElementos() {
		return elementos;
	}

	public void setElementos(String[] elementos) {
		this.elementos = elementos;
	}

	public Deque() {
		super();
		n = 0;
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
			pilha.Desempilha();
			break;
		case 3:
			System.out.println("\t\nTopo/Último da Pilha Encadeada=" + pilha.topo());
			break;
		case 4:
			System.out.println("\t\nTamanho=\t" + pilha.Listar().size());
			break;
		case 5:
			System.out.println("\t\nObtém primeiro=\t" + pilha.obtemPrimeiroElemento());
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
		System.out.println("\tDigite a operação:\n\t1-Inserir Inicio" + "\n\t2-Inserir no fim\n\t3-Remover InÃ­cio"
				+ "\n\t4-Remover Fim\n\t5-Varrer pilha" + "\n\t6-Obter Primeiro \n\t7-Obter Ãšltimo");
	}

	private static void menuPilhaEncadeada() {
		System.out.println("\tDigite a operação:\n\t1-Inserir pilha encadeada" + "\n\t2-Desempilhar\n\t3-Topo"
				+ "\n\t4-Tamanho\n\t5-Obtem Primeiro" + "\n\t6-Listar ");
	}

	private void escolheOperacoesSequenciais(Deque d, Scanner sc) {
		int op = sc.nextInt();
		switch (op) {
		case 1:
			System.out.println("\t\n Inserir no inÃ­cio do Deque\n");
			d.inserirInicio(sc.next());
			break;
		case 2:
			System.out.println("\t\n Inserir no fim do Deque\n");
			d.inserirFim(sc.next());
			break;
		case 3:
			System.out.println("\t\nRemove InÃ­cio");
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
			System.out.println("\t\nObter Ãºltimo\t" + d.ultimo());
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
		elementos[n] = valor;
		n++;
	}

	/**
	 * Questão 2 que insere elementos na Pilha utilizando duas filas como estruturas
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
		n--;
		elementos[n] = "\0";
		return elementos[n];

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
	 * ObtÃ©m o primeiro elemento da pilha
	 * 
	 * @return
	 */
	public String topo() {
		if (elementos[n] != null)
			return elementos[n];
		if (elementos[n - 1] != null)
			return elementos[n - 1];
		return "";
	}

	/**
	 * ObtÃ©m Ãºltimo elemento da pilha
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
	 * Algoritmo da questão 4 com 1 Pilha e uma Fila que inverte a ordem dos seus
	 * elementos - letra a
	 * 
	 * @param pilha
	 *            Pilha que será usada como parâmetro para a inversão de elementos
	 * @param fila
	 *            Fila que servirá de estrutura auxiliar para inverter os elementos
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
	 * Algoritmo da questão 4 com 2 Pilhas que inverte a ordem dos seus elementos -
	 * letra b
	 * 
	 * @param pilha
	 *            Pilha que será usada como parâmetro para a inversão de elementos
	 * @param pilha2
	 *            Pilha que servirá de estrutura auxiliar para inverter os elementos
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

}
