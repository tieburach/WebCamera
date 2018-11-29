package sample.LightModel.Model;

import javax.swing.*;
import java.awt.*;

public class Paint extends JPanel {

    private Light light;

    public Paint(Light light) {
        this.light = light;
    }

    @Override
    protected void paintComponent(Graphics g) {

        light.setLights();
        long time1 = System.currentTimeMillis();
        for (int y = 0; y < light.height; y++) {
            for (int x = 0; x < light.width; x++) {
                if (light.colors[y][x] != null) {
                    g.setColor(light.colors[y][x]);
                    g.drawLine(x, y, x, y);
                } else {
                    g.setColor(Color.white);
                    g.drawLine(x, y, x, y);
                }
            }
        }
        System.out.println("PaintComponent trwa: " + (System.currentTimeMillis() - time1));
    }
}
