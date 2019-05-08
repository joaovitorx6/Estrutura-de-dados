package Arvore;

public class nodeArvoreB {
	
	int elemento;
	nodeArvoreB nodePai;
	nodeArvoreB nodeFilhoE;
	nodeArvoreB nodeFilhoD;
	
	//	construct
	public nodeArvoreB(){
		elemento = 0;
		nodePai = null;
		nodeFilhoE = null;
		nodeFilhoD = null;
	}
	
	public int getElemento() {
		return elemento;
	}
	
	public nodeArvoreB getNodePai() {
		return nodePai;
	}
	
	public nodeArvoreB getNodeFilhoD() {
		return nodeFilhoD;
	}
	
	public nodeArvoreB getNodeFilhoE() {
		return nodeFilhoE;
	}

	public void setElemento(int elemento) {
		this.elemento = elemento;
	}
	
	public void setNodePai(nodeArvoreB nodePai) {
		this.nodePai = nodePai;
	}
	
	public void setNodeFilhoE(nodeArvoreB nodeFilhoE) {
		this.nodeFilhoE = nodeFilhoE;
	}
	
	public void setNodeFilhoD(nodeArvoreB nodeFilhoD) {
		this.nodeFilhoD = nodeFilhoD;
	}
	
	
}
