package at.tripwire.samsung.remote.test;

import at.tripwire.samsung.remote.Client;
import at.tripwire.samsung.remote.Command;

public class TestClient {

	public static final String TEST_IP = "10.10.0.8";

	public static final String TEST_MAC = "01-23-45-67-89-ad";

	public static final String TEST_NAME = "Java Lib 2";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Perl: "01-23-45-67-89-ab"
		// Java: "01-23-45-67-89-ac"
		// Test TV-Model: "UE32C6500"

		Client client = new Client(TEST_IP, TEST_MAC, TEST_NAME);
		client.sendCommand(Command.KEY_VOLUME_UP);
	}
}
