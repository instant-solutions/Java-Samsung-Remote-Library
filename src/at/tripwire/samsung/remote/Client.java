package at.tripwire.samsung.remote;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

	public static final int PORT = 55000;

	private String remoteIp;

	private RequestBuilder requestBuilder;

	private Socket socket;

	private static final Logger LOG = Logger.getLogger(Client.class.getName());

	public Client(String localIp, String remoteIp, String mac, String name) {
		this.remoteIp = remoteIp;
		requestBuilder = new RequestBuilder(mac, name, localIp);
	}

	public Client(String remoteIp, String mac, String name) {
		this(new String(), remoteIp, mac, name);
	}

	private void connect() throws UnknownHostException, IOException {
		if (socket == null || socket.isClosed()) {
			LOG.info("connecting... ");
			socket = new Socket(remoteIp, PORT);
			LOG.info("connected");
		}
	}

	private void disconnect() throws IOException {
		if (socket != null && socket.isConnected()) {
			LOG.info("closing... ");
			socket.close();
			LOG.info("closed");
		}
	}

	private void send(String message) {
		try {
			connect();

			OutputStream out = socket.getOutputStream();

			String part1 = requestBuilder.getFirstPart();
			LOG.info(part1);
			out.write(part1.getBytes());

			String part2 = requestBuilder.getSecondPart();
			LOG.info(part2);
			out.write(part2.getBytes());

			LOG.info(message);
			out.write(message.getBytes());

			disconnect();
		} catch (UnknownHostException e) {
			LOG.log(Level.SEVERE, "unknown host", e);
		} catch (IOException e) {
			LOG.log(Level.SEVERE, "network exception", e);
		}
	}

	public void sendCommand(Command command) {
		send(requestBuilder.getCommandString(command));
	}

	public void sendText(String text) {
		send(requestBuilder.getTextString(text));
	}
}
