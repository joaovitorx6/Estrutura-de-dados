package Arvore;
import java.util.Vector;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;

public class ArvoreBinaria implements ArvoreB {

//	variaveis
	Scanner input = new Scanner(System.in);
	ArrayList <nodeArvoreB> nodesArvore;
	nodeArvoreB nodeRoot = new nodeArvoreB();
	nodeArvoreB novoNo, nodePai, node;
	int tamanho, elemento, elementoE, elementoD; 
	boolean x;
	Iterator <nodeArvoreB> nodesArvoreI;
	
//	construct
	public ArvoreBinaria(int elemento){
		nodeRoot.setElemento(elemento);
		tamanho=1;
	}
//	methods.
	
	@Override
	public nodeArvoreB root() {
		// TODO Auto-generated method stub
		return nodeRoot;
	}
	
	public nodeArvoreB parent(nodeArvoreB v) 
	{	
		if (!isRoot(v)){
			nodeArvoreB n = (nodeArvoreB) v;
			return (n.getNodePai());
		}
		
		return null;

	}
	
	public Iterator children(nodeArvoreB v)
	{
		nodesArvore = new ArrayList<>();
		nodesArvore.add(v.getNodeFilhoD());
		nodesArvore.add(v.getNodeFilhoE());
		nodesArvoreI = nodesArvore.iterator();
		return nodesArvoreI;
	}
	
	public boolean isInternal(nodeArvoreB v) {
		nodeArvoreB n = (nodeArvoreB) v;
		if(hasRight(n) || hasLeft(n)){ //return (n.childrenNumber() > 0);
			return true; 
		} else {
			return false;
		}
	}
	
	public boolean isExternal(nodeArvoreB v) {
		nodeArvoreB n = (nodeArvoreB) v;
		if(!hasLeft(n) && !hasRight(n)) //return (n.childrenNumber() == 0);
			return true; 
		else 
			return false;
	}
	
	public boolean isRoot(nodeArvoreB v){
		nodeArvoreB n = (nodeArvoreB) v;
		//return n == raiz;
		if (n==nodeRoot)
			return true;
		else 
			return false;
	}
	
	public void addChild(nodeArvoreB v, int o) throws InvalidPositionException {
		
		nodeArvoreB n = (nodeArvoreB) v;
		elemento = n.getElemento();
		
//		n�o tem filhos, e adiciona de acordo com a restri��o da �rvore bin�ria.
		if(isExternal(n)){
			System.out.println("Entrou no primeiro if");
			novoNo = new nodeArvoreB();
			novoNo.setElemento(o);
			novoNo.setNodePai(n);
			if (o>elemento){
				System.out.println("Entrou no primeiro if direita");
				n.setNodeFilhoD(novoNo);
				tamanho++;
			} else {
				System.out.println("Entrou no primeiro if esquerda");
				n.setNodeFilhoE(novoNo);
				tamanho++;
			}
		} else if (isInternal(n)){
				if (o<elemento){
					if (hasLeft(n)){
						addChild(n.getNodeFilhoE(), o);
					}
					else {
						novoNo = new nodeArvoreB();
						novoNo.setElemento(o);
						novoNo.setNodePai(n);
						n.setNodeFilhoE(novoNo);
					}
				}
				if (o>elemento){
					if (hasRight(n)){
						addChild(n.getNodeFilhoD(), o);
					} else {
						novoNo = new nodeArvoreB();
						novoNo.setElemento(o);
						novoNo.setNodePai(n);
						n.setNodeFilhoD(novoNo);
					}
				} 
		}
	}
	
//methods arvore binaria.
	public nodeArvoreB leftChild(nodeArvoreB n) throws InvalidPositionException{
		if (!hasLeft(n)){
			throw new InvalidPositionException("Filho da esquerda n�o existe");
		} 
		return n.getNodeFilhoE();
	}
	
	public nodeArvoreB rightChild(nodeArvoreB n) throws InvalidPositionException {
		if (!hasRight(n)){
			throw new InvalidPositionException("Filho da direita n�o existe");
		}
		return n.getNodeFilhoD();
	}
	
