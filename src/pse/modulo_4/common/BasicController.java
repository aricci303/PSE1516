package pse.modulo_4.common;

public abstract class BasicController extends Thread {

	protected void waitFor(long ms) throws InterruptedException{
		Thread.sleep(ms);
	}
}
