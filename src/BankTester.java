public class BankTester {
    public static void main(String[] args) {
        System.out.println("Create Bank Object");
        BankAccount b1 = new BankAccount("Sam's", "1234");
        System.out.println(b1);
        b1.deposit("1233", 100);
        b1.deposit("1234", 100);
        System.out.println(b1);
        b1.withdraw("4321", 50);
        b1.withdraw("1234", 99);
        System.out.println(b1);
        b1.withdraw("1234", 50);
        System.out.println(b1);
        b1.addInterst();
        System.out.println(b1);

    }
}
