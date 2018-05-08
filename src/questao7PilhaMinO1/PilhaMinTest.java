package questao7PilhaMinO1;

import java.util.Scanner;

import org.junit.Test;

import deque.Deque;

public class PilhaMinTest {
	Deque pilhaBase;
	private Scanner sc;
	PilhaMin min ;

	public PilhaMinTest() {
		super();
		sc = new Scanner(System.in);
		pilhaBase = new Deque();
	}

	public Deque inserirPilhaMin() {
		int i = 0;
		while (sc.hasNext()) {
			pilhaBase.inserirInicio(sc.next());
			i++;
			if (i == 5)
				break;

		}
		return pilhaBase;
	}

	@Test
	public String testRetornaMenorElemento() {
		String menorElemento ="";
		try {
			new PilhaMinTest();
			pilhaBase = inserirPilhaMin();
			min = new PilhaMin();
			for (String elemento : pilhaBase.getElementos()) {
				if(elemento!=null)
					min.queue(elemento);
			}
			menorElemento = min.retornaElementoComMenorChave(min.getPilha());
			System.out.println("Retorna menor elemento:");
			System.out.println(menorElemento);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//pilhaBase.desempilha();
		}
		return menorElemento;
	}

}
