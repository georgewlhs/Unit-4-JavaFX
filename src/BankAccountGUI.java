import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BankAccountGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private TextField nameField;
    private TextField createPin;
    private TextArea output;
    private TextField amount;
    private TextField enterPin;
    private BankAccount acct;

    @Override
    public void start(Stage stage) {

        Label nameLabel = new Label("Name:");
        nameField = new TextField();

        Label createPinLabel = new Label("PIN:");
        createPin = new TextField();

        output = new TextArea();

        Label amountLabel = new Label("Amount:");
        amount = new TextField();

        Label enterPinLabel = new Label("PIN:");
        enterPin = new TextField();

        Button createButton = new Button("Create Account");
        createButton.setOnAction(this::createNewAccount);

        Button depositButton = new Button("Deposit");
        depositButton.setOnAction(this::makeDeposit);

        Button withdrawButton = new Button("Withdraw");
        withdrawButton.setOnAction(this::makeWithdrawl);

        GridPane createAcctPane = new GridPane();
        createAcctPane.setPrefSize(300,300);
        createAcctPane.add(createButton,2,1, 1, 1);
        createAcctPane.add(nameLabel, 0, 0);
        createAcctPane.add(nameField,0,1);
        createAcctPane.add(createPinLabel, 1, 0);
        createAcctPane.add(createPin, 1, 1);
        createAcctPane.add(output,0,2,3,3);

        GridPane useAcctPane = new GridPane();
        useAcctPane.add(enterPinLabel,0,0);
        useAcctPane.add(enterPin, 1,0);
        useAcctPane.add(amountLabel,0,1);
        useAcctPane.add(amount,1,1);
        useAcctPane.add(depositButton, 0,2);
        useAcctPane.add(withdrawButton, 1,2);

        FlowPane pane = new FlowPane(createAcctPane, useAcctPane);

        Scene scene = new Scene(pane, 600, 300);

        stage.setTitle("Bank Account GUI");
        stage.setScene(scene);
        stage.show();
    }

    public void createNewAccount(ActionEvent event){
        String name = nameField.getText();
        String pin = createPin.getText();

        if (!name.isEmpty() && !pin.isEmpty()){
            acct = new BankAccount(name, pin);
            output.setText("New Account Created:\n" +acct.toString());
        }
    }

    public void makeDeposit(ActionEvent event){
        String amt = amount.getText();

        if (!amt.isEmpty()){
            double dAmt = Double.parseDouble(amt);
            //acct.deposit(dAmt);
        }
    }

    public void makeWithdrawl(ActionEvent event){

    }
}
