package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.LightModel.Controller.Logger;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View/StartWindow.fxml"));
        primaryStage.setTitle("VirtualCameraApp");
        primaryStage.setScene(new Scene(root, 450, 400));
        primaryStage.show();
        primaryStage.setOnCloseRequest(t -> {
            Logger.onExit();
            Platform.exit();
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
