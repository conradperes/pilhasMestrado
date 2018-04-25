package deque;

import static org.junit.Assert.*;
import java.util.Scanner;

import org.junit.Test;

import fila.Fila;
import pilhaEncadeada.EmptyStackException;

public class DequeTest {
	Deque d = new Deque();
	private Scanner sc;

	@Test
	public void testInserirInicio() {
		fail("Not yet implemented");
	}

	@Test
	public void testInserirUsandoFila() {
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
	public void testInverteElementosLetraA() {
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
	
	//@Test
	public void testInverteElementosLetraB() {
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
	public void testInverteElementosLetraC() {
		try {
			testInserirUsandoFila();
			String[] inverteElementos = d.inverteElementos(d);
			System.out.println("Elementos Invertidos:");
			for (String elemento : inverteElementos) {
				System.out.println(elemento);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testImprimePilha() {
		d.imprimePilha();
	}

	@Test
	public void testInserirFim() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveInicio() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveFim() {
		fail("Not yet implemented");
	}

	@Test
	public void testTopo() {
		fail("Not yet implemented");
	}

	@Test
	public void testUltimo() {
		fail("Not yet implemented");
	}

}
