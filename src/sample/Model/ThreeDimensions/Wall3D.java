package sample.Model.ThreeDimensions;

import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.abs;

public class Wall3D implements Comparable<Wall3D>{
    private List<Line3D> lines = new ArrayList<>();
    private List<Point3D> points = new ArrayList<>();
    private double ycenter, xcenter, zcenter;

    public Wall3D(Point3D a, Point3D b, Point3D c, Point3D d){
        lines.add(new Line3D(a, b, false));
        lines.add(new Line3D(b, c, false));
        lines.add(new Line3D(c, d, false));
        lines.add(new Line3D(d, a, false));
        points.add(a);
        points.add(b);
        points.add(c);
        points.add(d);
    }

    private Wall3D(Line3D ab, Line3D bc, Line3D cd, Line3D da){
        lines.add(ab);
        lines.add(bc);
        lines.add(cd);
        lines.add(da);
        setPoints();
    }


    public void countCenter(){
        ycenter = (points.get(0).getY()+points.get(1).getY()+points.get(2).getY()+points.get(3).getY())/4;
        xcenter = (points.get(0).getX()+points.get(1).getX()+points.get(2).getX()+points.get(3).getX())/4;
        zcenter = (points.get(0).getZ()+points.get(1).getZ()+points.get(2).getZ()+points.get(3).getZ())/4;
    }

    public ArrayList<Line3D> getLines(){
        return (ArrayList<Line3D>) lines;
    }

    public ArrayList<Point3D> getPoints(){
        return (ArrayList<Point3D>) points;
    }

    private void setPoints(){
        for (int i=0; i<4; i++)
            points.add(lines.get(i).getFirstPoint());
    }

    public List<Wall3D> divide() {
        List<Wall3D> walls = new ArrayList<>();
        double x1 = (points.get(0).getX()+points.get(1).getX())/2;
        double y1 = (points.get(0).getY()+points.get(1).getY())/2;
        double z1 = (points.get(0).getZ()+points.get(1).getZ())/2;
        double x2 = (points.get(2).getX()+points.get(1).getX())/2;
        double y2 = (points.get(2).getY()+points.get(1).getY())/2;
        double z2 = (points.get(2).getZ()+points.get(1).getZ())/2;
        double x3 = (points.get(2).getX()+points.get(3).getX())/2;
        double y3 = (points.get(2).getY()+points.get(3).getY())/2;
        double z3 = (points.get(2).getZ()+points.get(3).getZ())/2;
        double x4 = (points.get(0).getX()+points.get(3).getX())/2;
        double y4 = (points.get(0).getY()+points.get(3).getY())/2;
        double z4 = (points.get(0).getZ()+points.get(3).getZ())/2;
        double x5 = (x1+x3)/2;
        double y5 = (y2+y4)/2;
        double z5 = (z2+z4)/2;

        walls.add(new Wall3D(new Line3D(points.get(0),new Point3D(x1,y1,z1),false),
                new Line3D(new Point3D(x1,y1,z1),new Point3D(x5,y5,z5),true),
                new Line3D(new Point3D(x5,y5,z5),new Point3D(x4,y4,z4),true),
                new Line3D(new Point3D(x4,y4,z4),points.get(0),false)));
        walls.add(new Wall3D(new Line3D(new Point3D(x1,y1,z1),points.get(1),false),
                new Line3D(points.get(1),new Point3D(x2,y2,z2),false),
                new Line3D(new Point3D(x2,y2,z2),new Point3D(x5,y5,z5),true),
                new Line3D(new Point3D(x5,y5,z5),new Point3D(x1,y1,z1),true)));
        walls.add(new Wall3D(new Line3D(new Point3D(x5,y5,z5),new Point3D(x2,y2,z2),true),
                new Line3D(new Point3D(x2,y2,z2),points.get(2),false),
                new Line3D(points.get(2),new Point3D(x3,y3,z3),false),
                new Line3D(new Point3D(x3,y3,z3),new Point3D(x5,y5,z5),true)));
        walls.add(new Wall3D(new Line3D(new Point3D(x4,y4,z4),new Point3D(x5,y5,z5),true),
                new Line3D(new Point3D(x5,y5,z5),new Point3D(x3,y3,z3),true),
                new Line3D(new Point3D(x3,y3,z3),points.get(3),false),
                new Line3D(points.get(3),new Point3D(x4,y4,z4),false)));

        return walls;
    }

    @Override
    public int compareTo(Wall3D o) {
        if (abs(ycenter) < abs(o.ycenter)) {
            return 1;
        } else if (abs(ycenter) > abs(o.ycenter)) {
            return -1;
        } else {
            if (abs(xcenter) < abs(o.xcenter)){
                return 1;
            } else if (abs(xcenter) > abs(o.xcenter)){
                return -1;
            } else {
                return Double.compare(abs(o.zcenter), abs(zcenter));
            }
        }
    }
}