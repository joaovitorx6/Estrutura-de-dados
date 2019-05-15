package Fila;

public class Fila {
	
	int [] Fila;
	int [] FilaNew;
	int inicio; 
	int fim;
	int tamanho; 
	
	public Fila() {
		Fila = new int [5];
		inicio = 0;
		fim = 0;
		tamanho = 0;
	}
	
	public void enfileirar(int n){
//		quando chegar um "item" antes do limite, ele duplica, por conta do fim.
		if (fim==Fila.length-1){
//			pegando o inicio e armazenando em uma variavel que vai controlar
//			o laço do array antigo para caso chegue no final, ele volte pro inicio (segunda forma da fila).
			int ii = inicio;
			FilaNew = new int [size()*2];
			for (int i=0; i<fim; i++){
				FilaNew[i]=Fila[ii];
				ii = (ii+1)%(Fila.length);
			}
//			a antiga agora referência a nova.
			Fila = FilaNew;
		}
//		adicionando o item no fim da fila e somando.
		Fila[fim]=n;
		fim = (fim + 1) % (Fila.length);
		tamanho++;
	}
	
	public int desenfileirar () throws FilaVaziaException{
		if (isEmpty()){
			throw new FilaVaziaException("Fila vazia");
		} else {
//			somando o inicio para prosseguir para o próximo da fila.
			int o = Fila[inicio];
			inicio = (inicio+1) % (Fila.length);
//			somando o tamanho.
			tamanho--;
			return o;
		}
		
	}
	
	public int inicio() throws FilaVaziaException{
		if (isEmpty())
			throw new FilaVaziaException("Fila vazia");
		else 
			return Fila[inicio];
	}
	
	public int size(){
		return tamanho;
	}
	
	public boolean isEmpty(){
		if (inicio==fim)
			return true;
		else 
			return false;
	}
}	
