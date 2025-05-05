package e1;

public class FeeDecorator extends BankAccountDecorator{

    private final int minimumAmountWithFee;
    private final int fee;

    public FeeDecorator(BankAccount base, int minimumAmountWithFee, int fee) {
        super(base);
        this.fee = fee;
        this.minimumAmountWithFee = minimumAmountWithFee;
    }

    @Override
    public void withdraw(int amount){
        super.withdraw(amount > this.minimumAmountWithFee ? amount + fee : amount);
    }

}
