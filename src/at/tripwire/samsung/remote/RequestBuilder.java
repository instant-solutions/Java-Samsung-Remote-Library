package at.tripwire.samsung.remote;

import at.tripwire.samsung.remote.utils.Base64;

public class RequestBuilder {

	private static final String APP_STRING = "samsung.remote";

	private static final boolean lineSep = false;

	private String mac;

	private String name;

	private String localIp;

	public RequestBuilder(String mac, String name, String localIp) {
		super();
		this.mac = mac;
		this.name = name;
		this.localIp = localIp;
	}

	// @formatter:off
	public String getFirstPart() {
		String myIpBase64 = Base64.encodeToString(localIp.getBytes(), lineSep);
		String myMacBase64 = Base64.encodeToString(mac.getBytes(), lineSep);
		String nameBase64 = Base64.encodeToString(name.getBytes(), lineSep);
		
		String message = 
				Character.toString((char) 0x64) +
				Character.toString((char) 0x00) +
				Character.toString((char) myIpBase64.length()) + 
				Character.toString((char) 0x00) +
				myIpBase64 +
				Character.toString((char) myMacBase64.length()) +
				Character.toString((char) 0x00) +
				myMacBase64 +
				Character.toString((char) nameBase64.length()) +
				Character.toString((char) 0x00) +
				nameBase64;
				
		String part = 
				Character.toString((char) 0x00) + 
				Character.toString((char) APP_STRING.length()) + 
				Character.toString((char) 0x00) + 
				APP_STRING +
				Character.toString((char) message.length()) + 
				Character.toString((char) 0x00) + 
				message;
		
		return part;
	}
	
	public String getSecondPart() {
		String message = Integer.toHexString(0xc8) + Character.toString((char) 0x00);
		
		String part = 
				Character.toString((char) 0x00) + 
				Character.toString((char) APP_STRING.length()) + 
				Character.toString((char) 0x00) + 
				APP_STRING +
				Character.toString((char) message.length()) + 
				Character.toString((char) 0x00) + 
				message;
		
		return part;	
	}
	
	public String getCommandString(Command command) {
		String commandBase64 = Base64.encodeToString(command.getCommand().getBytes(), lineSep);
		
		String message = 
				Character.toString((char) 0x00) + 
				Character.toString((char) 0x00) + 
				Character.toString((char) 0x00) + 
				Character.toString((char) commandBase64.length()) +
				Character.toString((char) 0x00) + 
				commandBase64;
		
		String part = 
				Character.toString((char) 0x00) + 
				Character.toString((char) APP_STRING.length()) + 
				Character.toString((char) 0x00) + 
				APP_STRING +
				Character.toString((char) message.length()) +
				Character.toString((char) 0x00) + 
				message;
				
		return part;
	}
	
	public String getTextString(String text) {
		String textBase64 = Base64.encodeToString(text.getBytes(), lineSep);
		
		String message = 
				Character.toString((char) 0x01) + 
				Character.toString((char) 0x00) + 
				Character.toString((char) textBase64.length()) +
				Character.toString((char) 0x00) + 
				textBase64;
		
		String part = 
				Character.toString((char) 0x01) +
				Character.toString((char) APP_STRING.length()) + 
				Character.toString((char) 0x00) + 
				APP_STRING + 
				Character.toString((char) message.length()) + 
				Character.toString((char) 0x00) + 
				message;
				
		return part;
	}
	// @formatter:on
}
