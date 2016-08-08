package io.github.expansionteam.battleships;

import io.github.expansionteam.battleships.engine.Field;
import io.github.expansionteam.battleships.engine.Orientation;
import io.github.expansionteam.battleships.engine.Ship;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Collection;

class JsonHandler {

    String resolveAction(String json, Game game) {
        final JSONObject jsonRequest = new JSONObject(json);
        final String type = jsonRequest.getString("type");
        final JSONObject jsonResponse = new JSONObject();

        switch (type) {
            case "StartGameEvent": {
                return getOpponentArrivedEventJson(jsonResponse);
            }

            case "GenerateShipsEvent": {
                game.generateRandomShips();
                Collection<Ship> ships = game.getPlayerShips();

                return getShipsGeneratedEventJson(jsonResponse, ships);
            }

            case "ShootPositionEvent": {

                JSONObject position = jsonRequest.getJSONObject("data").getJSONObject("position");

                int x = position.getInt("x");
                int y = position.getInt("y");

                if (!game.shoot(x, y)) {
                    return getEmptyFieldHitEventJson(jsonResponse, position);
                }

                if (!game.isDestroyedShip(x, y)) {
                    return getShipHitEventJson(jsonResponse, position);
                }

                return getShipDestroyedEventJson(jsonResponse, position, game.getAdjacentToShip(x, y));
            }
            default:
                return getNotRecognizedEventJson(jsonResponse);
        }
    }

    private String getNotRecognizedEventJson(JSONObject jsonResponse) {
        return jsonResponse
                .put("type", "NotRecognizeEvent")
                .put("data", new JSONObject())
                .toString();
    }

    private String getOpponentArrivedEventJson(JSONObject jsonResponse) {
        return jsonResponse
                .put("type", "OpponentArrivedEvent")
                .put("data", new JSONObject())
                .toString();
    }

    private String getShipsGeneratedEventJson(JSONObject jsonResponse, Collection<Ship> ships) {
        JSONArray shipsJsonArray = new JSONArray();
        JSONObject positionJsonObject;
        JSONObject shipJsonObject;

        for (Ship ship : ships) {
            Field startField = ship.getStartField();
            Orientation orientation = ship.getOrientation();
            int size = ship.getSize();

            positionJsonObject = new JSONObject()
                    .put("x", startField.getX())
                    .put("y", startField.getY());

            shipJsonObject = new JSONObject()
                    .put("position", positionJsonObject)
                    .put("orientation", orientation.toString())
                    .put("size", size);

            shipsJsonArray.put(shipJsonObject);
        }

        JSONObject data = new JSONObject().put("ships", shipsJsonArray);

        return jsonResponse
                .put("type", "ShipsGeneratedEvent")
                .put("data", data)
                .toString();
    }

    private String getShipHitEventJson(JSONObject jsonResponse, JSONObject position) {
        return jsonResponse
                .put("type", "ShipHitEvent")
                .put("data", new JSONObject().put("position", position))
                .toString();
    }

    private String getEmptyFieldHitEventJson(JSONObject jsonResponse, JSONObject position) {
        return jsonResponse
                .put("type", "EmptyFieldHitEvent")
                .put("data", new JSONObject().put("position", position))
                .toString();
    }

    private String getShipDestroyedEventJson(JSONObject jsonResponse, JSONObject position, Collection<Field> adjacentToShip) {
        JSONArray adjacentPositions = new JSONArray();
        JSONObject adjacentPosition;

        for (Field field : adjacentToShip) {
            adjacentPosition = new JSONObject()
                    .put("x", field.getX())
                    .put("y", field.getY());

            adjacentPositions.put(adjacentPosition);
        }

        return jsonResponse
                .put("type", "ShipDestroyedEvent")
                .put("data", new JSONObject()
                        .put("position", position)
                        .put("adjacent", adjacentPositions))
                .toString();
    }
}