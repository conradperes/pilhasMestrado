package questao11Parentizada;

import java.util.Scanner;
/**
 *
 * @author Conrad Peres
 */
public class Anfitriao {
	/*
	 * Complexidade O(N)
	 */
    public static void main(String[] args) {
        System.out.println("Digite a expressao: ");
        Scanner sc = new Scanner(System.in);
        String expressao = sc.nextLine();
        System.out.println("Entrada: " + expressao);              
        Entrada entrada = new Entrada(expressao);        
        if(entrada.validarFormacao()) {
            System.out.println("Expressao validada!");
        } else {
            System.out.println("Expressao invalida!");
        }
    }    
}