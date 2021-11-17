package rocks.zipcode.atm;

import javafx.scene.Group;
import rocks.zipcode.atm.bank.Bank;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;

import javax.xml.soap.Text;

/**
 * @author ZipCodeWilmington
 */
public class CashMachineApp extends Application {

    private TextField field = new TextField();
    private TextField txtLogIn = new TextField();
    private TextField txtDeposit = new TextField();
    private TextField txtWithDraw = new TextField();
    private CashMachine cashMachine = new CashMachine(new Bank());






    private Parent createContent() {

        Button btnSubmit = new Button("Log-in");
        Button btnDeposit = new Button("Deposit");
        Button btnWithdraw = new Button("Withdraw");
        Button btnExit = new Button("Log-out");

        btnWithdraw.setDisable(true);
        btnDeposit.setDisable(true);
        btnExit.setDisable(true);


        VBox vbox = new VBox(20);                   //spacing between the buttons
        vbox.setPrefSize(600, 600);   //size of the display box
        TextArea areaInfo = new TextArea();



        btnSubmit.setOnAction(e -> {
            int id = Integer.parseInt(txtLogIn.getText());
            cashMachine.login(id);
            areaInfo.setText(cashMachine.toString());
            btnExit.setDisable(false);
            btnDeposit.setDisable(false);
            btnWithdraw.setDisable(false);
            btnSubmit.setDisable(true);
            clearTxtBoxes();

        });




        btnDeposit.setOnAction(e -> {
            Float amount = Float.parseFloat(txtDeposit.getText());
            cashMachine.deposit(amount);
            areaInfo.setText(cashMachine.toString());
            if(amount < 0) {
                areaInfo.setText("this is not a valid number!");
            }
            clearTxtBoxes();
        });




        btnWithdraw.setOnAction(e -> {
            Float amount = Float.parseFloat(txtWithDraw.getText());
            cashMachine.withdraw(amount);
            if(cashMachine.getMsg() != "") {
                areaInfo.setText(cashMachine.getMsg());

            }
            else{
                areaInfo.setText( "This is not a valid number!");
            }

            clearTxtBoxes();
        });



        btnExit.setOnAction(e -> {
            cashMachine.exit();
            areaInfo.setText(cashMachine.toString());
            btnExit.setDisable(true);
            btnDeposit.setDisable(true);
            btnWithdraw.setDisable(true);
            btnSubmit.setDisable(false);
            clearTxtBoxes();
        });




//        FlowPane flowpane = new FlowPane();
//        flowpane.getChildren().add(btnSubmit);
//        flowpane.getChildren().add(btnDeposit);
//        flowpane.getChildren().add(btnWithdraw);
//        flowpane.getChildren().add(btnExit);


        FlowPane flowPaneAccountID = new FlowPane();
        flowPaneAccountID.getChildren().add(btnSubmit);
        flowPaneAccountID.getChildren().add(txtLogIn);

        FlowPane flowPaneDeposit = new FlowPane();
        flowPaneDeposit.getChildren().add(btnDeposit);
        flowPaneDeposit.getChildren().add(txtDeposit);

        FlowPane flowPaneWithDraw = new FlowPane();
        flowPaneWithDraw.getChildren().add(btnWithdraw);
        flowPaneWithDraw.getChildren().add(txtWithDraw);

        FlowPane flowPaneLogOut = new FlowPane();
        flowPaneLogOut.getChildren().add(btnExit);


        vbox.getChildren().addAll(flowPaneAccountID, flowPaneDeposit,flowPaneWithDraw, flowPaneLogOut, areaInfo);
        return vbox;

    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void clearTxtBoxes(){
        txtDeposit.clear();
        txtWithDraw.clear();
        txtLogIn.clear();

    }

}
