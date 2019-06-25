package Sort;

import TADLista.ListaVaziaException;
import Vetor.RankNaoExisteException;

public class bubbleSort {
	
	int size;
	Sequencia S;
	Sequencia S3, S4;
	Sequencia S1;
	Sequencia S2;
	
	public Sequencia mergeSort (Sequencia S) throws ListaVaziaException, RankNaoExisteException {
		S4 = new Sequencia();
		S4 = S;
		size = S.size();
		if (size>1){ 
			S1 = new Sequencia();
			S2 = new Sequencia();
			for (int i=0; i<size/2; i++){
				S1.insertLast(S.elementAtRank(i));
				System.out.println("quebrou 1 = "+S1.last());
			}
			for (int j=size/2; j<size; j++){
				S2.insertLast(S.elementAtRank(j));
				System.out.println("quebrou 2 = "+S2.last());
			}
			
			S1 = mergeSort(S1);
			S2 = mergeSort(S2);
			return merge(S1, S2);
		} 
		System.out.println("Menor que 1");
		return S4;
	}
	
	public Sequencia merge (Sequencia S1, Sequencia S2) throws ListaVaziaException, RankNaoExisteException{
		
		S3 = new Sequencia();
		
		System.out.println("Simbora fazer o merge");
		
		for(int i=0; i<S1.size(); i++){
			System.out.println("S1 do merge = " + S1.elementAtRank(i));
		}
		
		for(int i=0; i<S2.size(); i++){
			System.out.println("S2 do merge = " + S2.elementAtRank(i));
		}
		
		
		while (!S1.isEmpty() && !S2.isEmpty()){
			if(S1.first().getElemento() < S2.first().getElemento()){
				System.out.println("entrou");
				S3.insertLast(S1.first().getElemento());
				S1.remove(S1.first());
			} else {
				System.out.println("entrou 2");
				S3.insertLast(S2.first().getElemento());
				S2.remove(S2.first());
			}
		}
		
		while (!S1.isEmpty()){
			System.out.println("entrou 3");
			S3.insertLast(S1.first().getElemento());
			S1.remove(S1.first());
		}
		
		while (!S2.isEmpty()){
			System.out.println("entrou 4");
			S3.insertLast(S2.first().getElemento());
			S2.remove(S2.first());
		}
		
		return S3;
	}
	
	public int [] bs (int a[]) {
		int aux=0;
		int qtdII=0;
		int qtd = a.length;
		for (int i=0; i<qtd-1; i++) {
			for (int j=0; j<(qtd-1)-i; j++) {
				if (a[j]>a[j+1]) {
					aux=a[j];
					a[j]=a[j+1];
					a[j+1]=aux;
				}
//				System.out.println(j);
			}
//			System.out.println("##########");
		}
		return a; 
	}
}	
