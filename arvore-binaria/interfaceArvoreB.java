package arvoreBinaria;

import java.util.Iterator;

public interface interfaceArvoreB {
	/* M�todos gen�ricos */
	/** Retorna o n�mero de n�s da �rvore */
	public int size();
	/** retorna se a �rvore est� vazia */
	public boolean isEmpty();
	/** Retorna a altura da �rvore */
	public int height(nodeAB n);
	/** Retorna um iterator com os elementos armazenados na �rvore */
	public Iterator elements();
	/** Retorna um iterator com as posi��es (n�s) da �rvore */
	public Iterator nos();

	/* M�todos de acesso*/
	/** Retorna a raiz da �rvore */
	public nodeAB root();
	/** Retorna o n� pai de um n� */
	public nodeAB parent(nodeAB v);
	/** Retorna os filhos de um n� */
	public Iterator children(nodeAB v);

	/* M�todos de consulta */
	/** Testa se um n� � interno */
	public boolean isInternal(nodeAB v);
	/** Testa se um n� � externo*/
	public boolean isExternal(nodeAB v);
	/** Testa se um n� � a raiz */
	public boolean isRoot(nodeAB v);
	/** Retorna a profundidade de um n� */
	public int depth(nodeAB v);

	/* M�todos de atualiza��o */
	/** Substitui o objeto de um um n� */
	public int replace(nodeAB v, int o);
	/** Retorna a profundidade de um n� */
	public void swapElementos(nodeAB n, nodeAB v);
}

