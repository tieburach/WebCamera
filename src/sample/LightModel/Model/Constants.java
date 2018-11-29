package sample.LightModel.Model;

class Constants {

    private static Sphere SPHERE = new Sphere(0, 0, 3, 2);
    private static final int HEIGHT = 400;
    private static final int WIDTH = 400;
    private static Vector OBSERVERPOSITION = new Vector(0, 0, 0);
    private static Vector LIGHTPOSITIONSTART = new Vector(-5,5,-5);


    static Vector getLightPositionAtStart() {
        return LIGHTPOSITIONSTART;
    }

    static Sphere getSphere() {
        return SPHERE;
    }

    static int getHeight() {
        return HEIGHT;
    }

    static int getWidth() {
        return WIDTH;
    }

    static Vector getObserverPosition() {
        return OBSERVERPOSITION;
    }

}
