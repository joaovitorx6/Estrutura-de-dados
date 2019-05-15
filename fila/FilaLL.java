package Fila;

public class FilaLL {
	
	public node no;
//	nó que armazena o inicio e o fim.
	public node inicio;
	public node fim;
//	utilizado durante o desenfileirar.
	public node remover;
	public int tamanho;

// construtor.
	public FilaLL(){
		no = new node();
		inicio = new node();
		fim = new node();
		remover = new node();
		tamanho=0;
	}
	
	public void enfileirar (int n){
		no = new node();
		no.setElemento(n);
		fim.setProximo(no);
		fim = no;
		
//		na primeira inserção, eu declaro que o inicio será igual ao fim.
		if(tamanho==0)
			inicio=fim;
		
		tamanho++;
	}
	
	public node desenfileirar() throws FilaVaziaException{
		if(tamanho==0)
			throw new FilaVaziaException("Fila vazia");
		else 
			remover = inicio;
			inicio = remover.getProximo();
//			inicio=inicio.getProximo();
			tamanho--;
		return remover;
	}
	
	public node inicio() throws FilaVaziaException{
		if(tamanho==0)
			throw new FilaVaziaException("Fila vazia");
		else 
			return inicio;
	}
	
	public int tamanho(){
		return tamanho;
	}
	
	public boolean estaVazia() throws FilaVaziaException{
		if(tamanho==0)
			throw new FilaVaziaException("Fila vazia");
		else
			return false;
	}
}
