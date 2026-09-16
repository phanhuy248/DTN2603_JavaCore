package backend.repository.impl;

import backend.repository.IAccountRepository;
import entity.Account;
import entity.Department;
import entity.Position;
import entity.PositionName;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements IAccountRepository {
    @Override
    public List<Account> getAllAccounts() {
        List<Account> list = new ArrayList<>();

        String sql = "SELECT a.account_id, a.email, a.username, a.fullname, a.create_date, " +
                "       d.department_id, d.department_name, " +
                "       p.position_id, p.position_name " +
                "FROM account a " +
                "LEFT JOIN department d ON a.department_id = d.department_id " +
                "LEFT JOIN position p ON a.position_id = p.position_id";

        try {
            Connection connection = JDBCUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int accountId = resultSet.getInt("account_id");
                String email = resultSet.getString("email");
                String userName = resultSet.getString("username");
                String fullName = resultSet.getString("fullname");


                Department department = null;
                int depId = resultSet.getInt("department_id");
                if (!resultSet.wasNull()) {
                    String depName = resultSet.getString("department_name");
                    department = new Department(depId, depName);
                }


                Position position = null;
                int posId = resultSet.getInt("position_id");
                if (!resultSet.wasNull()) {
                    String posNameRaw = resultSet.getString("position_name");

                    String enumKey = posNameRaw.trim().toUpperCase().replace(" ", "_");
                    PositionName positionName = PositionName.valueOf(enumKey);
                    position = new Position(positionName, posId);
                }


                java.sql.Date dbDate = resultSet.getDate("create_date");
                LocalDate createDate = (dbDate != null) ? dbDate.toLocalDate() : null;

                Account account = new Account(accountId, email, userName, fullName, department, position, createDate);
                list.add(account);
            }

            JDBCUtils.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Account> timKiemAccountTheoId(int accountId) {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT a.account_id, a.email, a.username, a.fullname, a.create_date, " +
                "       d.department_id, d.department_name, " +
                "       p.position_id, p.position_name " +
                "FROM account a " +
                "LEFT JOIN department d ON a.department_id = d.department_id " +
                "LEFT JOIN position p ON a.position_id = p.position_id " +
                "WHERE a.account_id = ?";

        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, accountId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("account_id");
                    String email = resultSet.getString("email");
                    String userName = resultSet.getString("username");
                    String fullName = resultSet.getString("fullname");


                    Department department = null;
                    int depId = resultSet.getInt("department_id");
                    if (!resultSet.wasNull()) {
                        department = new Department(depId, resultSet.getString("department_name"));
                    }


                    Position position = null;
                    int posId = resultSet.getInt("position_id");
                    if (!resultSet.wasNull()) {
                        String posNameRaw = resultSet.getString("position_name");
                        PositionName positionName = null;
                        if (posNameRaw != null && !posNameRaw.trim().isEmpty()) {
                            try {
                                String enumKey = posNameRaw.trim().toUpperCase().replace(" ", "_");
                                positionName = PositionName.valueOf(enumKey);
                            } catch (IllegalArgumentException ex) {
                                positionName = null;
                            }
                        }
                        position = new Position(positionName, posId);
                    }


                    java.sql.Date dbDate = resultSet.getDate("create_date");
                    LocalDate createDate = (dbDate != null) ? dbDate.toLocalDate() : null;

                    list.add(new Account(id, email, userName, fullName, department, position, createDate));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean xoaTheoAccountId(int accountId) {
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql = "DELETE FROM account WHERE account_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, accountId);
            int rowsAffected = statement.executeUpdate();
            JDBCUtils.closeConnection(connection);
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
        }


    @Override
    public boolean suaAccountTheoId(int accountId, String userName) {
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql = "UPDATE account SET username = ? WHERE account_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userName);
            statement.setInt(2, accountId);
            int rowsAffected = statement.executeUpdate();
            JDBCUtils.closeConnection(connection);
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean themAccount(Account account) {
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql = "INSERT INTO account (email, username, fullname, department_id, position_id, create_date) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, account.getEmail());
            statement.setString(2, account.getUserName());
            statement.setString(3, account.getFullName());


            if (account.getDepartment() != null) {
                statement.setInt(4, account.getDepartment().getDepartmentId());
            } else {
                statement.setNull(4, java.sql.Types.INTEGER);
            }


            if (account.getPosition() != null) {
                statement.setInt(5, account.getPosition().getPositionId());
            } else {
                statement.setNull(5, java.sql.Types.INTEGER);
            }


            if (account.getCreateDate() != null) {
                statement.setDate(6, java.sql.Date.valueOf(account.getCreateDate()));
            } else {
                statement.setDate(6, new java.sql.Date(System.currentTimeMillis())); // Mặc định lấy ngày hiện tại
            }

            int rowsAffected = statement.executeUpdate();
            JDBCUtils.closeConnection(connection);
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkExist(String email) {
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql = "SELECT COUNT(*) FROM account WHERE email = ? OR username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                JDBCUtils.closeConnection(connection);
                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}


