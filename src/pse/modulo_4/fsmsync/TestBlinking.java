package pse.modulo_4.fsmsync;

import pse.modulo_4.devices.Light;

public class TestBlinking {
	public static void main(String[] args) {
		Light led = new pse.modulo_4.devices.emu.Led(4);
		// Light led = new devices.dio_impl.Led(4);
		// Light led = new modulo_4.devices.p4j_impl.Led(4);
		new Blinker(led).start();
	}

}
