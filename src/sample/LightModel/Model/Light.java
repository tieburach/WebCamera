package sample.LightModel.Model;

import sample.LightModel.Controller.Logger;

import java.awt.*;

public class Light {
    private PhongLight phongLight;
    private Vector lightSource;
    private Double[][] intensityTab = new Double[Constants.getHeight()][Constants.getWidth()];
    Color[][] colorTab = new Color[Constants.getHeight()][Constants.getWidth()];

    public Light() {
        phongLight = new PhongLight();
        lightSource = Constants.getLightPositionAtStart();
    }

    public Light(double ia, double Ka, double ii, double Kd, double Ks, double N, double C ) {
        phongLight = new PhongLight(ia, Ka, ii, Kd, Ks, N, C);
        lightSource = Constants.getLightPositionAtStart();
    }

    public void changeCoordinatesOfLight(Vector vector){
        this.lightSource = vector;
    }

    private Vector[][] createGrid() {
        Vector left = new Vector(1, 1, 1);
        Vector right = new Vector(-1, -1, 1);
        Double dx = (right.getX() - left.getX()) / Constants.getWidth();
        Double dy = (right.getY() - left.getY()) / Constants.getHeight();
        Vector[][] grid = new Vector[Constants.getHeight()][Constants.getWidth()];

        for (int y = 0; y < Constants.getHeight(); y++) {
            for (int x = 0; x < Constants.getWidth(); x++) {
                grid[y][x] = new Vector(left.getX() + x * dx, left.getX() + y * dy, left.getZ());
            }
        }
        return grid;
    }

    void calculateNewColors() {
        Double maxI = null;
        long time1 = System.currentTimeMillis();
        Vector[][] grid = createGrid();
        for (int y = 0; y < Constants.getHeight(); y++) {
            for (int x = 0; x < Constants.getWidth(); x++) {
                Vector p = grid[y][x];
                Vector crossPoint = Constants.getSphere().getCrossPoint(Constants.getObserverPosition(), p);
                Double I = phongLight.spherePointLighting(lightSource, Constants.getObserverPosition(), Constants.getSphere().getVector(), crossPoint);
                if (I != null) {
                    if (maxI == null) {
                        maxI = I;
                    } else if (I > maxI) {
                        maxI = I;
                    }
                }
                intensityTab[Constants.getHeight() - y - 1][x] = I;
            }
        }
        long time2 = System.currentTimeMillis();
        Logger.log("1szy trwa: " + (time2 - time1));
        for (int y = 0; y < Constants.getHeight(); y++) {
            for (int x = 0; x < Constants.getWidth(); x++) {
                if (intensityTab[y][x] != null) {
                    float f = (float) ((intensityTab[y][x]) / (maxI));
                    float red = (float) ((f * 0.8));
                    float green = (float) (f * 0.4);
                    float blue = (float) (f * 0.3);
                    colorTab[y][x] = new Color(red, green, blue);
                }
            }
        }
       Logger.log("2gi trwa: " + (System.currentTimeMillis() - time2));
    }
    public PhongLight getPhongLight() {
        return phongLight;
    }
}
