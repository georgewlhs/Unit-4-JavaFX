import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BankAccountGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private TextField nameField;
    private PasswordField createPin;
    private TextArea output;
    private TextField amount;
    private PasswordField enterPin;
    private ArrayList<BankAccount> accts;

    @Override
    public void start(Stage stage) {
        Font font = new Font(18);
        accts = new ArrayList<BankAccount>();

        Label nameLabel = new Label("Name:");
        nameField = new TextField();

        Label createPinLabel = new Label("PIN:");
        createPin = new PasswordField();

        output = new TextArea();
        output.setFont(font);

        Label amountLabel = new Label("Amount:");
        amount = new TextField();
        amount.setMaxWidth(60);

        Label enterPinLabel = new Label("PIN:");
        enterPin = new PasswordField();
        enterPin.setMaxWidth(60);

        Button createButton = new Button("Create Account");
        createButton.setOnAction(this::createNewAccount);

        Button depositButton = new Button("Deposit");
        depositButton.setOnAction(this::makeDeposit);

        Button withdrawButton = new Button("Withdraw");
        withdrawButton.setOnAction(this::makeWithdrawl);

        Button addInterestButton = new Button("Interest");
        addInterestButton.setOnAction(this::processInterest);

        Button viewAcctButton = new Button("View Acct");
        viewAcctButton.setOnAction(this::viewAcct);

        GridPane createAcctPane = new GridPane();
        createAcctPane.setPrefSize(300,300);
        createAcctPane.add(nameLabel, 0, 0);
        createAcctPane.add(nameField,0,1);
        createAcctPane.add(createPinLabel, 1, 0);
        createAcctPane.add(createPin, 1, 1);
        createAcctPane.add(createButton,0,2, 1, 1);
        createAcctPane.setMaxHeight(100);

        GridPane useAcctPane = new GridPane();
        useAcctPane.add(enterPinLabel,0,0);
        useAcctPane.add(enterPin, 1,0);
        useAcctPane.add(amountLabel,0,1);
        useAcctPane.add(amount,1,1);
        useAcctPane.add(depositButton, 0,2);
        useAcctPane.add(withdrawButton, 1,2);
        useAcctPane.add(addInterestButton, 0, 3);
        useAcctPane.add(viewAcctButton, 1, 3);
        useAcctPane.setMaxHeight(100);

        FlowPane pane = new FlowPane(createAcctPane, useAcctPane, output);
        pane.setHgap(20.0);
        Scene scene = new Scene(pane, 500, 300);

        stage.setTitle("Bank Account GUI");
        stage.setScene(scene);
        stage.show();
    }

    public void createNewAccount(ActionEvent event){
        String name = nameField.getText();
        String pin = createPin.getText();

        if (!name.isEmpty() && !pin.isEmpty()){
            accts.add(new BankAccount(name, pin));
            output.setText("New Account Created:\n");
        }
        else
            output.setText("Please complete all fields to create an account.");

        nameField.clear();
        createPin.clear();
    }

    public void makeDeposit(ActionEvent event){
        String amt = amount.getText();
        String pin = enterPin.getText();

        if (!amt.isEmpty() && !pin.isEmpty()){
            double dAmt = Double.parseDouble(amt);
            output.setText(accts.get(getAcctIndex(pin)).deposit(pin, dAmt));
        }
        else
            output.setText("Please complete all fields to make a deposit.");

        enterPin.clear();
        amount.clear();
    }

    public void makeWithdrawl(ActionEvent event){
        String amt = amount.getText();
        String pin = enterPin.getText();

        if (!amt.isEmpty() && !pin.isEmpty()){
            double dAmt = Double.parseDouble(amt);
            output.setText(accts.get(getAcctIndex(pin)).withdraw(pin, dAmt));;
        }
        else
            output.setText("Please complete all fields to make a withdrawl.");

        enterPin.clear();
        amount.clear();
    }

    public void processInterest(ActionEvent event){
        String pin = enterPin.getText();
        accts.get(getAcctIndex(pin)).addInterst();
    }

    public void viewAcct(ActionEvent event){
        String pin = enterPin.getText();

        if (!pin.isEmpty() && pin.equals(accts.get(getAcctIndex(pin)).getPin())){
            output.setText(accts.get(getAcctIndex(pin)).toString());;
        }
        else
            output.setText("Please complete enter the correct PIN to view the account.");

        enterPin.clear();
    }

    private int getAcctIndex(String pin){
        int index = 0;
        for(BankAccount acct : accts){
            if(pin.equals(acct.getPin())){
                return index;
            }
            else
                index++;
        }
        return -1;
    }
}
