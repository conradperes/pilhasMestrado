package questao13MonitoradorRoteador;

import java.util.Stack;

public class MonitoradorRoteador {

	String expressao;

	public MonitoradorRoteador(String expresao) {
		super();
		this.expressao = expresao;
	}

	public MonitoradorRoteador() {
		super();
	}

	public void monitora(String expressao, Stack controle) {
		if (expressao.charAt(0) == 'E') {
			controle.push(expressao.subSequence(1, expressao.length()));
		} else if (expressao.charAt(0) == 'S') {
			if (controle.isEmpty())
				System.out.println("Pilha Vazia");
			System.out.println(controle.peek());
			System.out.println(controle.firstElement());
			controle.pop();
		}
	}

}
