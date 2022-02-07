package Classes;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Maze maze = new Maze();

        while (!maze.isFinished()) {
            System.out.println("You are in the " + maze.getCurrentRoomName() +
                    "\nAbout the room: " + maze.getCurrentRoomDescription() +
                    "\nYou may move: " + maze.getCurrentRoomExits() +
                    "\nMove Command Options: (n) move north, (s) move south, (e) move east, (w) move west, (u) move up, (d) move down" +
                    "\nOther Command Options: (i) interact with room, (l - lower case L) loot room, (x) exit room, (v) view inventory ");
            char currentCommand = (scan.nextLine().toLowerCase()).charAt(0);
            switch (currentCommand) {
                case 'n', 's', 'e', 'w', 'u', 'd' -> System.out.println(maze.move(currentCommand));
                case 'i' -> System.out.println(maze.interactWithCurrentRoom());
                case 'l' -> System.out.println(maze.lootCurrentRoom());
                case 'x' -> System.out.println(maze.exitCurrentRoom());
                case 'v' -> System.out.println(maze.getPlayerInventory());
                default -> System.out.println("You shouldn't be seeing this...");
            }
        }
        System.out.println("The game is finished, your final score was: " + maze.getPlayerScore()
                            + "\nYour final inventory contained: " + maze.getPlayerInventory());
    }
}
