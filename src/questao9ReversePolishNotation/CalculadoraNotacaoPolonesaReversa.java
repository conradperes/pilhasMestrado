package questao9ReversePolishNotation;

import java.util.Scanner;

import pilhaEncadeada.EmptyStackException;
import pilhaEncadeada.Pilha;

public class CalculadoraNotacaoPolonesaReversa extends Validacao {

	// Deque deque;
	Pilha deque;
	Scanner sc;

	/**
	 * Complexidade O(1)
	 */
	public void iniciar() {
		opcoes();
		menu(sc.nextInt());
	}

	/**
	 * Complexidade O(1)
	 * 
	 * @throws EmptyStackException
	 */
	private void calculaNPR() throws EmptyStackException {
		String numero = sc.next();
		if (isDigit(numero))
			deque.empilha(numero);
		int tamanhoEquacao = 1;
		int qtdeOperacoes = 1;
		while (sc.hasNext()) {
			String proximo = sc.next();
			if (isDigit(proximo)) {
				deque.empilha(proximo);
				tamanhoEquacao++;
				qtdeOperacoes++;
			} else {
				if (tamanhoEquacao > 2) {
					System.out.println(aplicarOperador(proximo.charAt(0), tamanhoEquacao));
					tamanhoEquacao = 0;
					qtdeOperacoes++;
				} else {
					System.out.println(aplicarOperador(proximo.charAt(0)));
					tamanhoEquacao = 0;
					qtdeOperacoes++;
				}
			}
			if (qtdeOperacoes >= 9) {
				System.out.println("Essa equação só pode ter 9 membros! Voltando ao Menu!");
				deque.desempilha();
				iniciar();
			}
		}
	}

	/**
	 * Complexidade O(1)
	 * 
	 * @param opcao
	 */
	private void menu(int opcao) {
		switch (opcao) {
		case 1:
			deque.desempilha();
			break;
		case 2:
			deque.print();
			break;
		case 3:
			System.out.println("Entre com números, Pense em uma calculadora HP:");
			calculaNPR();
			break;
		case 4:
			System.exit(0);
			break;
		default:
			System.out.println("Escolha de 1 a 4");
			break;
		}
	}

	/**
	 * Complexidade O(1)
	 */
	private void opcoes() {
		System.out.println("1- Desempilha para realizar outras equações:");
		System.out.println("2-Exibe pilha:");
		System.out.println("3-Realizar cálculos do sistema de Cálculo de NPR!");
		System.out.println("4-Sair do sistema de Cálculo de NPR!");

	}

	/**
	 * Complexidade O(1)
	 */
	public CalculadoraNotacaoPolonesaReversa() {
		super();
		deque = new Pilha();
		sc = new Scanner(System.in);
	}

	/**
	 * Complexidade O(1)
	 */
	private double aplicarOperador(char op) {
		double operadorEsquerdo, operadorDireito = 0;
		operadorDireito = Double.parseDouble(deque.topo());
		operadorEsquerdo = Double.parseDouble(deque.anterior());
		return realizarOperacoes(op, operadorEsquerdo, operadorDireito);
	}

	/**
	 * Complexidade O(1)
	 */
	private double aplicarOperador(char op, int tamanhoEquacao) {
		double operadorEsquerdo, operadorDireito, resultado = 0;
		operadorDireito = Double.parseDouble(deque.topo());
		operadorEsquerdo = Double.parseDouble(deque.anterior());
		resultado = realizarOperacoes(op, operadorEsquerdo, operadorDireito);
		double resultadoFinal = 0;
		try {
			resultadoFinal = realizarOperacoes(op, Double.parseDouble(deque.anterior(tamanhoEquacao)), resultado);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao Operar o NPR=" + e.getMessage());
		}
		// deque.desempilha();
		return resultadoFinal;
		// deque.print();
	}

	/**
	 * Complexidade O(1)
	 */
	private double realizarOperacoes(char op, double operadorEsquerdo, double operadorDireito) {
		double resultado = 0;
		switch (op) {
		case '+':
			resultado = operadorEsquerdo + operadorDireito;
			break;
		case '-':
			resultado = operadorEsquerdo - operadorDireito;
			break;
		case '*':
			resultado = operadorEsquerdo * operadorDireito;
			break;
		case '/':
			resultado = operadorEsquerdo / operadorDireito;
			break;
		}
		deque.empilha("" + resultado);
		return resultado;
	}

}
