package sample.LightModel.Controller;

import javafx.embed.swing.SwingNode;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import sample.LightModel.Model.Light;
import sample.LightModel.Model.Paint;
import sample.LightModel.Model.Vector;

import javax.swing.*;
import java.awt.*;

public class LightController {
    public StackPane figureScene;
    public TextField IAmbientTextField, IhittingTextField, shinenessTextField;
    public TextField kappaATextField, kappaDTextField, kappaSTextField;
    public RadioButton matowaRadioButton, mieszanaRadioButton, blyszczacaRadioButton;
    public Spinner xSpinner, ySpinner, zSpinner;
    private Light currentLight;
    private Paint currentPaint;


    public void initialize() {
        SwingNode swingNode = new SwingNode();
        currentLight = new Light();
        currentPaint = new Paint(currentLight);
        currentPaint.setBackground(Color.WHITE);
        currentPaint.setSize(400, 400);
        swingNode.setContent(currentPaint);
        createAndSetSwingContent(swingNode, currentPaint);
        figureScene.getChildren().add(swingNode);
        final ToggleGroup group = new ToggleGroup();
        matowaRadioButton.setToggleGroup(group);
        mieszanaRadioButton.setToggleGroup(group);
        blyszczacaRadioButton.setToggleGroup(group);
        mieszanaRadioButton.setSelected(true);
        initializeTextFields();
    }

    private void createAndSetSwingContent(final SwingNode swingNode, JPanel panel) {
        SwingUtilities.invokeLater(() -> swingNode.setContent(panel));
    }

    public void loadMatowaSphere() {

        currentLight = new Light(100, 0.4, 1000, 0.7, 0.2, 10, 2);
        currentPaint = new Paint(currentLight);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        initializeDrawing(currentPaint);
        initializeTextFields();
    }

    public void loadMieszanaSphere() {
        currentLight = new Light(100, 0.4, 1000, 0.5, 0.5, 100, 2);
        currentPaint = new Paint(currentLight);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        initializeDrawing(currentPaint);
        initializeTextFields();
    }

    public void loadBlyszczacaSphere() {
        currentLight = new Light(100, 0.4, 1000, 0.75, 2, 100, 2);
        currentPaint = new Paint(currentLight);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        initializeDrawing(currentPaint);
        initializeTextFields();
    }

    public void changeCoordinates() {
        currentLight.changeCoordinatesOfLight(new Vector((double) xSpinner.getValue(), (double) ySpinner.getValue(), (double) zSpinner.getValue()));
        currentPaint = new Paint(currentLight);
        initializeDrawing(currentPaint);
    }


    private void initializeDrawing(Paint paint) {
        SwingNode swingNode = new SwingNode();
        paint.setBackground(Color.WHITE);
        paint.setSize(600, 500);
        swingNode.setContent(paint);
        createAndSetSwingContent(swingNode, paint);
        figureScene.getChildren().add(swingNode);
    }

    public void reloadByParameters() {
        try {
            currentLight.getPhongModel().setIa(Double.parseDouble(IAmbientTextField.getText()));
            currentLight.getPhongModel().setIi(Double.parseDouble(IhittingTextField.getText()));
            currentLight.getPhongModel().setN(Double.parseDouble(shinenessTextField.getText()));
            currentLight.getPhongModel().setKa(Double.parseDouble(kappaATextField.getText()));
            currentLight.getPhongModel().setKd(Double.parseDouble(kappaDTextField.getText()));
            currentLight.getPhongModel().setKs(Double.parseDouble(kappaSTextField.getText()));
            currentPaint = new Paint(currentLight);
            initializeDrawing(currentPaint);
        }catch (Exception ignored){}
    }

    private void initializeTextFields() {
        IAmbientTextField.setText("" + currentLight.getPhongModel().getIa());
        IhittingTextField.setText("" + currentLight.getPhongModel().getIi());
        shinenessTextField.setText("" + currentLight.getPhongModel().getN());
        kappaATextField.setText("" + currentLight.getPhongModel().getKa());
        kappaDTextField.setText("" + currentLight.getPhongModel().getKd());
        kappaSTextField.setText("" + currentLight.getPhongModel().getKs());
    }


}
