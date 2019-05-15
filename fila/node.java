package Fila;
public class node {
	//n=valor armazenado no nó.
	//proximo=variavel que está apontando pro proximo.
	
		private int n;
		private node proximo;
		
		public node(){
			n = 0;
			proximo = null;
		}
		
		//recebendo os valores e armazenando em n.	
		public void setElemento(int n){
			this.n=n;
		}
		//retornando o valor do nó.	
		public int getElemento(){
			return n;
		}	
		
		public void setProximo(node proximo){
			this.proximo=proximo;
		}
		
		public node getProximo(){
			return proximo;
		}
}
