package Arvore;

import java.util.Iterator;

public interface ArvoreB {
	/* Métodos genéricos */
	/** Retorna o número de nós da árvore */
	public int size();
	/** retorna se a árvore está vazia */
	public boolean isEmpty();
	/** Retorna a altura da árvore */
	public int height();
	/** Retorna um iterator com os elementos armazenados na árvore */
	public Iterator elements();
	/** Retorna um iterator com as posições (nós) da árvore */
	public Iterator nos();

	/* Métodos de acesso*/
	/** Retorna a raiz da árvore */
	public nodeArvoreB root();
	/** Retorna o nó pai de um nó */
	public nodeArvoreB parent(nodeArvoreB v);
	/** Retorna os filhos de um nó */
	public Iterator children(nodeArvoreB v);

	/* Métodos de consulta */
	/** Testa se um nó é interno */
	public boolean isInternal(nodeArvoreB v);
	/** Testa se um nó é externo*/
	public boolean isExternal(nodeArvoreB v);
	/** Testa se um nó é a raiz */
	public boolean isRoot(nodeArvoreB v);
	/** Retorna a profundidade de um nó */
	public int depth(nodeArvoreB v);

	/* Métodos de atualização */
	/** Substitui o objeto de um um nó */
	public int replace(nodeArvoreB v, int o);
	/** Retorna a profundidade de um nó */
}
