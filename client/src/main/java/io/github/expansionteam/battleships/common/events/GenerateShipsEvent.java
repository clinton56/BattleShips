package io.github.expansionteam.battleships.common.events;

import io.github.expansionteam.battleships.logic.message.Message;
import org.json.JSONObject;

public class GenerateShipsEvent extends EventBase{
    @Override
    public Message getMessageJson() {
        return new Message("GenerateShipsEvent", null, new JSONObject());
    }
}
