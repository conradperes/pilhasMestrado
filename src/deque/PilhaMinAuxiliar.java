package deque;

import java.util.Scanner;

import questao7PilhaMinO1.PilhaMin;
import questao7PilhaMinO1.PilhaMinTest;

public class PilhaMinAuxiliar {
	Deque pilhaBase;
	private Scanner sc;
	PilhaMin min ;

	public PilhaMinAuxiliar() {
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

	public String testRetornaMenorElemento() {
		String menorElemento ="";
		try {
			pilhaMin();
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

	private PilhaMin pilhaMin() {
		new PilhaMinTest();
		pilhaBase = inserirPilhaMin();
		min = new PilhaMin();
		for (String elemento : pilhaBase.getElementos()) {
			if(elemento!=null)
				min.queue(elemento);
		}
		return min;
	}
}
