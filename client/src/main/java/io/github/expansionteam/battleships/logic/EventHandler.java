package io.github.expansionteam.battleships.logic;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import io.github.expansionteam.battleships.MainLauncher;
import io.github.expansionteam.battleships.logic.client.Client;
import io.github.expansionteam.battleships.logic.events.StartGameEvent;
import org.apache.log4j.Logger;

public class EventHandler {

    private final static Logger log = Logger.getLogger(EventHandler.class.getSimpleName());

    @Inject
    private Client client;

    @Inject
    private EventConverter eventConverter;

    @Subscribe
    public void handle(StartGameEvent event) {
        log.debug("[LOGIC] Handle StartGameEvent.");
        client.sendMessage(eventConverter.convertToJson(event));
    }

}
