package at.tripwire.samsung.remote;

public enum Command {

	// Numbers
	NUMBER_0("0"), NUMBER_1("1"), NUMBER_2("2"), NUMBER_3("3"), NUMBER_4("4"), NUMBER_5("5"), NUMBER_6("6"), NUMBER_7("7"), NUMBER_8("8"), NUMBER_9("9"),

	// Navigation
	KEY_UP("UP"), KEY_DOWN("DOWN"), KEY_LEFT("LEFT"), KEY_RIGHT("RIGHT"), KEY_EXIT("EXIT"), KEY_ENTER("ENTER"), KEY_RETURN("RETURN"),

	// Recorder
	KEY_PLAY("PLAY"), KEY_PAUSE("PAUSE"), KEY_REWIND("REWIND"), KEY_FAST_FORWARD("FF"), KEY_RECORD("REC"), KEY_STOP("STOP"),

	// Volume
	KEY_VOLUME_UP("VOLUP"), KEY_VOLUME_DOWN("VOLDOWN"), KEY_MUTE("MUTE"),

	// Channels
	KEY_CHANNEL_LIST("CH_LIST"), KEY_CHANNEL_UP("CHUP"), KEY_CHANNEL_DOWN("CHDOWN"), KEY_PRECH("PRECH"),

	// Common
	KEY_MENU("MENU"), KEY_POWER_OFF("POWEROFF"), KEY_TOOLS("TOOLS"), KEY_CONTENTS("CONTENTS"), KEY_W_LINK("W_LINK #Media P"), KEY_RSS("RSS #Internet"), KEY_MTS(
			"MTS #Dual"), KEY_CAPTION("KEY_CAPTION #Subt"), KEY_PICTURE_SIZE("PICTURE_SIZE"), KEY_GUIDE("GUIDE"), KEY_INFO("INFO"), KEY_SOURCE("SOURCE"), KEY_AD(
			"AD");

	private String command;

	private Command(String command) {
		this.command = command;
	}

	public String getCommand() {
		return "KEY_" + command;
	}
}
