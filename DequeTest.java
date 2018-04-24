package deque;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import fila.Fila;

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
		int i=0;
		while(sc.hasNext()) {
			d.inserirUsandoFila(fila1, fila2, sc.next());
			if(i==5)break;
			i++;
		}
		testImprimePilha();
		
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
