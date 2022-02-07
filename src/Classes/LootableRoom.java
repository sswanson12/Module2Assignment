package Classes;

import Interfaces.ILootable;

public class LootableRoom extends Room implements ILootable {
    private String lootableItem;

    public LootableRoom(String name, String description, String loot) {
        super(name, description);
        this.lootableItem = loot;
    }

    @Override
    public String loot() {
        return "You have found " + this.lootableItem + "!";
    }

    public String getLootableItem() {
        return lootableItem;
    }
}
