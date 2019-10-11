import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EggBusiness {
	
	static LinkedList<Consumer> client = new LinkedList<>();
	static List<Integer> eggsPerClient = new ArrayList<>();
	
	public static void main(String[] args){
		MangKanor drop = new MangKanor();
		
		String[] names = {"Taylor","Luther","Elsa","Darla","Lisa"};
		for(int i = 0; i<names.length;client.add(new Consumer(names[i])),i++);
		for(int i =0; i<client.size();i++) {
			(new Thread(client.get(i))).start();
		}
		(new Thread(new Producer(drop))).start();
    }
}