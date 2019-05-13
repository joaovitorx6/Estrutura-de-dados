 
import java.util.ArrayList;
import java.util.Iterator;

public class Map {
	
	public node a [];
	public node n;
	public ArrayList <node> lista;
	public ArrayList <Integer> listaKeys, listaElements;
	public int element, hash, tamanho, key;
	public Iterator <Integer> keys, elements;
	
	public Map(){
		 a = new node[5];
		 tamanho=0;
	}
	
	public int findElement(int k) throws invalidKeyException{
		hash = k%a.length;
		if(a[hash]==null){
			throw new invalidKeyException("Chave invalida.");
		} else {
			if (a[hash].getKey()==k){
				System.out.println("Entrou");
				element = a[hash].getElement();
				return element;
			} else {
				System.out.println("Entrou 2");
				lista = a[hash].getLista();
				for (int i=0; i<lista.size(); i++){
					if (lista.get(i).getKey()==k){
						element = lista.get(i).getElement();
						break;
					}
				}
			}
		}
		return element;
	}
	
	public void insertItem(int k, int e){
		hash = k%a.length;
		System.out.println(hash);
		if (a[hash]==null){
			System.out.println("entrou");
			n = new node(e,k);
			a[hash]=n;
		} else {
			System.out.println("entrou 2");
			n = new node ();
			n.setElement(e);
			n.setKey(k);
			a[hash].setItemList(n);
		}
	}
	
	public int removeElement(int k) throws invalidKeyException {
		hash = k%a.length;
		if (a[hash]==null){
			throw new invalidKeyException("Chave invalida.");
		} else {
			if (a[hash].getKey()==k){
				element = a[hash].getElement();
				lista = a[hash].getLista();
				lista.get(0).setLista(lista);
				a[hash]=lista.get(0);
				return element;
			} else {
				lista = a[hash].getLista();
				for (int i=0; i<lista.size(); i++){
					if (lista.get(i).getKey()==k){
						element = lista.get(i).getElement();
						a[hash].removeItemList(lista.get(i));
						break;
					}
				}
			}
		}
			return element;
	}
	
	public int size(){
		return tamanho;
	}
	
	public boolean isEmpty(){
		if (size()==0){
			return true;
		} else {
			return false;
		}
	}
	
	public Iterator keys(){
		for (int i=0; i<a.length; i++){
			if (a[i]!=null){
				lista=a[i].getLista();
				key = a[i].getKey();
			}
			listaKeys.add(key);
			for (int k=0; k<lista.size(); k++){
				listaKeys.add(lista.get(i).getKey());
			}
		}
		keys = listaKeys.iterator();
		return keys;
	}
	
	public Iterator Elements(){
		for (int i=0; i<a.length; i++){
			if (a[i]!=null){
				lista=a[i].getLista();
				element = a[i].getElement();
			}
			listaElements.add(element);
			for (int k=0; k<lista.size(); k++){
				listaElements.add(lista.get(i).getElement());
			}
		}
		elements = listaElements.iterator();
		return elements;
	}
}
