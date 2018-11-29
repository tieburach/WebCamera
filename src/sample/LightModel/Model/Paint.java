package sample.LightModel.Model;

import sample.LightModel.Controller.Logger;

import javax.swing.*;
import java.awt.*;

public class Paint extends JPanel {

    private Light light;

    public Paint(Light light) {
        this.light = light;
    }

    @Override
    protected void paintComponent(Graphics g) {
        light.calculateNewColors();
        long time1 = System.currentTimeMillis();
        for (int y = 0; y < Constants.getHeight(); y++) {
            for (int x = 0; x < Constants.getWidth(); x++) {
                if (light.colorTab[y][x] != null) {
                    g.setColor(light.colorTab[y][x]);
                    g.drawLine(x, y, x, y);
                } else {
                    g.setColor(Color.white);
                    g.drawLine(x, y, x, y);
                }
            }
        }
        Logger.log("PaintComponent trwa: " + (System.currentTimeMillis() - time1));
    }
}
