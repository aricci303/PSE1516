package modulo_lab_1_3;

import javax.json.*;


/**
 * Testing simple message passing based on JSON
 * 
 * To be used with an Arduino connected via Serial Port
 * running modulo-2.4/serial_json_XXX.ino
 * 
 * @author aricci
 *
 */
public class TestMsgJSON {

	public static void main(String[] args) throws Exception {
		SerialCommChannel channel = new SerialCommChannel(args[0],9600);
		
		/* attesa necessaria per fare in modo che Arduino completi il reboot */
		Thread.sleep(2000);
		System.out.println("Ready.");		
		
		while (true){
			try {
				String msg = channel.receiveMsg();
				System.out.println(msg);		
				JsonReader reader = Json.createReader(new java.io.StringReader(msg));
				JsonObject obj = reader.readObject();
				String type = obj.getString("msg");
				int value = obj.getInt("value");
				System.out.println("Type: "+type+" value: "+value);		
				Thread.sleep(500);
			} catch (Exception ex){}
	
		}
	}

}
