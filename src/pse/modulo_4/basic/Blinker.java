package pse.modulo_4.basic;

import java.io.IOException;

import pse.modulo_4.common.BasicController;
import pse.modulo_4.devices.Light;

public class Blinker extends BasicController {
	
	private Light led;
	private int period;
	
	public Blinker(Light led, int period){
		this.led = led;
		this.period = period;
	}
	
	public void run(){
		try {
			while (true){
			  led.switchOn();
			  waitFor(period);
			  led.switchOff(); 
			  waitFor(period);
			}		
		} catch (InterruptedException ex){
			ex.printStackTrace();
		} catch (IOException ex){
			ex.printStackTrace();
		}
	}
}
