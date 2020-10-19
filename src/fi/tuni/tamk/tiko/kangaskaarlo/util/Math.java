package fi.tuni.tamk.tiko.kangaskaarlo.util;

/**
 * This class Math can perform simple mathematical tasks (short).
 */

public class Math {
    /**
     * Method getRandom generates a random number within given parameters.
     * @param min is the smallest the output can be.
     * @param max is the largest the output can be.
     * @return a random number between min and max values.
     */
    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }
}
