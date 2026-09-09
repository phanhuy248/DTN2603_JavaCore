package backend;

import entity.Department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QLDepartment {

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

    public static void main(String[] args) {
        QLDepartment qlDepartment = new QLDepartment();
        qlDepartment.hienThiThongTin();
    }
}