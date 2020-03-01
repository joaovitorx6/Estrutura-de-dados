package arvoreBinaria;

import java.util.Vector;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;

public class arvoreB implements interfaceArvoreB {
	
//	variaveis
	ArrayList <nodeAB> nodesTree;
	nodeAB nodeRaiz = new nodeAB();
	nodeAB nodeR;
	int tamanho=0;
	Iterator <nodeAB> iteratorNodes;
	
//	construtor
	public arvoreB(int elemento){
		nodeRaiz.setElemento(elemento);
		tamanho=1;
	}
	
//	metodos.
	
//	retorna o node raiz.
	public nodeAB root() {
		return nodeRaiz;
	}

// retorna o pai do node.
	public nodeAB parent(nodeAB node) {	
		
		if (!isRoot(node)){
			nodeAB nodeT = (nodeAB) node;
			return (nodeT.getNodePai());
		}
		
		return null;

	}
	
//	public Iterator children(nodeArvoreB v)
//	{
//		nodesArvore = new ArrayList<>();
//		nodesArvore.add(v.getNodeFilhoD());
//		nodesArvore.add(v.getNodeFilhoE());
//		nodesArvoreI = nodesArvore.iterator();
//		return nodesArvoreI;
//	}
//	
	
// retorna um boolean se o node tem filhos.
	public boolean isInternal(nodeAB node) {
		nodeAB nodeT = (nodeAB) node;
		if(hasRight(nodeT) || hasLeft(nodeT)){ //return (n.childrenNumber() > 0);
			return true; 
		} else {
			return false;
		}
	}
	
// retorna um boolean se o node não tem filhos.	
	public boolean isExternal(nodeAB node) {
		nodeAB nodeT = (nodeAB) node;
		if(!hasLeft(nodeT) && !hasRight(nodeT)) //return (n.childrenNumber() == 0);
			return true; 
		else 
			return false;
	}
	
//verifica se o node é raiz.
	public boolean isRoot(nodeAB node){
		nodeAB nodeT = (nodeAB) node;
		//return n == raiz;
		if (nodeT==nodeRaiz)
			return true;
		else 
			return false;
	}

//adiciona filho na árvore.
	public void addChild(nodeAB node, int elemento) throws InvalidPositionException {
		
		nodeAB newNode;
		nodeAB nodeT = (nodeAB) node;
		int elementoT = nodeT.getElemento();
		
//		nao tem filhos, e adiciona de acordo com a restricao da arvore binaria (menor e maior).
		if(isExternal(nodeT)){
			
			newNode = new nodeAB();
			newNode.setElemento(elemento);
			newNode.setNodePai(nodeT);
			
			if (elemento>elementoT){
				nodeT.setnodeFD(newNode);
				tamanho++;
			} else {
				nodeT.setnodeFE(newNode);
				tamanho++;
			}
			
//	 tem filhos, e adiciona de acordo com a restricao da arvore binaria (menor e maior) recursivamente, achando o lugar correto.			
		} else if (isInternal(nodeT)){
				
				if (elemento<elementoT){
					if (hasLeft(nodeT)){
						addChild(nodeT.getnodeFE(), elemento);
					}
					else {
						newNode = new nodeAB();
						newNode.setElemento(elemento);
						newNode.setNodePai(nodeT);
						nodeT.setnodeFE(newNode);
					}
					
				} else if (elemento>elementoT){
					if (hasRight(nodeT)){
						addChild(nodeT.getnodeFD(), elemento);
					} else {
						newNode = new nodeAB();
						newNode.setElemento(elemento);
						newNode.setNodePai(nodeT);
						nodeT.setnodeFD(newNode);
					}
				} 
		}
	}
	
// retorna o filho esquerdo do node.	
	public nodeAB leftChild(nodeAB node) throws InvalidPositionException{
		if (!hasLeft(node)){
			throw new InvalidPositionException("Filho da esquerda não existe");
		} 
		return node.getnodeFE();
	}
	
// retorna o filho direito do node.		
	public nodeAB rightChild(nodeAB node) throws InvalidPositionException {
		if (!hasRight(node)){
			throw new InvalidPositionException("Filho da direita no existe");
		}
		return node.getnodeFD();
	}
	
// verifica se o node tem filho esquerdo.			
	public boolean hasLeft(nodeAB node){
		if (node.getnodeFE()!=null){
			return true;
		} else {
			return false;
		}
	}
	
// verifica se o node tem filho direito.		
	public boolean hasRight(nodeAB node){
		if (node.getnodeFD()!=null){
			return true;
		} else {
			return false;
		}
	}

// visita primeiro os filhos da esquerda, depois o própio node e após isso os filhos da direita.	
	public ArrayList <nodeAB> inOrder(nodeAB node, boolean siga){
		
		nodeAB nodeT = (nodeAB) node;
		
		if (siga==true){
			nodesTree = new ArrayList<>(); 
		}
		
		if(isInternal(nodeT)){
			if(hasLeft(nodeT)){
				nodesTree = inOrder(nodeT.getnodeFE(), false);
			}
		}
		
		nodesTree.add(nodeT);
		
		if(isInternal(nodeT)){
			if (hasRight(nodeT)){
				nodesTree = inOrder(nodeT.getnodeFD(), false);
			}
		}
		
		return nodesTree;

	}
	
// visita primeiro os filhos da direita, depois os filhos da esquerda, e por fim o própio node.	
	public ArrayList <nodeAB> posOrder(nodeAB node, boolean siga){
		
		if (siga==true){
			nodesTree = new ArrayList<>();
		}
		
		if (isInternal(node)){
			if (node.getnodeFE()!=null){
				posOrder(node.getnodeFE(), false);
			} 
			if (node.getnodeFD()!=null){
				posOrder(node.getnodeFD(), false);
			}
		}
		
		nodesTree.add(node);
		
		return nodesTree;
	}
	
// visita primeiro o node, depois os filhos da esquerda, e por fim os filhos da direita.	
	public ArrayList<nodeAB>preOrder(nodeAB node, boolean siga){
		
		if (siga==true){
			nodesTree = new ArrayList<>();
		}
		
		nodesTree.add(node);
		
		if (isInternal(node)){
			if (node.getnodeFE()!=null){
				nodesTree = preOrder(node.getnodeFE(), false);
			} 
			if (node.getnodeFD()!=null){
				nodesTree = preOrder(node.getnodeFD(), false);
			}
		}
		
		return nodesTree;
	}
	
//	metodo pra encontrar node especifico na arvore. 
	public nodeAB findNode(int elemento) {
		nodesTree = inOrder(nodeRaiz, true);
		int size = nodesTree.size();
		for (int i=0; i<size; i++) {
			if (nodesTree.get(i).getElemento()==elemento) {
				return nodesTree.get(i);
			}
		}
		return null;
	}
	
//	metodo para remover um node.
	public int remove(int elemento) { //public Object remove(Position v)
		
//		node que vai ser o novo node no lugar do node que sera removido.
		nodeAB nodeZ;
//		node que vai ser removido.
		nodeAB nodeT = findNode(elemento);
		
		int elementoT = nodeT.getElemento();
		int elementoD; 
		
//		se não tem filho e é raiz.
		if(isRoot(nodeT) && isExternal(nodeT)){
			nodeRaiz=null;
			tamanho--;
			
//		se ele tiver pai e nao tiver filho.
		} else if(parent(nodeT)!=null && isExternal(nodeT)){
			
			nodeAB nodePai;
			nodePai = nodeT.getNodePai();
			
//		verifica se é o filho da esquerda ou se é o filho da direita..
			if (nodePai.getnodeFE()==nodeT){
				nodePai.setnodeFE(null);
			} else if (nodePai.getnodeFD()==nodeT){
				nodePai.setnodeFD(null);
			}
			
			nodeT=null;
			tamanho--;
			
//	se tem apenas 1 filho ou os dois filhos.
			
		} else if (isInternal(nodeT)){
			
			if (hasRight(nodeT) && !hasLeft(nodeT)){
				
				elementoD = nodeT.getnodeFD().getElemento();
				nodeT.setElemento(elementoD);
				nodeT.setnodeFD(null);
				
//				falta destruir o nodeFD.
			} else if (hasLeft(nodeT) && !hasRight(nodeT)){
				
				elementoD = nodeT.getnodeFE().getElemento();
				nodeT.setElemento(elementoD);
				nodeT.setnodeFE(null);
				
			} else if (hasLeft(nodeT) && hasRight(nodeT)){
				
				nodeZ = findNodeForRemove(nodeT.getnodeFD());
// 				verificar se o que está sendo removido é o esquerdo ou direito, pra setar a referencia para o pai.
				
//				mudando as referências caso o node escolhido seja o filho da direita do node escolhido.
				if (nodeZ.getNodePai().getnodeFD()==nodeZ) {
					
					nodeZ.setnodeFE(nodeT.getnodeFE());
					nodeT.getnodeFE().setNodePai(nodeZ);
					
					nodeZ.setNodePai(nodeT.getNodePai());
					nodeT.getNodePai().setnodeFD(nodeZ);
					
//					mudando as referências caso o node escolhido seja o filho da esquerda.
				} else if (nodeZ.getNodePai().getnodeFE()==nodeZ) {
					
					nodeZ.setnodeFE(nodeT.getnodeFE());
					nodeT.getnodeFE().setNodePai(nodeZ);
					
					nodeZ.setNodePai(nodeT.getNodePai());
					nodeT.getNodePai().setnodeFD(nodeZ);
					
					nodeT.getnodeFD().setNodePai(nodeZ);
					nodeZ.setnodeFD(nodeT.getnodeFD());
					nodeT.getnodeFD().setnodeFE(null);
					}

				nodeT.setElemento(nodeZ.getElemento());
				nodeZ = null;
				tamanho--;
			}
			
			tamanho--;
		}
		return elementoT;
	}
	
