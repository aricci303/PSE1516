package pse.modulo_4.devices.emu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PirSensor implements pse.modulo_4.devices.MotionDetectorSensor {

	private int pinNum;
	private boolean detected;
	private PirFrame pirFrame;
	
	public PirSensor(int pinNum){
		this.pinNum = pinNum;
		try {
			pirFrame = new PirFrame(pinNum);
			pirFrame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public synchronized boolean detected() {
		return detected;
	}
	
	void setDetected(boolean state){
		detected = state;
	}
	
	class PirFrame extends JFrame implements MouseListener {
		  public PirFrame(int pin){
		    super("PIR Emu");
		    setSize(200,50);
		    JButton button = new JButton("PIR on pin: "+pin);
		    button.addMouseListener(this);
		    getContentPane().add(button);
		    addWindowListener(new WindowAdapter(){
		      public void windowClosing(WindowEvent ev){
		        System.exit(-1);
		      }
		    });
		  }

		@Override
		public void mousePressed(MouseEvent e) {
			setDetected(true);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			setDetected(false);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mouseClicked(MouseEvent e) {			
		}
	}

}
