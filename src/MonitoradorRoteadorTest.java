package questao13MonitoradorRoteador;

import static org.junit.Assert.fail;

import java.util.Scanner;
import java.util.Stack;

import org.junit.Test;

public class MonitoradorRoteadorTest {

	Scanner sc;

	public MonitoradorRoteadorTest() {
		super();
		sc = new Scanner(System.in);
	}

	@Test
	public void testMonitora() {
		try {
			new MonitoradorRoteadorTest();
			MonitoradorRoteador roteador = new MonitoradorRoteador();
			Stack controle = new Stack();
			System.out.println("Digite qtde de pares a serem monitorados pelo roteador:");
			int qtdePares = sc.nextInt();
			int i = 0;
			System.out.println("Digite par de controles para Roteador, "+qtdePares+" vezes!");
			while (sc.hasNext()) {
				i++;
				roteador.monitora(sc.next() + sc.next(), controle);
				if (qtdePares == i) {
					System.out.println("Número de pares concluído");
					break;
				}
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}

	}

}
