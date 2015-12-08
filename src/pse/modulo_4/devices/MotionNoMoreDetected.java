package pse.modulo_4.devices;

import pse.modulo_4.common.*;

public class MotionNoMoreDetected implements Event {
	private ObservableMotionDetectorSensor source;
	
	public MotionNoMoreDetected(ObservableMotionDetectorSensor source){
		this.source = source;
	}
	
	public ObservableMotionDetectorSensor getSource(){
		return source;
	}
}
