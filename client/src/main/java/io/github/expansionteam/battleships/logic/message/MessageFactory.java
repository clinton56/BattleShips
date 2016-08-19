package io.github.expansionteam.battleships.logic.message;

import io.github.expansionteam.battleships.common.events.*;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageFactory {

    public Message createFromEvent(EventBase event){
        return event.getMessageJson();
    }

    Message createFromJson(String jsonText) {
        try {
            JSONObject jsonObject = new JSONObject(jsonText);
            String type = jsonObject.getString("type");
            BoardOwner boardOwner = jsonObject.getString("boardOwner").equals("OPPONENT") ? BoardOwner.OPPONENT : BoardOwner.PLAYER;
            JSONObject data = jsonObject.getJSONObject("data");

            return new Message(type, boardOwner, data);
        } catch (JSONException ex) {
            throw new IllegalArgumentException("The jsonText argument must be a valid json text that represents a message.");
        }
    }

}
