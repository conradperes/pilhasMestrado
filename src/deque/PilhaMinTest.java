package deque;

import java.util.Scanner;

import org.junit.Test;

public class PilhaMinTest {
	PilhaMin pilhaMin = new PilhaMin();
	private Scanner sc;

	public PilhaMinTest() {
		super();
		sc = new Scanner(System.in);
	}
	public PilhaMin inserirPilhaMin() {
		int i = 0;
		while (sc.hasNext()) {
			pilhaMin.inserirInicio(sc.next());
			i++;
			if (i == 10)
				break;
			
		}
		return pilhaMin;
	}
	@Test
	public void testRetornaElementoComMenorChave() {
		try {
			PilhaMin min= inserirPilhaMin();
			String[] elementos = min.getElementos();
			min.setElementos(min.inverte(elementos,0 , elementos.length-1));//inverte para checar se retorna o menor
			String menorChave = pilhaMin.retornaElementoComMenorChave(min);
			System.out.println("Retorna elemento com menor chave:");
			System.out.println(menorChave);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
