package pse.modulo_4.basic;

import pse.modulo_4.devices.*;

public class TestButtonLed {
	public static void main(String[] args) {
		// Light led = new pse.modulo_4.devices.emu.Led(4);
		// Button button = new pse.modulo_4.devices.emu.Button(17);
		// Light led = new pse.devices.dio_impl.Led(4);
		Light led = new pse.modulo_4.devices.p4j_impl.Led(7);
		Button button = new pse.modulo_4.devices.p4j_impl.Button(4);
		new ButtonLedController(button,led).start();
	}

}
