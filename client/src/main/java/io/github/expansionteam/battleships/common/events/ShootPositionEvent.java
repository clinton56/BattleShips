package io.github.expansionteam.battleships.common.events;

import io.github.expansionteam.battleships.common.events.data.PositionData;
import io.github.expansionteam.battleships.logic.message.Message;
import org.json.JSONObject;

public class ShootPositionEvent extends EventBase {

    private final PositionData position;

    public ShootPositionEvent(PositionData position) {
        this.position = position;
    }

    public PositionData getPosition() {
        return position;
    }

    @Override
    public Message getMessageJson() {
        return new Message("ShootPositionEvent", null, new JSONObject()
                .put("position", new JSONObject()
                        .put("x", getPosition().getX())
                        .put("y", getPosition().getY())));
    }
}
