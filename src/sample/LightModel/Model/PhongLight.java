package sample.LightModel.Model;


public class PhongLight {

    //specular intensity - natezenie swiatla odbijanego zwierciadlanie
    private double Ia;
    // natężenie światła padającego
    private double Ii;
    //wspolczynniki do ustalania procentowego wplywu skladowych na natezenie wynikowe
    //ratio of reflection of the specular term of incoming light
    private double ka, ks, kd;
    //
    private double n, c;


    PhongLight(double ia, double Ka, double ii, double Kd, double Ks, double N, double C) {
        Ia = ia;
        ka = Ka;
        Ii = ii;
        kd = Kd;
        ks = Ks;
        n = N;
        c = C;
    }

    PhongLight(){
        Ia = 100;
        ka =0.4;
        Ii = 60000 ;
        kd = 0.5;
        ks = 0.5;
        n = 100;
        c = 2;
    }

    Double spherePointLighting(Vector lightSource, Vector observer, Vector sphereCenter, Vector point) {
        if (point == null){
            return null;}
        Vector N = new Vector(sphereCenter.getX(), point.getX(), sphereCenter.getY(), point.getY(), sphereCenter.getZ(), point.getZ()).toNormalizeVector();
        Vector V = new Vector(point.getX(), observer.getX(), point.getY(), observer.getY(), point.getZ(), observer.getZ()).toNormalizeVector();
        Vector L = new Vector(point.getX(), lightSource.getX(), point.getY(), lightSource.getY(), point.getZ(), lightSource.getZ());
        double r = L.normalization();
        L = L.toNormalizeVector();
        Vector R = (N.multiply(2)).multiply(N.scalarProduct(L)).subtract(L).toNormalizeVector();
        return Ia * ka + Ii *(kd * Math.max(N.scalarProduct(L), 0) + ks * Math.pow(Math.max(R.scalarProduct(V), 0), n)) / (c + r);

    }

    public double getIa() {
        return Ia;
    }

    public void setIa(double ia) {
        Ia = ia;
    }

    public double getIi() {
        return Ii;
    }

    public void setIi(double ii) {
        Ii = ii;
    }

    public double getKa() {
        return ka;
    }

    public void setKa(double ka) {
        this.ka = ka;
    }

    public double getKs() {
        return ks;
    }

    public void setKs(double ks) {
        this.ks = ks;
    }

    public double getKd() {
        return kd;
    }

    public void setKd(double kd) {
        this.kd = kd;
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }
}
