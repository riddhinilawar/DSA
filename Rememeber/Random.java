//will generate the random number from 0 till given number-1;

Random rand= new Random();
int pivot = rand.nextInt(high-low)+low;




To use the Random Class to generate random numbers, follow the steps below:

Import the class java.util.Random
Make the instance of the class Random, i.e., Random rand = new Random()
Invoke one of the following methods of rand object:
nextInt(upperbound) generates random numbers in the range 0 to upperbound-1.
nextFloat() generates a float between 0.0 and 1.0.
nextDouble() generates a double between 0.0 and 1.0.


import java.util.Random;

class GenerateRandom {
    public static void main( String args[] ) {
      // Instance of random class
      Random rand = new Random(); 
      // Setting the upper bound to generate the
      // random numbers in specific range
      int upperbound = 25;
      // Generating random values from 0 - 24 
      // using nextInt()
      int int_random = rand.nextInt(upperbound); 
      // Generating random using nextDouble 
      // in 0.0 and 1.0 range
      double double_random = rand.nextDouble();
      // Generating random using nextDouble
      // in 0.0 and 1.0 range
      float float_random = rand.nextFloat();
      
      // Printing the generated random numbers
      System.out.println("Random integer value from 0 to" + (upperbound-1) + " : " + int_random);
      System.out.println("Random float value between 0.0 and 1.0 : " + float_random);
      System.out.println("Random double value between 0.0 and 1.0 : " + double_random);
    }
}
