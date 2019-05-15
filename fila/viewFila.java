package Fila;
import java.util.Scanner;

public class viewFila {
	public static void main (String[]args){
		int op,n;
		Scanner input = new java.util.Scanner(System.in);
		Fila fila = new Fila(); 
		
		while (true){
			System.out.println("1 - Enfileirar");
			System.out.println("2 - Desenfileirar");
			System.out.println("3 - Tamanho");
			System.out.println("4 - estaVazia");
			System.out.println("5 - Inicio");
			op = input.nextInt();
			
			switch (op){
				case 1:
					System.out.println("Digite o valor desejado:");
					n = input.nextInt();
					fila.enfileirar(n);
					break;
				case 2:
					try {
						System.out.println(fila.desenfileirar());
					} catch (FilaVaziaException e){
						System.out.println(e.getMessage());
					}
					break;
				case 3: 
					System.out.println(fila.size());
					break;
				case 4:
					System.out.println(fila.isEmpty());
					break;
				case 5:
					try {
						System.out.println(fila.inicio());
					} catch (FilaVaziaException e){
						System.out.println(e.getMessage());
					}
					break;
				default: 
					break;
			}
		}
	}
}
