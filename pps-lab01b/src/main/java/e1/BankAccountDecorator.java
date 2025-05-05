package e1;

public class BankAccountDecorator implements BankAccount{

    private BankAccount base;

    public BankAccountDecorator(BankAccount base) {
        this.base = base;
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        base.withdraw(amount);
    }
}
