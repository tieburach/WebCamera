package sample.LightModel.Model;

import java.awt.*;

public class Light {
    private PhongModel phongModel;
    int height = 400;
    int width = 400;
    private Vector observer = new Vector(0, 0, 0);
    private Vector lightSource;
    private Sphere sphere = new Sphere(0, 0, 3, 2);
    private Double maxI = null;
    private Double[][] buffer = new Double[height][width];
    Color[][] colors = new Color[height][width];

    public Light() {
        phongModel = new PhongModel();
        lightSource = new Vector(-3, 3, -7);
    }

    public Light(double ia, double Ka, double ii, double Kd, double Ks, double N, double C ) {
        phongModel = new PhongModel(ia, Ka, ii, Kd, Ks, N, C);
        lightSource = new Vector(-3, 3, -7);
    }

    public void changeCoordinatesOfLight(Vector vector){
        this.lightSource = vector;
    }


    private Vector[][] createGrid() {
        Vector left = new Vector(1, 1, 1);
        Vector right = new Vector(-1, -1, 1);
        Double dx = (right.x - left.x) / width;
        Double dy = (right.y - left.y) / height;
        Vector[][] grid = new Vector[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[y][x] = new Vector(left.x + x * dx, left.y + y * dy, left.z);
            }
        }
        return grid;
    }

    void setLights() {
        long time1 = System.currentTimeMillis();
        Vector[][] grid = createGrid();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Vector p = grid[y][x];
                Vector crossPoint = sphere.getCrossPoint(observer, p);
                Double I = phongModel.spherePointLighting(lightSource, observer, sphere.getVector(), crossPoint);
                if (I != null) {
                    if (maxI == null) {
                        maxI = I;
                    } else if (I > maxI) {
                        maxI = I;
                    }
                }
                buffer[height - y - 1][x] = I;
            }
        }
        long time2 = System.currentTimeMillis();
        System.out.println("Setlights 1szy trwa: " + (time2 - time1));
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (buffer[y][x] != null) {
                    Double intensityCorrection = 0.01;
                    float f = (float) ((buffer[y][x]) / (maxI + intensityCorrection));
                    float red = (float) ((f * 0.8));
                    float green = (float) (f * 0.4);
                    float blue = (float) (f * 0.3);
                    Color color = new Color(red, green, blue);
                    colors[y][x] = color;
                }
            }
        }
        System.out.println("Setlights 2gi trwa: " + (System.currentTimeMillis() - time2));
    }
    public PhongModel getPhongModel() {
        return phongModel;
    }
}
