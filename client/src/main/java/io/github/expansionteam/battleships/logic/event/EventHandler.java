package io.github.expansionteam.battleships.logic.event;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import io.github.expansionteam.battleships.common.annotations.EventConsumer;
import io.github.expansionteam.battleships.common.events.*;
import org.apache.log4j.Logger;

@EventConsumer
public class EventHandler {

    private final static Logger log = Logger.getLogger(EventHandler.class);

    private final EventProcessor eventProcessor;

    @Inject
    public EventHandler(EventProcessor eventProcessor) {
        this.eventProcessor = eventProcessor;
    }


    @Subscribe
    public void handleEvent(EventBase event) {
        log.debug("Handle: " + event.getClass().getSimpleName());
        eventProcessor.processEvent(event);
    }

}
