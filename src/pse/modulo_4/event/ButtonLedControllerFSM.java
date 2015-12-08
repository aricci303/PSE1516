package pse.modulo_4.event;

import java.io.IOException;

import pse.modulo_4.common.*;
import pse.modulo_4.devices.*;

public class ButtonLedControllerFSM extends BasicEventLoopController {
	
	private Light led;
	private ObservableButton button;
	
	private enum State {ON, OFF};
	private State currentState;

	public ButtonLedControllerFSM(ObservableButton button, Light led){
		this.led = led;
		this.button = button;
		button.addObserver(this);
		currentState = State.OFF;
	}
	
	protected void processEvent(Event ev){
		switch (currentState){
		case ON:
			try {
				if (ev instanceof ButtonReleased){
					led.switchOff();
					currentState = State.OFF;
					break;
				}
			} catch (IOException ex){
				ex.printStackTrace();
			}
		case OFF:
			try {
				if (ev instanceof ButtonPressed){
					led.switchOn();
					currentState = State.ON;
					break;
				}
			} catch (IOException ex){
				ex.printStackTrace();
			}
		}
	}
}
