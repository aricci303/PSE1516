package pse.modulo_4.event;

import pse.modulo_4.devices.*;

public class TestButtonLed {
	public static void main(String[] args) {
		Light led = new pse.modulo_4.devices.emu.Led(4);
		ObservableButton button = new pse.modulo_4.devices.emu.ObservableButton(17);
		// Light led = new devices.dio_impl.Led(4);
		// Light led = new modulo_4_4.devices.p4j_impl.Led(4);
		// Button button = new modulo_4_4.devices.p4j_impl.Button(17);
		new ButtonLedController(button,led).start();
	}

}
