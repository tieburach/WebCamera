package sample.Model.Logic;

import sample.Model.ThreeDimensions.Point3D;
import sample.Model.ThreeDimensions.Wall3D;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Buildings {
    private List<Wall3D> walls;

    public Buildings() throws IOException {
        walls = loadBuildings();
    }

    private ArrayList<Wall3D> loadBuildings() throws IOException{
        List<Wall3D> walls = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("src/sample/resources/walls.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.length() == 0 || line.charAt(0)=='*')
                continue;
            String[] coordinates = line.split(" ");
            Point3D a = new Point3D(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]), Integer.parseInt(coordinates[2]));
            Point3D b = new Point3D(Integer.parseInt(coordinates[3]), Integer.parseInt(coordinates[4]), Integer.parseInt(coordinates[5]));
            Point3D c = new Point3D(Integer.parseInt(coordinates[6]), Integer.parseInt(coordinates[7]), Integer.parseInt(coordinates[8]));
            Point3D d = new Point3D(Integer.parseInt(coordinates[9]), Integer.parseInt(coordinates[10]), Integer.parseInt(coordinates[11]));
            walls.add(new Wall3D(a, b, c, d));
        }
        br.close();
        return (ArrayList<Wall3D>) walls;
    }

    public ArrayList<Wall3D> getWalls(){
        return (ArrayList<Wall3D>) walls;
    }

    public void divideWalls(int n) {
        for (int i=0; i<n; i++)
            walls = walls.stream().flatMap(wall -> wall.divide().stream()).collect(Collectors.toList());
    }
}
