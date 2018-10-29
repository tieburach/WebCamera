package sample.Model.TwoDimensions;

import java.util.ArrayList;
import java.util.List;

public class Wall2D {
    private Point2D a, b, c, d;
    private List<Line2D> lines = new ArrayList<>();

    public Wall2D (Line2D ab, Line2D bc, Line2D cd, Line2D da){
        lines.add(ab);
        lines.add(bc);
        lines.add(cd);
        lines.add(da);
        this.a = ab.getFirstPoint();
        this.b = bc.getFirstPoint();
        this.c = cd.getFirstPoint();
        this.d = da.getFirstPoint();
    }

    public int[] getWallXCoordinates(){
        return new int[]{a.getX(),b.getX(),c.getX(),d.getX()};
    }

    public int[] getWallYCoordinates(){
        return new int[]{a.getY(),b.getY(),c.getY(),d.getY()};
    }

    public ArrayList<Line2D> getLines(){
        return (ArrayList<Line2D>) lines;
    }
}
