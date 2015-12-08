package modulo_lab_1_3;

/**
 * Testing simple message passing.
 * 
 * To be used with an Arduino connected via Serial Port
 * running modulo-2.4/serial_led.ino
 * 
 * @author aricci
 *
 */
public class TestSimpleMsgPassing {

	public static void main(String[] args) throws Exception {
		SerialCommChannel channel = new SerialCommChannel(args[0],9600);		
		/* attesa necessaria per fare in modo che Arduino completi il reboot */
		Thread.sleep(2000);
		System.out.println("Ready.");

		
		while (true){
			channel.sendMsg("1");
			String msg = channel.receiveMsg();
			System.out.println(msg);		
			Thread.sleep(500);
		
			channel.sendMsg("0");
			msg = channel.receiveMsg();
			System.out.println(msg);
			Thread.sleep(500);

		}
	}

}
