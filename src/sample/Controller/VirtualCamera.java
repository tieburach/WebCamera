package sample.Controller;

import sample.Model.ThreeDimensions.Line3D;
import sample.Model.ThreeDimensions.Point3D;
import sample.Model.ThreeDimensions.Wall3D;
import sample.Model.Logic.Buildings;
import sample.Model.Logic.Movement;
import sample.Model.TwoDimensions.Line2D;
import sample.Model.TwoDimensions.Point2D;
import sample.Model.TwoDimensions.Wall2D;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VirtualCamera {
    private CameraPainter cameraPainter;
    private Buildings buildings;
    private List<Wall2D> walls;
    private int focalLength = 200;
    private Movement movement;

    VirtualCamera(CameraPainter cameraPainter) throws IOException{
        this.cameraPainter = cameraPainter;
        buildings = new Buildings();
        int divideWalls = 1;
        buildings.divideWalls(divideWalls);
        walls = new ArrayList<>();
        movement = new Movement(this, buildings, focalLength);
        refresh();
    }

    public void refresh(){
        walls.clear();
        for (Wall3D wall : buildings.getWalls()){
            wall.countCenter();
        }
        Collections.sort(buildings.getWalls());
        for (Wall3D wall : buildings.getWalls()){
            if (isVisible(wall))
                walls.add(transformWall(wall));
        }
        cameraPainter.repaint();
    }

    Movement setMovement(){
        return movement;
    }

    private Wall2D transformWall(Wall3D wall){
        Point3D firstPoint = wall.getPoints().get(0);
        Point3D secondPoint = wall.getPoints().get(1);
        Point3D thirdPoint = wall.getPoints().get(2);
        Point3D fourthPoint = wall.getPoints().get(3);
        return new Wall2D(new Line2D(transformPoint(firstPoint), transformPoint(secondPoint),wall.getLines().get(0).isInside()),
                new Line2D(transformPoint(secondPoint), transformPoint(thirdPoint),wall.getLines().get(1).isInside()),
                new Line2D(transformPoint(thirdPoint), transformPoint(fourthPoint),wall.getLines().get(2).isInside()),
                new Line2D(transformPoint(fourthPoint), transformPoint(firstPoint),wall.getLines().get(3).isInside()));
    }

    private Point2D transformPoint(Point3D p){
        double k = focalLength /p.getY();
        int x = (int) (k*p.getX()+ cameraPainter.getWidth()/2);
        int y = (int) (cameraPainter.getHeight()/2 - k*p.getZ());
        return new Point2D(x,y);
    }

    public void setFocalLength(int focalLength){
        this.focalLength = focalLength;
    }

    List<Wall2D> getWalls(){
        return walls;
    }

    private boolean isVisible(Wall3D wall){
        boolean check = true;
        for (Line3D line : wall.getLines())
            check = isVisible(line) && check;
        return check;
    }

    private boolean isVisible(Line3D line) {
        return isVisible(line.getFirstPoint()) && isVisible(line.getSecondPoint());
    }

    private boolean isVisible(Point3D p){
        return p.getY() >= focalLength;
    }
}
