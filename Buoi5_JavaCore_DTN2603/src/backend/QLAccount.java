package backend;

import entity.Account;
import entity.Department;
import entity.Position;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLAccount implements IQLAccount {
    private List<Account> accounts;
    private Scanner scanner;

    public QLAccount() {
        scanner = new Scanner(System.in);
        this.accounts = new ArrayList<>();
    }

    public void hienThiThongTin() {
        List<Account> listAccount = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/qlns";
        String username = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM account;");

            while (resultSet.next()) {
                int accountId = resultSet.getInt("account_id");
                String email = resultSet.getString("email");
                String userName = resultSet.getString("username");
                String fullName = resultSet.getString("fullname");
                int departmentId = resultSet.getInt("department_id");
                int positionId = resultSet.getInt("position_id");

                Date dbDate = resultSet.getDate("create_date");
                LocalDate createDate = (dbDate != null) ? dbDate.toLocalDate() : null;

                Department dep = new Department();
                dep.setDepartmentId(departmentId);

                Position pos = new Position();
                pos.setPositionId(positionId);

                Account account = new Account(accountId, email, userName, fullName, dep, pos, createDate);
                listAccount.add(account);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("+---------------+--------------------+---------------+---------------+---------------+---------------+---------------+");
        System.out.printf("|%-15s|%-20s|%-15s|%-15s|%-15s|%-15s|%-15s|\n",
                "Account Id", "Email", "User Name", "Full Name", "Department Id", "Position Id", "Create Date");
        System.out.println("+---------------+--------------------+---------------+---------------+---------------+---------------+---------------+");

        if (!listAccount.isEmpty()) {
            for (Account account : listAccount) {
                System.out.printf("|%-15s|%-20s|%-15s|%-15s|%-15s|%-15s|%-15s|\n",
                        account.getAccountId(),
                        account.getEmail(),
                        account.getUserName(),
                        account.getFullName(),
                        account.getDepartment() != null ? account.getDepartment().getDepartmentId() : "",
                        account.getPosition() != null ? account.getPosition().getPositionId() : "",
                        account.getCreateDate());
            }
        } else {
            System.out.println("|                              Không có thông tin                                                               |");
        }
        System.out.println("+---------------+--------------------+---------------+---------------+---------------+---------------+---------------+");
    }

}