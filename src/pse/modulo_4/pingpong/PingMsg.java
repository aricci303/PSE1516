package pse.modulo_4.pingpong;

import pse.modulo_4.common.*;

public class PingMsg implements Msg {
	
	private int count;
	
	public PingMsg(int count){
		this.count = count;
	}
	
	public int getCount(){
		return count;
	}
	
}
