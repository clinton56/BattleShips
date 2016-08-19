package io.github.expansionteam.battleships.common.events;

import io.github.expansionteam.battleships.logic.message.Message;
import org.json.JSONObject;

public class StartGameEvent extends EventBase{
    @Override
    public Message getMessageJson() {
        return new Message("StartGameEvent", null, new JSONObject());
    }
}
