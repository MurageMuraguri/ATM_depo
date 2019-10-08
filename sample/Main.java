package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import static javafx.fxml.FXMLLoader.*;

public class Main extends Application implements Hello{

   // public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = load(getClass().getResource("withdraw.fxml"));

        primaryStage.setTitle("WAMLAMBEZZ BANK DEPOSIT SYSTEM");
        primaryStage.setScene(new Scene(root, 600, 400));

        primaryStage.show();
    }

     public void animation(){
        launch();
     }


}
