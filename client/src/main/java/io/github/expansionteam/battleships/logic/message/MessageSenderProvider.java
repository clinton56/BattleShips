package io.github.expansionteam.battleships.logic.message;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;

public class MessageSenderProvider implements Provider<MessageSender> {

    private final static Logger log = Logger.getLogger(MessageSenderProvider.class);

    private static final String IP = "127.0.0.1";
    private static final int PORT = 1234;

    private final MessageFactory messageFactory;

    @Inject
    public MessageSenderProvider(MessageFactory messageFactory) {
        this.messageFactory = messageFactory;
    }

    @Override
    public MessageSender get() {
        try {
            SocketAddress socketAddress = new InetSocketAddress(IP, PORT);

            SocketChannel socketChannel = SocketChannel.open(socketAddress);
            socketChannel.configureBlocking(true);

            return new MessageSender(socketChannel, messageFactory);
        } catch (IOException ex) {
            log.debug("Unable to connect to server.");
            ex.printStackTrace();
        }

        return null;
    }

}
