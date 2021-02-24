package GUI.Settings;

import GUI.GUIFacade;
import GUI.IOutFacade;
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
    private Button startButton;

    private IOutFacade facade;

    @FXML
    public void start_action(ActionEvent actionEvent) {
        System.out.println("work, work, work");
        String response = this.facade.getAnalysis();
        this.resultLabelID.setText(response);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.facade = GUIFacade.getInstance();

        System.out.println("this is controller");
    }

}
