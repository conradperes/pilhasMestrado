package deque;

public class NoPilha {
	Character valor;
	NoPilha proximo;
	public Character getValor() {
		return valor;
	}
	public void setValor(Character valor) {
		this.valor = valor;
	}
	public NoPilha getProximo() {
		return proximo;
	}
	public void setProximo(NoPilha proximo) {
		this.proximo = proximo;
	}
	public NoPilha(Character valor, NoPilha proximo) {
		super();
		this.valor = valor;
		this.proximo = proximo;
	}
	public NoPilha() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
