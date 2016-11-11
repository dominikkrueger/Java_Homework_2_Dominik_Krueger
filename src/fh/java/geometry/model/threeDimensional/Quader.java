package fh.java.geometry.model.threeDimensional;

import javafx.geometry.Side;

/**
 * Created by Dominik on 09.11.2016.
 */
public class Quader extends ThreeDimensional{

    private double SideA,SideB,SideC;

    //constructor
    public Quader() {
    }
    public Quader(double sideA, double sideB, double sideC) {
        SideA = sideA;
        SideB = sideB;
        SideC = sideC;
    }

    //GETTER and SETTER
    public double getSideA() {
        return SideA;
    }
    public void setSideA(double sideA) {
        SideA = sideA;
    }
    public double getSideB() {
        return SideB;
    }
    public void setSideB(double sideB) {
        SideB = sideB;
    }
    public double getSideC() {
        return SideC;
    }
    public void setSideC(double sideC) {
        SideC = sideC;
    }

    //overwrite methods from ThreeDimensional
    @Override
    public double calculateVolume() {
        return SideA*SideB*SideC;
    }
    @Override
    public double calculateSurfaceArea() {
        return 2*(SideA*SideB+SideA*SideC+SideB*SideC);
    }

    //EQUAL and HASH
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quader quader = (Quader) o;

        if (Double.compare(quader.SideA, SideA) != 0) return false;
        if (Double.compare(quader.SideB, SideB) != 0) return false;
        return Double.compare(quader.SideC, SideC) == 0;

    }
    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(SideA);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(SideB);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(SideC);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    //toString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Quader{");
        sb.append("SideA=").append(SideA);
        sb.append(", SideB=").append(SideB);
        sb.append(", SideC=").append(SideC);
        sb.append(", volume=").append(calculateVolume());
        sb.append(", surface=").append(calculateSurfaceArea());
        sb.append('}');
        return sb.toString();
    }
}
