package Classes;

import Interfaces.IInteractable;

public class InteractableRoom extends Room implements IInteractable {
    private String interactableItem;
    private int earnablePoints;
    public InteractableRoom(String name, String description, String interactableTrait, int possiblePoints) {
        super(name, description);
        this.interactableItem = interactableTrait;
        this.earnablePoints = possiblePoints;
    }

    @Override
    public String interact() {
        return "You have " + this.interactableItem + "!";
    }

    public int getEarnablePoints() {
        return earnablePoints;
    }

    public void setEarnablePoints(int earnablePoints) {
        this.earnablePoints = earnablePoints;
    }
}
