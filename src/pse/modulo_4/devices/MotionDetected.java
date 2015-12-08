package pse.modulo_4.devices;

import pse.modulo_4.common.*;

public class MotionDetected implements Event {
	private ObservableMotionDetectorSensor source;
	
	public MotionDetected(ObservableMotionDetectorSensor source){
		this.source = source;
	}
	
	public ObservableMotionDetectorSensor getSource(){
		return source;
	}
}
