package io.github.expansionteam.battleships.gui.models;

import org.apache.log4j.Logger;

public class PlayerField extends Field {

    private final static Logger log = Logger.getLogger(PlayerField.class);

    private boolean isOccupied = false;
    private boolean isShot = false;

    PlayerField(Position position) {
        super(position);
    }

    public void occupy() {
        isOccupied = true;
        updateCss();
    }

    public void shoot() {
        isShot = true;
        updateCss();
    }
    // TODO: CSS name should be store in a type becouse now somebody can use incorrect name and the spend a lot of time for debugging
    @Override
    protected void updateCss() {
        String cssClass;
        if (isShot) {
            cssClass = isOccupied ? "field-was-shot-hit" : "field-was-shot-miss";
        } else {
            cssClass = isOccupied ? "field-is-occupied" : "field-is-empty";
        }

        getStyleClass().clear();
        getStyleClass().add(cssClass);
    }
    
}
