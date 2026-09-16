package backend.service.impl;

import backend.repository.IPositionRepository;
import backend.repository.impl.PositionRepositoryImpl;
import backend.service.IPositionService;
import entity.Position;

import java.util.List;

public class PositionServiceImpl implements IPositionService {
    private IPositionRepository repository = new PositionRepositoryImpl();

    @Override
    public List<Position> getAllPositions() {
        return repository.getAllPositions();
    }

    @Override
    public boolean themPosition(String positionName) {
        return repository.themPosition(positionName);
    }

    @Override
    public boolean xoaPositionTheoId(int id) {
        return repository.xoaPositionTheoId(id);
    }

    @Override
    public boolean suaPositionNameTheoId(int id, String newName) {
        return repository.suaPositionNameTheoId(id, newName);
    }

    @Override
    public Position getPositionById(int positionId) {
        return repository.getPositionById(positionId);
    }
}