package reversePolishNotation;

import org.junit.Test;

import pilhaEncadeada.EmptyStackException;

public class CalculadorNPRTest {

	@Test
	public void testCalculaNPR() {
		try {
			CalculadoraNotacaoPolonesaReversa npr =  new CalculadoraNotacaoPolonesaReversa();
			npr.iniciar();
		} catch (EmptyStackException e) {
			e.printStackTrace();
		}
	}

}
