package deque;

import java.util.Scanner;

public class Deque {

	private static final int PILHA_ENCADEADA = 2;
	private static final int PILHA_SEQUENCIAL = 1;
	private Character elementos[];
	private Deque proximo;
	private static final int MAX = 100000;
	private int n;

	public Deque() {
		super();
		n = 0;
		elementos = new Character[MAX];
	}

	public Deque getProximo() {
		return proximo;
	}

	public void setProximo(Deque proximo) {
		this.proximo = proximo;
	}

	public static void main(String[] args) {
		Deque d = new Deque();
		PilhaEncadeada pilhaEncadeada = new PilhaEncadeada();
		Scanner sc = new Scanner(System.in);
		System.out.println("\tEscolha Pilha : 1- Sequencial 2- Encadeada");
		int tipoPilha = sc.nextInt();
		if (tipoPilha == PILHA_SEQUENCIAL) {
			escolhaOperacoesPilha();
			while (sc.hasNext())
				d.escolheOperacoesSequenciais(d, sc);
		}else  if(tipoPilha==PILHA_ENCADEADA){
			escolhaOperacoesPilha();
			while (sc.hasNext())
				d.escolheOperacoesEncadeada(sc, pilhaEncadeada);
		}
	}

	private void escolheOperacoesEncadeada(Scanner sc, PilhaEncadeada pilha) {
		int op = sc.nextInt();
		switch (op) {
		case 1:
			pilha.empilhar(sc.next().charAt(0));
			break;
		case 2:
			pilha.desempilhar();
			break;
		case 3:
			System.out.println("\t\nTopo/Último da Pilha Encadeada="+pilha.topo());
			break;
		case 4:
			System.out.println("\t\nTamanho=\t"+pilha.tamanho());
			break;
		case 5:
			System.out.println("\t\nObtém primeiro=\t"+pilha.obtemPrimeiro());
			break;
		default:
			System.out.println("De 1 a 5 somente!");
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

	private void escolheOperacoesSequenciais(Deque d, Scanner sc) {
		int op = sc.nextInt();
		switch (op) {
		case 1:
			System.out.println("\t\n Inserir no início do Deque\n");
			d.inserirInicio(sc.next().charAt(0));
			break;
		case 2:
			System.out.println("\t\n Inserir no fim do Deque\n");
			d.inserirFim(sc.next().charAt(0));
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
		for (Character c : elementos) {
			if (c != null)
				System.out.println(c);
		}
	}

	public void inserirInicio(Character valor) {
		elementos[n] = valor;
		n++;
	}

	public void inserirFim(Character valor) {
		if (elementos != null && elementos.length > 0) {
			int indiceFinal = 0;
			for (int i = 0; i < elementos.length; i++) {
				if (i == elementos.length)
					indiceFinal = i;
			}
			elementos[indiceFinal + 1] = valor;
		}
	}

	public char removeInicio() {
		n--;
		elementos[n] = '\0';
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
		elementos[indiceFinal] = '\0';
	}

	/**
	 * Obtém o primeiro elemento da pilha
	 * 
	 * @return
	 */
	public char topo() {
		if (elementos[n] != null)
			return elementos[n];
		if (elementos[n - 1] != null)
			return elementos[n - 1];
		return 0;
	}

	/**
	 * Obtém último elemento da pilha
	 * 
	 * @return
	 */
	public Character ultimo() {
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
