import java.util.Scanner;

public class Exercise4 {
//    Question 1:
//    Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có thể cách nhau bằng nhiều khoảng trắng );
    public static void question1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi ban đầu: ");
        String input = sc.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("Số từ trong chuỗi là: 0");
        } else {
            String[] words = input.split("\\s+");
            System.out.println("Số từ trong chuỗi là: " + words.length);
        }
    }
//    Question 2:
//    Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;
    public static void question2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào xâu s1: ");
        String s1 = sc.nextLine();
        System.out.println("Nhập vào xâu s2: ");
        String s2 = sc.nextLine();
        String s3 = s1 + s2;
        System.out.println("CHuỗi mới: " + s3);
    }
//    Question 3:
//    Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chữ viết hoa chữ cái đầu thì viết hoa lên.
    public static void question3() {
        Scanner scanner = new Scanner(System.in);
        String name;
        System.out.println("Nhập Tên: ");
        name = scanner.nextLine();
        String firstCharacter = name.substring(0, 1).toUpperCase();
        String leftCharacter = name.substring(1);
        name = firstCharacter + leftCharacter;
        System.out.println(name);
    }
//    Question 4:
//    Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên của người dùng ra
//    VD:
//    Người dùng nhập vào "Nam", hệ thống sẽ in ra
//        "Ký tự thứ 1 là: N"
//                "Ký tự thứ 1 là: A"
//                "Ký tự thứ 1 là: M"
    public static void question4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào tên: ");
        String ten = sc.nextLine();
        for (int i = 0; i < ten.length(); i++) {
            System.out.println("Ký tự thứ " + (i + 1) + " là: " + ten.charAt(i));
        }
    }
//    Question 5:
//    Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ.
    public static void question5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào họ: ");
        String ho = sc.nextLine();
        System.out.println("Nhập vào tên: ");
        String ten = sc.nextLine();
        System.out.println("Họ và tên vừa nhập: " + ho + " " + ten);
    }
//    Question 6:
//    Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và sau đó hệ thống sẽ tách ra họ, tên , tên đệm
//    VD:
//    Người dùng nhập vào "Nguyễn Văn Nam"
//    Hệ thống sẽ in ra
//    "Họ là: Nguyễn"
//            "Tên đệm là: Văn"
//            "Tên là: Nam"
    public static void question6() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào họ và tên đầy đủ: ");
        String fullName = sc.nextLine().trim();

        if (!fullName.isEmpty()) {
            String[] words = fullName.split("\\s+");

            String ho = words[0];
            String ten = words[words.length - 1];
            String tenDem = "";

            for (int i = 1; i < words.length - 1; i++) {
                tenDem += words[i] + " ";
            }

            tenDem = tenDem.trim();

            System.out.println("Họ: " + ho);
            System.out.println("Tên đệm: " + tenDem);
            System.out.println("Tên: " + ten);
        } else {
            System.out.println("Chuỗi rỗng!");
        }
    }
//    Question 7:
//    Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và chuẩn hóa họ và tên của họ như sau:
//    a) Xóa dấu cách ở đầu và cuối và giữa của chuỗi người dùng nhập vào
//    VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ chuẩn hóa thành "nguyễn văn   nam"
//    b) Viết hoa chữ cái mỗi từ của người dùng
//    VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ chuẩn hóa thành "Nguyễn Văn Nam"
    public static void question7() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào họ và tên: ");
        String input = sc.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("Chuỗi rỗng!");
            return;
        }

        String[] words = input.split("\\s+");
        StringBuilder normalized = new StringBuilder();

        for (String word : words) {
            String firstChar = word.substring(0, 1).toUpperCase();
            String remainingChars = word.substring(1).toLowerCase();
            normalized.append(firstChar).append(remainingChars).append(" ");
        }

        System.out.println("Họ tên sau chuẩn hóa: " + normalized.toString().trim());
    }

//    Question 8:
//    In ra tất cả các group có chứa chữ "Java"
    public static void question8() {
        String[] groupNames = {"Java Core", "Front-end Basic", "Java Advanced", "Python Master", "Learn Java Fast"};

        System.out.println("Các group có chứa chữ 'Java':");
        for (String group : groupNames) {
            if (group.contains("Java")) {
                System.out.println("- " + group);
            }
        }
    }

