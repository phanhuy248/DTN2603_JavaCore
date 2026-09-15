package backend.controller;

import backend.service.IPositionService;
import backend.service.impl.PositionServiceImpl;
import entity.Position;

import java.util.List;

public class PositionController {
    private IPositionService service = new PositionServiceImpl();

    public List<Position> getAllPositions() {
        return service.getAllPositions();
    }

    public boolean themPosition(String name) {
        return service.themPosition(name);
    }

    public boolean xoaPositionTheoId(int id) {
        return service.xoaPositionTheoId(id);
    }

    public boolean suaPositionNameTheoId(int id, String newName) {
        return service.suaPositionNameTheoId(id, newName);
    }
}