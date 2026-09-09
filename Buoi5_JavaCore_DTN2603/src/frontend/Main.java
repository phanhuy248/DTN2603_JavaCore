package frontend;

import backend.QLAccount;
import backend.QLDepartment;
import backend.QLPosition;

public class Main {
    public static void main(String[] args) {
        QLAccount qlAccount = new QLAccount();
        QLDepartment qlDepartment = new QLDepartment();
        QLPosition qlPosition = new QLPosition();

        qlAccount.hienThiThongTin();
        qlDepartment.hienThiThongTin();
        qlPosition.hienThiThongTin();
    }
}
