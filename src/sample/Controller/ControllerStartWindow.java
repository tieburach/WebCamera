package sample.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.VirtualCamera.Model.Logic.LaunchType;

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
            root = FXMLLoader.load(getClass().getResource("../VirtualCamera/View/MainWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("VirtualCameraApp");
        assert root != null;
        stage.setScene(new Scene(root, 560, 610));
        stage.show();
    }

    public void thirdProjectAction() {
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../LightModel/View/LightView.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("VirtualCameraApp");
        assert root != null;
        stage.setScene(new Scene(root, 600 , 700));
        stage.show();
    }
}
