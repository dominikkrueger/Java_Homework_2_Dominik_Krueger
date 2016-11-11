package fh.java.geometry.model.twoDimensional;

/**
 * Created by Dominik on 09.11.2016.
 */
public class Diamond extends TwoDimensional {

    private double sideA, sideE, sideF;

    //constructors
    public Diamond() {
    }
    public Diamond(double SideA, double SideE, double SideF) {
        this.sideA = SideA;
        this.sideE = SideE;
        this.sideF = SideF;
    }

    //GETTER and SETTER
    public double getSideA() {
        return sideA;
    }
    public void setSideA(double sideA) {
        this.sideA = sideA;
    }
    public double getSideE() {
        return sideE;
    }
    public void setSideE(double sideE) {
        this.sideE = sideE;
    }
    public double getSideF() {
        return sideF;
    }
    public void setSideF(double sideF) {
        this.sideF = sideF;
    }

    //overwrite methods of TwoDimensional class
    @Override
    public double calculateArea() {
        return (sideE * sideF)/2;
    }
    @Override
    public double calculatePerimeter() {
        return 4* sideA;
    }

    //EQUAL and HASH
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Diamond diamond = (Diamond) o;

        if (Double.compare(diamond.sideA, sideA) != 0) return false;
        if (Double.compare(diamond.sideE, sideE) != 0) return false;
        return Double.compare(diamond.sideF, sideF) == 0;

    }
    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(sideA);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sideE);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sideF);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    //toString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Diamond{");
        sb.append("sideA=").append(sideA);
        sb.append(", sideE=").append(sideE);
        sb.append(", sideF=").append(sideF);
        sb.append(", area=").append(calculateArea());
        sb.append(", perimeter=").append(calculatePerimeter());
        sb.append('}');
        return sb.toString();
    }
}
