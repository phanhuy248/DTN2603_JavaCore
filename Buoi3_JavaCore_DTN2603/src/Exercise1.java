import java.util.Random;
import java.util.Scanner;

public class Exercise1 {
//    Question 1:
//    Khai báo 2 số lương có kiểu dữ liệu là float.
//    Khởi tạo Lương của Account 1 là 5240.5 $
//    Khởi tạo Lương của Account 2 là 10970.055$
//    Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra
//    Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra
    public static void question1() {
        float account1 = 5240.5f;
        float account2 = 10970.055f;
        int intAccount1 = (int) account1;
        int intAccount2 = (int) account2;
        System.out.println(intAccount1);
        System.out.println(intAccount2);
    }
//    Question 2:
//    Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm có số 0 ở đầu cho      đủ 5 chữ số)
    public static void question2() {
        Random random = new Random();
        int a = random.nextInt(100000);
        String result = String.format("%05d", a);
        System.out.println(result);
    }
//    Question 3:
//    Lấy 2 số cuối của số ở Question 2 và in ra.
//    Gợi ý:
//    Cách 1: convert số có 5 chữ số ra String, sau đó lấy 2 số cuối
//    Cách 2: chia lấy dư số đó cho 100
    public static void question3() {
        Random random = new Random();
        int a = random.nextInt(100000);
        String b = String.format("%05d", a);
        System.out.println("Hai chữ số cuối là: " + b.substring(3));
    }
//    Question 4:
//    Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của chúng.
    public static float question4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số nguyên a: ");
        int a = sc.nextInt();
        int b;
        do {
            System.out.println("Nhập vào số nguyên b: ");
            b = sc.nextInt();
            if (b == 0) {
                System.out.println("Vui lòng nhập số b khác 0");
            }
        } while (b == 0);

        return (float) a / b;
    }

}
