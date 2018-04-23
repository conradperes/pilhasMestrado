package deque;

public class PilhaEncadeada {

	NoPilha inicio;
	int N;

	public PilhaEncadeada() {
		super();
		N = 0;
		inicio = new NoPilha();
	}

	char topo() {
		return this.inicio.valor;
	}

	void empilhar(Character valor) {
		this.inicio = new NoPilha(valor, this.inicio);
		N++;
	}

	char desempilhar() {
		this.inicio.proximo = new NoPilha();
		NoPilha proximoNoPilha = inicio;
		Character caracterInicial = this.inicio.valor;
		this.inicio = proximoNoPilha;
		N--;
		return caracterInicial;
	}

	public Character obtemPrimeiro() {
		for (int i = N; i >= 1; i--) {
			if (i == 1)
				return inicio.valor;
		}
		return 65;
	}

	public NoPilha getInicio() {
		return inicio;
	}

	public void setInicio(NoPilha inicio) {
		this.inicio = inicio;
	}

	public int tamanho() {
		return this.N;
	}

}
