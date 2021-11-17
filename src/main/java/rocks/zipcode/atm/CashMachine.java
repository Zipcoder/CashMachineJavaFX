package rocks.zipcode.atm;

import rocks.zipcode.atm.bank.AccountData;
import rocks.zipcode.atm.bank.Bank;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author ZipCodeWilmington
 */
public class CashMachine {

    private final Bank bank;
    private AccountData accountData = null;
    private String msg;

    public CashMachine(Bank bank) {
        this.bank = bank;
    }

    private Consumer<AccountData> update = data -> {
        accountData = data;
    };

    public String getMsg(){ //method to return the error msg on line 92
        return msg;

    }

    public void login(int id) {
            tryCall(
                () -> bank.getAccountById(id),
                update
        );
    }


    public void deposit(Float amount) {

    public boolean userIsLoggedIn() { //method to validate if the log-in id is valid
        //if account data is = null; means user is not logged in = false
        //if account data is valid; true
        if (accountData == null) {
            return false;
        } else {
            return true;
        }
        if (accountData != null) {
            tryCall(
                    () -> bank.deposit(accountData, amount),
                    update
            );
        }
    }

    public void withdraw(Float amount) {

        if (accountData != null) {
             tryCall(
                    () -> bank.withdraw(accountData, amount),
                    update
            );
        }
    }

    public void exit() {
        if (accountData != null) {
            accountData = null;
        }

    }

    @Override
    public String toString() {
        return accountData != null ? accountData.toString() : "Log-in with your account ID.";
    }


    private <T> void tryCall(Supplier<ActionResult<T> > action, Consumer<T> postAction) {

      msg = "";

        try {
            ActionResult<T> result = action.get();
            if (result.isSuccess()) {
                T data = result.getData();
                postAction.accept(data);
            } else {
                String errorMessage = result.getErrorMessage();
                throw new RuntimeException(errorMessage);
            }
        } catch (Exception e) {
            msg = "Error: " + e.getMessage();
        }
    }
}