	public nodeAB findNodeForRemove(nodeAB nodeT){
		if (isExternal(nodeT)){
			nodeR = nodeT;
		} else if (isInternal(nodeT)) {
			if (hasLeft(nodeT)){
				nodeR = findNodeForRemove(nodeT.getnodeFE());
			} else {
				nodeR = nodeT;
			}
		}
		return nodeR;
	}
	
	
	public int depth(nodeAB nodeT)
	{
		nodeAB nodeW = (nodeAB) nodeT;
		if (isRoot(nodeW))
			return 0;
		else 
			return 1+depth(nodeW.getNodePai());
	}

	
	public int height(nodeAB n) {
		if(n == null || isExternal(n)) {
			return 0;
		}
		else {
			return 1 + Math.max(height(n.getnodeFE()), height(n.getnodeFD()));
		}
	}

	
	public int size()
	{
		return tamanho;
	}
	
	public boolean isEmpty()
	{
		return false;
	}
	
	public String viewTree(nodeAB nodeRaiz){
		
		nodesTree = inOrder(nodeRaiz, true);
		String arvore = " "; 
		
		String [][] tree = new String [height(nodeRaiz)+1][nodesTree.size()];
		
		for (int k=0; k<nodesTree.size(); k++){
			nodeR = nodesTree.get(k);
			tree[depth(nodeR)][k] = Integer.toString(nodeR.getElemento());
		}
		
		for (int i=0; i<height(nodeRaiz)+1; i++){
			for (int k=0; k<nodesTree.size(); k++){
				if (tree[i][k]==null){
					arvore+="    ";
				} else {
					arvore+=tree[i][k];
					arvore+="    ";
				}
			}
			arvore+="\n";
		}

		return arvore;

	}

	@Override
	public Iterator elements() {
		iteratorNodes = inOrder(nodeRaiz, true).iterator();
		return iteratorNodes;
	}

	@Override
	public Iterator nos() {
		iteratorNodes = inOrder(nodeRaiz,true).iterator();
		return iteratorNodes;
	}

	@Override
	public Iterator children(nodeAB v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int replace(nodeAB v, int o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void swapElementos(nodeAB n, nodeAB v) {
		// TODO Auto-generated method stub
		
	}

}
