package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;


public class SampleController implements Initializable {

    @FXML
    private Label resultLabelID;

    @FXML
    private Button start_button;

    @FXML
    public void start_action(ActionEvent actionEvent) {
        System.out.println("work, work, work");

        this.resultLabelID.setText("Look at these incredible results");
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


}
