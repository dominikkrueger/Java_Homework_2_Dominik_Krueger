package fh.java.geometry.model.threeDimensional;

/**
 * Created by Dominik on 09.11.2016.
 */
public class Cylinder extends ThreeDimensional {

    private double radius, height;

    //constructors
    public Cylinder() {
    }
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    //GETTER and SETTER
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    //overwrite the methods from the threeDimensional class
    @Override
    public double calculateVolume() {
        return radius*radius*Math.PI*height;
    }
    @Override
    public double calculateSurfaceArea() {
        return radius*radius*Math.PI*2 + 2*Math.PI*radius*height;
    }

    //EQUAL and HASH
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cylinder cylinder = (Cylinder) o;

        if (Double.compare(cylinder.radius, radius) != 0) return false;
        return Double.compare(cylinder.height, height) == 0;
    }
    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(radius);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    //toString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cylinder{");
        sb.append("radius=").append(radius);
        sb.append(", height=").append(height);
        sb.append(", volume=").append(calculateVolume());
        sb.append(", surface=").append(calculateSurfaceArea());
        sb.append('}');
        return sb.toString();
    }
}
