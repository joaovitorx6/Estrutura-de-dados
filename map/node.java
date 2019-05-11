import java.util.ArrayList;

public class node {
	public int element;
	public int key;
	public ArrayList<node>lista;
	
	public node(int element, int key){
		this.element = element;
		this.key=key;
		lista = new ArrayList<>();
	}
	
	public node(){
		element = 0;
		key=0;
	}
	
	public int getElement() {
		return element;
	}
	
	public void setElement(int element) {
		this.element = element;
	}
	
	public void setLista(ArrayList<node> lista) {
		this.lista = lista;
	}
	
	public ArrayList<node> getLista() {
		return lista;
	}
	
	public int getKey() {
		return key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public void setItemList(node n){
		lista.add(n);
	}
	
	public void removeItemList(node n){
		lista.remove(n);
	}
	
}
