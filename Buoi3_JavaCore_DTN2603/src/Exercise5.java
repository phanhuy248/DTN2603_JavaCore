import java.util.Objects;

public class Exercise5 {
//    Question 1:
//    In ra thông tin của phòng ban thứ 1 (sử dụng toString())
    public static void q1(Department department) {
        System.out.println(department);
    }
//    Question 2:
//    In ra thông tin của tất cả phòng ban (sử dụng toString())
    public static void q2(Department[] departments) {
        for (Department department : departments) {
            System.out.println(department);
            System.out.println();
        }
    }
//    Question 3:
//    In ra địa chỉ của phòng ban thứ 1
    public static void q3(Department department) {
        System.out.println(department.hashCode());
    }
//    Question 4: Kiểm tra xem phòng ban thứ 1 có tên là "Phòng A" không?
    public static void q4(Department department) {
        if (Objects.equals(department.getDepartmentName(), "Phòng A")) {
            System.out.println("Phòng ban 1 là Phòng A");
        } else {
            System.out.println("Không");
        }
    }
//    Question 5:
//    So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau không (bằng nhau khi tên của 2 phòng ban đó bằng nhau)
    public static void q5(Department department1, Department department2) {
        if (department1.equals(department2)) {
            System.out.println("2 phòng ban này là một");
        } else {
            System.out.println("Không phải");
        }
    }
//    Question 6:
//    Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD)
//    VD:
//    Accounting
//    Boss of director
//          Marketing
//    Sale
//    Waiting room
    public static void q6(Department[] departments) {

        // order by
        for (int i = 0; i < departments.length; i++) {
            for (int j = 0; j < departments.length - 1; j++) {

                if (departments[i].getDepartmentName().compareToIgnoreCase(departments[j].getDepartmentName()) < 0) {
                    // swap
                    Department temp = departments[i];
                    departments[i] = departments[j];
                    departments[j] = temp;
                }
            }
        }


    }
}
