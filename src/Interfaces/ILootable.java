package Interfaces;

public interface ILootable {
    default String loot(){
        return "You have looted the room!";
    }
}
