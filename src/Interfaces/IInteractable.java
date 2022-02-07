package Interfaces;

public interface IInteractable {
    default String interact(){
        return "You've interacted with the room!";
    }
}
