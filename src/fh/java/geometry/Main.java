package fh.java.geometry;

import com.sun.imageio.plugins.gif.GIFImageReader;
import fh.java.geometry.model.GeometricShapes;
import fh.java.geometry.model.threeDimensional.Cylinder;
import fh.java.geometry.model.threeDimensional.Quader;
import fh.java.geometry.model.threeDimensional.Sphere;
import fh.java.geometry.model.threeDimensional.ThreeDimensional;
import fh.java.geometry.model.twoDimensional.Circle;
import fh.java.geometry.model.twoDimensional.CircularSegment;
import fh.java.geometry.model.twoDimensional.Diamond;
import fh.java.geometry.model.twoDimensional.TwoDimensional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dominik on 09.11.2016.
 */
public class Main{

    //define global variables
    private List<TwoDimensional> twoDimList = new ArrayList<>();
    private List<ThreeDimensional> threeDimList = new ArrayList<>();

    private double sumArea = 0;
    private double sumPerimeter = 0;
    private double sumVolume = 0;
    private double sumSurface = 0;

    //public Main class
    public static void main(String[] args) {

        //create an instance of Main because otherwise you cant call other methods like fillList and printList
        Main main = new Main();
        main.doIt();
    }

    public void doIt() {

        //create a new empty list which can contain GeometricShapes
        List<GeometricShapes> shapesList = new ArrayList<>();

        //To-Do list
        fillList(shapesList);
        separateList(shapesList);
        calcAreaPerimeterVolumeSurface(twoDimList);
        calcAreaPerimeterVolumeSurface(threeDimList);
        displayResults();
    }

    private void fillList(List<GeometricShapes> shapesList) {

        //add shapes to list
        shapesList.add(new Circle(5));
        shapesList.add(new CircularSegment(10,272));
        shapesList.add(new Diamond(10,18,5));

        shapesList.add(new Cylinder(10,20));
        shapesList.add(new Quader(10,4,7));
        shapesList.add(new Sphere(15));
    }

    private void separateList(List<GeometricShapes> shapesList) {

        //separate shapes from shapesList to TwoDimensional or ThreeDimensional list
        for (GeometricShapes shape : shapesList) {
            if(shape instanceof TwoDimensional){
                if (shape instanceof Circle){
                    twoDimList.add((Circle)shape);
                }
                else if (shape instanceof CircularSegment){
                    twoDimList.add((CircularSegment)shape);
                }
                else {
                    twoDimList.add((Diamond)shape);
                }
            }
            else {
                if (shape instanceof Cylinder){
                    threeDimList.add((Cylinder)shape);
                }
                else if (shape instanceof Quader){
                    threeDimList.add((Quader)shape);
                }
                else {
                    threeDimList.add((Sphere)shape);
                }
            }
        }
    }

    private <A>void calcAreaPerimeterVolumeSurface(List<A> DimList) {
        //check for each shape in list wheather it is two- or three dimensional and calculate certain things
        for (A shape : DimList){
            if (shape instanceof TwoDimensional){
                sumArea += ((TwoDimensional) shape).calculateArea();
                sumPerimeter += ((TwoDimensional) shape).calculatePerimeter();
            }
            else if (shape instanceof ThreeDimensional){
                sumVolume += ((ThreeDimensional) shape).calculateVolume();
                sumSurface += ((ThreeDimensional) shape).calculateSurfaceArea();
            }
        }
    }

    private void displayResults(){
        //print out all results
        System.out.printf("\nThe sum of areas of all 2 dimensional shapes is: %.2f", sumArea);
        System.out.printf("\nThe sum of perimeters of all 2 dimensional shapes is: %.2f\n", sumPerimeter);
        System.out.printf("\nThe sum of volumes of all 3 dimensional shapes is: %.2f", sumVolume);
        System.out.printf("\nThe sum of surfaces of all 3 dimensional shapes is: %.2f\n", sumSurface);
    }


}
