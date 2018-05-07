package questao11Parentizada;

import java.util.Stack;

/**
 *
 * @author Conrad Peres
 */
public class Entrada {
	private String expressao;

	public Entrada(String pExpressao) {
		this.expressao = pExpressao;
	}

	/**
	 * Complexidade O(N)
	 * 
	 * @return
	 */
	public boolean validarFormacao() {
		Stack controle = new Stack();
		for (int i = 0; i < this.expressao.length(); i++) {
			if (this.expressao.charAt(i) == '(') {//this.expressao.charAt(i) == '{' || this.expressao.charAt(i) == '[' || 
				controle.push(this.expressao.charAt(i));
			} else if (this.expressao.charAt(i) == ')' ) {//|| this.expressao.charAt(i) == ']'|| this.expressao.charAt(i) == '}'
				if (controle.isEmpty()) {
					return false;
				} else if (this.expressao.charAt(i) == ')' && controle.peek().equals('(')) {
					controle.pop();
					// calcular
					continue;
				}
				// else if (this.expressao.charAt(i) == ']' && controle.peek().equals('[')) {
				// controle.pop();
				// // calcular
				// continue;
				// } else if (this.expressao.charAt(i) == '}' && controle.peek().equals('{')) {
				// controle.pop();
				// // calcular
				// continue;
				// }
				return false;
			}
		}
		if (controle.isEmpty())
			return true;
		return false;
	}

	public String getExpressao() {
		return expressao;
	}
}