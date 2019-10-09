import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * ʹ��lock
 * @author 13653
 *
 */
public class Resources2 {

	private int count = 0;
	private boolean flag = false;
	private Lock lock = new ReentrantLock();
	private Condition con_conCondition = lock.newCondition();
	private Condition pro_conCondition = lock.newCondition();

	public void create(int No) throws InterruptedException {
		try {
			lock.lock();
			while (flag) {
				pro_conCondition.await();;
			}
			++count;
			System.out.println(No + "��������������-----------" + count);
			flag = true;
		con_conCondition.signal();	
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();	
		}
		

	}

	public void consume(int NO) throws InterruptedException {
		try {
			lock.lock();
			while (!flag) {
			con_conCondition.await();
			}

			System.out.println(NO + "��������������*****" + count);
			flag = false;
			pro_conCondition.signal();
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			lock.unlock();
		}
		
		

	}

}