	public boolean hasLeft(nodeArvoreB n){
		if (n.getNodeFilhoE()!=null){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean hasRight(nodeArvoreB n){
		if (n.getNodeFilhoD()!=null){
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList <nodeArvoreB> inOrder(nodeArvoreB n, boolean x){
		
		if (x==true){
			nodesArvore = new ArrayList<>(); 
		}
		
		if(isInternal(n)){
			if(hasLeft(n)){
				inOrder(n.getNodeFilhoE(), false);
			}
		}
		
		nodesArvore.add(n);
		
		if(isInternal(n)){
			if (hasRight(n)){
				inOrder(n.getNodeFilhoD(), false);
			}
		}
		
		return nodesArvore;

	}
	
	public ArrayList <nodeArvoreB> posOrder(nodeArvoreB n, boolean x){
		
		if (x==true){
			nodesArvore = new ArrayList<>();
		}
		
		if (isInternal(n)){
			if (n.getNodeFilhoE()!=null){
				posOrder(n.getNodeFilhoE(), false);
			} 
			if (n.getNodeFilhoD()!=null){
				posOrder(n.getNodeFilhoD(), false);
			}
		}
		
		nodesArvore.add(n);
		
		return nodesArvore;
	}
	
	public ArrayList<nodeArvoreB>preOrder(nodeArvoreB n, boolean x){
		if (x==true){
			nodesArvore = new ArrayList<>();
		}
		nodesArvore.add(n);
		if (isInternal(n)){
			if (n.getNodeFilhoE()!=null){
				preOrder(n.getNodeFilhoE(), false);
			} 
			if (n.getNodeFilhoD()!=null){
				preOrder(n.getNodeFilhoD(), false);
			}
		}
		return nodesArvore;
	}
	
	public int remove(nodeArvoreB v) { //public Object remove(Position v)
		
		nodeArvoreB n = (nodeArvoreB) v;
		elemento = n.getElemento();
		
//		se n�o tem filho e � raiz.
		if(isRoot(n) && isExternal(n)){
			nodeRoot=null;
			tamanho--;
			
//		se ele tiver pai e n�o tiver filho.
		} else if(parent(n)!=null && isExternal(n)){
			nodePai = n.getNodePai();
//		verifica se � o filho da esquerda.
			if (nodePai.getNodeFilhoE()==n){
				nodePai.setNodeFilhoE(null);
			} 
//			verifica se � o filho da direita.
			if (nodePai.getNodeFilhoD()==n){
				nodePai.setNodeFilhoD(null);
			}
			n=null;
			tamanho--;
			
//	se tem apenas 1 filho ou os dois filhos.
			
		} else if (isInternal(n)){
			if (hasRight(n) && !hasLeft(n)){
				elementoD = n.getNodeFilhoD().getElemento();
				n.setElemento(elementoD);
				n.setNodeFilhoD(null);
			}
			if (hasLeft(n) && !hasRight(n)){
				elementoE = n.getNodeFilhoE().getElemento();
				n.setElemento(elementoE);
				n.setNodeFilhoE(null);
			} 
			if (hasLeft(n) && hasRight(n)){
				node = findNodeRemove(n.getNodeFilhoD());
				n.setElemento(node.getElemento());
				node = null;
				tamanho--;
			}
			tamanho--;
		}
		return elemento;
	}
	
	public nodeArvoreB find(nodeArvoreB n, int elemento){
		if (n.elemento==elemento){
			System.out.println("Entrou no primeiro if");
			node = n;
		} else if (isInternal(n)) {
			System.out.println("Entrou no segundo if");
			if (n.getElemento()<elemento && n.getNodeFilhoD()!=null){
				System.out.println("Entrou no primeiro do segundo if");
				node = find(n.getNodeFilhoD(), elemento);
			} else if (n.getElemento()>elemento && n.getNodeFilhoE()!=null){
				System.out.println("Entrou no segundo do segundo if");
				node = find(n.getNodeFilhoE(), elemento);
			}
		}
		return node;
	}
	
	public nodeArvoreB findNodeRemove(nodeArvoreB n){
		if (isExternal(n)){
			node = n;
		} else if (isInternal(n)) {
			if (hasLeft(n)){
				node = findNodeRemove(n.getNodeFilhoE());
			} 
		}
		return node;
	}
	
//	public Object remove(nodeArvoreB v) throws InvalidPositionException { //public Object remove(Position v)
//		nodeArvore n = (nodeArvore) v;
//		nodeArvore pai = n.getPai(); //NoArvore pai = n.parent();
//		if (pai != null || isExternal(n)) //se ele n�o tiver filho.
//			pai.removeChild(n);
//		else
//			throw new InvalidPositionException("Posi��o Invalida.");
//		Object o = n.element();
//		tamanho--;
//		return o;
//	}
//	
	
//	public void swapElements(nodeArvoreB v, nodeArvoreB w){
//		int element = v.getElemento();
//		int element2 = w.getElemento();
//		v.setElemento(element2);
//		w.setElemento(element);
//	}
//	
	

//	public int replace(nodeArvoreB v, int o) {
//		// TODO Auto-generated method stub
//		int elemento = v.getElemento();
//		v.setElemento(o);
//		return elemento;
//	}
	
	public int depth(nodeArvoreB v)
	{
		nodeArvoreB n = (nodeArvoreB) v;
		if (isRoot(n))
			return 0;
		else 
			return 1+depth(n.getNodePai());
	}
	
	public int height(nodeArvoreB n) {
		if(n == null || isExternal(n)) {
			return 0;
		}
		else {
			return 1 + Math.max(height(n.getNodeFilhoE()), height(n.getNodeFilhoD()));
		}
	}
//	
	
	
	public Iterator elements() {
		nodesArvoreI = inOrder(nodeRoot, true).iterator();
		return nodesArvoreI;
	}
	
	
	public Iterator nos()
	{
		nodesArvoreI = inOrder(nodeRoot,true).iterator();
		return nodesArvoreI;
	}
	
	public int size()
	{
		return tamanho;
	}
	
	public boolean isEmpty()
	{
		return false;
	}
	
	public void mostrarArvore(nodeArvoreB nodeRoot){
		
		nodesArvore = inOrder(nodeRoot, true);
		String arvore = " "; 
		System.out.println(nodesArvore.size());
		String [][] tree = new String [height(nodeRoot)+1][nodesArvore.size()];
		
		for (int i=0; i<nodesArvore.size(); i++){
			node = nodesArvore.get(i);
//			System.out.println(depth(node));
			tree[depth(node)][i] = Integer.toString(node.getElemento());
		}
		
		for (int i=0; i<height(nodeRoot)+1; i++){
			for (int k=0; k<nodesArvore.size(); k++){
				if (tree[i][k]==null){
					arvore+="    ";
				} else {
					arvore+=tree[i][k];
					arvore+="    ";
				}
				//				System.out.println(tree[i][k]);
			}
			arvore+="\n";
		}
		
		System.out.println(arvore);
//		
//		return arvore;
	}

	@Override
	public int replace(nodeArvoreB v, int o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void swapElementos(nodeArvoreB n, nodeArvoreB v) {
		// TODO Auto-generated method stub
		
	}
	
}