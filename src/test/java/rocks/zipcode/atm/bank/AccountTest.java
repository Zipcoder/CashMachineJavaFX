package rocks.zipcode.atm.bank;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void deposit() {
        // Given
        Bank bank = new Bank();
        Account account = bank.getAccounts().get(10);

        //When
        account.deposit(100.00f);


        // Expected
        Float expected = 1045658.89f + 100.00f;
        Float actual = account.getBalance();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void withdraw() {
        // Given
        Bank bank = new Bank();
        Account account = bank.getAccounts().get(10);

        //When
        account.withdraw(100.00f);


        // Expected
        Float expected = 1045658.89f - 100.00f;
        Float actual = account.getBalance();

        Assert.assertEquals(actual, expected);

    }
}
