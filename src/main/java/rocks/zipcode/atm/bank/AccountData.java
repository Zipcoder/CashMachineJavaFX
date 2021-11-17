package rocks.zipcode.atm.bank;


import java.math.BigDecimal;
import java.text.DecimalFormat;

import javafx.scene.control.Alert;


/**
 * @author ZipCodeWilmington
 */
public final class AccountData {

    private final int id;
    private final String acctType;
    private final String name;
    private final String email;
    private final Float balance;

    DecimalFormat decimalFormat = new DecimalFormat("#.##");

        AccountData( int id, String acctType, String name, String email,float balance){
            this.id = id;
            this.acctType = acctType;
            this.name = name;
            this.email = email;
            this.balance = balance;
        }

        public int getId() {
            return id;
        }

        public String getAcctType() {
            return acctType;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
            public Float getBalance() {
                return balance;
            }
            public static Float round(float d,int decimalPlace){
                BigDecimal bd = new BigDecimal(Float.toString(d));
                bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
                return bd.floatValue();
            }

    @Override
            public String toString () {
            return "Account id: " + id + '\n' +
                    "Account type: " + acctType + '\n' +
                        "Name: " + name + '\n' +
                        "Email: " + email + '\n' +
                        "Balance: " + String.format("$" + "%,.2f", Float.valueOf(decimalFormat.format(balance)));

                }

            }





