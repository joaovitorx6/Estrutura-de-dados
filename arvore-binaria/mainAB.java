package arvoreBinaria;
import java.util.ArrayList;
import java.util.Scanner;

public class mainAB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		nodeAB nodeTeste = new nodeAB();
		nodeAB nodeTree; 
		ArrayList <nodeAB> nodesTree;
		int sizeTree, i;
		String treeView;
		
		try {
			arvoreB tree = new arvoreB(40); 
			
			nodeTree = tree.root();
			
			tree.addChild(nodeTree, 50);
			tree.addChild(nodeTree, 30);
			
			treeView = tree.viewTree(nodeTree);
			System.out.println(treeView);
			
//			nodesTree = tree.posOrder(nodeTree, true);
//			sizeTree = nodesTree.size();
			
//			for (i=0; i<sizeTree; i++) {
//				System.out.println(nodesTree.get(i).getElemento());
//			}
			
		}catch(InvalidPositionException ipex){
			System.out.println(ipex.getMessage());
		}
	}

}
