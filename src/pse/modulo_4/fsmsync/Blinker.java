package pse.modulo_4.fsmsync;

import java.io.IOException;

import pse.modulo_4.common.BasicFSMController;
import pse.modulo_4.devices.Light;

public class Blinker extends BasicFSMController {
	
	private Light led;
	private enum State {ON,OFF}
	private State currentState;
	
	public Blinker(Light led){
		super(500);
		this.led = led;
		currentState = State.OFF;
	}
	
	protected void tick(){
		switch (currentState){
		case ON:
			try {
				led.switchOff();
				currentState = State.OFF;
			} catch (IOException ex){}
			break;
		case OFF:
			try {
				led.switchOn();
				currentState = State.ON;
			} catch (IOException ex){}
			break;
		}
	}
}
