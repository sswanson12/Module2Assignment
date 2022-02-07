package Classes;

import Interfaces.IExitable;

public class ExitableRoom extends Room implements IExitable {
    public ExitableRoom(String name, String description) {
        super(name, description);
    }
}
