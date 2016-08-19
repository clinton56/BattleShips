package io.github.expansionteam.battleships.common.events;

import io.github.expansionteam.battleships.logic.message.Message;

/**
 * Created by ehsan on 19.08.16.
 */
public abstract class EventBase {
    public abstract Message getMessageJson();
}
