package pse.modulo_4.devices;

import pse.modulo_4.common.*;

public class ButtonReleased implements Event {
	private Button source;
	
	public ButtonReleased(Button source){
		this.source = source;
	}
	
	public Button getSourceButton(){
		return source;
	}
}
