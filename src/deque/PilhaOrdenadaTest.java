package deque;

import java.util.Scanner;

import org.junit.Test;


public class PilhaOrdenadaTest {
	PilhaOrdenada pilhaAux;
	private Scanner sc;

	public PilhaOrdenadaTest() {
		super();
		sc = new Scanner(System.in);
		pilhaAux = new PilhaOrdenada();
	}
	public void inserirPilhaMin() {
		int i = 0;
		while (sc.hasNext()) {
			pilhaAux.insere(sc.next());
			i++;
			if (i == 5)
				break;

		}
	}

	@Test
	public void testOrdenaElementos() {
		try {
			new PilhaOrdenadaTest();
			inserirPilhaMin();
			PilhaOrdenada pilhaOrdenada = new PilhaOrdenada();
			for (String elemento : pilhaAux.getPilha().listar()) {
				if(elemento!=null)
					pilhaOrdenada.queue(pilhaAux, pilhaOrdenada);
			}
			System.out.println(pilhaOrdenada.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			pilhaAux.desempilha();
		}

	}

}
