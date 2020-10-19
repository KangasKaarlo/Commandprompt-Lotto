# Commandprompt-Lotto
A simple commandline based lotto app that tries to win the game within a human lifetime.
## Motivation
Program was made as a coursework while studying at Tampere university of applied sciences.

The goal was to learn how to use packets in java, how to use github and how to make a complete program from start to finish and release it.

## Usage
The program first asks player for their lotto numbers one by one. After that it calculates how long it took to win the game

If the jackpot was not achieved within the set lifetime (by default it's the average lifetime for a Finnish woman, 85.) the game resets and start running again with the same numbers player gave earlier. The program stops when the jackpot is achieved within the lifetime. Beware that this can take some time, my worst run took 3hours and countless lifetimes, maybe gambling is not a good idea after all...

## Settings
There are a few variables at the start of the main.java file that act as settings for the program
```java
class main {
    //Settings
    static int howManyNumbers = 7; #how many numbers are needed to get the jackpot and how many numbers the player chooses
    static int minNumber = 1; #what's the smallest number in the game
    static int maxNumber = 40; #whats the largest number in the game
    static int averageHumanLifetime = 85; #what is the length of time you need to win the jackpot in, for the program to end
```
These can be changed as you see fit.

## Language
The program was written in java

#### note to self
This was written with 2.5 months of coding experience, so if you happen to read the code years from now, take that into account.
