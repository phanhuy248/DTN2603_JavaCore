package backend.service;

import entity.Position;
import java.util.List;

public interface IPositionService {
    List<Position> getAllPositions();
    boolean themPosition(String positionName);
    boolean xoaPositionTheoId(int id);
    boolean suaPositionNameTheoId(int id, String newName);
}