package rocks.zipcode.atm.bank;

/**
 * @author ZipCodeWilmington
 */
public abstract class Account {

    private AccountData accountData;

    public Account(AccountData accountData) {
        this.accountData = accountData;
    }

    public AccountData getAccountData() {
        return accountData;
    }

    public void deposit(Float amount) {
       accountData = new AccountData (accountData.getId(), accountData.getName(), accountData.getEmail(), accountData.getBalance() + amount);
    }

    public boolean withdraw(Float amount) {
        if (canWithdraw(amount)) {
            updateBalance((int) (getBalance() - amount));
            return true;
        } else {
            return false;
        }
    }

    protected boolean canWithdraw(float amount) {
        return accountData.getBalance() >= amount;
    }

    public int getBalance() {
        return (int) accountData.getBalance();
    }

    private void updateBalance(float newBalance) {
        accountData = new AccountData(accountData.getId(), accountData.getName(), accountData.getEmail(),
                newBalance);
    }
}
