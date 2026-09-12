package backend;

import entity.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLDepartment implements IQLDepartment {
    private Scanner scanner;

    public QLDepartment() {
        scanner = new Scanner(System.in);
    }

    public void hienThiThongTin() {
        List<Department> listDepartment = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/qlns";
        String username = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM department;");

            while (resultSet.next()) {
                int departmentId = resultSet.getInt("department_id");
                String departmentName = resultSet.getString("department_name");

                Department department = new Department(departmentId, departmentName);
                listDepartment.add(department);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Định dạng bảng hiển thị
        System.out.println("+---------------+--------------------+");
        System.out.printf("|%-15s|%-20s|\n", "Department ID", "Department Name");
        System.out.println("+---------------+--------------------+");

        if (!listDepartment.isEmpty()) {
            for (Department department : listDepartment) {
                System.out.printf("|%-15s|%-20s|\n",
                        department.getDepartmentId(),
                        department.getDepartmentName());
            }
        } else {
            System.out.println("|        Không có thông tin          |");
        }
        System.out.println("+---------------+--------------------+");
    }

    @Override
    public void themDepartment() {
        System.out.print("Nhập tên phòng ban cần thêm: ");
        String name = scanner.nextLine();

        String url = "jdbc:mysql://localhost:3306/qlns";
        String username = "root";
        String password = "root";

        try {
            String sql = "INSERT INTO department (department_name) VALUES (?)";
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            if (ps.executeUpdate() > 0) {
                System.out.println("Thêm department thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xoaDepartmentTheoId() {
        System.out.print("Nhập Department ID cần xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String url = "jdbc:mysql://localhost:3306/qlns";
        String username = "root";
        String password = "root";


        try  {
            String sql = "DELETE FROM department WHERE department_id = ?";
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                System.out.println("Xóa department thành công!");
            } else {
                System.out.println("Không tìm thấy Department ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void suaDepartmentNameTheoId() {
        System.out.print("Nhập Department ID cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập tên phòng ban mới: ");
        String newName = scanner.nextLine();

        String url = "jdbc:mysql://localhost:3306/qlns";
        String username = "root";
        String password = "root";

        try {
            String sql = "UPDATE department SET department_name = ? WHERE department_id = ?";
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newName);
            ps.setInt(2, id);
            if (ps.executeUpdate() > 0) {
                System.out.println("Cập nhật department_name thành công!");
            } else {
                System.out.println("Không tìm thấy Department ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}