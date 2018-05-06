package deque;

import java.util.Scanner;

import org.junit.Test;

public class PilhaMinTest {
	Deque pilhaBase;
	private Scanner sc;
<<<<<<< HEAD
	PilhaMin min ;
=======
>>>>>>> d347a8edcc2d86ec88fcaa67e757cac1035ed1fb

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
<<<<<<< HEAD
			if (i == 5)
=======
			if (i == 10)
>>>>>>> d347a8edcc2d86ec88fcaa67e757cac1035ed1fb
				break;

		}
		return pilhaBase;
	}

	@Test
<<<<<<< HEAD
	public String testRetornaMenorElemento() {
		String menorElemento ="";
		try {
			new PilhaMinTest();
			pilhaBase = inserirPilhaMin();
			min = new PilhaMin();
=======
	public void testRetornaElementoComMenorChave() {
		try {
			new PilhaMinTest();
			pilhaBase = inserirPilhaMin();
			PilhaMin min = new PilhaMin();
>>>>>>> d347a8edcc2d86ec88fcaa67e757cac1035ed1fb
			for (String elemento : pilhaBase.getElementos()) {
				if(elemento!=null)
					min.queue(elemento);
			}
<<<<<<< HEAD
			menorElemento = min.retornaElementoComMenorChave(min.getPilha());
=======
			String menorElemento = min.retornaElementoComMenorChave(min.getPilha());
>>>>>>> d347a8edcc2d86ec88fcaa67e757cac1035ed1fb
			System.out.println("Retorna menor elemento:");
			System.out.println(menorElemento);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
<<<<<<< HEAD
			//pilhaBase.desempilha();
		}
		return menorElemento;
=======
			pilhaBase.desempilha();
		}
>>>>>>> d347a8edcc2d86ec88fcaa67e757cac1035ed1fb
	}

}
