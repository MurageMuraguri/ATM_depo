package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * <h1>Commit class</h1>
 * This class holds the interface to prompt the user to either commit or rollback changes to the database.
 *
 *
 */

public class Commit {
    public static boolean display(String acc,String amt) {
        /**
         * Method display
         *
         *This method pops up an interface to confirm the users decision on the transaction.Returns a boolean value to verify rollback or commit.
         * @param String acc,account number.
         * @param String amt,cash amount of transaction.
         *
         *
         */
        AtomicBoolean commit= new AtomicBoolean(true);
        Stage window = new Stage();

        window.setOnCloseRequest(e->{
            commit.set(false);
        });
        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("You sure G?");
        window.setMinWidth(300);
        window.setMinHeight(250);

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
