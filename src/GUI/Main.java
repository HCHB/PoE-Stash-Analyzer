package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Settings/sample.fxml"));
        primaryStage.setTitle("PoE Stash Analyzer");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    static void main(String[] args) {
        launch(args);
    }
}
