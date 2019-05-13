import java.util.Iterator;
public class mainMap {

	public static void main(String[] args) {
		Map map = new Map ();
		Iterator <Integer> keys;
		int n;
		
		node a[];
		map.insertItem(26, 1);
		map.insertItem(36, 3);
//		map.insertItem(500, 3);
//		map.insertItem(800, 4);
		
		try{
			System.out.println(map.removeElement(26));
			System.out.println(map.findElement(36));
		} catch (invalidKeyException e){
			System.out.println(e.getMessage());
		}
	}
}
