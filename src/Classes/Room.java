package Classes;

public abstract class Room {
    private String name;
    private String description;
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private Room up;
    private Room down;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public Room getAdjoiningRoom(char direction){
        if (this.isValidDirection(direction)){
            return switch (direction) {
                case 'n' -> this.north;
                case 's' -> this.south;
                case 'e' -> this.east;
                case 'w' -> this.west;
                case 'u' -> this.up;
                case 'd' -> this.down;
                default -> null;
            };
        }
        return null;
    }

    public String getExits(){
        String returnString = "";
        if (this.getNorth()!= null){
                returnString += "north, ";
        }
        if (this.getSouth() != null){
            returnString += "south, ";
        }
        if (this.getEast() != null){
            returnString += "east, ";
        }
        if (this.getWest() != null){
            returnString += "west, ";
        }
        if (this.getUp() != null){
            returnString += "up, ";
        }
        if (this.getDown() != null){
            returnString += "down, ";
        }
        if (returnString.length() >= 2) {
            return returnString.substring(0, returnString.length() - 2);
        } else {
            return returnString;
        }

    }

    public String getName(){
        return this.name;
    }

    public boolean isValidDirection(char direction){
        return switch (direction) {
            case 'n' -> this.north != null;
            case 's' -> this.south != null;
            case 'e' -> this.east!= null;
            case 'w' -> this.west != null;
            case 'u' -> this.up != null;
            case 'd' -> this.down != null;
            default -> false;
        };
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public Room getUp() {
        return up;
    }

    public void setUp(Room up) {
        this.up = up;
    }

    public Room getDown() {
        return down;
    }

    public void setDown(Room down) {
        this.down = down;
    }
}
