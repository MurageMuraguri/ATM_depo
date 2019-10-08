package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicBoolean;

public class Commit {
    public static boolean display(String acc,String amt) {
        AtomicBoolean commit= new AtomicBoolean(true);
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("You sure G?");
        window.setMinWidth(250);
        window.setMinHeight(200);

        Label label = new Label();
        label.setText("Do you want to deposit ksh "+amt+" into account "+acc+" ?");

        Button yesButton = new Button("Yes");
        yesButton.setOnAction(e ->{
            commit.set(true);
            window.close();
        });

        Button noButton = new Button("No");
        noButton.setOnAction(e -> {
            commit.set(false);
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, yesButton,noButton);
        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return commit.get();
    }

}
