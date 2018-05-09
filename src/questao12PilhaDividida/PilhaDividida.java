package questao12PilhaDividida;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PilhaDividida {
	List<Stack> listaPilhas= new ArrayList<Stack>();
	int quantidadePilhas;
	int tamanhoPilhas;
	
	
	/**
	 * Complexidade O(N)
	 * @param pilha
	 * @param quantidadePilhas
	 * @param tamanhoPilhas
	 */
	public PilhaDividida( int quantidadePilhas, int tamanhoPilhas) {
		super();
		this.quantidadePilhas = quantidadePilhas;
		this.tamanhoPilhas = tamanhoPilhas;
		for (int i = 0; i<quantidadePilhas; i++) {
			Stack pilha = new Stack();
			listaPilhas.add(pilha);
			pilha.setSize(tamanhoPilhas);
		}
	}
	/**
	 * Complexidade O(N)
	 * @return
	 */
	public List<Object> topo() {
		List<Object> listaTopos= new ArrayList<Object>();
		for (Stack stack : listaPilhas) {
			listaTopos.add(stack.pop());
		}
		return listaTopos;
	}
	/**
	 * Complexidade O(N)
	 * @param o
	 */
	public void push(Object o) {
		for (Stack stack : listaPilhas) {
			if(!stack.contains(o))
				stack.push(o);
			else
				stack.pop();
		}
	}
	/**
	 * Complexidade O(N)
	 */
	public void pop() {
		for (Stack stack : listaPilhas) {
			if(!stack.isEmpty())
				stack.pop();
		}
	}
	/**
	 * Complexidade O(N)
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite Quantidade de Pilhas:");
		System.out.println("Digite Tamanho de Pilhas:");
		int qtdePilhas = sc.nextInt();
		int tamanhoPilhas = sc.nextInt();
		PilhaDividida pilhaDividida = new PilhaDividida(qtdePilhas, tamanhoPilhas);
		for (int i = 0; i < qtdePilhas; i++) {
			System.out.println("Digite os "+tamanhoPilhas+" elementos das  "+qtdePilhas+" pilhas ");
			pilhaDividida.push(sc.next());
			pilhaDividida.topo().forEach(item -> System.out.println(item));;
			pilhaDividida.pop();
		}
		
	}

}
