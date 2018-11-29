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
        double dx = end.x - start.x;
        double dy = end.y - start.y;
        double dz = end.z - start.z;

        double a = Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2);
        double b = 2 * (dx * (start.x - this.x) + dy * (start.y - this.y) + dz * (start.z - this.z));
        double c = Math.pow(start.x - this.x, 2) + Math.pow(start.y - this.y, 2) + Math.pow(start.z - this.z, 2) - Math.pow(this.r, 2);
        double delta = Math.pow(b, 2) - 4 * a * c;

        if(delta < 0) {
            return null;
        } else if( delta == 0) {
            double t = - b / 2 * a;
            return new Vector(start.x + t * (end.x - start.x), start.y + t * (end.y - start.y), start.z + t * (end.z - start.z));
        } else {
            double t = Math.min((-b - Math.sqrt(delta)) / (2 * a), (-b + Math.sqrt(delta)) / (2 * a));
            return new Vector (start.x + t * (end.x - start.x), start.y + t * (end.y - start.y), start.z + t * (end.z - start.z));
        }
    }
}