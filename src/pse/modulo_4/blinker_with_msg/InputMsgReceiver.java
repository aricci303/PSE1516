package pse.modulo_4.blinker_with_msg;

import pse.modulo_4.common.*;
import pse.modulo_4.devices.*;

public class InputMsgReceiver extends BasicController {

	private Blinker blinker;
	private Serial serialDevice;
	
	public InputMsgReceiver(Blinker blinker, Serial serialDevice){
		this.blinker = blinker;
		this.serialDevice = serialDevice;
	}
	
	@Override
	public void run() {
		while (true){
			try {
				String msg = serialDevice.waitForMsg();
				if (msg.equals("start")){
					blinker.notifyEvent(new StartMsg());
				} else if (msg.equals("stop")){
					blinker.notifyEvent(new StopMsg());
				}
			} catch (Exception ex){
				ex.printStackTrace();
			}
		}
	}

}
