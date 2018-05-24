package palindromo;

import java.util.Scanner;

import deque.Deque;
import fila.Fila;

public class Palindromo {

	Deque pilha;

	public Palindromo(Deque pilha) {
		super();
		this.pilha = pilha;
	}

	public void empilha(String valor) {
		pilha.inserirInicio(valor);
	}

	public boolean ehPalindromo(Fila fila) {

		// fila.setFila(pilha.getElementos());

		for (int i = 0; i < fila.getFila().length; i++) {
			if (pilha.topo().equalsIgnoreCase(pilha.ultimo())) {
				pilha.removeTopo();
				pilha.removeFim();
				fila.removerDaFila();
			}
			if (i == fila.getFila().length) {
				if (fila.getFila().length == 1)
					return true;
				else
					return false;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a palavra supostamente Palindroma:");
		Palindromo palindromo = new Palindromo(new Deque());
		String palavra = sc.next();
		Fila fila = new Fila();
		for (int i = 0; i < palavra.length(); i++) {
			palindromo.empilha(palavra.charAt(i) + "");
			fila.inserirNaFila(palavra.charAt(i) + "");
		}

		System.out.println(palindromo.ehPalindromo(fila));
	}

}
