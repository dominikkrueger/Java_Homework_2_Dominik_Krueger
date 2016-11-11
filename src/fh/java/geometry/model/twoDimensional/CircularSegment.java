package fh.java.geometry.model.twoDimensional;

/**
 * Created by Dominik on 09.11.2016.
 */
public class CircularSegment extends TwoDimensional {

    private double radius, alpha;

    //constructor
    public CircularSegment() {
    }
    public CircularSegment(double radius, double alpha) {
        this.radius = radius;
        this.alpha = alpha;
    }

    //GETTER and SETTER
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getAlpha() {
        return alpha;
    }
    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    //overwrite methods of TwoDimensional class
    @Override
    public double calculateArea() {
        return ((radius*radius)/2)*(alpha-Math.sin(alpha));
    }
    @Override
    public double calculatePerimeter() {
        return 2*radius+(radius*alpha);
    }

    //EQUAL and HASH
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CircularSegment that = (CircularSegment) o;

        if (Double.compare(that.radius, radius) != 0) return false;
        return Double.compare(that.alpha, alpha) == 0;

    }
    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(radius);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(alpha);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    //toString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CircularSegment{");
        sb.append("radius=").append(radius);
        sb.append(", alpha=").append(alpha);
        sb.append(", area=").append(calculateArea());
        sb.append(", perimeter=").append(calculatePerimeter());
        sb.append("}");
        return sb.toString();
    }
}
