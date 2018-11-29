package sample.LightModel.Model;

public class Vector {

    private double x, y, z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(double x1,double x2,double y1,double y2,double z1,double z2) {
        this.x = x2 - x1;
        this.y = y2 - y1;
        this.z = z2 - z1;
    }

    Vector toNormalizeVector(){
        double x = this.x/normalization();
        double y = this.y/normalization();
        double z = this.z/normalization();
        return new Vector(x,y,z);
    }

    double normalization(){
        return Math.sqrt(scalarProduct(this));
    }

    double scalarProduct(Vector vector){
        return this.x * vector.x + this.y * vector.y + this.z * vector.z;
    }

    Vector multiply(double value) {
        return new Vector(this.x * value, this.y * value, this.z * value);
    }
    Vector subtract(Vector vector) {
        return new Vector(this.x - vector.x, this.y -vector.y, this.z - vector.z);
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                "}. \n";
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
