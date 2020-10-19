package fi.tuni.tamk.tiko.kangaskaarlo;

import fi.tuni.tamk.tiko.kangaskaarlo.util.Math;
import fi.tuni.tamk.tiko.kangaskaarlo.util.Arrays;
import fi.tuni.tamk.tiko.kangaskaarlo.util.MyConsole;

class main {
    //Settings
    static int howManyNumbers = 7;
    static int minNumber = 1;
    static int maxNumber = 40;
    static int averageHumanLifetime = 85;

    //do not change these variables
    static int [][] yearsToWin = new int [howManyNumbers][2];
    static boolean [] winFound = new boolean [howManyNumbers];
    static int numbersFound = 0;
    static int weeksPlayed = 0;
    static int [] timeToWin = new int [2];
    static boolean wonWithinLifetime = false;
    

    public static void main(String [] args) {
        //asks for players lotto numbers and makes sure that the numbers are within range and there is the correct amount of them
        int [] playersNumbers = Arrays.fillArray(howManyNumbers, minNumber, maxNumber);

        //loops until the player wins within a lifetime
        while (!(wonWithinLifetime)) {
            //loops until player wins.
            //one loop equals one week played
            while (numbersFound < howManyNumbers) {

                //calculates this weeks lotto
                int [] lotto = calculateLotto();
                weeksPlayed++;

                //if player has any numbers correct this if statement marks the win to winFound and adds 1 to numbersFound
                //it also stores the amount of months and weeks that the win took to yearsToWin
                if (Arrays.containsSameValues(playersNumbers, lotto) > 0 && (!(winFound[Arrays.containsSameValues(playersNumbers, lotto) -1]))) {            
                    howLongToWin(Arrays.containsSameValues(playersNumbers, lotto));
                }
            }
            //prints out how long it took to find the numbers
            printWin();
            //checks if the win was won within a lifetime
            checkLifetime();
           
        }    
        
    }
    /**
     * Prints out how long it took to win, from one correct all the way to the jackpot (short)
     */
    public static void printWin() {
        for (int x = 0; x < howManyNumbers; x++) {
            System.out.println("got " + (x + 1) + " right! it took " + yearsToWin[x][0] + " years and " + yearsToWin[x][1] + " weeks" );
        }        
    }
    /**
     * checks if game was won within a lifetime (short)
     **/    
    public static void checkLifetime() {
        if (yearsToWin[howManyNumbers -1][0] < averageHumanLifetime) {
            wonWithinLifetime = true;
            System.out.println("You won within a lifetime! Nice!");
        } 
        else { 
            System.out.println("Althought it took more than a lifetime, let's try it again.");
            yearsToWin = new int [howManyNumbers][2];
            winFound = new boolean [howManyNumbers];
            numbersFound = 0;
            weeksPlayed = 0;
            timeToWin = new int [2];
        }
    }
    /**
     * converts a int number indicating number of weeks to an int array where the first int is years and the second is weeks (short)
     * @param weeks input for how many weeks need to be converted to a {month, week} format
     * @return int array that displays the input weeks in a{month, weeks} format
     */
    private static void howLongToWin(int howManyFound) {
        int years = 0;
        while (weeksPlayed > 52) {
            years++;
            weeksPlayed -= 52;
        }
        winFound[howManyFound -1] = true;
        yearsToWin[howManyFound -1][0] = years;
        yearsToWin[howManyFound -1][1] = weeksPlayed;
        numbersFound++;
    }

    /**
     * Fills an array with random unique int numbers that are within given range (short)
     * @return int array filled with random unique int numbers that are within given range
     */
    private static int[] calculateLotto() {
        int [] lotto = new int [howManyNumbers];
        for (int i = 0; i < howManyNumbers; i++) {
            lotto[i] = Math.getRandom(minNumber, maxNumber);

            // Makes sure number is unique
            for (int y = 0; y < i; y++) {
                if (lotto[i] == lotto[y]) {
                    i--;
                    break;
                }
            }
        }
        return lotto;
    }

}
