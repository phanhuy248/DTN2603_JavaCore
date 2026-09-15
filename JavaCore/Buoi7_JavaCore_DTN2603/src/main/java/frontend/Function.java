package frontend;

import backend.controller.AccountController;
import backend.controller.DepartmentController;
import backend.controller.PositionController;
import entity.Account;
import entity.Department;
import entity.Position;
import entity.PositionName;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Function {
    private Scanner scanner;
    private DepartmentController departmentController;
    private PositionController positionController;
    private AccountController accountController;

    public Function() {
        this.scanner = new Scanner(System.in);
        this.departmentController = new DepartmentController();
        this.positionController = new PositionController();
        this.accountController = new AccountController();
    }

    // ==========================================
    // MENU CHÍNH
    // ==========================================
    public void menu() {
        while (true) {
            System.out.println("\n============= HỆ THỐNG QUẢN LÝ NHÂN SỰ =============");
            System.out.println("1. Quản lý Department");
            System.out.println("2. Quản lý Position");
            System.out.println("3. Quản lý Account");
            System.out.println("0. Thoát chương trình");
            System.out.print("Chọn chức năng: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> menuDepartment();
                case "2" -> menuPosition();
                case "3" -> menuAccount();
                case "0" -> {
                    System.out.println("Đã đóng chương trình!");
                    System.exit(0);
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    // ==========================================
    // MODULE DEPARTMENT
    // ==========================================
    private void menuDepartment() {
        while (true) {
            System.out.println("\n--- QUẢN LÝ DEPARTMENT ---");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm phòng ban");
            System.out.println("3. Sửa tên phòng ban theo ID");
            System.out.println("4. Xóa phòng ban theo ID");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            String opt = scanner.nextLine();
            switch (opt) {
                case "1" -> hienThiDepartment();
                case "2" -> themDepartment();
                case "3" -> suaDepartment();
                case "4" -> xoaDepartment();
                case "0" -> { return; }
                default -> System.out.println("Lựa chọn sai!");
            }
        }
    }

    private void hienThiDepartment() {
        List<Department> list = departmentController.getAllDepartments();
        System.out.println("+---------------+-------------------------+");
        System.out.printf("|%-15s|%-25s|\n", "Department ID", "Department Name");
        System.out.println("+---------------+-------------------------+");
        if (list != null && !list.isEmpty()) {
            for (Department d : list) {
                System.out.printf("|%-15s|%-25s|\n", d.getDepartmentId(), d.getDepartmentName());
            }
        } else {
            System.out.printf("|%41s|\n", "Không có thông tin");
        }
        System.out.println("+---------------+-------------------------+");
    }

    private void themDepartment() {
        System.out.print("Nhập tên phòng ban cần thêm: ");
        String name = scanner.nextLine();
        if (departmentController.themDepartment(name)) {
            System.out.println("Thêm department thành công!");
        } else {
            System.out.println("Thêm department thất bại!");
        }
    }

    private void suaDepartment() {
        System.out.print("Nhập Department ID cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên phòng ban mới: ");
        String newName = scanner.nextLine();
        if (departmentController.suaDepartmentNameTheoId(id, newName)) {
            System.out.println("Cập nhật department thành công!");
        } else {
            System.out.println("Cập nhật department thất bại!");
        }
    }

    private void xoaDepartment() {
        System.out.print("Nhập Department ID cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (departmentController.xoaDepartmentTheoId(id)) {
            System.out.println("Xóa department thành công!");
        } else {
            System.out.println("Xóa department thất bại!");
        }
    }

    // ==========================================
    // MODULE POSITION
    // ==========================================
    private void menuPosition() {
        while (true) {
            System.out.println("\n--- QUẢN LÝ POSITION ---");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm vị trí");
            System.out.println("3. Sửa vị trí theo ID");
            System.out.println("4. Xóa vị trí theo ID");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            String opt = scanner.nextLine();
            switch (opt) {
                case "1" -> hienThiPosition();
                case "2" -> themPosition();
                case "3" -> suaPosition();
                case "4" -> xoaPosition();
                case "0" -> { return; }
                default -> System.out.println("Lựa chọn sai!");
            }
        }
    }

    private void hienThiPosition() {
        List<Position> list = positionController.getAllPositions();
        System.out.println("+---------------+-------------------------+");
        System.out.printf("|%-15s|%-25s|\n", "Position ID", "Position Name");
        System.out.println("+---------------+-------------------------+");
        if (list != null && !list.isEmpty()) {
            for (Position p : list) {
                String posName = (p.getPositionName() != null) ? p.getPositionName().name() : "N/A";
                System.out.printf("|%-15s|%-25s|\n", p.getPositionId(), posName);
            }
        } else {
            System.out.printf("|%41s|\n", "Không có thông tin");
        }
        System.out.println("+---------------+-------------------------+");
    }

    private void themPosition() {
        String name = choosePositionName();
        if (positionController.themPosition(name)) {
            System.out.println("Thêm position thành công!");
        } else {
            System.out.println("Thêm position thất bại!");
        }
    }

    private void suaPosition() {
        System.out.print("Nhập Position ID cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        String name = choosePositionName();
        if (positionController.suaPositionNameTheoId(id, name)) {
            System.out.println("Cập nhật position thành công!");
        } else {
            System.out.println("Cập nhật position thất bại!");
        }
    }

    private void xoaPosition() {
        System.out.print("Nhập Position ID cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (positionController.xoaPositionTheoId(id)) {
            System.out.println("Xóa position thành công!");
        } else {
            System.out.println("Xóa position thất bại!");
        }
    }

    private String choosePositionName() {
        System.out.println("Chọn chức vụ: 1. DEV  2. TEST  3. SCRUM_MASTER  4. PM");
        System.out.print("Lựa chọn: ");
        String opt = scanner.nextLine();
        return switch (opt) {
            case "1" -> "DEV";
            case "2" -> "TEST";
            case "3" -> "SCRUM_MASTER";
            default -> "PM";
        };
    }

    // ==========================================
    // MODULE ACCOUNT
    // ==========================================
    private void menuAccount() {
        while (true) {
            System.out.println("\n--- QUẢN LÝ ACCOUNT ---");
            System.out.println("1. Hiển thị toàn bộ tài khoản");
            System.out.println("2. Thêm mới tài khoản");
            System.out.println("3. Sửa Username theo ID");
            System.out.println("4. Xóa tài khoản theo ID");
            System.out.println("5. Tìm kiếm tài khoản theo ID");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            String opt = scanner.nextLine();
            switch (opt) {
                case "1" -> hienThiAccount();
                case "2" -> themAccount();
                case "3" -> suaAccount();
                case "4" -> xoaAccount();
                case "5" -> timKiemAccount();
                case "0" -> { return; }
                default -> System.out.println("Lựa chọn sai!");
            }
        }
    }

    private void hienThiAccount() {
        List<Account> list = accountController.getAllAccounts();
        showAccountList(list);
    }

    private void themAccount() {
        System.out.print("Nhập Email: ");
        String email = scanner.nextLine();
        System.out.print("Nhập Username: ");
        String userName = scanner.nextLine();
        System.out.print("Nhập Full Name: ");
        String fullName = scanner.nextLine();

        System.out.print("Nhập Department ID: ");
        int departmentId = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập Position ID: ");
        int positionId = Integer.parseInt(scanner.nextLine());

        Department department = new Department();
        department.setDepartmentId(departmentId);

        Position position = new Position();
        position.setPositionId(positionId);

        Account account = new Account(0, email, userName, fullName, department, position, LocalDate.now());
        if (accountController.themAccount(account)) {
            System.out.println("Thêm tài khoản thành công!");
        } else {
            System.out.println("Thêm tài khoản thất bại!");
        }
    }

    private void suaAccount() {
        System.out.print("Nhập Account ID cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập Username mới: ");
        String newUsername = scanner.nextLine();
        if (accountController.suaAccountTheoId(id, newUsername)) {
            System.out.println("Cập nhật username thành công!");
        } else {
            System.out.println("Cập nhật username thất bại!");
        }
    }

    private void xoaAccount() {
        System.out.print("Nhập Account ID muốn xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (accountController.xoaTheoAccountId(id)) {
            System.out.println("Xóa tài khoản thành công!");
        } else {
            System.out.println("Xóa tài khoản thất bại!");
        }
    }

    private void timKiemAccount() {
        System.out.print("Nhập Account ID cần tìm: ");
        int id = Integer.parseInt(scanner.nextLine());
        List<Account> accounts = accountController.timKiemAccountTheoId(id);
        showAccountList(accounts);
    }

    private void showAccountList(List<Account> accounts) {
        System.out.println("+---------------+--------------------+---------------+--------------------+--------------------+--------------------+---------------+");
        System.out.printf("|%-15s|%-20s|%-15s|%-20s|%-20s|%-20s|%-15s|\n",
                "Account ID", "Email", "Username", "Full Name", "Department Name", "Position Name", "Create Date");
        System.out.println("+---------------+--------------------+---------------+--------------------+--------------------+--------------------+---------------+");

        if (accounts != null && !accounts.isEmpty()) {
            for (Account acc : accounts) {
                String depName = (acc.getDepartment() != null && acc.getDepartment().getDepartmentName() != null)
                        ? acc.getDepartment().getDepartmentName()
                        : "N/A";
                String posName = (acc.getPosition() != null && acc.getPosition().getPositionName() != null)
                        ? acc.getPosition().getPositionName().name()
                        : "N/A";

                System.out.printf("|%-15s|%-20s|%-15s|%-20s|%-20s|%-20s|%-15s|\n",
                        acc.getAccountId(),
                        acc.getEmail(),
                        acc.getUserName(),
                        acc.getFullName(),
                        depName,
                        posName,
                        acc.getCreateDate());
            }
        } else {
            System.out.printf("|%128s|\n", "Không có thông tin");
        }
        System.out.println("+---------------+--------------------+---------------+--------------------+--------------------+--------------------+---------------+");
    }
}