package deque;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import fila.Fila;
import pilhaEncadeada.EmptyStackException;

class DequeTest {
	Deque d = new Deque();
	private Scanner sc;

	@Test
	void testInserirInicio() {
		fail("Not yet implemented");
	}

	@Test
	void testInserirUsandoFila() {
		sc = new Scanner(System.in);
		Fila fila1 = new Fila();
		Fila fila2 = new Fila();
		int i = 0;
		while (sc.hasNext()) {
			d.inserirUsandoFila(fila1, fila2, sc.next());
			i++;
			if (i == 10)
				break;
			
		}
		testImprimePilha();

	}

	//@Test
	void testInverteElementosLetraA() {
		// sc = new Scanner(System.in);
		// int i=0;
		// while(sc.hasNext()) {
		// d.inserirInicio(sc.next());
		// if(i==5)break;
		// i++;
		// }
		try {
			testInserirUsandoFila();
			String[] inverteElementos = d.inverteElementos(d, new Fila());
			System.out.println("Elementos Invertidos:");
			for (String elemento : inverteElementos) {
				System.out.println(elemento);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testInverteElementosLetraB() {
		// sc = new Scanner(System.in);
		// int i=0;
		// while(sc.hasNext()) {
		// d.inserirInicio(sc.next());
		// if(i==5)break;
		// i++;
		// }
		try {
			testInserirUsandoFila();
			String[] inverteElementos = d.inverteElementos(d, new Deque());
			System.out.println("Elementos Invertidos:");
			for (String elemento : inverteElementos) {
				System.out.println(elemento);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void testImprimePilha() {
		d.imprimePilha();
	}

	@Test
	void testInserirFim() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveInicio() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveFim() {
		fail("Not yet implemented");
	}

	@Test
	void testTopo() {
		fail("Not yet implemented");
	}

	@Test
	void testUltimo() {
		fail("Not yet implemented");
	}

}
