package backend.repository.impl;

import backend.repository.IPositionRepository;
import entity.Position;
import entity.PositionName;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PositionRepositoryImpl implements IPositionRepository {

    @Override
    public List<Position> getAllPositions() {
        List<Position> list = new ArrayList<>();
        String sql = "SELECT * FROM position";
        try (Connection conn = JDBCUtils.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("position_id");
                String rawName = rs.getString("position_name");
                PositionName posName = null;
                if (rawName != null && !rawName.trim().isEmpty()) {
                    try {
                        posName = PositionName.valueOf(rawName.trim().toUpperCase().replace(" ", "_"));
                    } catch (IllegalArgumentException ignored) {}
                }
                list.add(new Position(posName, id));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean themPosition(String positionName) {
        String sql = "INSERT INTO position (position_name) VALUES (?)";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, positionName);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean xoaPositionTheoId(int id) {
        String sql = "DELETE FROM position WHERE position_id = ?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean suaPositionNameTheoId(int id, String newName) {
        String sql = "UPDATE position SET position_name = ? WHERE position_id = ?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newName);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}