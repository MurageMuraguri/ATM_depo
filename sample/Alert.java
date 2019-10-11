package sample;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class Alert {
  /**<h1>Class Alert</h1>
    * This class handles all alert pop up windows for user inclusion and interaction.
    *@author Mulei Muraguri Mwala
    * @version 4.20
    * @param title is the title of the alert box.
    * @param message is the message to be displayed in case of an error.
    */

  public static void display(String title, String message) {
      Stage window = new Stage();

      //Block events to other windows
      window.initModality(Modality.APPLICATION_MODAL);
      window.setTitle(title);
      window.setMinWidth(300);
      window.setMinHeight(250);



      Label label = new Label();
      label.setText(message);
      //label.setFont("TimesRoman",  20);
      label.setStyle("-fx-font-weight: bold" );

      Button closeButton = new Button("OK");
    closeButton.setMinHeight(50);
    closeButton.setMinWidth(80);

      closeButton.setStyle("-fx-background-color: #d0d2ff; -fx-background-radius: 10");
      closeButton.setOnAction(e -> window.close());

      VBox layout = new VBox(10);
      layout.getChildren().addAll(label, closeButton);
      layout.setAlignment(Pos.CENTER);
      layout.setStyle("-fx-background-color: #fffdd0");

      //Display window and wait for it to be closed before returning
      Scene scene = new Scene(layout);
      window.setScene(scene);
      window.showAndWait();
  }

}
