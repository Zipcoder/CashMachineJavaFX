package rocks.zipcode.atm.bank;

import rocks.zipcode.atm.ActionResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZipCodeWilmington
 */
public class Bank {

    private Map<Integer, Account> accounts = new HashMap<>(); //use to create a collection to show all the accounts

    public Bank() {
        accounts.put(1000, new BasicAccount(new AccountData(
                1000, "Action Jackson", "blamblam1@gmail.com", 300000f
        )));

        accounts.put(2000, new PremiumAccount(new AccountData(
                2000, "Spawn", "spawny3@gmail.com", 200000f
        )));

        accounts.put(3000, new PremiumAccount(new AccountData(
                3000, "David", "Nice@gmail.com", 1000000f
        )));

        accounts.put(4000, new PremiumAccount(new AccountData(
                4000, "Simba", "woofwoof@gmail.com", 300000f
        )));
    }

    public ActionResult<AccountData> getAccountById(int id) {
        Account account = accounts.get(id);

        if (account != null) {
            return ActionResult.success(account.getAccountData());
        }
        else {
            return ActionResult.fail("No account with id: " + id + "\nEnter your account ID and then click submit");
        }
    }

    public ActionResult<AccountData> deposit(AccountData accountData, float amount) {
        Account account = accounts.get(accountData.getId());
        account.deposit(amount);

        return ActionResult.success(account.getAccountData());
    }

    public ActionResult<AccountData> withdraw(AccountData accountData, float amount) {
        Account account = accounts.get(accountData.getId());
        boolean ok = account.withdraw(amount);

        if (ok) {
            return ActionResult.success(account.getAccountData());
        } else {
            return ActionResult.fail("Cannot Withdraw Amount: " + amount + ". Account has: " + account.getBalance());
        }
    }
}
