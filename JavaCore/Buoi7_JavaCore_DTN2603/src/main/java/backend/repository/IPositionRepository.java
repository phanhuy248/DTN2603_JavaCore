package backend.repository;

import entity.Position;
import java.util.List;

public interface IPositionRepository {
    List<Position> getAllPositions();
    boolean themPosition(String positionName);
    boolean xoaPositionTheoId(int id);
    boolean suaPositionNameTheoId(int id, String newName);
}