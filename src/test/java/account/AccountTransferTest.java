package account;

import com.revolut.account.Account;
import com.revolut.account.NegativeAmountException;
import com.revolut.account.NotEnoughMoneyException;
import com.revolut.account.OperationDeniedException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AccountTransferTest {


    @Test
    public void success_account_transfer() throws NegativeAmountException, NotEnoughMoneyException, OperationDeniedException {
        Account account1 = new Account(new BigDecimal(100), "1");
        Account account2 = new Account(new BigDecimal(10), "2");
        account1.transfer(account2, new BigDecimal(50));
        assertEquals(new BigDecimal(50), account1.getAmount());
        assertEquals(new BigDecimal(60), account2.getAmount());
    }

    @Test
    public void not_enough_money() throws NegativeAmountException, NotEnoughMoneyException, OperationDeniedException {
        Account account1 = new Account(new BigDecimal(10), "1");
        Account account2 = new Account(new BigDecimal(10), "2");
        assertThrows(NotEnoughMoneyException.class, () -> account1.transfer(account2, new BigDecimal(50)));
    }

    @Test
    public void negative_amount() throws NegativeAmountException, NotEnoughMoneyException, OperationDeniedException {
        Account account1 = new Account(new BigDecimal(100), "1");
        Account account2 = new Account(new BigDecimal(10), "2");
        assertThrows(NegativeAmountException.class, () -> account1.transfer(account2, new BigDecimal(-50)));
    }

    @Test
    public void operation_denied_from() throws NegativeAmountException, NotEnoughMoneyException, OperationDeniedException {
        Account account1 = new Account(new BigDecimal(100), "1");
        Account account2 = new Account(new BigDecimal(10), "2");
        account1.setOperationsAllowed(false);
        assertThrows(OperationDeniedException.class, () -> account1.transfer(account2, new BigDecimal(50)));
    }

    @Test
    public void operation_denied_to() throws NegativeAmountException, NotEnoughMoneyException, OperationDeniedException {
        Account account1 = new Account(new BigDecimal(100), "1");
        Account account2 = new Account(new BigDecimal(10), "2");
        account2.setOperationsAllowed(false);
        assertThrows(OperationDeniedException.class, () -> account1.transfer(account2, new BigDecimal(50)));
    }

}
