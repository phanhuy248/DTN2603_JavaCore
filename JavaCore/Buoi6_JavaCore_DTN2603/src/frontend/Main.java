package frontend;

import backend.IQLAccount;
import backend.IQLDepartment;
import backend.IQLPosition;
import backend.QLAccount;
import backend.QLDepartment;
import backend.QLPosition;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IQLDepartment qlDepartment = new QLDepartment();
        IQLPosition qlPosition = new QLPosition();
        IQLAccount qlAccount = new QLAccount();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n============= HỆ THỐNG QUẢN LÝ =============");
            System.out.println("1. Quản lý Department");
            System.out.println("2. Quản lý Position");
            System.out.println("3. Quản lý Account");
            System.out.println("0. Thoát chương trình");
            System.out.print("Chọn chức năng: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> menuDepartment(qlDepartment, scanner);
                case "2" -> menuPosition(qlPosition, scanner);
                case "3" -> menuAccount(qlAccount, scanner);
                case "0" -> {
                    System.out.println("Đã đóng chương trình!");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void menuDepartment(IQLDepartment ql, Scanner scanner) {
        while (true) {
            System.out.println("\n--- QUẢN LÝ DEPARTMENT ---");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm department");
            System.out.println("3. Xóa department theo ID");
            System.out.println("4. Sửa department_name theo ID");
            System.out.println("0. Quay lại");
            System.out.print("Chọn chức năng: ");
            String opt = scanner.nextLine();
            switch (opt) {
                case "1" -> ql.hienThiThongTin();
                case "2" -> ql.themDepartment();
                case "3" -> ql.xoaDepartmentTheoId();
                case "4" -> ql.suaDepartmentNameTheoId();
                case "0" -> { return; }
                default -> System.out.println("Lựa chọn sai!");
            }
        }
    }

    private static void menuPosition(IQLPosition ql, Scanner scanner) {
        while (true) {
            System.out.println("\n--- QUẢN LÝ POSITION ---");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm position");
            System.out.println("3. Xóa position theo ID");
            System.out.println("4. Sửa position_name theo ID");
            System.out.println("0. Quay lại");
            System.out.print("Chọn chức năng: ");
            String opt = scanner.nextLine();
            switch (opt) {
                case "1" -> ql.hienThiThongTin();
                case "2" -> ql.themPosition();
                case "3" -> ql.xoaPositionTheoId();
                case "4" -> ql.suaPositionNameTheoId();
                case "0" -> { return; }
                default -> System.out.println("Lựa chọn sai!");
            }
        }
    }

    private static void menuAccount(IQLAccount ql, Scanner scanner) {
        while (true) {
            System.out.println("\n--- QUẢN LÝ ACCOUNT ---");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm account");
            System.out.println("3. Xóa account theo ID");
            System.out.println("4. Sửa username theo ID");
            System.out.println("0. Quay lại");
            System.out.print("Chọn chức năng: ");
            String opt = scanner.nextLine();
            switch (opt) {
                case "1" -> ql.hienThiThongTin();
                case "2" -> ql.themAccount();
                case "3" -> ql.xoaAccountTheoId();
                case "4" -> ql.suaUsernameTheoId();
                case "0" -> { return; }
                default -> System.out.println("Lựa chọn sai!");
            }
        }
    }
}