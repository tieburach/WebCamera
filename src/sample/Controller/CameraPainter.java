package sample.Controller;

import sample.Model.Logic.LaunchType;
import sample.Model.TwoDimensions.Line2D;
import sample.Model.TwoDimensions.Wall2D;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CameraPainter extends JPanel{
    private int width;
    private int height;
    private WebCamera webCamera;

    CameraPainter() throws IOException{
        width = 560;
        height = 450;
        webCamera = new WebCamera(this);
    }

    WebCamera getCamera(){
        return webCamera;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        for (Wall2D wall: webCamera.getWalls()){
            if (LaunchType.isFirstProject()){
                g2D.setColor(Color.gray);

            } else {
                g2D.setColor(Color.pink);
                g2D.fillPolygon(wall.getWallXCoordinates(), wall.getWallYCoordinates(), 4);
                g2D.setColor(Color.black);
            }
        for (Line2D line : wall.getLines()){
            if(!line.isInside())
                g2D.drawLine(line.getFirstPoint().getX(), line.getFirstPoint().getY(), line.getSecondPoint().getX(), line.getSecondPoint().getY());
        }
    }
}
}
