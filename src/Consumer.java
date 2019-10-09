
/**
 * 
 * @author 13653 Ïû·ÑÕß
 */

public class Consumer implements Runnable {
	private Resources2 resource;
	private int No;

	public Consumer(Resources2 resource,int No) {
		this.resource = resource;
		this.No = No;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				resource.consume(No);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
