
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DIceDisplay extends Application {
    public void start(Stage stage) {
        Image d1 = new Image("images/Dice1.jpg");
        ImageView d1View = new ImageView(d1);
        Image d2 = new Image("images/Dice2.jpg");
        ImageView d2View = new ImageView(d2);

        GridPane pane = new GridPane();
        pane.setHgap(20);
        pane.setVgap(20);
        pane.add(d1View, 0,0);
        pane.add(d2View, 1, 1);

        Scene scene = new Scene(pane, 500, 500, Color.GRAY);

        stage.setTitle("Some Dice");
        stage.setScene(scene);
        stage.show();
    }
}
