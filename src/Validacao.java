package questao9ReversePolishNotation;

public class Validacao {

	public Validacao() {
		super();
	}

	protected boolean isDigit(final String c) {
		return c.matches("[0-9]+");
	}
	
	protected boolean isLetter(final String c) {
		return c.matches("[a-z]+");
	}

}