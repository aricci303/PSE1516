package pse.modulo_4.basic;

import pse.modulo_4.devices.Light;

public class TestBlinking {
	public static void main(String[] args) {
		// Light led = new pse.modulo_4.devices.emu.Led(4);
		// Light led = new pse.devices.dio_impl.Led(4);
		Light led = new pse.modulo_4.devices.p4j_impl.Led(7);
		new Blinker(led,500).start();
	}

}
