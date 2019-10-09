
public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Resources resources = new Resources();
		Resources2 resources = new Resources2();
//		Producter producter = new Producter(resources,1);
//		Consumer consumer = new Consumer(resources,1);
		new Thread(new Producter(resources,1)).start();
		new Thread(new Consumer(resources,1)).start();
		new Thread(new Producter(resources,2)).start();
//		new Thread(new Consumer(resources,2)).start();
	
	}

}
