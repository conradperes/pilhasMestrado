package questao5PilhaInverteOrdem;

import java.util.Scanner;

import org.junit.Test;

import br.edu.fasul.lac.estruturas.Pilha;

public class PIlhaInverteOrdemTest {
	PIlhaInverteOrdem pilhaAux;
	private Scanner sc;

	public PIlhaInverteOrdemTest() {
		super();
		sc = new Scanner(System.in);
		pilhaAux = new PIlhaInverteOrdem();
	}
	/**
	 * Complexidade O(N)
	 */
	public void inserirPilhaMin() {
		int i = 0;
		while (sc.hasNext()) {
			pilhaAux.insere(sc.next());
			i++;
			if (i == 5)
				break;

		}
	}
	/**
	 * Complexidade O(N)
	 */
	@Test
	public void testInverteOrdem() {
		new PIlhaInverteOrdemTest();
		inserirPilhaMin();
		System.out.println(pilhaAux.inverteOrdem(pilhaAux, new Pilha()));
	}

	

	// //@Test
	// public void testOrdenaElementos() {
	// try {
	// new PilhaOrdenadaTest();
	// inserirPilhaMin();
	// PilhaOrdenada pilhaOrdenada = new PilhaOrdenada();
	// for (String elemento : pilhaAux.getPilha().listar()) {
	// if(elemento!=null)
	// pilhaOrdenada.queue(pilhaAux, pilhaOrdenada);
	// }
	// System.out.println(pilhaOrdenada.toString());
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	//// pilhaAux.desempilha();
	// }
	//
	// }
	//
	// //@Test
	// public void testPilhaOrdenada() {
	// new PilhaOrdenadaTest();
	// inserirPilhaMin();
	// PilhaOrdenada pilhaOrdenada = new PilhaOrdenada();
	// Pilha pilhaFinal = new Pilha();
	// System.out.println(pilhaOrdenada.ordenacao(pilhaAux, pilhaFinal));
	// System.out.println(pilhaFinal.toString());
	// }

}
