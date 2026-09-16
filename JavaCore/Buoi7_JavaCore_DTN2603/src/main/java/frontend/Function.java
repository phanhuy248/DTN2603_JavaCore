package frontend;

import backend.controller.AccountController;
import backend.controller.DepartmentController;
import backend.controller.PositionController;
import entity.Account;
import entity.Department;
import entity.Position;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Function {
    private final Scanner scanner;
    private final DepartmentController departmentController;
    private final PositionController positionController;
    private final AccountController accountController;

    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    public Function() {
        this.scanner = new Scanner(System.in);
        this.departmentController = new DepartmentController();
        this.positionController = new PositionController();
        this.accountController = new AccountController();
    }

    // ==================== CÁC HÀM VALIDATION DÙNG CHUNG ====================

    private void printError(String message) {
        System.out.println(RED + ">> Lỗi: " + message + RESET + "\n");
    }

    private String inputStringWithLength(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String text = scanner.nextLine().trim();
            if (text.length() < min || text.length() > max) {
                printError("Độ dài phải từ " + min + " đến " + max + " ký tự. Vui lòng nhập lại!");
                continue;
            }
            return text;
        }
    }

    private int inputInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.matches("\\d+")) {
                try {
                    return Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    printError("Số quá lớn, vui lòng nhập lại!");
                }
            } else {
                printError("Dữ liệu nhập vào phải là số nguyên. Vui lòng nhập lại!");
            }
        }
    }

    // ==================== MENU CHÍNH ====================

    public void menu() {
        while (true) {
            System.out.println("\n============= HỆ THỐNG QUẢN LÝ NHÂN SỰ =============");
            System.out.println("1. Quản lý Department");
            System.out.println("2. Quản lý Position");
            System.out.println("3. Quản lý Account");
            System.out.println("0. Thoát chương trình");
            System.out.print("Chọn chức năng: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> menuDepartment();
                case "2" -> menuPosition();
                case "3" -> menuAccount();
                case "0" -> {
                    System.out.println("Đã đóng chương trình!");
                    System.exit(0);
                }
                default -> printError("Lựa chọn không hợp lệ!");
            }
        }
    }

    // ==================== MODULE DEPARTMENT ====================

    private void menuDepartment() {
        while (true) {
            System.out.println("\n--- QUẢN LÝ DEPARTMENT ---");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm phòng ban");
            System.out.println("3. Sửa tên phòng ban theo ID");
            System.out.println("4. Xóa phòng ban theo ID");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            String opt = scanner.nextLine().trim();
            switch (opt) {
                case "1" -> hienThiDepartment();
                case "2" -> themDepartment();
                case "3" -> suaDepartment();
                case "4" -> xoaDepartment();
                case "0" -> { return; }
                default -> printError("Lựa chọn sai!");
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
        String name = inputStringWithLength("Nhập tên phòng ban cần thêm: ", 2, 50);
        if (departmentController.themDepartment(name)) {
            System.out.println("Thêm department thành công!");
        } else {
            printError("Thêm department thất bại!");
        }
    }

    private void suaDepartment() {
        int id = inputInt("Nhập Department ID cần sửa: ");
        if (departmentController.getDepartmentById(id) == null) {
            printError("Không tìm thấy Department với ID: " + id);
            return;
        }
        String newName = inputStringWithLength("Nhập tên phòng ban mới: ", 2, 50);
        if (departmentController.suaDepartmentNameTheoId(id, newName)) {
            System.out.println("Cập nhật department thành công!");
        } else {
            printError("Cập nhật department thất bại!");
        }
    }

    private void xoaDepartment() {
        int id = inputInt("Nhập Department ID cần xóa: ");
        if (departmentController.xoaDepartmentTheoId(id)) {
            System.out.println("Xóa department thành công!");
        } else {
            printError("Xóa department thất bại (ID không tồn tại hoặc có ràng buộc dữ liệu)!");
        }
    }

    // ==================== MODULE POSITION ====================

    private void menuPosition() {
        while (true) {
            System.out.println("\n--- QUẢN LÝ POSITION ---");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm vị trí");
            System.out.println("3. Sửa vị trí theo ID");
            System.out.println("4. Xóa vị trí theo ID");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            String opt = scanner.nextLine().trim();
            switch (opt) {
                case "1" -> hienThiPosition();
                case "2" -> themPosition();
                case "3" -> suaPosition();
                case "4" -> xoaPosition();
                case "0" -> { return; }
                default -> printError("Lựa chọn sai!");
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
            printError("Thêm position thất bại!");
        }
    }

    private void suaPosition() {
        int id = inputInt("Nhập Position ID cần sửa: ");
        if (positionController.getPositionById(id) == null) {
            printError("Không tìm thấy Position với ID: " + id);
            return;
        }
        String name = choosePositionName();
        if (positionController.suaPositionNameTheoId(id, name)) {
            System.out.println("Cập nhật position thành công!");
        } else {
            printError("Cập nhật position thất bại!");
        }
    }

    private void xoaPosition() {
        int id = inputInt("Nhập Position ID cần xóa: ");
        if (positionController.xoaPositionTheoId(id)) {
            System.out.println("Xóa position thành công!");
        } else {
            printError("Xóa position thất bại (ID không tồn tại hoặc có ràng buộc dữ liệu)!");
        }
    }

    private String choosePositionName() {
        while (true) {
            System.out.println("Chọn chức vụ: 1. DEV | 2. TEST | 3. SCRUM_MASTER | 4. PM");
            System.out.print("Lựa chọn: ");
            String opt = scanner.nextLine().trim();
            switch (opt) {
                case "1" -> { return "DEV"; }
                case "2" -> { return "TEST"; }
                case "3" -> { return "SCRUM_MASTER"; }
                case "4" -> { return "PM"; }
                default -> printError("Lựa chọn không hợp lệ, vui lòng chọn từ 1 đến 4!");
            }
        }
    }

    // ==================== MODULE ACCOUNT ====================

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
            String opt = scanner.nextLine().trim();
            switch (opt) {
                case "1" -> hienThiAccount();
                case "2" -> themAccount();
                case "3" -> suaAccount();
                case "4" -> xoaAccount();
                case "5" -> timKiemAccount();
                case "0" -> { return; }
                default -> printError("Lựa chọn sai!");
            }
        }
    }

    private void hienThiAccount() {
        List<Account> list = accountController.getAllAccounts();
        showAccountList(list);
    }

    private void themAccount() {
        String email;
        while (true) {
            email = inputStringWithLength("Nhập Email: ", 6, 100);
            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                printError("Email không đúng định dạng (VD: example@domain.com)!");
                continue;
            }
            if (accountController.checkExist(email)) {
                printError("Email đã tồn tại trên hệ thống. Vui lòng nhập email khác!");
                continue;
            }
            break;
        }

        String userName = inputValidUsername("Nhập Username: ");

        String fullName;
        while (true) {
            fullName = inputStringWithLength("Nhập Full Name: ", 2, 100);
            if (!fullName.matches("^[\\p{L} ]+$")) {
                printError("Họ tên chỉ được chứa chữ cái và khoảng trắng!");
                continue;
            }
            break;
        }

        int departmentId;
        while (true) {
            departmentId = inputInt("Nhập Department ID: ");
            if (departmentController.getDepartmentById(departmentId) == null) {
                printError("Department ID không tồn tại. Vui lòng nhập lại!");
                continue;
            }
            break;
        }

        int positionId;
        while (true) {
            positionId = inputInt("Nhập Position ID: ");
            if (positionController.getPositionById(positionId) == null) {
                printError("Position ID không tồn tại. Vui lòng nhập lại!");
                continue;
            }
            break;
        }

        Department department = new Department();
        department.setDepartmentId(departmentId);

        Position position = new Position();
        position.setPositionId(positionId);

        Account account = new Account(0, email, userName, fullName, department, position, LocalDate.now());
        if (accountController.themAccount(account)) {
            System.out.println("Thêm tài khoản thành công!");
        } else {
            printError("Thêm tài khoản thất bại!");
        }
    }

    private void suaAccount() {
        int id = inputInt("Nhập Account ID cần sửa: ");
        List<Account> checkList = accountController.timKiemAccountTheoId(id);
        if (checkList == null || checkList.isEmpty()) {
            printError("Không tìm thấy Account với ID: " + id);
            return;
        }

        String newUsername = inputValidUsername("Nhập Username mới: ");
        if (accountController.suaAccountTheoId(id, newUsername)) {
            System.out.println("Cập nhật username thành công!");
        } else {
            printError("Cập nhật username thất bại!");
        }
    }

    private String inputValidUsername(String prompt) {
        while (true) {
            String userName = inputStringWithLength(prompt, 6, 50);
            if (!userName.matches("^[A-Za-z0-9_]+$")) {
                printError("Username chỉ được chứa chữ cái, chữ số và dấu gạch dưới (_).");
                continue;
            }
            if (accountController.checkExist(userName)) {
                printError("Username đã tồn tại. Vui lòng chọn tên khác!");
                continue;
            }
            return userName;
        }
    }

    private void xoaAccount() {
        int id = inputInt("Nhập Account ID muốn xóa: ");
        if (accountController.timKiemAccountTheoId(id) == null || accountController.timKiemAccountTheoId(id).isEmpty()) {
            System.out.println("Không tim thấy Account với ID: " + id);
        }
        if (accountController.xoaTheoAccountId(id)) {
            System.out.println("Xóa tài khoản thành công!");
        } else {
            printError("Xóa tài khoản thất bại (ID không tồn tại)!");
        }
    }

    private void timKiemAccount() {
        int id = inputInt("Nhập Account ID cần tìm: ");
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