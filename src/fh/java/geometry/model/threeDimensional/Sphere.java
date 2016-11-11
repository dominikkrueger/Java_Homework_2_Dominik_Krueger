package fh.java.geometry.model.threeDimensional;

/**
 * Created by Dominik on 09.11.2016.
 */
public class Sphere extends ThreeDimensional {

    private double radius;

    //constructor
    public Sphere() {
    }
    public Sphere(double radius) {
        this.radius = radius;
    }

    //GETTER and SETTER
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    //overwrite methods from threeDimensional
    @Override
    public double calculateVolume() {
        return (4/3)*Math.PI*radius*radius*radius;
    }
    @Override
    public double calculateSurfaceArea() {
        return 4*Math.PI*radius*radius;
    }

    //EQUAL and HASH
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sphere sphere = (Sphere) o;

        return Double.compare(sphere.radius, radius) == 0;
    }
    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(radius);
        return (int) (temp ^ (temp >>> 32));
    }

    //toString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Sphere{");
        sb.append("radius=").append(radius);
        sb.append("volume=").append(calculateVolume());
        sb.append("surface=").append(calculateSurfaceArea());
        sb.append('}');
        return sb.toString();
    }
}
