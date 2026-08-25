import java.time.LocalDate;

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

        // 3. Account
        Account acc1 = new Account(1, "nguyenvana@gmail.com", "ana", "Nguyen Van A", dep1, pos1,
                LocalDate.of(2023, 1, 15));
        Account acc2 = new Account(2, "tranvanb@gmail.com", "btran", "Tran Van B", dep2, pos2,
                LocalDate.of(2023, 2, 20));
        Account acc3 = new Account(3, "lethic@gmail.com", "cle", "Le Thi C", dep3, pos3, LocalDate.of(2023, 3, 10));

        // 4. Group
        Group group1 = new Group(1, "Java Development", acc1, LocalDate.of(2023, 4, 1));
        Group group2 = new Group(2, "C# Development", acc2, LocalDate.of(2023, 4, 5));
        Group group3 = new Group(3, "Software Testing", acc3, LocalDate.of(2023, 4, 12));

        // 5. GroupAccount
        GroupAccount groupAcc1 = new GroupAccount(group1, acc1, LocalDate.of(2023, 4, 2));
        GroupAccount groupAcc2 = new GroupAccount(group1, acc2, LocalDate.of(2023, 4, 6));
        GroupAccount groupAcc3 = new GroupAccount(group2, acc3, LocalDate.of(2023, 4, 15));

        // 6. TypeQuestion
        TypeQuestion type1 = new TypeQuestion(1, TypeName.ESSAY);
        TypeQuestion type2 = new TypeQuestion(2, TypeName.MULTIPLE_CHOICE);

        // 7. CategoryQuestion
        CategoryQuestion cat1 = new CategoryQuestion(1, "Java");
        CategoryQuestion cat2 = new CategoryQuestion(2, ".NET");
        CategoryQuestion cat3 = new CategoryQuestion(3, "SQL");

        // 8. Question
        Question q1 = new Question(1, "Câu hỏi về Java OOP là gì?", cat1, type1, acc1, LocalDate.of(2023, 5, 1));
        Question q2 = new Question(2, "Câu hỏi về C# Interface?", cat2, type2, acc2, LocalDate.of(2023, 5, 2));
        Question q3 = new Question(3, "Câu hỏi về SQL JOIN?", cat3, type1, acc3, LocalDate.of(2023, 5, 3));

        // 9. Answer
        Answer ans1 = new Answer(1, "Trả lời 01 cho câu hỏi Java", q1, true);
        Answer ans2 = new Answer(2, "Trả lời 02 cho câu hỏi C#", q2, false);
        Answer ans3 = new Answer(3, "Trả lời 03 cho câu hỏi SQL", q3, true);

        // 10. Exam
        Exam exam1 = new Exam(1, "EX001", "Đề thi Java Basic", cat1, 60, acc1, LocalDate.of(2023, 6, 1));
        Exam exam2 = new Exam(2, "EX002", "Đề thi C# Advanced", cat2, 90, acc2, LocalDate.of(2023, 6, 5));
        Exam exam3 = new Exam(3, "EX003", "Đề thi SQL Fundamentals", cat3, 45, acc3, LocalDate.of(2023, 6, 10));

        // 11. ExamQuestion
        ExamQuestion examQ1 = new ExamQuestion(q1, exam1);
        ExamQuestion examQ2 = new ExamQuestion(q2, exam2);
        ExamQuestion examQ3 = new ExamQuestion(q3, exam3);

        System.out.println("--- DANH SÁCH DEPARTMENT ---");
        System.out.println("Department 1: ID = " + dep1.getDepartmentId() + ", Name = " + dep1.getDepartmentName());
        System.out.println("Department 2: ID = " + dep2.getDepartmentId() + ", Name = " + dep2.getDepartmentName());
        System.out.println("Department 3: ID = " + dep3.getDepartmentId() + ", Name = " + dep3.getDepartmentName());
    }
}
