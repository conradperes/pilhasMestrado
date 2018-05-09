package questao9ReversePolishNotation;

public class Validacao {
	/**
	 * Complexidade O(1)
	 */
	public Validacao() {
		super();
	}

	/**
	 * Complexidade O(1)
	 */
	protected boolean isDigit(final String c) {
		return c.matches("[0-9]+");
	}

	/**
	 * Complexidade O(1)
	 */
	protected boolean isLetter(final String c) {
		return c.matches("[a-z]+");
	}

}