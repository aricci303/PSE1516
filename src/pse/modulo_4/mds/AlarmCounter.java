package pse.modulo_4.mds;

public class AlarmCounter {

	private int count;
	
	public AlarmCounter(){
		count = 0;
	}
	
	public synchronized void incNumAlarms(){
		count++;
	}
	
	public synchronized int getCurrentNumAlarms(){
		return count;
	}
}
