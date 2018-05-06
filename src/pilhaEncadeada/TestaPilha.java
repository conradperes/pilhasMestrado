package pilhaEncadeada;

import java.util.ArrayList;
import java.util.Scanner;

public class TestaPilha {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Pilha pilha = new Pilha();
		String valor, resp;

		do {
			System.out.println("Escolha uma opção:\n1->Empilhar\n2->Desempilhar\n3->Listar");
			resp = sc.next();
			// Empilha um valor.
			if (resp.equals("1")) {
				System.out.println("Digite o valor:");
				valor = sc.next();
				pilha.empilha(valor);
			}

			// Desempilha um valor.
			else if (resp.equals("2")) {
				try {
					System.out.println("Desempilhado valor " + pilha.desempilha());
				} catch (EmptyStackException e) {
					System.out.println(e.getMessage());
				}
			}
			// Lista os valore na pilha.
			else if (resp.equals("3")) {
				ArrayList<String> listar = new ArrayList<String>();
				try {
					listar = pilha.Listar();
				} catch (EmptyStackException e) {
					System.out.println(e.getMessage());
				}

				for (String vl : listar) {
					System.out.println(vl);
				}
			} else
				System.out.println("Opção inválida!");

		} while (resp != "9");
	}

}