//    Question 9:
//    In ra tất cả các group "Java"
    public static void question9() {
        String[] groupNames = {"Java Core", "Java", "Java Advanced", "C++", "Java"};

        System.out.println("Các group có tên chính xác là 'Java':");
        for (String group : groupNames) {
            if (group.equals("Java")) {
                System.out.println("- " + group);
            }
        }
    }

//    estion 10:
//    Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không.
    public static void question10() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuỗi thứ 1: ");
        String s1 = sc.nextLine();
        System.out.println("Nhập chuỗi thứ 2: ");
        String s2 = sc.nextLine();

        if (s1.length() != s2.length()) {
            System.out.println("KO");
            return;
        }

        boolean isReverse = true;
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(len - 1 - i)) {
                isReverse = false;
                break;
            }
        }

        System.out.println(isReverse ? "OK" : "KO");
    }

//    ecial Character
//    Tìm số lần xuất hiện ký tự "a" trong chuỗi
    public static void question11() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi: ");
        String str = sc.nextLine();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                count++;
            }
        }

        System.out.println("Số lần xuất hiện ký tự 'a': " + count);
    }

//     12: Reverse String
//    Đảo ngược chuỗi sử dụng vòng lặp
    public static void question12() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi: ");
        String str = sc.nextLine();

        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        System.out.println("Chuỗi đảo ngược: " + reversed);
    }

//    Question 13:
//    String not contains digit
//    Kiểm tra một chuỗi có chứa chữ số hay không, nếu có in ra false ngược lại true.
//    Ví dụ:
//            "abc" => true
//            "1abc", "abc1", "123", "a1bc", null => false
    public static void question13() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi: ");
        String str = sc.nextLine();

        boolean notContainsDigit = true;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                notContainsDigit = false;
                break;
            }
        }

        System.out.println("Kết quả: " + notContainsDigit);
    }

//    Question 14: Replace character
//    Cho một chuỗi str, chuyển các ký tự được chỉ định sang một ký tự khác cho trước.
//    Ví dụ:
//            "VTI Academy" chuyển ký tự 'e' sang '*' kết quả " VTI Acad*my"
    public static void question14() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuỗi ban đầu: ");
        String str = sc.nextLine();
        System.out.println("Nhập ký tự cần thay: ");
        char oldChar = sc.nextLine().charAt(0);
        System.out.println("Nhập ký tự mới: ");
        char newChar = sc.nextLine().charAt(0);

        String result = str.replace(oldChar, newChar);
        System.out.println("Chuỗi sau khi thay thế: " + result);
    }

//    Question 15: Revert string by word
//    Đảo ngược các ký tự của chuỗi cách nhau bởi dấu cách mà không dùng thư viện.
//    Ví dụ: " I am developer " => "developer am I".
//    Các ký tự bên trong chỉ cách nhau đúng một dấu khoảng cách.
//    Gợi ý: Các bạn cần loại bỏ dấu cách ở đầu và cuối câu, thao tác cắt chuỗi theo dấu cách
    public static void question15() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi: ");
        String str = sc.nextLine().trim();

        if (str.isEmpty()) {
            System.out.println("Chuỗi rỗng!");
            return;
        }

        String[] words = str.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" ");
            }
        }

        System.out.println("Chuỗi sau khi đảo theo từ: " + result.toString());
    }

//    Question 16:
//    Cho một chuỗi str và số nguyên n >= 0. Chia chuỗi str ra làm các phần bằng nhau với n    ký tự. Nếu chuỗi không chia được thì xuất ra màn hình “KO”.
    public static void question16() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi: ");
        String str = sc.nextLine();
        System.out.println("Nhập số nguyên n: ");
        int n = sc.nextInt();

        if (n <= 0 || str.length() % n != 0) {
            System.out.println("KO");
        } else {
            System.out.println("Các phần sau khi chia:");
            for (int i = 0; i < str.length(); i += n) {
                System.out.println(str.substring(i, i + n));
            }
        }
    }
}
