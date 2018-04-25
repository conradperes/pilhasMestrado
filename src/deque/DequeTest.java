package deque;

import static org.junit.Assert.*;
import java.util.Scanner;

import org.junit.Test;

import fila.Fila;
import pilhaEncadeada.EmptyStackException;

public class DequeTest {
	Deque d = new Deque();
	private Scanner sc;
	
	

	public DequeTest() {
		super();
		sc = new Scanner(System.in);
		// TODO Auto-generated constructor stub
	}

	//@Test
	public void testInserirInicio() {
		fail("Not yet implemented");
	}

	//@Test
	public void testInserirUsandoFila() {
		
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
	
	
	public Fila inserirFila() {
		Fila fila1 = new Fila();
		int i = 0;
		while (sc.hasNext()) {
			fila1.inserirNaFila(sc.next());
			i++;
			if (i == 10)
				break;
			
		}
		return fila1;
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
	
	//@Test
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
	public void testInverteElementosQuestao5LetraA() {
		try {
			Fila fila=inserirFila();
			String[] inverteElementos = d.inverteElementos(fila, new Deque());
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
