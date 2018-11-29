package sample.VirtualCamera.Controller;

import sample.VirtualCamera.Model.Logic.LaunchType;
import sample.VirtualCamera.Model.TwoDimensions.Line2D;
import sample.VirtualCamera.Model.TwoDimensions.Wall2D;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CameraPainter extends JPanel {
    private int width;
    private int height;
    private VirtualCamera virtualCamera;

    CameraPainter() throws IOException {
        width = 560;
        height = 450;
        virtualCamera = new VirtualCamera(this);
    }

    VirtualCamera getCamera() {
        return virtualCamera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        for (Wall2D wall : virtualCamera.getWalls()) {
            if (LaunchType.isFirstProject()) {
                g2D.setColor(Color.gray);
            } else {
                g2D.setColor(Color.pink);
                g2D.fillPolygon(wall.getWallXCoordinates(), wall.getWallYCoordinates(), 4);
                g2D.setColor(Color.black);
            }
            for (Line2D line : wall.getLines()) {
                if (!line.isInside())
                    g2D.drawLine(line.getFirstPoint().getX(), line.getFirstPoint().getY(), line.getSecondPoint().getX(), line.getSecondPoint().getY());
            }
        }
    }
}
