package modulo_lab_1_3;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;

import gnu.io.CommPortIdentifier; 
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent; 
import gnu.io.SerialPortEventListener; 

import java.util.Enumeration;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

class MySender extends Thread {
	
	private OutputStream output;

	public MySender(OutputStream output){
		this.output = output;
	}
	
	public void run(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true){
			try {
				String st = reader.readLine();
				output.write(st.getBytes(Charset.forName("UTF-8")));
			} catch (Exception ex){
				ex.printStackTrace();
			}
		}
	}
}
/**
 * Simple Serial Monitor, based on: 
 * 
 * http://playground.arduino.cc/Interfacing/Java
 * @author aricci
 *
 */
public class SimpleSerialMonitor implements SerialPortEventListener {
	SerialPort serialPort;
	
	/**
	* A BufferedReader which will be fed by a InputStreamReader 
	* converting the bytes into characters 
	* making the displayed results codepage independent
	*/
	private BufferedReader input;
	/** The output stream to the port */
	private OutputStream output;
	/** Milliseconds to block while waiting for port open */
	private static final int TIME_OUT = 2000;

	public void initialize(String portName, int dataRate) {
		CommPortIdentifier portId = null;
		
		try {
			portId = CommPortIdentifier.getPortIdentifier(portName);
			// open serial port, and use class name for the appName.
			serialPort = (SerialPort) portId.open(this.getClass().getName(),
					TIME_OUT);

			// set port parameters
			serialPort.setSerialPortParams(dataRate,
					SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);

			// open the streams
			input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
			output = serialPort.getOutputStream();

			// add event listeners
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
			
			new MySender(output).start();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	/**
	 * This should be called when you stop using the port.
	 * This will prevent port locking on platforms like Linux.
	 */
	public synchronized void close() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	}

	/**
	 * Handle an event on the serial port. Read the data and print it.
	 */
	public synchronized void serialEvent(SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				String inputLine=input.readLine();
				System.out.println(inputLine);
			} catch (Exception e) {
				System.err.println(e.toString());
			}
		}
		// Ignore all the other eventTypes, but you should consider the other ones.
	}

	public static void main(String[] args) throws Exception {
		if (args.length == 0){
			System.out.println("args: <CommPortName> <BoudRate>");
			System.out.println("Available serial ports:");

			Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
			while (portEnum.hasMoreElements()) {
				CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
				System.out.println(currPortId.getName());
			}
		} else {
			String comPortName = args[0];
			int dataRate = Integer.parseInt(args[1]);
			System.out.println("Start monitoring serial port "+args[0]+" at boud rate: "+args[1]);
			try {
				SimpleSerialMonitor main = new SimpleSerialMonitor();
				main.initialize(comPortName,dataRate);
				Thread.sleep(1000000);
			} catch (InterruptedException ie) {
				
			}
		}
	}
}