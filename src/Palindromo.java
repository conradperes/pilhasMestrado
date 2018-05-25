package palindromo;

import java.util.Scanner;

import br.edu.fasul.lac.estruturas.Fila;
import br.edu.fasul.lac.estruturas.Pilha;

public class Palindromo {

	Pilha pilha;

	public Palindromo(Pilha pilha) {
		super();
		this.pilha = pilha;
	}

	public void empilha(String valor) {
		pilha.insere(valor);
	}

	public boolean ehPalindromo(Fila fila) {
		int i = 0;
		while (!fila.isVazia()) {
			if (pilha.getPilha().listar().size() > 1
					&& pilha.getPilha().verificarInicio().equals(pilha.verificarFinal())) {
				pilha.retira();
				pilha.getPilha().removerDoInicio();
				fila.retira();
				i++;
			}else {
				return false;
			}
			if (pilha.getPilha().listar().size() == 1)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a palavra supostamente Palindroma:");
		Palindromo palindromo = new Palindromo(new Pilha());
		Fila fila = new Fila();
		variosPalindromos(palindromo, sc.next(), fila);
	}

	private static void variosPalindromos(Palindromo palindromo, String palavra, Fila fila) {
		for (int i = 0; i < palavra.length(); i++) {
			palindromo.empilha(palavra.charAt(i) + "");
			fila.insere(palavra.charAt(i));
		}
		System.out.println(palindromo.ehPalindromo(fila));
	}

}
