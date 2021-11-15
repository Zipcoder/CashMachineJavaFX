package rocks.zipcode.atm.bank;

/**
 * @author ZipCodeWilmington
 */
public class PremiumAccount extends Account {

    private static final float OVERDRAFT_LIMIT = 100f;

    public PremiumAccount(AccountData accountData) {
        super(accountData);
    }

    @Override
    protected boolean canWithdraw(float amount) {
        return getBalance() + OVERDRAFT_LIMIT >= amount;
    }
}
