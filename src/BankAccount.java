public class BankAccount {
    private double balance;
    private String pin;
    private String name;
    public static final double INTERST_RATE = 0.01;

    public BankAccount(String name, String pin){
        this.name = name;
        this.pin = pin;
        balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public String getPin() {
        return pin;
    }

    public String getName() {
        return name;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void deposit(String pin, double amt){
        if (this.pin.equals(pin))
            balance += amt;
        else
            System.out.println("Invalid PIN no deposit made");
    }

    public void withdraw(String pin, double amt){
        if (this.pin.equals(pin)) {
            if (amt <= balance) {
                balance -= amt;
            } else
                System.out.println("Insufficient funds, no withdrawl made.");
        }
        else
            System.out.println("Invalid PIN no withdrawl made.");
    }

    public void addInterst(){
        balance += balance*INTERST_RATE;
    }

    public String toString(){
        return "Name: " + name + "\nBalance: " + balance + "\nPIN: "+ pin;
    }
}
