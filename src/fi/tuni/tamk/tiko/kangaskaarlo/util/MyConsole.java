package fi.tuni.tamk.tiko.kangaskaarlo.util;

import java.io.Console; 
/**
 * This class takes input from the user using console. (short)
 */

public class MyConsole {
    /**
     * This method returns an int value that has been asked from the user and checks that the input is correct.(short)
     * A correct input is a number between or same as the min and max values and it's a int number.
     * It also displays a given error message, depending how the input was wrong.
     * If the number given by the user is outside the min - max range, the error message shows these numbers at the end of the message (long)
     * @param min Smallest the ouput can be
     * @param max Largest the output can be
     * @param errorMessageNonNumeric  Error shown when input is not a number
     * @param errorMessageNonMinAndMax Error shown when input is not between the min and max values. Displays those values after the message
     * @return
     */
    public static int readInt(int min, int max, String errorMessageNonNumeric, String errorMessageNonMinAndMax) {
       Console c = System.console(); 
        int output = 0;
        boolean noNumberfound;
        boolean inputNotMinMax;
        do {
            noNumberfound = false;
            inputNotMinMax = false;
            try {
                output = Integer.parseInt(c.readLine());
                if (!(output >= min && output <= max)) {
                    System.out.println(errorMessageNonMinAndMax + " " + min +" and " + max + ". Please, try again.");
                    inputNotMinMax = true;
                }
            } catch(NumberFormatException e) {
                noNumberfound = true;
                System.out.println(errorMessageNonNumeric);
            }    
        }  while (noNumberfound || inputNotMinMax);
        
        return output;
    }
}