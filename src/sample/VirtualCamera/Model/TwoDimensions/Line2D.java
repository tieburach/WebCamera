package sample.VirtualCamera.Model.TwoDimensions;

public class Line2D {
    private Point2D firstPoint, secondPoint;
    private boolean inside;

    public Line2D (Point2D a, Point2D b, boolean inner){
        this.firstPoint = a;
        this.secondPoint = b;
        this.inside = inner;
    }

    public Point2D getFirstPoint(){
        return firstPoint;
    }

    public Point2D getSecondPoint(){
        return secondPoint;
    }

    public boolean isInside(){
        return inside;
    }
}
