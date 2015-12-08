package pse.modulo_4.blinker_with_msg;

import pse.modulo_4.devices.*;

public class ControllableBlinking {
	public static void main(String[] args) {
		Light led = new pse.modulo_4.devices.emu.Led(4);
		Serial inputDev = new pse.modulo_4.devices.emu.SerialImpl(6, 7);
		
		Blinker blinker = new Blinker(led);
		InputMsgReceiver rec = new InputMsgReceiver(blinker,inputDev);
		blinker.start();
		rec.start();
	}

}
