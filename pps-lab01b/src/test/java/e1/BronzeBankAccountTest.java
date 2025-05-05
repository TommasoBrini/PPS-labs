package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest {
    private static final int INITIAL_DEPOSIT = 1000;

    private BankAccount account;

    @BeforeEach
    void init(){
        this.account = BankAccountFactory.bronzeBankAccount();
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
        assertEquals(799, this.account.getBalance());
    }

    @Test
    public void testCannotOverdraft() {
        this.account.deposit(INITIAL_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }

    @Test
    public void testCannotTaxedMinimalAmount() {
        this.account.deposit(INITIAL_DEPOSIT);
        this.account.withdraw(50);
        assertEquals(950, this.account.getBalance());
    }
}
