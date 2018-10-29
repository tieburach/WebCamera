package sample.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Model.Logic.LaunchType;

import java.io.IOException;

public class ControllerStartWindow {
    public void firstProjectAction() {
        LaunchType.setFirstProject(true);
        startWindow();
    }

    public void secondProjectAction() {
        LaunchType.setFirstProject(false);
        startWindow();
    }

    private void startWindow(){
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../View/MainWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("WebCameraApp");
        assert root != null;
        stage.setScene(new Scene(root, 560, 610));
        stage.show();
    }
}
