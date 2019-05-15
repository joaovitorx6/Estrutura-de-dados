package Fila;
import java.util.Scanner;
public class viewFilaLL {

	public static void main(String[] args) {
		
		FilaLL fila = new FilaLL();
		Scanner input = new java.util.Scanner(System.in);
		int op=0, n=0;
		
		while (true){
			
			System.out.println("1 - Enfileirar");
			System.out.println("2 - Desenfileirar");
			System.out.println("3 - Inicio");
			System.out.println("4 - Tamanho");
			System.out.println("5 - Está Vazia");
			System.out.println("Digite a operação desejada:");
			op = input.nextInt();
			
			switch(op){
			case 1:
				System.out.println("Digite o valor desejado:");
				n=input.nextInt();
				fila.enfileirar(n);
				break;
			case 2:
				try{
					System.out.println(fila.desenfileirar().getElemento());
				} catch (FilaVaziaException e){
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try{
					System.out.println(fila.inicio().getElemento());
				}catch (FilaVaziaException e){
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println(fila.tamanho());
				break;
			case 5:
				try{ 
					System.out.println(fila.estaVazia());
				}catch(FilaVaziaException e){
					System.out.println(e.getMessage());
				}
				break;
			default:
				break;
			}
		}
	}

}
