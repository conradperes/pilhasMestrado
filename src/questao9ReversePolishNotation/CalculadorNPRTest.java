package questao9ReversePolishNotation;

import org.junit.Test;

import pilhaEncadeada.EmptyStackException;

public class CalculadorNPRTest {
	/**
	 * Complexidade O(1)
	 */
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
