package Classes;

public class Maze {
    private Room currentRoom;
    private Player player;
    private boolean isFinished = false;

    public Maze() {
        player = new Player();
        Room lobby = new ExitableRoom("lobby", "this is the lobby to our makeshift office building, you may exit here");
        Room boiler = new LootableRoom("boiler", "a scary room, but you might find something valuable", "some louis vuitton rain boots");
        Room restroom = new InteractableRoom("restroom", "you may use the restroom to earn some points", "flushed the toilet", 100);
        Room office = new InteractableRoom("office", "you may invest in some stocks for points", "invested in stocks", 150);
        Room gymnasium = new LootableRoom("gymnasium", "you may find something shiny in here", "a golden basketball");
        Room stairs = new InteractableRoom("stairs", "you may slide down the railing for some points", "slid down the railing", 50);

        stairs.setDown(boiler);
        stairs.setUp(office);
        stairs.setSouth(lobby);

        lobby.setNorth(stairs);
        lobby.setEast(restroom);

        boiler.setUp(stairs);

        office.setDown(stairs);

        restroom.setWest(lobby);

        switch ((int)((Math.random()*6) + 1)) {
            case 1 -> currentRoom = lobby;
            case 2 -> currentRoom = boiler;
            case 3 -> currentRoom = restroom;
            case 4 -> currentRoom = office;
            case 5 -> currentRoom = gymnasium;
            case 6 -> currentRoom = stairs;
        }

    }

    public String exitCurrentRoom(){
        if (currentRoom instanceof ExitableRoom){
            isFinished = true;
            return ((ExitableRoom) currentRoom).exit();
        } else {
            return "You may not exit from this room, please try something else.";
        }
    }

    public String interactWithCurrentRoom(){
        if (currentRoom instanceof InteractableRoom){
            player.addToScore(((InteractableRoom) currentRoom).getEarnablePoints());
            ((InteractableRoom) currentRoom).setEarnablePoints(0);
            return "You have" + ((InteractableRoom) currentRoom).interact();
        } else {
            return "You may not interact with this room, please try something else.";
        }
    }

    public String lootCurrentRoom(){
        if (currentRoom instanceof LootableRoom){
            player.addToInventory(((LootableRoom) currentRoom).getLootableItem());
            player.addToScore(10);
            return "You have found " + ((LootableRoom) currentRoom).loot();
        } else {
            return "You may not loot this room, please try something else.";
        }
    }

    public boolean move(char direction){
        if (currentRoom.getAdjoiningRoom(direction) != null){
            currentRoom = currentRoom.getAdjoiningRoom(direction);
            return true;
        } else {
            return false;
        }
    }

    public String getPlayerInventory() {
        return player.getInventory();
    }

    public int getPlayerScore() {
        return player.getScore();
    }

    public String getCurrentRoomDescription() {
        return currentRoom.getDescription();
    }

    public String getCurrentRoomExits() {
        return currentRoom.getExits();
    }

    public String getCurrentRoomName() {
        return currentRoom.getName();
    }

    public boolean isFinished(){
        return isFinished;
    }
}
