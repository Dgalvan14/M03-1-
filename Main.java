import java.util.Scanner; // inport scanner class for user input

public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in); // creating scanner object for user input

        // Input for the first circle's radius
        System.out.println("Enter the radius for the first circle: ");
        double radius1 = userInput.nextDouble();
        Circle circle1 = new Circle(radius1);

        // Input for the second circle's radius
        System.out.println("Enter the radius for the second circle: ");
        double radius2 = userInput.nextDouble();
        Circle circle2 = new Circle(radius2);

        // Compares both circles to check if they are equal
        if (circle1.equals(circle2)) {
            System.out.println("The two circles are equal.");
        } else {
           // Using compareTo to see which circle is larger or smaller
           int comparison = circle1.compareTo(circle2);
            if (comparison > 0) {
                System.out.println("The first circle is larger than the second.");
            } else if (comparison < 0) {
                System.out.println("The first circle is smaller than the second.");
            } else {
                System.out.println("The two circles are equal in size."); // shouldnt get here but just in case
            }
        }

        // closing scanner to prevent memory leak
        userInput.close();

        // Output the radius and area for both circles
        System.out.println("Circle 1: \n" + "Radius: " + circle1.getRadius() + "\nArea: " + circle1.getArea() + "\nDiametere: " + circle1.getDiameter() + "\nPerimeter: " + circle1.getPerimeter());
        System.out.println("Circle 2: \n" + "Radius: " + circle2.getRadius() + "\nArea: " + circle2.getArea() + "\nDiametere: " + circle2.getDiameter() + "\nPerimeter: " + circle2.getPerimeter());
    }
    
    // this section is primarily based off the code from the triangle project and section 11.2 some of the data is not used
    public static class GeometricObject {
        private String color = "Null";
        private boolean filled;
        private java.util.Date dateCreated;

        // Default constructor
        public GeometricObject() {
            dateCreated = new java.util.Date();
        }

        // Constructor with a specified color and filled status
        public GeometricObject(String color, boolean filled) {
            dateCreated = new java.util.Date();
            this.color = color;
            this.filled = filled;
        }

        // return color
        public String getColor() {
            return color;
        }

        // Set a new color
        public void setColor(String color) {
            this.color = color;
        }

        // Return filled status

        public boolean isFilled() {
            return filled;
        }

        // set a new filled status
        public void setFilled(boolean filled) {
            this.filled = filled;
        }

        // get the date when the object was created
        public java.util.Date getDatecreated() {
            return dateCreated;
        }

        // returns a string representation of this object
        public String toString() {
            return "Created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
        }
    }

    // based off 11.2 primarily
    public static class Circle extends GeometricObject implements Comparable<Circle> {

        private double radius;

        //Default constructor
        public Circle() {

        }

        // Constructor with radius: initializes radius with user input
        public Circle(double radius) {
            this.radius = radius;
        }

        // constructor with radius, color, and filled status
        public Circle(double radius, String color, boolean filled) {
            this.radius = radius;

        }

        // returns radius
        public double getRadius() {
            return radius;
        }

        // sets radius
        public void setRadius(double radius) {
            this.radius = radius;
        }

        // returns area
        public double getArea() {
            return radius * radius * Math.PI;
        }

        // return the diamater of the circle
        public double getDiameter() {
            return 2 * radius;
        }

        // returns the Perimeter of the circle
        public double getPerimeter() {
            return 2 * radius * Math.PI;
        }

        // Print information about the circle
        public void printCircle() {
            System.out.println("The circle radius is " + radius);
        }

        // comparing based on both circles diameters
        public int compareTo(Circle secondCircle) {
            return Double.compare(this.getDiameter(), secondCircle.getDiameter());
        }

        public boolean equals(Object obj) {
            // Check if both objects are the same
            if (this == obj) {
                return true; 
            }
            // Ensure object is a circle
            if (obj == null || getClass() != obj.getClass()) {
                return false; 
            }

            Circle circle = (Circle) obj; // casts object to circle

            return Double.compare(circle.radius, radius) == 0; // Compare the radius of both circles

        }
        
    }
}