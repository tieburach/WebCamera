package sample.LightModel.Model;

class Sphere {

    private double x, y, z, r;

    Sphere(double x, double y, double z, double r) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.r = r;
    }

    Vector getVector(){
        return new Vector(this.x, this.y, this.z);
    }

    //przeciecie sfery z prosta od kamery
    Vector getCrossPoint(Vector start, Vector end) {
        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();
        double dz = end.getZ() - start.getZ();

        double a = Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2);
        double b = 2 * (dx * (start.getX() - this.x) + dy * (start.getY() - this.y) + dz * (start.getZ() - this.z));
        double c = Math.pow(start.getX() - this.x, 2) + Math.pow(start.getY() - this.y, 2) + Math.pow(start.getZ() - this.z, 2) - Math.pow(this.r, 2);
        double delta = Math.pow(b, 2) - 4 * a * c;

        if(delta < 0) {
            return null;
        } else if( delta == 0) {
            double t = - b / 2 * a;
            return new Vector(start.getX() + t * (end.getX() - start.getX()), start.getY() + t * (end.getY() - start.getY()), start.getZ() + t * (end.getZ() - start.getZ()));
        } else {
            double t = Math.min((-b - Math.sqrt(delta)) / (2 * a), (-b + Math.sqrt(delta)) / (2 * a));
            return new Vector (start.getX() + t * (end.getX() - start.getX()), start.getY() + t * (end.getY() - start.getY()), start.getZ() + t * (end.getZ() - start.getZ()));
        }
    }
}