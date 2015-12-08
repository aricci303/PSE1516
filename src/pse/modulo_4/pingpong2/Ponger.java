package pse.modulo_4.pingpong2;

import pse.modulo_4.common.*;
import pse.modulo_4.devices.*;

public class Ponger extends ReactiveAgent {

	private Light myLed;
	private ReactiveAgent peer;
	private ObservableTimer timer;
	private int currentCount;
	
	public void init(Light led, ReactiveAgent peer){
		this.myLed = led;
		this.peer = peer;
		this.timer = new ObservableTimer();
		timer.addObserver(this);
	}
	
	@Override
	protected void processEvent(Event ev) {
		if (ev instanceof MsgEvent){
			Msg msg = ((MsgEvent) ev).getMsg();
			if (msg instanceof PingMsg){
				PingMsg pingMsg = ((PingMsg) msg);
				currentCount = pingMsg.getCount();
				try {
					myLed.switchOn();
					timer.scheduleTick(1000);
				} catch (Exception ex){
					ex.printStackTrace();
				}
			}
		} else if (ev instanceof Tick){
			try {
				myLed.switchOff();
				sendMsgTo(peer, new PongMsg(currentCount + 1));
				log("PONG!");
			} catch (Exception ex){
				ex.printStackTrace();
			}
		}
	}

	private void log(String msg){
		System.out.println("[PINGER] "+msg);
	}
}
