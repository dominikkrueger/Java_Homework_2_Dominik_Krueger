package fh.java.geometry.model.twoDimensional;

/**
 * Created by Dominik on 09.11.2016.
 */
public class Circle extends TwoDimensional {

    private double radius;

    //constructor
    public Circle() {
    }
    public Circle(double radius) {
        this.radius = radius;
    }

    //GETTER and SETTER
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    //methods from the TwoDimensional class
    @Override
    public double calculateArea() {
        return radius*radius*Math.PI;
    }
    @Override
    public double calculatePerimeter() {
        return 2*radius*Math.PI;
    }

    //EQUAL and HASH
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        return Double.compare(circle.radius, radius) == 0;
    }
    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(radius);
        return (int) (temp ^ (temp >>> 32));
    }

    //toString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Circle{");
        sb.append("radius=").append(radius);
        sb.append(", area=").append(calculateArea());
        sb.append(", perimeter=").append(calculatePerimeter());
        sb.append('}');
        return sb.toString();
    }
}
