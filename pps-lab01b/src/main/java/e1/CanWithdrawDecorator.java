package e1;

public class CanWithdrawDecorator extends BankAccountDecorator {

    private final int maxOverdraft;

    public CanWithdrawDecorator(BankAccount base, int maxOverdraft) {
        super(base);
        this.maxOverdraft = -maxOverdraft;
    }

    @Override
    public void withdraw(int amount){
        if(this.getBalance() - amount < maxOverdraft){
            throw new IllegalStateException();
        }
        super.withdraw(amount);
    }
}
