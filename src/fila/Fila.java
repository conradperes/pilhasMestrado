package fila;

import java.util.Scanner;

public class Fila {

	private static final int NUMERO_MAXIMO_FILA = 10;
	int extensaoFila = 0;
	String fila[] = new String[NUMERO_MAXIMO_FILA];

	/**
	 * Complexidade O(1) Método para Inserir elementos na Fila
	 * 
	 * @param elemento
	 */
	public void inserirNaFila(String elemento) {

		if (extensaoFila == NUMERO_MAXIMO_FILA)
			System.out.println("Fila Cheia");
		else {
			fila[extensaoFila] = elemento;
			extensaoFila++;
		}
	}

	/**
	 * Complexidade O(N) Método para Remover elementos da Fila
	 */
	public void removerDaFila() {

		if (extensaoFila == 0)
			System.out.println("Fila Vazia: ");

		if (extensaoFila == 1)
			extensaoFila = 0;

		if (extensaoFila > 1) {

			for (int i = 0; i < (extensaoFila - 1); ++i)
				fila[i] = fila[i + 1];

			extensaoFila--;
		}
	}

	/**
	 * Complexidade O(1) Método para Exibir elementos da Fila
	 */
	public void exibirFila() {
		System.out.print("Fila: ");
		for (int i = 0; i < extensaoFila; ++i)
			System.out.print(fila[i] + "  ");
		System.out.print("\n");
	}

	/**
	 * Complexidade O(1) Método para Retirar todos elementos da Fila
	 */
	public void LimparFila() {
		System.out.println("Fila Limpa!");
		extensaoFila = 0;
	}

	/**
	 * Complexidade O(N) Método Gerenciador da Fila
	 * 
	 * @param fila
	 */
	public void play(Fila fila) {
		menuFila();
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite opcao: ");
		while (sc.hasNext()) {
			escolheOperacao(sc, fila);
		}
	}

	/**
	 * Complexidade O(1) Menu de opções da Fila
	 */
	private void menuFila() {
		System.out.println("\n======= MENU  FILA =======");
		System.out.println("1 - Inserir na Fila: ");
		System.out.println("2 - Remover da Fila: ");
		System.out.println("3 - Exibir Fila: ");
		System.out.println("4 - Limpar Fila: ");
		System.out.println("5 - Sair ");
		System.out.println("============================");
	}

	/**
	 * Complexidade O(1) Método que executa as opções do menu
	 * 
	 * @param sc
	 * @param fila
	 */
	private void escolheOperacao(Scanner sc, Fila fila) {
		int opcao = sc.nextInt();
		switch (opcao) {
		case 1:
			System.out.print("Digite o elemento a ser inserido na Fila: ");
			fila.inserirNaFila(sc.next());
			break;
		case 2:
			fila.removerDaFila();
			break;
		case 3:
			fila.exibirFila();
			break;
		case 4:
			fila.LimparFila();
			break;
		case 5:
			System.exit(0);
		default:
			System.out.println("Escolha de 1 a 5");
			break;
		}
	}

	/**
	 * Complexidade O(1) Execução da Fila em si
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Fila fila = new Fila();
		fila.play(fila);
	}

	/**
	 * Complexidade O(1)
	 */
	public String[] getFila() {
		return fila;
	}

	/**
	 * Complexidade O(1)
	 */
	public void setFila(String[] fila) {
		this.fila = fila;
	}

}
