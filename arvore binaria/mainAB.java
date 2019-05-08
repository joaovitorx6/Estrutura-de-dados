package Arvore;
import java.util.Scanner;
import java.util.ArrayList;

public class MainArvoreB {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		nodeArvoreB nodeab, node; 
		int elemento;
		ArvoreBinaria ab = new ArvoreBinaria(10);
		ArrayList <nodeArvoreB> nodesArvore;
		System.out.println("Raiz:" + ab.root().getElemento());
		nodeab=ab.root();
		
		try {
			ab.addChild(nodeab, 20);
			ab.addChild(nodeab, 5);
//			ab.addChild(nodeab, 50);
//			ab.addChild(nodeab, 10);
//			ab.addChild(nodeab, 60);
//			ab.addChild(nodeab, 8);
//			ab.addChild(nodeab, 7);
//			ab.addChild(nodeab, 49);
//			ab.addChild(nodeab, 48);
		}catch(InvalidPositionException ipex){
			System.out.println(ipex.getMessage());
		}
		
		
		System.out.println("Altura" + ab.height(nodeab));
		System.out.println("Profundidade" + ab.depth(nodeab));
//	
//		ab.inOrder(nodeab);
////		System.out.println(ab.height(nodeab));
//		
//		ab.remove(nodeab);
//		node = ab.find(nodeab, 50);
//		System.out.println(node.getElemento());
//		ab.remove(node);
//		
//		ab.preOrder(nodeab);
		
//		System.out.println(nodeab.getElemento());
//		System.out.println(nodeab.getNodeFilhoD().getElemento());
//		System.out.println(nodeab.getNodeFilhoE().getElemento());
//		
//		nodesArvore = ab.inOrder(nodeab, true);
//		for (int i=0; i<nodesArvore.size(); i++){
//			System.out.println(nodesArvore.get(i).getElemento() + " + ");
//		}
		
		ab.mostrarArvore(nodeab);
		
	}
}
