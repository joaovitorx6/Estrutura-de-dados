package Arvore;

import java.util.Iterator;

public interface ArvoreB {
	/* M�todos gen�ricos */
	/** Retorna o n�mero de n�s da �rvore */
	public int size();
	/** retorna se a �rvore est� vazia */
	public boolean isEmpty();
	/** Retorna a altura da �rvore */
	public int height(nodeArvoreB n);
	/** Retorna um iterator com os elementos armazenados na �rvore */
	public Iterator elements();
	/** Retorna um iterator com as posi��es (n�s) da �rvore */
	public Iterator nos();

	/* M�todos de acesso*/
	/** Retorna a raiz da �rvore */
	public nodeArvoreB root();
	/** Retorna o n� pai de um n� */
	public nodeArvoreB parent(nodeArvoreB v);
	/** Retorna os filhos de um n� */
	public Iterator children(nodeArvoreB v);

	/* M�todos de consulta */
	/** Testa se um n� � interno */
	public boolean isInternal(nodeArvoreB v);
	/** Testa se um n� � externo*/
	public boolean isExternal(nodeArvoreB v);
	/** Testa se um n� � a raiz */
	public boolean isRoot(nodeArvoreB v);
	/** Retorna a profundidade de um n� */
	public int depth(nodeArvoreB v);

	/* M�todos de atualiza��o */
	/** Substitui o objeto de um um n� */
	public int replace(nodeArvoreB v, int o);
	/** Retorna a profundidade de um n� */
	public void swapElementos(nodeArvoreB n, nodeArvoreB v);
}
