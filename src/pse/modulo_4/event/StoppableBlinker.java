package pse.modulo_4.event;

import java.io.IOException;

import pse.modulo_4.common.*;
import pse.modulo_4.devices.*;

public class StoppableBlinker extends BasicEventLoopController {
	
	private Light led;
	private ObservableButton stopButton;
	private ObservableTimer timer;
	
	private enum State {ON, OFF, IDLE};
	private State currentState;

	public StoppableBlinker(ObservableButton button, Light led){
		this.led = led;
		this.stopButton = button;
		this.timer = new ObservableTimer();		
		button.addObserver(this);
		timer.addObserver(this);
		currentState = State.IDLE;
	}
	
	protected void processEvent(Event ev){
		switch (currentState){
		case IDLE:
			try {
				if (ev instanceof ButtonPressed){
					led.switchOn();
					timer.start(500);
					currentState = State.ON;
				}
			} catch (IOException ex){
				ex.printStackTrace();
			}
			break;
		case ON:
			try {
				if (ev instanceof Tick){
					led.switchOff();
					currentState = State.OFF;
				} else if (ev instanceof ButtonPressed){
					led.switchOff();
					currentState = State.IDLE;
					timer.stop();					
				}
			} catch (IOException ex){
				ex.printStackTrace();
			}
			break;
		case OFF:
			try {
				if (ev instanceof Tick){
					led.switchOn();
					currentState = State.ON;
				} else if (ev instanceof ButtonPressed){
					currentState = State.IDLE;
					timer.stop();
				}
			} catch (IOException ex){
				ex.printStackTrace();
			}
			break;
		}
	}
}
