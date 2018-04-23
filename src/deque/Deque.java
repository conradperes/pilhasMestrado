package deque;

import java.util.Scanner;

import exemplo.Pilha;

public class Deque {

	private static final int PILHA_ENCADEADA = 2;
	private static final int PILHA_SEQUENCIAL = 1;
	private String elementos[];
	private Deque proximo;
	private static final int MAX = 100000;
	private int n;

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
			escolhaOperacoesPilha();
			while (sc.hasNext())
				d.escolheOperacoesSequenciais(d, sc);
		}else  if(tipoPilha==PILHA_ENCADEADA){
			escolhaOperacoesPilhaEncadeada();
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
			System.out.println("\t\nTopo/Último da Pilha Encadeada="+pilha.topo());
			break;
		case 4:
			System.out.println("\t\nTamanho=\t"+pilha.Listar().size());
			break;
		case 5:
			System.out.println("\t\nObtém primeiro=\t"+pilha.obtemPrimeiroElemento());
			break;
		case 6:
			System.out.println("\t\nListar tudo=\t"+pilha.Listar());
			break;
		default:
			System.out.println("De 1 a 6 somente!");
			break;
		}
	}

	private static void escolhaOperacoesPilha() {
		System.out.println(
				"\tDigite a operação:\n\t1-Inserir Inicio"
				+ "\n\t2-Inserir no fim\n\t3-Remover Início"
				+ "\n\t4-Remover Fim\n\t5-Varrer pilha"
				+ "\n\t6-Obter Primeiro \n\t7-Obter Último");
	}
	private static void escolhaOperacoesPilhaEncadeada() {
		System.out.println(
				"\tDigite a operação:\n\t1-Inserir pilha encadeada"
				+ "\n\t2-Desempilhar\n\t3-Topo"
				+ "\n\t4-Tamanho\n\t5-Obtem Primeiro"
				+ "\n\t6-Listar ");
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
		for (String c : elementos) {
			if (c != null)
				System.out.println(c);
		}
	}

	public void inserirInicio(String valor) {
		elementos[n] = valor;
		n++;
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
	 * Obtém o primeiro elemento da pilha
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

}
