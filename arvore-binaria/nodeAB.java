package arvoreBinaria;

public class nodeAB {
	
	int elemento;
	nodeAB nodePai;
	nodeAB nodeFE;
	nodeAB nodeFD;
	
	//	construct
	public void nodeArvoreB(){
		elemento = 0;
		nodePai = null;
		nodeFE = null;
		nodeFD = null;
	}
	
	public int getElemento() {
		return elemento;
	}
	
	public nodeAB getNodePai() {
		return nodePai;
	}
	
	public nodeAB getnodeFD() {
		return nodeFD;
	}
	
	public nodeAB getnodeFE() {
		return nodeFE;
	}

	public void setElemento(int elemento) {
		this.elemento = elemento;
	}
	
	public void setNodePai(nodeAB nodePai) {
		this.nodePai = nodePai;
	}
	
	public void setnodeFE(nodeAB nodeFE) {
		this.nodeFE = nodeFE;
	}
	
	public void setnodeFD(nodeAB nodeFD) {
		this.nodeFD = nodeFD;
	}
	
	
}
