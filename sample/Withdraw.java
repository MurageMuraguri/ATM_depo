package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Withdraw {
  /**
    * <h1>Class Withdraw</h1>
    @author Mulei Muraguri Mwala
    * @version 4.20
    * This is the controller class for the main interface.
    */
    public Text heading1;
    public Text heading2;
    public Button CANCEL;
    // We get buttons from the GUI in variables
    @FXML
    private Button DEPOSIT;
       @FXML
    private TextField resultArea; //This is text field where whatever user types in appears
    @FXML
    private TextField resultArea1;


// force the field to be numeric only

    public void handleButtonAction( ActionEvent event) {
      /**
 *
 * <h2>Method handleButtonAction</h2>
 *Handles events.
 *
 */


        if(event.getSource() == DEPOSIT) //This condition is triggered when enter button is pressed
        {
            String entered = resultArea.getText(); //Entered amount is obtained
            String accountnumber=resultArea1.getText();
            assert accountnumber != null;
            assert entered != null;
            if(entered.equals("") | entered.matches("[a-z]*") | accountnumber.equals("") | accountnumber.matches("[a-z]*"))
            {
                String title="ERROR";
                String message="Enter Valid data types";

                Alert a1 =new Alert();
                a1.display(title,message);

            }
            else{
                    DBinteract db1= new DBinteract();
                    db1.update(accountnumber,entered);
            }
            resultArea.clear();
            resultArea1.clear();
    }else if(event.getSource()== CANCEL) {

            Stage stage = (Stage) CANCEL.getScene().getWindow();

            stage.close();
        }

    }

    }
