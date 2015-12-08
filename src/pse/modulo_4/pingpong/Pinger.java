package pse.modulo_4.pingpong;

import pse.modulo_4.common.*;
import pse.modulo_4.devices.*;

public class Pinger extends ReactiveAgent {

	private Light myLed;
	private ReactiveAgent peer;
	
	public void init(Light led, ReactiveAgent peer){
		this.myLed = led;
		this.peer = peer;
	}
	
	@Override
	protected void processEvent(Event ev) {
		if (ev instanceof MsgEvent){
			Msg msg = ((MsgEvent) ev).getMsg();
			if (msg instanceof BootMsg){
				sendMsgTo(peer, new PingMsg(0));
			} else if (msg instanceof PongMsg){
				PongMsg pongMsg = ((PongMsg) msg);
				try {
					myLed.switchOn();
					waitFor(5000);
					myLed.switchOff();
					int count = pongMsg.getCount();
					sendMsgTo(peer, new PingMsg(count + 1));
					log("PING!");
				} catch (Exception ex){
					ex.printStackTrace();
				}
			}
		}
	}

	private void log(String msg){
		System.out.println("[PINGER] "+msg);
	}

	private void waitFor(long ms){
		try {
			Thread.sleep(ms);
		} catch (Exception ex){}
	}
}
