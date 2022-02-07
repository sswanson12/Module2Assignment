package Interfaces;

public interface IExitable {
    default String exit(){
        return "You have exited the maze!";
    }
}
