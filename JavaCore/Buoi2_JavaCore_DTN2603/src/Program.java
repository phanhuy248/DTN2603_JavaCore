import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        // 1. Department
        Department dep1 = new Department(1, "Sale");
        Department dep2 = new Department(2, "Marketing");
        Department dep3 = new Department(3, "IT");

        // 2. Position
        Position pos1 = new Position(PositionName.DEV, 1);
        Position pos2 = new Position(PositionName.TEST, 2);
        Position pos3 = new Position(PositionName.PM, 3);
        Position pos4 = new Position(PositionName.SCRUM_MASTER, 4);

        // 3. Account
        Account acc1 = new Account(1, "nguyenvana@gmail.com", "ana", "Nguyen Van A", dep1, pos1,null,
                LocalDate.of(2023, 1, 15));
        Account acc2 = new Account(2, "tranvanb@gmail.com", "btran", "Tran Van B", dep2, pos2,null,
                LocalDate.of(2023, 2, 20));
        Account acc3 = new Account(3, "lethic@gmail.com", "cle", "Le Thi C", dep3, pos3,null, LocalDate.of(2023, 3, 10));

        // 4. Group
        Group group1 = new Group(1, "Java Development", acc2,null, LocalDate.of(2023, 4, 1));
        Group group2 = new Group(2, "C# Development", acc1, null, LocalDate.of(2023, 4, 5));
        Group group3 = new Group(3, "Software Testing", acc3, null, LocalDate.of(2023, 4, 12));

        group1.setAccounts(new Account[]{acc2, acc3});
        group2.setAccounts(new Account[]{acc1, acc3});
        group3.setAccounts(new Account[]{acc2, acc3,acc1});

        acc1.setGroups(new Group[]{group2, group3});
        acc2.setGroups(new Group[]{group1, group3});
        acc3.setGroups(new Group[]{group2, group3,group1});

        // 6. TypeQuestion
        TypeQuestion type1 = new TypeQuestion(1, TypeName.ESSAY);
        TypeQuestion type2 = new TypeQuestion(2, TypeName.MULTIPLE_CHOICE);

        // 7. CategoryQuestion
        CategoryQuestion cat1 = new CategoryQuestion(1, "Java");
        CategoryQuestion cat2 = new CategoryQuestion(2, ".NET");
        CategoryQuestion cat3 = new CategoryQuestion(3, "SQL");

        // 8. Question
        Question q1 = new Question(1, "Câu hỏi về Java OOP là gì?", cat1, type1, acc1,null, LocalDate.of(2023, 5, 1));
        Question q2 = new Question(2, "Câu hỏi về C# Interface?", cat2, type2, acc2,null, LocalDate.of(2023, 5, 2));
        Question q3 = new Question(3, "Câu hỏi về SQL JOIN?", cat3, type1, acc3,null, LocalDate.of(2023, 5, 3));

        // 9. Answer
        Answer ans1 = new Answer(1, "Trả lời 01 cho câu hỏi Java", q1, true);
        Answer ans2 = new Answer(2, "Trả lời 02 cho câu hỏi C#", q2, false);
        Answer ans3 = new Answer(3, "Trả lời 03 cho câu hỏi SQL", q3, true);

        // 10. Exam
        Exam exam1 = new Exam(1, "EX001", "Đề thi Java Basic", cat1, 60, acc1, null, LocalDate.of(2023, 6, 1));
        Exam exam2 = new Exam(2, "EX002", "Đề thi C# Advanced", cat2, 90, acc2, null, LocalDate.of(2023, 6, 5));
        Exam exam3 = new Exam(3, "EX003", "Đề thi SQL Fundamentals", cat3, 45, acc3, null, LocalDate.of(2023, 6, 10));

        exam1.setQuestions(new Question[]{q1, q2});
        exam2.setQuestions(new Question[]{q2, q3});
        exam3.setQuestions(new Question[]{q1, q3});

        q1.setExams(new Exam[]{exam1, exam3});
        q2.setExams(new Exam[]{exam1, exam2});
        q3.setExams(new Exam[]{exam2, exam3});

        System.out.println("--- DANH SÁCH DEPARTMENT ---");
        System.out.println("Department 1: ID = " + dep1.getDepartmentId() + ", Name = " + dep1.getDepartmentName());
        System.out.println("Department 2: ID = " + dep2.getDepartmentId() + ", Name = " + dep2.getDepartmentName());
        System.out.println("Department 3: ID = " + dep3.getDepartmentId() + ", Name = " + dep3.getDepartmentName());

        question1(acc2);
        question2(acc2);
        question3(acc2);
        question4(acc1);
        question5(group1);
        question6(acc2);
        question7(acc1);
        Account[] accounts = {acc1,acc2,acc3};
        question8(accounts);
        Department[] departments = {dep1,dep2,dep3};
        question9(departments);
        question10(accounts);
        quesiton11(departments);
        question12(departments);
        question13(accounts);
        question14(accounts);
        question15();
        question16A(accounts);
        question16B(departments);
        question16C();
        question17(accounts);

    }

    public static void question1(Account account){
        // IF
        // Question 1 Kiểm tra account thứ 2
        //Nếu không có phòng ban (tức là department == null) thì sẽ in ra text "Nhân viên này chưa có phòng ban"
        //Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là …
        if (account.getDepartment() == null){
            System.out.println("Nhân viên này chưa có phòng ban");
        }else{
            System.out.println("Phòng ban của nhân viên này là: "+account.getDepartment().getDepartmentName());
        }
    }
    public static void question2(Account account){
        //Question 2:
        //Kiểm tra account thứ 2
        //Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
        //Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên này là Java Fresher, C# Fresher"
        //Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều group"
        //Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là người hóng chuyện, tham gia tất cả các group"
        if (account.getGroups().length == 0){
            System.out.println("Nhân viên này chưa có group");
        } else if (account.getGroups().length == 1 || account.getGroups().length == 2) {
            System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
        } else if (account.getGroups().length == 3) {
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        }else {
            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }
    }
    public  static void question3(Account account){
//        Question 3:
//        Sử dụng toán tử ternary để làm Question 1
        String result = (account.getDepartment() == null)
                ? "Nhân viên này chưa có phòng ban"
                : "Phòng ban của nhân viên này là: " + account.getDepartment().getDepartmentName();
        System.out.println(result);
    }
    public static void question4(Account account){
        //Question 4:
        //Sử dụng toán tử ternary để làm yêu cầu sau:
        //Kiểm tra Position của account thứ 1
        //Nếu Position = Dev thì in ra text "Đây là Developer"
        //Nếu không phải thì in ra text "Người này không phải là Developer"
        String result = account.getPosition().getPositionName() == PositionName.DEV ? "Đây là Developer" : "Người này không phải Developer";
        System.out.println(result);
    }
    public static void question5(Group group){
        //Question 5:
        //Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
        //Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
        //Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
        //Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
        //Còn lại in ra "Nhóm có nhiều thành viên"
        switch (group.getAccounts().length){
            case 1:
                System.out.println("Nhóm này có một thành viên");break;
            case 2:
                System.out.println("Nhóm này có hai thành viên");break;
            case 3:
                System.out.println("Nhóm này có ba thành viên");break;
            default:
                System.out.println("Nhóm này có nhiều thành viên");
        }
    }
    public static void question6(Account account){
        //Question 6:
        //Sử dụng switch case để làm lại Question 2
        switch (account.getGroups().length){
            case 0:
                System.out.println("Nhân viên này chưa có group");break;
            case 1:
                System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");break;
            case 3:
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");break;
            case 4:
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");break;
        }
    }
    public static void question7(Account account){
        //Question 7:
        //Sử dụng switch case để làm lại Question 4
        switch (account.getPosition().getPositionName()){
            case DEV:
                System.out.println("Đây là developer");break;
            default:
                System.out.println("Người này không phải developer");
        }
    }
    public static void question8(Account[] accounts){
        //FOREACH
        //Question 8:
        //In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ
        for (Account account : accounts){
            System.out.println("Email: "+account.getEmail());
            System.out.println("Full Name: "+ account.getFullName());
            if (account.getDepartment().getDepartmentName() == null){
                System.out.println("Nhân viên này chưa có phòng ban.");
            }else {
                System.out.println("Department Name: "+account.getDepartment().getDepartmentName());
            }
            System.out.println();
        }
    }
    public static void question9(Department[] departments){
        //Question 9:
        //In ra thông tin các phòng ban bao gồm: id và name
        for(Department department : departments){
            System.out.println(department);
            System.out.println();
        }
    }
    public static void question10(Account[] accounts){
        //FOR
        //Question 10:
        //In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của
        //họ theo định dạng như sau:
        //      Thông tin account thứ 1 là:
        //Email: NguyenVanA@gmail.com
        //Full name: Nguyễn Văn A
        //Phòng ban: Sale
        //Thông tin account thứ 2 là:
        //Email: NguyenVanB@gmail.com
        //Full name: Nguyễn Văn B
        //Phòng ban: Marketting
        for (int i = 0;i < accounts.length;i++){
            System.out.println("Thông tin account thứ "+ (i+1));
            System.out.println("Email: "+accounts[i].getEmail()) ;
            System.out.println("Full name: "+accounts[i].getFullName());
            System.out.println("Phòng ban: "+ accounts[i].getDepartment().getDepartmentName());
            System.out.println();

        }
    }
    public static void quesiton11(Department[] departments){
        //Question 11:
        //In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
        //       Thông tin department thứ 1 là:
        //Id: 1
        //Name: Sale
        //Thông tin department thứ 2 là:
        //Id: 2
        //Name: Marketing
        for (int i = 0;i < departments.length;i++){
            System.out.println("Thông tin phòng ban thứ "+(i+1)+" là:");
            System.out.println("Id: "+departments[i].getDepartmentId());
            System.out.println("Name: "+departments[i].getDepartmentName());
            System.out.println();
        }
    }
    public static void question12(Department[] departments){
        //
        //Question 12:
        //Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
        for (int i = 0;i < 2;i++){
            System.out.println("Thông tin phòng ban thứ "+(i+1)+" là:");
            System.out.println("Id: "+departments[i].getDepartmentId());
            System.out.println("Name: "+departments[i].getDepartmentName());
            System.out.println();
        }
    }
    public static void question13(Account[] accounts){
        //
        //Question 13:
        //In ra thông tin tất cả các account ngoại trừ account thứ 2
        for (int i = 0;i < accounts.length;i++){
            if (i == 1){
                continue;
            }
            System.out.println("Thông tin account thứ "+ (i+1));
            System.out.println("Account Id: "+accounts[i].getAccountId());
            System.out.println("Email: "+accounts[i].getEmail()) ;
            System.out.println("User name: "+accounts[i].getUserName() );
            System.out.println("Full name: "+accounts[i].getFullName());
            System.out.println("Phòng ban: "+ accounts[i].getDepartment().getDepartmentName());
            System.out.println("Vi trí: "+ accounts[i].getPosition().getPositionName());
            System.out.println("Create Date: "+accounts[i].getCreateDate());
            System.out.println();

        }
    }
    public static void question14(Account[] accounts){
        //Question 14:
        //In ra thông tin tất cả các account có id < 4
        for (int i = 0;i < accounts.length;i++){
            if (accounts[i].getAccountId() >= 4){
                continue;
            }
            System.out.println("Thông tin account thứ "+ (i+1));
            System.out.println("Account Id: "+accounts[i].getAccountId());
            System.out.println("Email: "+accounts[i].getEmail()) ;
            System.out.println("User name: "+accounts[i].getUserName() );
            System.out.println("Full name: "+accounts[i].getFullName());
            System.out.println("Phòng ban: "+ accounts[i].getDepartment().getDepartmentName());
            System.out.println("Vi trí: "+ accounts[i].getPosition().getPositionName());
            System.out.println("Create Date: "+accounts[i].getCreateDate());
            System.out.println();
        }
    }
    public static void question15(){
        //Question 15:
        //In ra các số chẵn nhỏ hơn hoặc bằng 20
        for (int i = 0;i <= 20;i++){
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }
    public static void question16A(Account[] accounts){
        //WHILE
        //Question 16:
        //Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với
        //lệnh break, continue
        int a = 0;
        while (a < accounts.length){
            System.out.println("Thông tin account thứ "+ (a+1));
            System.out.println("Email: "+accounts[a].getEmail()) ;
            System.out.println("Full name: "+accounts[a].getFullName());
            System.out.println("Phòng ban: "+ accounts[a].getDepartment().getDepartmentName());
            System.out.println();
            a++;
        }
        int a3 = 0;
        while (a3 < accounts.length){
            if (accounts[a3].getAccountId() == 2){
                a3++;
                continue;
            }
            System.out.println("Thông tin account thứ "+ (a3+1));
            System.out.println("Email: "+accounts[a3].getEmail()) ;
            System.out.println("Full name: "+accounts[a3].getFullName());
            System.out.println("Phòng ban: "+ accounts[a3].getDepartment().getDepartmentName());
            System.out.println();
            a3++;
        }
        int a4 = 0;
        while (a4 < accounts.length && accounts[a4].getAccountId() < 4){
            System.out.println("Thông tin account thứ "+ (a4+1));
            System.out.println("Email: "+accounts[a4].getEmail()) ;
            System.out.println("Full name: "+accounts[a4].getFullName());
            System.out.println("Phòng ban: "+ accounts[a4].getDepartment().getDepartmentName());
            System.out.println();
            a4++;
        }
    }
    public static void question16B(Department[] departments){
        int a2 = 0;
        while (a2 < 2){
            System.out.println("Thông tin phòng ban thứ "+(a2+1)+" là:");
            System.out.println("Id: "+departments[a2].getDepartmentId());
            System.out.println("Name: "+departments[a2].getDepartmentName());
            System.out.println();
            a2++;
        }
    }
    public static void question16C(){
        int f = 0;
        while (f <=  20){
            if (f % 2 == 0){
                System.out.println(f);
            }
            f++;
        }
    }
    public static void question17(Account[] accounts){
        // DO-WHILE
        int g = 0;
        do {
            System.out.println("Thông tin account thứ "+ (g+1));
            System.out.println("Email: "+accounts[g].getEmail()) ;
            System.out.println("Full name: "+accounts[g].getFullName());
            System.out.println("Phòng ban: "+ accounts[g].getDepartment().getDepartmentName());
            System.out.println();
            g++;
        }while (g< accounts.length);
    }
    public static void ex1(){
        // Exercise 2: System out printf
        //Question 1:
        //Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số
        //nguyên đó
        int z = 5;
        System.out.printf("%d%n", z);
    }
    public static void ex2(){
        //Question 2:
        //Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in
        //ra số nguyên đó thành định dạng như sau: 100,000,000
        int y = 1000000000;
        System.out.printf("%,d%n", y);
        System.out.println();
    }
    public static void ex3(){
        //Question 3:
        //Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số
        //thực đó chỉ bao gồm 4 số đằng sau
        float u = 5.567098f;
        System.out.printf("%.4f",u);
    }
    public static void ex4(){
        //Question 4:
        //Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định
        //dạng như sau:
        //Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
        //Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.
        System.out.println();
        String hoTen = "Phan Quang Huy";
        System.out.println("Họ và tên: "+hoTen+" và tôi đang độc thân.");
    }
    public static void ex5(){
        //Question 5:
        //Lấy thời gian bây giờ và in ra theo định dạng sau:
        //24/04/2020 11h:16p:20s
        String pattern = "dd/MM/yyyy HH'h':mm'p':ss's'";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        System.out.println(date);
    }
    public static void ex6(Account[] accounts){
        //Question 6:
        //In ra thông tin account (như Question 8 phần FOREACH) theo định dạng
        //table (giống trong Database)
        System.out.println("-----------------------------------------------------------------------");
        // In tiêu đề cột
        System.out.printf("%-20s | %-25s | %-15s%n", "Email", "Full Name", "Department");
        System.out.println("-----------------------------------------------------------------------");
        for (Account account : accounts) {
            System.out.printf("%-20s | %-25s | %-15s%n",
                    account.getEmail(),
                    account.getFullName(),
                    account.getDepartment().getDepartmentName());
        }
        System.out.println("-----------------------------------------------------------------------");
    }
    public static void e1(Exam exam){
        //Exercise 3: Date Format
        //Question 1:
        //In ra thông tin Exam thứ 1 và property create date sẽ được format theo định
        //dạng vietnamese
        DateTimeFormatter vnFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Exam thứ 1:");
        System.out.println("Title: " + exam.getTitle());
        System.out.println("Create Date (VN): " + exam.getCreateDate().format(vnFormat));

    }
    public static void e2(Exam exam){
        //Question 2:
        //In ra thông tin: Exam đã tạo ngày nào theo định dạng
        //Năm – tháng – ngày – giờ – phút – giây
        DateTimeFormatter fullFormat =
                DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");

        System.out.println("Exam được tạo ngày: " +
                exam.getCreateDate().format(fullFormat));

    }
    public static void e3(Exam exam){
        //Question 3:
        //Chỉ in ra năm của create date property trong Question 2
        System.out.println("Năm tạo Exam: " + exam.getCreateDate().getYear());

    }
    public static void e4(Exam exam){
        //Question 4:
        //Chỉ in ra tháng và năm của create date property trong Question 2
        DateTimeFormatter monthYearFormat =
                DateTimeFormatter.ofPattern("MM-yyyy");

        System.out.println("Tháng - Năm tạo Exam: " +
                exam.getCreateDate().format(monthYearFormat));

    }
    public static void e5(Exam exam){
        //Question 5:
        //Chỉ in ra "MM-DD" của create date trong Question 2
        DateTimeFormatter monthDayFormat =
                DateTimeFormatter.ofPattern("MM-dd");

        System.out.println("MM-DD: " +
                exam.getCreateDate().format(monthDayFormat));

    }
    public static void exe1(){
        Random random = new Random();
        //Exercise 4: Random Number
        //Question 1:
        //In ngẫu nhiên ra 1 số nguyên
        int value1 = random.nextInt();
        System.out.println(value1);
    }
    public static void exe2(){
        Random random = new Random();
        //Question 2:
        //In ngẫu nhiên ra 1 số thực
        float value2 = random.nextFloat();
        System.out.println(value2);
    }
    public static void exe3(){
        Random random = new Random();
        //Question 3:
        //Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên ra tên của 1 bạn
        String[] arr = new String[]{"Phan Quang Huy","Nguyễn Văn A","Nguyễn Thị B"};
        int i = random.nextInt(arr.length);
        System.out.println("1 bạn ngẫu nhiên trong lớp là : "+arr[i]);
    }
    public static void exe4(){
        //Question 4:
        //Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12- 1995
        Random random = new Random();
        LocalDate startDate = LocalDate.of(1995, 7, 24);
        LocalDate endDate = LocalDate.of(1995, 12, 20);

        int days = (int) (endDate.toEpochDay() - startDate.toEpochDay());
        int randomDays = random.nextInt(days + 1);

        LocalDate randomDate = startDate.plusDays(randomDays);
        System.out.println("Ngày ngẫu nhiên (1995): " + randomDate);

    }
    public static void exe5(){
        //Question 5:
        //Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây
        Random random = new Random();
        LocalDate today = LocalDate.now();
        LocalDate oneYearAgo = today.minusYears(1);

        int daysBetween = (int) (today.toEpochDay() - oneYearAgo.toEpochDay());
        int randomDay = random.nextInt(daysBetween + 1);

        LocalDate randomDateInYear = oneYearAgo.plusDays(randomDay);
        System.out.println("Ngày ngẫu nhiên trong 1 năm gần đây: " + randomDateInYear);

    }
    public static void exe6(){
        Random random = new Random();
        //Question 6:
        //Lấy ngẫu nhiên 1 ngày trong quá khứ.
        LocalDate pastStart = LocalDate.of(1900, 1, 1);
        LocalDate now = LocalDate.now();

        int pastDays = (int) (now.toEpochDay() - pastStart.toEpochDay());
        int randomPastDay = random.nextInt(pastDays + 1);

        LocalDate randomPastDate = pastStart.plusDays(randomPastDay);
        System.out.println("Ngày ngẫu nhiên trong quá khứ: " + randomPastDate);

    }
    public static void exe7(){
        Random random = new Random();
        //Lấy ngẫu nhiên 1 số có 3 chữ số
        int threeDigitNumber = 100 + random.nextInt(900);
        System.out.println("Số ngẫu nhiên có 3 chữ số: " + threeDigitNumber);

    }
    public static void exer1(){
        //Question 1:
        //Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình.
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số nguyên a: ");
        int a = sc.nextInt();
        System.out.println("Nhâp vào số nguyên b: ");
        int b = sc.nextInt();
        System.out.println("Nhâp vào số nguyên c: ");
        int c = sc.nextInt();
        System.out.println("Các số nguyên vừa nhập là: "+a+" "+b+" "+c);
    }
    public static void exer2(){
        //Question 2:
        //Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình.
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số thực a: ");
        float a = sc.nextFloat();
        System.out.println("Nhập vào số thực b: ");
        float b = sc.nextFloat();
        System.out.println("Hai số thực vừa nhập là: "+a+" "+b);
    }
    public static void exer3(){
        //Question 3:
        //Viết lệnh cho phép người dùng nhập họ và tên.
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào họ và tên: ");
        String hoTen = sc.nextLine();
        System.out.println("Thông tin người dùng vừa nhập là: "+hoTen);
    }
    public static void exer4(){
        //Question 4:
        //Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ.
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào ngày sinh của bạn: ");
        int day = sc.nextInt();
        System.out.println("Nhập vào tháng sinh của bạn: ");
        int month = sc.nextInt();
        System.out.println("Nhập vào năm sinh của bạn: ");
        int year = sc.nextInt();
        LocalDate localDate = LocalDate.of(year,month,day);
        System.out.println("Ngày tháng năm sinh của bạn là: "+localDate);
    }
    public static void exer5(Position[] positions){
        //Question 5:
        //Viết lệnh cho phép người dùng tạo account (viết thành method)
        //Đối với property Position, Người dùng nhập vào 1 2 3 4 5 và vào
        //chương trình sẽ chuyển thành Position.Dev, Position.Test, Position.ScrumMaster, Position.PM.
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào thông tin của của người dùng");
        Account account = new Account();
        System.out.println("Nhập Account Id: ");
        account.setAccountId(sc.nextInt());
        sc.nextLine();
        System.out.println("Nhập vào email: ");
        account.setEmail(sc.nextLine());
        System.out.println("Nhập vào User name: ");
        account.setUserName(sc.nextLine());
        System.out.println("Nhập vào Full name: ");
        account.setFullName(sc.nextLine());
        System.out.println("Nhập vào Position: ");
        int num = sc.nextInt();
        switch (num){
            case 1:
                account.setPosition(positions[0]);
                break;
            case 2:
                account.setPosition(positions[1]);
                break;
            case 3:
                account.setPosition(positions[2]);
                break;
            case 4:
                account.setPosition(positions[3]);
                break;
        }
        System.out.println("Thông tin của người dùng vừa nhập là ID: "+account.getAccountId());
        System.out.println("Email: "+account.getEmail());
        System.out.println("User name: "+account.getUserName());
        System.out.println("Full name: "+account.getFullName());
        System.out.println("Position: "+account.getPosition().getPositionName());
    }
    public static void exer6(){
        //Question 6:
        //Viết lệnh cho phép người dùng tạo department (viết thành method)
        Scanner sc = new Scanner(System.in);
        Department department = new Department();
        System.out.println("Nhập vào DepartmentId: ");
        department.setDepartmentId(sc.nextInt());
        sc.nextLine();
        System.out.println("Nhập vào DepartmentName: ");
        department.setDepartmentName(sc.nextLine());
        System.out.printf("Thông tin phòng ban vừa nhập là: "+department.getDepartmentId()+" "+department.getDepartmentName());
    }
    public static void exer7(){
        //Question 7:
        //Nhập số chẵn từ console
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Nhập vào số chẵn: ");
            int a = sc.nextInt();
            if(a % 2 == 0){
                System.out.println("So chẵn bạn vừa nhập là: "+a);break;
            }else {
                System.out.println("Số bạn vừa nhập không phải số chẵn vui lòng nhập lại");
            }
        }
    }
    public static void exer8(){
        //Question 8:
        //Viết chương trình thực hiện theo flow sau:
        //Bước 1:
        // Chương trình in ra text "mời bạn nhập vào chức năng muốn sử dụng"
        //Bước 2:
        //Nếu người dùng nhập vào 1 thì sẽ thực hiện tạo account
        //Nếu người dùng nhập vào 2 thì sẽ thực hiện chức năng tạo
        //department
        //Nếu người dùng nhập vào số khác thì in ra text "Mời bạn nhập
        //lại" và quay trở lại bước 1
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Mời bạn chọn chức năng muốn sử dụng: ");
            int a = sc.nextInt();
            if (a == 1 || a == 2){
                switch (a){
                    case 1:
                        System.out.println("Bạn đã chọn chức năng tạo Account.");
                        Account account = new Account();
                        System.out.println("Nhập vào AccountId: ");
                        account.setAccountId(sc.nextInt());
                        sc.nextLine();
                        System.out.println("Nhập vào email: ");
                        account.setEmail(sc.nextLine());
                        System.out.println("Nhập vào UserName: ");
                        account.setUserName(sc.nextLine());
                        System.out.println("Nhập vào fullName: ");
                        account.setFullName(sc.nextLine());
                        System.out.println("Nhập vào DepartmentName: ");
                        Department dep = new Department();
                        dep.setDepartmentName(sc.nextLine());
                        account.setDepartment(dep);
                        Position pos = new Position();
                        pos.setPositionName(PositionName.DEV);
                        account.setPosition(pos);
                        break;
                    case 2:
                        System.out.println("Bạn đã chọn chức năng tạo Department");
                        Department department = new Department();
                        System.out.println("Nhập vào DepartmentId: ");
                        department.setDepartmentId(sc.nextInt());
                        sc.nextLine();
                        System.out.println("Nhập vào DepartmentName: ");
                        department.setDepartmentName(sc.nextLine());break;
                }

            }else {
                System.out.println("Mời bạn quay lại bước 1");
            }
        }
    }


}
