package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest {
    private static final int INITIAL_DEPOSIT = 1000;
    private BankAccount account;

    @BeforeEach
    void init(){
        this.account = BankAccountFactory.goldBankAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(INITIAL_DEPOSIT);
        assertEquals(INITIAL_DEPOSIT, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(INITIAL_DEPOSIT);
        this.account.withdraw(200);
        assertEquals(800, this.account.getBalance());
    }

    @Test
    public void testCanOverdraft() {
        this.account.withdraw(300);
        assertEquals(-300, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanLimit(){
        this.account.deposit(INITIAL_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1600));
    }

}
