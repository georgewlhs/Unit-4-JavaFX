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

    public String deposit(String pin, double amt){
        if (getPin().equals(pin)) {
            balance += amt;
            return "Deposit Successful\nCurrent Balance for " + getName() + ": " + "$" + getBalance();
        }
        else
            return "Invalid PIN no deposit made";
    }

    public String withdraw(String pin, double amt){
        if (getPin().equals(pin)) {
            if (amt <= balance) {
                balance -= amt;
                return "Withdrawl Successful\nCurrent Balance for " + getName() + ": " + "$" + getBalance();
            } else
                return "Insufficient funds, no withdrawl made.";
        }
        else
            return "Invalid PIN no withdrawl made.";
    }

    public void addInterst(){
        balance += balance*INTERST_RATE;
    }

    public String toString(){
        return "Name: " + name + "\nBalance: $" + Math.round(balance * 100.0)/100.0 + "\nPIN: "+ pin;
    }
}
