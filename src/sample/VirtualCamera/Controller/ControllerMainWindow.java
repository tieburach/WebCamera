package sample.VirtualCamera.Controller;

import javafx.embed.swing.SwingNode;
import javafx.scene.layout.StackPane;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ControllerMainWindow {

    public StackPane mainPane;
    private VirtualCamera camera;

    public void initialize() throws IOException {
        SwingNode swingNode = new SwingNode();
        CameraPainter cameraPainter = new CameraPainter();
        cameraPainter.setBackground(Color.white);
        cameraPainter.setSize(600, 500);
        swingNode.setContent(cameraPainter);
        createAndSetSwingContent(swingNode, cameraPainter);
        mainPane.getChildren().add(swingNode);
        camera = cameraPainter.getCamera();
    }

    private void createAndSetSwingContent(final SwingNode swingNode, JPanel panel) {
        SwingUtilities.invokeLater(() -> swingNode.setContent(panel));
    }

    public void moveLeftAction() {
        camera.setMovement().moveLeft();
    }

    public void moveRightAction() {
        camera.setMovement().moveRight();
    }

    public void moveForwardAction() {
        camera.setMovement().moveForward();
    }

    public void moveBackwardAction() {
        camera.setMovement().moveBackward();
    }

    public void moveUpstairsAction() {
        camera.setMovement().moveUpstairs();
    }

    public void moveDownstairsClicked() {
        camera.setMovement().moveDownstairs();
    }

    public void rotateLeftAction() {
        camera.setMovement().rotateLeft();
    }

    public void rotateRightAction() {
        camera.setMovement().rotateRight();
    }

    public void rotateUpAction() {
        camera.setMovement().rotateUp();
    }

    public void rotateDownAction() {
        camera.setMovement().rotateDown();
    }

    public void tiltLeftAction() {
        camera.setMovement().tiltLeft();
    }

    public void tiltRightAction() {
        camera.setMovement().tiltRight();
    }

    public void zoomInAction() {
        camera.setMovement().zoomIn();
    }

    public void zoomOutAction() {
        camera.setMovement().zoomOut();
    }
}
