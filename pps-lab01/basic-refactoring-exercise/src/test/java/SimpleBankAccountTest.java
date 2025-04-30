import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private static final int INITIAL_BALANCE = 0;
    private static final int FIRST_DEPOSIT = 100;
    private static final int FIRST_WITHDRAW = 70;
    private static final int ERROR_ACCOUNT_ID = 2;

    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, INITIAL_BALANCE);
    }

    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_BALANCE, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), FIRST_DEPOSIT);
        assertEquals(FIRST_DEPOSIT, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), FIRST_DEPOSIT);
        bankAccount.deposit(ERROR_ACCOUNT_ID, 50);
        assertEquals(FIRST_DEPOSIT, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), FIRST_DEPOSIT);
        bankAccount.withdraw(accountHolder.getId(), FIRST_WITHDRAW);
        assertEquals(29, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), FIRST_DEPOSIT);
        bankAccount.withdraw(ERROR_ACCOUNT_ID, FIRST_WITHDRAW);
        assertEquals(FIRST_DEPOSIT, bankAccount.getBalance());
    }

}
