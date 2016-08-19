package io.github.expansionteam.battleships.logic.event;

import io.github.expansionteam.battleships.common.events.EventBase;

/**
 * Created by ehsan on 19.08.16.
 */
public class EventCaster<T>{

    public <T extends EventBase> T castEvent(EventBase event) {
        return (T)event;
    }
}
