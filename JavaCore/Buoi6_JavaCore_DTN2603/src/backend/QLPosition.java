package backend;

import entity.Position;
import entity.PositionName;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLPosition implements IQLPosition {
    private Scanner scanner;

    public QLPosition() {
        this.scanner = new Scanner(System.in);
    }

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

    @Override
    public void themPosition() {
        System.out.println("Chọn chức vụ cần thêm:");
        System.out.println("1. DEV  2. TEST  3. SCRUM_MASTER  4. PM");
        System.out.print("Lựa chọn của bạn: ");
        String opt = scanner.nextLine();
        String posName = switch (opt) {
            case "1" -> "DEV";
            case "2" -> "TEST";
            case "3" -> "SCRUM_MASTER";
            default -> "PM";
        };

        String url = "jdbc:mysql://localhost:3306/qlns";
        String username = "root";
        String password = "root";

        try  {
            String sql = "INSERT INTO position (position_name) VALUES (?)";
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, posName);
            if (ps.executeUpdate() > 0) {
                System.out.println("Thêm position thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xoaPositionTheoId() {
        System.out.print("Nhập Position ID cần xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String url = "jdbc:mysql://localhost:3306/qlns";
        String username = "root";
        String password = "root";


        try  {
            String sql = "DELETE FROM position WHERE position_id = ?";
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                System.out.println("Xóa position thành công!");
            } else {
                System.out.println("Không tìm thấy Position ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void suaPositionNameTheoId() {
        System.out.print("Nhập Position ID cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Chọn tên chức vụ mới:");
        System.out.println("1. DEV  2. TEST  3. SCRUM_MASTER  4. PM");
        System.out.print("Lựa chọn của bạn: ");
        String opt = scanner.nextLine();
        String newName = switch (opt) {
            case "1" -> "DEV";
            case "2" -> "TEST";
            case "3" -> "SCRUM_MASTER";
            default -> "PM";
        };

        String url = "jdbc:mysql://localhost:3306/qlns";
        String username = "root";
        String password = "root";

        try  {
            String sql = "UPDATE position SET position_name = ? WHERE position_id = ?";
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newName);
            ps.setInt(2, id);
            if (ps.executeUpdate() > 0) {
                System.out.println("Cập nhật position_name thành công!");
            } else {
                System.out.println("Không tìm thấy Position ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}