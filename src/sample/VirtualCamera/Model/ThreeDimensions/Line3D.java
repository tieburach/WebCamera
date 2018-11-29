package sample.VirtualCamera.Model.ThreeDimensions;

public class Line3D {
    private Point3D firstPoint;
    private Point3D secondPoint;
    private boolean inside;

    Line3D(Point3D a, Point3D b, boolean inner){
        this.firstPoint = a;
        this.secondPoint = b;
        this.inside = inner;
    }

    public Point3D getFirstPoint(){
        return firstPoint;
    }

    public Point3D getSecondPoint(){
        return secondPoint;
    }

    public boolean isInside(){
        return inside;
    }
}

