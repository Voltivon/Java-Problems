// make any necessary imports here (for example, you will need a Scanner)
import java.util.Scanner;
import java.util.*;
public class GenesGreen {
   public static void main(String[] args) {
      // declare and create your Scanner
      Scanner scnr = new Scanner(System.in);
      // prompt for and collect the required inputs
      System.out.print("Enter Course Length : ");
      double length = scnr.nextInt();
      
      System.out.print("Enter Course Width  : ");
      double width = scnr.nextInt();
        System.out.println();
      // call your methods to compute the required outputs
      System.out.printf("Total square yards of rough sod  : %d\n", computeRoughSod(length, width));
      System.out.printf("Total square yards of smooth sod : %d\n", computeSmoothSod(length, width));
      // display the results
    
      System.out.printf("Tons of sand                     : %d\n", computeSand(length, width));
      System.out.printf("Number of bushes                 : %d\n", numberOfBushes(width, length));
   }
    
   // copy your method definitions from the previous parts here below
    public static double perimeterOfRectangle(double length, double width){
      double perimeter = 2 * (length + width);
      return perimeter;
   }
   
   // write your numberOfBushes method definition below
   public static int numberOfBushes(double width, double length){
      double numBushes = perimeterOfRectangle(length, width);
      numBushes -= 2;
      return (int) Math.floor(numBushes);
   }

   public static double areaOfCircle(double diameter){
     double radius = diameter / 2;
     double area = 3.1415 * (radius * radius);
     return area;
  }
   
   // write your areaOfSandTrap method definition below
   public static double areaOfSandTrap(double width){
      double diameter = width / 4;
      return areaOfCircle(diameter);
      
   }
   public static double areaOfPuttingGreen(double width){
      double diameter = width * 2 / 3;
      return areaOfCircle(diameter);
   }

   public static double areaOfTee(double width){
      double diameter = width / 3;
      return areaOfCircle(diameter);
   }

   public static double perimeterOfCircle(double diameter) {
       double perimeter = 3.1415 * diameter;
       return perimeter;
       
   } 

   public static double areaOfRectangle(double width, double length) {

       double area = length * width;
   
       return area;
   }  
   
   // add any additional methods you may want here below below
   
   public static int computeSmoothSod(double length, double width){
      double totalArea = areaOfTee(width) + areaOfPuttingGreen(width);
      return (int) Math.ceil(totalArea);
   }
   
   public static int computeRoughSod(double length, double width){
      double totalArea = areaOfRectangle(length, width);
      double computeArea = totalArea - areaOfTee(width) - areaOfPuttingGreen(width) - areaOfSandTrap(width); 
      return (int) Math.ceil(computeArea);
   }
   
   public static int computeSand(double length, double width){
      double sandTrapSqFt = areaOfSandTrap(width) * 9;
      double sandTrapCbFt = sandTrapSqFt * 2;
      double sandNeeded = sandTrapCbFt * 80;
      double sandTons = sandNeeded / 2000;
      return (int) Math.ceil(sandTons);
   }
}
