package sample.Model.Logic;

import sample.Controller.VirtualCamera;
import sample.Model.ThreeDimensions.Point3D;
import sample.Model.ThreeDimensions.Wall3D;

public class Movement {
    private Buildings scene;
    private VirtualCamera camera;
    private int focalLength;
    private static final int STEP = 50;
    private static final int ZOOM = 5;
    private static final double DEGREE = Math.PI * 10 / 180;

    public Movement(VirtualCamera camera, Buildings scene, int d) {
        this.camera = camera;
        this.scene = scene;
        this.focalLength = d;
    }

    public void moveUpstairs() {
        for (Wall3D wall : scene.getWalls()) {
            for (Point3D point3D : wall.getPoints()) {
                point3D.setZ(point3D.getZ() - STEP);
            }
        }
        camera.refresh();
    }

    public void moveDownstairs() {
        for (Wall3D wall : scene.getWalls()) {
            for (Point3D point3D : wall.getPoints()) {
                point3D.setZ(point3D.getZ() + STEP);
            }
        }
        camera.refresh();
    }

    public void moveLeft() {
        for (Wall3D wall : scene.getWalls()) {
            for (Point3D point3D : wall.getPoints()) {
                point3D.setX(point3D.getX() + STEP);
            }
        }
        camera.refresh();
    }

    public void moveRight() {
        for (Wall3D wall : scene.getWalls()) {
            for (Point3D point3D : wall.getPoints()) {
                point3D.setX(point3D.getX() - STEP);
            }
        }
        camera.refresh();
    }

    public void moveForward() {
        for (Wall3D wall : scene.getWalls()) {
            for (Point3D point3D : wall.getPoints()) {
                point3D.setY(point3D.getY() - STEP);
            }
        }
        camera.refresh();
    }

    public void moveBackward() {
        for (Wall3D wall : scene.getWalls()) {
            for (Point3D point3D : wall.getPoints()) {
                point3D.setY(point3D.getY() + STEP);
            }
        }
        camera.refresh();
    }

    public void rotateUp() {
        for (Wall3D wall : scene.getWalls()) {
            for (Point3D point3D : wall.getPoints()) {
                point3D.setY(point3D.getY() * cosinus(-DEGREE) - point3D.getZ() * sinus(-DEGREE));
                point3D.setZ(point3D.getY() * sinus(-DEGREE) + point3D.getZ() * cosinus(-DEGREE));
            }
        }
        camera.refresh();
    }

    public void rotateDown() {
        for (Wall3D wall : scene.getWalls()) {
            for (Point3D point3D : wall.getPoints()) {
                point3D.setY(point3D.getY() * cosinus(DEGREE) - point3D.getZ() * sinus(DEGREE));
                point3D.setZ(point3D.getY() * sinus(DEGREE) + point3D.getZ() * cosinus(DEGREE));
            }
        }
        camera.refresh();
    }

    public void rotateLeft() {
        for (Wall3D wall : scene.getWalls()) {
            for (Point3D point3D : wall.getPoints()) {
                point3D.setX(point3D.getX() * cosinus(-DEGREE) - point3D.getY() * sinus(-DEGREE));
                point3D.setY(point3D.getX() * sinus(-DEGREE) + point3D.getY() * cosinus(-DEGREE));
            }
        }
        camera.refresh();
    }

    public void rotateRight() {
        for (Wall3D wall : scene.getWalls()) {
            for (Point3D point3D : wall.getPoints()) {
                point3D.setX(point3D.getX() * cosinus(DEGREE) - point3D.getY() * sinus(DEGREE));
                point3D.setY(point3D.getX() * sinus(DEGREE) + point3D.getY() * cosinus(DEGREE));
            }
        }
        camera.refresh();
    }

    public void tiltLeft() {
        for (Wall3D wall : scene.getWalls()) {
            for (Point3D point3D : wall.getPoints()) {
                point3D.setX(point3D.getX() * cosinus(-DEGREE) + point3D.getZ() * sinus(-DEGREE));
                point3D.setZ(-point3D.getX() * sinus(-DEGREE) + point3D.getZ() * cosinus(-DEGREE));
            }
        }
        camera.refresh();
    }

    public void tiltRight() {
        for (Wall3D wall : scene.getWalls()) {
            for (Point3D point3D : wall.getPoints()) {
                point3D.setX(point3D.getX() * cosinus(DEGREE) + point3D.getZ() * sinus(DEGREE));
                point3D.setZ(-point3D.getX() * sinus(DEGREE) + point3D.getZ() * cosinus(DEGREE));
            }
        }
        camera.refresh();
    }

    public void zoomIn() {
        camera.setFocalLength(focalLength += ZOOM);
        camera.refresh();
    }

    public void zoomOut() {
        camera.setFocalLength(focalLength -= ZOOM);
        camera.refresh();
    }

    private static double cosinus(double a) {
        return Math.cos(a);
    }

    private static double sinus(double a) {
        return Math.sin(a);
    }

}

