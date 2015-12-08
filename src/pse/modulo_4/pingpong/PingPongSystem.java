package pse.modulo_4.pingpong;

import pse.modulo_4.common.MsgEvent;
import pse.modulo_4.devices.*;

public class PingPongSystem {

	public static void main(String[] args) {
		Light ledA = new pse.modulo_4.devices.emu.Led(4,"green");
		Light ledB = new pse.modulo_4.devices.emu.Led(4,"red");

		Pinger pinger = new Pinger();
		Ponger ponger = new Ponger();
		
		pinger.init(ledA, ponger);
		ponger.init(ledB, pinger);
		
		pinger.start();
		ponger.start();
		pinger.notifyEvent(new MsgEvent(new BootMsg()));
				
	}

}
