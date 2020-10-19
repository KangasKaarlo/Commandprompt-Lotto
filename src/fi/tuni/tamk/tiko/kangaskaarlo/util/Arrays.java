package fi.tuni.tamk.tiko.kangaskaarlo.util;

/**
 * This class contains simple methods that help working with arrays (short)
 */
public class Arrays {
    /**
     * This method converts a string array to an int array.
     * @param input is the string array you want to convert
     * @return input as a int array.
     */
    public static int [] toIntArray(String [] input) {
        int [] output = new int [input.length];

        for (int i = 0; i < input.length; i++) {
            output[i] = Integer.parseInt(input[i]);
        }
 
        return output;
    }
    /**
     * This method tests if a int value is found from an int array.
     * @param value is the value that will be searched from the array.
     * @param array is the array that the value will be searched from.
     * @return boolean indicating if value was found from array.
     */
    public static boolean contains(int value, int [] array) {
        boolean output = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                output = true;
            }
        }
        return output;
    }
    /**
     *  Compares two int arrays and returns how many values match between the two (short)
     *  This method does NOT take into account the possibility that the same array has the same number included several times
     *  and will give a false positives if that's the case.
     *  This method was made for a personal project and only that project in mind,
     *  so its use elsewhere is not recommended and might cause unexpected issues and behaviors. (long)
     * @param array1 Array that will be compared to array2
     * @param array2 Array that will be compared to array1
     * @return how many numbers are shared between the two arrays
     */
    public static int containsSameValues(int [] array1, int [] array2) {
        int output = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int y = 0; y < array2.length; y++) {
                if (array1[i] == array2[y]) {
                    output += 1;
                }
            }
        }
        return output;
    }
    /**
     * Fills an int array with unique numbers asked from the user (short)
     * you can define a range that the numbers need to be within. Method makes sure that all numbers on the array are unique(long)
     * @param howManyNumbers how long the array should be.
     * @param minNumber whats the smallest the number can be
     * @param maxNumber whats the largest the number can be
     * @return int array filled with numbers asked from the user
     */
    public static int [] fillArray(int howManyNumbers, int minNumber, int maxNumber ) {
        int[] output = new int [howManyNumbers];
        for (int i = 0; i < howManyNumbers; i++) {
            System.out.print("Please give unique number between ");
            System.out.print(minNumber);
            System.out.print(" and ");
            System.out.println(maxNumber);
            output[i] = MyConsole.readInt(minNumber, maxNumber, "Please give number", "Number not between");
            
            // Makes sure number is unique
            for (int y = 0; y < i; y++) {
                if (output[i] == output[y]) {
                    System.out.println("That number has already been given!");
                    i--;
                    break;
                }
            }
        }
        return output;
    }
}
