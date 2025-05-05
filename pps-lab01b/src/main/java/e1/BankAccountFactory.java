package e1;

public class BankAccountFactory {

    public static BankAccount silverBankAccount() {
        return new FeeDecorator(new CanWithdrawDecorator(new CoreBankAccount(), 0), 0, 1);
    }

    public static BankAccount goldBankAccount() {
        return new CanWithdrawDecorator(new CoreBankAccount(), 500);
    }

    public static BankAccount bronzeBankAccount() {
        return new FeeDecorator(new CanWithdrawDecorator(new CoreBankAccount(), 0), 100, 1);
    }
}
