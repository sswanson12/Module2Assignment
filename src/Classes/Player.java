package Classes;

import java.util.ArrayList;
import java.util.List;

public class Player {
    int score;
    
    List<String> inventory = new ArrayList<>();

    public void addToInventory(String item){
        inventory.add(item);
    }

    public void addToScore(int value){
        score += value;
    }

    public int getScore() {
        return score;
    }
    
    public String getInventory() {
        //returns either the string nothing, or a list of comma seperated values for each item of the inventory.
        if (inventory.isEmpty()){
            return "nothing.";
        } else {
            String returnString = "";
            for (String item:
                 inventory) {
                returnString += item + ", ";
            }
            returnString.substring(0, returnString.length() - 2); //removes extra space & comma

            return returnString + ".";
        }
    }
}
