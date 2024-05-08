The Factory Pattern is a creational design pattern that provides an interface for creating objects in a superclass but allows subclasses
to alter the type of objects that will be created. This is useful for creating objects without specifying the exact class of object that will be created.

// Define the Shape interface
interface Shape {
    void draw();
}

// Create concrete classes implementing the Shape interface
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

// Create a ShapeFactory to generate different types of shapes
class ShapeFactory {
    // Factory method to create Shape objects based on input
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        } else if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}

// Usage example
public class FactoryPatternExample {
    public static void main(String[] args) {
        // Create a ShapeFactory
        ShapeFactory shapeFactory = new ShapeFactory();

        // Get different shapes from the factory
        Shape circle = shapeFactory.getShape("CIRCLE");
        if (circle != null) {
            circle.draw();  // Output: Drawing Circle
        }

        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        if (rectangle != null) {
            rectangle.draw();  // Output: Drawing Rectangle
        }

        Shape square = shapeFactory.getShape("SQUARE");
        if (square != null) {
            square.draw();  // Output: Drawing Square
        }
    }
}
