/**
 * 
 * @author 13653 ��Դ
 * ʹ��synchronized
 */
public class Resources {
	private int count = 0;
	private boolean flag = false;

	public synchronized void create(int No) {
		while (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		++count;
		System.out.println(No+"��������������-----------" +count);
		flag = true;
//		notify();
		notifyAll();

	}

	public synchronized void consume(int NO) {
		while (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	
		System.out.println(NO+"��������������*****" + count);
//		--count;
		flag = false;
//		notify();
		notifyAll();

	}

}
