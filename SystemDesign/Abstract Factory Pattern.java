The Abstract Factory Pattern is another creational design pattern that provides an interface 
for creating families of related or dependent objects without specifying their concrete classes.

// Abstract CPU interface
interface CPU {
    void process();
}

// Concrete implementations of CPU
class LaptopCPU implements CPU {
    @Override
    public void process() {
        System.out.println("Laptop CPU is processing.");
    }
}

class DesktopCPU implements CPU {
    @Override
    public void process() {
        System.out.println("Desktop CPU is processing.");
    }
}

// Abstract RAM interface
interface RAM {
    void store();
}

// Concrete implementations of RAM
class LaptopRAM implements RAM {
    @Override
    public void store() {
        System.out.println("Laptop RAM is storing data.");
    }
}

class DesktopRAM implements RAM {
    @Override
    public void store() {
        System.out.println("Desktop RAM is storing data.");
    }
}

// Abstract factory interface
interface ComputerFactory {
    CPU createCPU();
    RAM createRAM();
}

// Concrete factory implementations
class LaptopFactory implements ComputerFactory {
    @Override
    public CPU createCPU() {
        return new LaptopCPU();
    }

    @Override
    public RAM createRAM() {
        return new LaptopRAM();
    }
}

class DesktopFactory implements ComputerFactory {
    @Override
    public CPU createCPU() {
        return new DesktopCPU();
    }

    @Override
    public RAM createRAM() {
        return new DesktopRAM();
    }
}

// Client class using the abstract factory pattern
public class AbstractFactoryPatternExample {
    public static void main(String[] args) {
        // Create a Laptop using LaptopFactory
        ComputerFactory laptopFactory = new LaptopFactory();
        CPU laptopCPU = laptopFactory.createCPU();
        RAM laptopRAM = laptopFactory.createRAM();

        laptopCPU.process();  // Output: Laptop CPU is processing.
        laptopRAM.store();    // Output: Laptop RAM is storing data.

        // Create a Desktop using DesktopFactory
        ComputerFactory desktopFactory = new DesktopFactory();
        CPU desktopCPU = desktopFactory.createCPU();
        RAM desktopRAM = desktopFactory.createRAM();

        desktopCPU.process();  // Output: Desktop CPU is processing.
        desktopRAM.store();    // Output: Desktop RAM is storing data.
    }
}
