import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BankAccountGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private TextField nameField;
    private TextField pinField;
    private TextArea output;
    private TextField deposit;
    private TextField withdraw;
    private BankAccount acct;

    @Override
    public void start(Stage stage) {

        Label nameLabel = new Label("Name:");
        nameField = new TextField();

        Label pinLabel = new Label("PIN:");
        pinField = new TextField();

        output = new TextArea();

        Label depositLabel = new Label("Deposit Amount");
        deposit = new TextField();

        Button createButton = new Button("Create Account");
        createButton.setOnAction(this::createNewAccount);

        Button depositButton = new Button("Make Deposit");
        depositButton.setOnAction(this::makeDeposit);


        GridPane mainPane = new GridPane();
        mainPane.setPrefSize(300,300);
        mainPane.add(createButton,2,1, 1, 1);
        mainPane.add(nameLabel, 0, 0);
        mainPane.add(nameField,0,1);
        mainPane.add(pinLabel, 1, 0);
        mainPane.add(pinField, 1, 1);
        mainPane.add(output,0,2,3,3);

        Scene scene = new Scene(mainPane, 500, 300);

        stage.setTitle("Bank Account GUI");
        stage.setScene(scene);
        stage.show();
    }

    public void createNewAccount(ActionEvent event){
        String name = nameField.getText();
        String pin = pinField.getText();

        if (!name.isEmpty() && !pin.isEmpty()){
            acct = new BankAccount(name, pin);
            output.setText(acct.toString());
        }
    }

    public void makeDeposit(ActionEvent event){
        String amt = deposit.getText();

        if (!amt.isEmpty()){
            double dAmt = Double.parseDouble(amt);
            acct.deposit();
        }
    }
}
