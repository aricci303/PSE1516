package pse.modulo_4.pingpong2;

import pse.modulo_4.common.*;

public class PongMsg implements Msg {
	
	private int count;
	
	public PongMsg(int count){
		this.count = count;
	}
	
	public int getCount(){
		return count;
	}
	
}
