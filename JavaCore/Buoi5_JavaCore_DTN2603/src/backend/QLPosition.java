package backend;

import entity.Position;
import entity.PositionName;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QLPosition {

    public void hienThiThongTin() {
        List<Position> listPosition = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/qlns";
        String username = "root";
        String password = "root";

        try  {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM position;");

            while (resultSet.next()) {
                int positionId = resultSet.getInt("position_id");
                String nameRaw = resultSet.getString("position_name");

                String enumKey = nameRaw.trim().toUpperCase().replace(" ", "_");
                PositionName positionName = PositionName.valueOf(enumKey);

                Position position = new Position(positionName, positionId);
                listPosition.add(position);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Định dạng bảng hiển thị
        System.out.println("+---------------+--------------------+");
        System.out.printf("|%-15s|%-20s|\n", "Position ID", "Position Name");
        System.out.println("+---------------+--------------------+");

        if (!listPosition.isEmpty()) {
            for (Position position : listPosition) {
                System.out.printf("|%-15s|%-20s|\n",
                        position.getPositionId(),
                        position.getPositionName());
            }
        } else {
            System.out.println("|        Không có thông tin          |");
        }
        System.out.println("+---------------+--------------------+");
    }

    public static void main(String[] args) {
        QLPosition qlPosition = new QLPosition();
        qlPosition.hienThiThongTin();
    }
}