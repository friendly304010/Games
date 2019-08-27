/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheeloffortune;
import java.util.Scanner; //import Scanner
import java.util.Random; //import Random class
/* File name: WheelOfFortune
 * Author: Samantha Ouyang
 * Teacher: Ms. Leung
 * Course: ICS3U1 - 03
 * Description: This program replicates the game Wheel of Fortune. There are two players: the computer and the user.
   Contestants are competeting to win the most amount of money in three rounds. Each round, the wheel is spun. There are
   24 spaces on the wheel. One space reads "Lose a Turn" and two spaces read "Bankrupt". If the wheel lands on this, the 
   control is moved to the other player all earnings in the round will be lost if it reads "Bankrupt". All other spaces
   on the wheel hold a monetary value. After the wheel is spun, the player can choose a letter or to solve the puzzle. 
   Vowels can be bought for $250, but they don't have to be played in that round. If the letter is guessed correctly,
   the frequency of the letter in the phrase, multiplied by the monetary value of what the spinner value is added to 
   their earnings. Otherwise, if the letter is guessed incorrectly, or has already been guessed, control moves to the
   other player. The second option is to solve the puzzle. If it is solved correctly, the minimum value of the earnings
   must be at least $1000. If it is guessed incorrectly, control moves to the other person. The winner is the player 
   who wins the most amount of money in all three rounds. If the user wishes to play again, the program will run again. 
*/
public class WheelOfFortuneTask { //create class
    static Random generate = new Random(); //declare Random class
    static int [] wheel = new int [24]; //declare an integer array to hold the values of the 24 spaces on the wheel
    public static int generateSpin(){ //create a method to choose a space for the spinner to land on
        return generate.nextInt(24); //returns a random number from 0 to 23
    }
    public static int randomPuzzle(){ //create a method to choose a random puzzle
        return generate.nextInt(25); //returns a random number from 0 to 24
    }
    public static int compGenChoice(){ //create a method to choose one of the 3 options during the computer's turn
        return generate.nextInt(3); //returns a random number from 0 to 2
    }
    public static int compGenAlpha(){ //create a method to choose one of the letters in the alphabet for the computer to guess
        return generate.nextInt(26); //returns a random number from 0 to 25
    }
    public static int compGenVowel(){ //create a method to choose one of the vowels for the computer to guess
        return generate.nextInt(5); //returns a random number from 0 to 4
    }
    public static int compGenPercentage(){ //create a method to generate a percentage for the win rate of the computer
        return generate.nextInt(100)+1; //returns a random number from 1 to 100
    }
    /**
     * 
     * @param wheel is an integer array that holds the value of the spaces on the wheel
     * @param round is an integer that determines which round of the game it is
     */
    public static void updateWheel(int [] wheel, int round){ //create method to update the spaces on the wheel for each round
        wheel[1] = 0; //the second element of the wheel is assigned the value of 0
        wheel[2] = -1; //the third element of the wheel is assigned the value of -1
        wheel[3] = -1; //the fourth element of the wheel is assigned the value of -1
        for(int i = 4; i < 24; i++){ //this loop will run for the length of the rest of the array
            wheel[i] = generate.nextInt(401)+500; //a random number from 500 to 900 is stored into the element in the array
        }
        if(round==0){ //if it is the first found, the following statement will run
            wheel[0] = 2500; //the first element in the array, the top dollar, will be given the value of 2500
        }
        else if(round==1){ //otherwise, if it is the second round, the following statement will run
            wheel[0] = 3500; //the first element in the array, the top dollar, will be given the value of 3500
        }
        else if(round==2){ //otherwise, if is the third round, the following statement will run
            wheel[0] = 5000; //the first element in the array, the top dollar, will be given the value of 5000
        }
    }
    /**
     * 
     * @param letterboard is a String array and will be converted into a letter board 
     * @param alphabet is a String and is used to check if the character is a letter or not
     */
    public static void convertLetterboard(String [] letterboard, String alphabet){ //converts the puzzle chosen into a letterboard by filling the letters with spaces
        for(int i = 0; i < letterboard.length; i++){ //this for loop runs for the length of the array
            if(alphabet.contains(letterboard[i])){ //if the element in the array can be found in the alphabet String, the following statement will run
                letterboard[i] = "_"; //the element in the array is replaced with an underscore
            }
        }
    }
    /**
     * 
     * @param lettersToChoose is a String array that holds letters that have not already been guessed
     * @param letter is a String that holds the letter that has been guessed by the player or computer
     */
    public static void removeGuessedLetters(String [] lettersToChoose, String letter){ //removes letters from the array that have already been guessed
        for(int i = 0; i < lettersToChoose.length; i++){ //this for loop runs for the length of the array
            if(lettersToChoose[i].equals(letter)){ //if the element in the array is the letter guessed
                lettersToChoose[i] = ""; //the element in the array is replaced with an empty String
            }
        }
    }
    /**
     * 
     * @param puzzleChosen is a String that contains the puzzle being played for that round
     * @param letter is a String that contains the letter guessed by the player or the computer
     * @return an integer that holds the number of times the letter appears in the puzzleChosen String
     */
    public static int frequency(String puzzleChosen, String letter){ //determines the number of times the letter appears in the String
        int count = 0; //declare an integer variable called count
        for(int i = 0; i < puzzleChosen.length(); i++){ //this for loop runs for the length of the array
            if(puzzleChosen.substring(i,i+1).equals(letter)){ //if the letter in the puzzle equals the letter the player or computer guessed
                count++; //1 is added to count
            }
        }
        return count; //returns the number of times the letter guessed appears in the puzzle
    }
    /**
     * 
     * @param puzzleChosen is a String that contains the puzzle being played for that round
     * @param letterboard is a String array and will be updated by adding letters that have been guessed correctly
     * @param letter is a String that contains the letter guessed by the player or the computer
     */
    public static void updateLetterboard(String puzzleChosen, String [] letterboard, String letter){ //updates the letterboard of which the player sees
        for(int i = 0; i < letterboard.length; i++){ //this for loop runs for the length of the array
            if(puzzleChosen.substring(i,i+1).equals(letter)){ //if the letter in the puzzle equals the letter the player or computer guessed
                letterboard[i] = letter; //the element in the array is updated to the letter chosen
            }
        }
    }
    /**
     * 
     * @param lettersToChoose is a String array containing the letters that can still be guessed
     * @param letter is a String containing the letter that the player or computer has guessed
     * @return false, unless the letter is found in the array
     */
    public static boolean lettersToChoose(String [] lettersToChoose, String letter){ //determines whether or not the letter can be guessed properly
        for(int i = 0; i < lettersToChoose.length; i++){ //this for loop runs for the length of the array
            if(lettersToChoose[i].equals(letter)){ //if the element in the array is equal to the letter guessed
                return true; //method will return the boolean value as true
            }
        }
        return false; //otherwise, the method will return the boolean value as false
    }
    /**
     * 
     * @param vowelsToChoose is a String array that contains the vowels that haven't been bought yet
     * @param vowel is a String that contains the vowel wanted to be bought by the player or computer
     * @return false, unless the vowel is found in the array
     */
    public static boolean vowelsToChoose(String [] vowelsToChoose, String vowel){ //this method checks if the vowel was bought
        for(int i = 0; i < vowelsToChoose.length; i++){ //this for loop runs for the length of the array
            if(vowelsToChoose[i].equals(vowel)){ //if the element in the array is equal to the chosen vowel
                return true; //method will return the boolean value as true
            }
        }
        return false; //otherwise, the method will return the boolean value as false
    }
    /**
     * 
     * @param vowelsToChoose is a String array containing the vowels that can still be bought
     * @param vowel is a String containing the vowel that was just bought
     */
    public static void removeBoughtVowels(String [] vowelsToChoose, String vowel){
    //this method removes the vowels that have already been bought from the array of letters that can still be bought
        for(int i = 0; i < vowelsToChoose.length; i++){ //this for loop runs for the length of the array
            if(vowelsToChoose[i].equals(vowel)){ //if the element in the array is equal to the chosen vowel
                vowelsToChoose[i] = ""; //the element in the array will update to an empty string
            }
        }
    }
    /**
     * 
     * @param money is an integer array holding the earnings of either the computer or player, depending what actual parameters are passed
     * @param round is an integer indicating which round of the game it is
     * @return false, unless the earnings in that round is greater than 250
     */
    public static boolean checkBuy(int [] money, int round){ //this method checks if the player or computer has enough money to buy a vowel
        if(money[round]>250){ //if the element in the array is greater than 250, the following statement will run
            return true; //the method will return a value of true
        }
        return false; //otherwise, the method will return a value of false
    }
    /**
     * 
     * @param letterboard is a String array containing the letters and underscores that the player and computer can see
     * @return true, unless the array contains an underscore in one of its elements
     */
    public static boolean noBlanks(String [] letterboard){ 
    //this method checks if the letterboard still contains blanks, or underscores, indicating missing letters
        for(int i = 0; i < letterboard.length; i++){ //this for loop runs for the length of the array
            if(letterboard[i].equals("_")){ //if the element in the array is an underscore, the following statement will run
                return false; //the method will return a value of false
            }
        }
        return true; //otherwise, the method will return a value of true
    }
    public static void printOptions(){ //this method will print out the 3 options each time for the player
        System.out.println("1) Guess a letter"); //prints the first option, which is to guess a letter
        System.out.println("2) Buy a vowel ($250 for each)"); //prints out the second option, which is to buy a vowel
        System.out.println("3) Solve the puzzle"); //prints out the third option, which is to solve the puzzle
    }
    /**
     * 
     * @param arr is a String array
     */
    public static void printArray(String [] arr){ //this method will be used to print arrays easier, instead of running a for loop each time
        for(int i = 0; i < arr.length; i++){ //this for loop runs for the length of the array
            if(!arr[i].equals("")){ //if the element in the array is not an empty String
                System.out.print(arr[i] + " "); //prints out the element plus a space
            }
            else{ //otherwise, if the element in the array is an empty String
                System.out.print(arr[i]); //prints out the empty String
            }
        }
        System.out.println(); //prints out a blank line, moving the cursor to the next line
    }
    /**
     * 
     * @param letterboard is a String array containing the letters and blanks that the player and computer sees
     * @param lettersToChoose is a String array containing the letters that are still available to guess
     * @param vowelsToChoose //is a String array containing the vowels that are still available to buy
     * @param compMoney is an integer array for the computer's earnings
     * @param playerMoney is an integer array for the player's money
     * @param compVowels is a String array containing the vowels the computer has bought
     * @param playerVowels is a String array containing the vowels the player has bought
     * @param round is an integer indicating which round it is
     */
    public static void displayGameState(String [] letterboard, String [] lettersToChoose, String [] vowelsToChoose, 
                                        int [] compMoney, int [] playerMoney, int round){
        //this method is to display the current game state, so that only 1 line is needed to run many print statements
        System.out.println("This is the current letterboard."); //prints for the player to understand
        printArray(letterboard); //calling a method to print the elements in the letterboard array
        System.out.println("These are the letters available to guess."); //prints for the player to understand
        printArray(lettersToChoose); //calling a method to print the letters still available from the array
        System.out.println("These are the vowels available to buy."); //prints for the player to understand
        printArray(vowelsToChoose); //calling a method to print the vowels still available from the array
        System.out.println("These are the computer's earnings for this round."); //prints for the player to understand
        System.out.println("$" + compMoney[round]); //prints the computer's current amount of money in the round
        System.out.println("These are your earnings for this round."); //prints for the player to understand
        System.out.println("$" + playerMoney[round]); //prints the player's current amount of money in the round
    }
    /**
     * 
     * @param arr is an integer array
     * @return the sum of all elements in the array added
     */
    public static int sumArray(int [] arr){ //this method returns the sum of all the values int the array passed as an actual parameter
        int sum = 0; //declare an integer value sum as 0
        for(int i = 0; i < arr.length; i++){ //this for loop runs for the length of the array
            sum = sum + arr[i]; //the value of the element in the array is added to the accumulator called sum
        }
        return sum; //the method returns the value of sum
    }
    public static void main(String[] args) { //this is the main entry point for the program to run
        Scanner input = new Scanner(System.in); //declare Scanner
        System.out.println("Welcome to Wheel Of Fortune!"); //Prints "Wheel Of Fortune!"
        System.out.println("What is your name?"); //Asks for their name
        String name = input.next(); //Reads and stores user input for name
        System.out.println("Welcome to Wheel Of Fortune, " + name + "."); //Prints "Welcome to Wheel Of Fortune," and their name
        System.out.println("Let's play!"); //Prints "Let's play
        System.out.println("The theme is 2014 songs."); //Prints the theme
        boolean wishToPlay = true; //declare boolean value wishToPlay
        String [] puzzle = new String [25]; //declare a String array to hold the 25 puzzle options
        puzzle[0] = "BANG BANG"; //assign a puzzle to element in array
        puzzle[1] = "ALL ABOUT THAT BASS"; //assign a puzzle to element in array
        puzzle[2] = "RATHER BE"; //assign a puzzle to element in array
        puzzle[3] = "BAILANDO"; //assign a puzzle to element in array
        puzzle[4] = "AM I WRONG"; //assign a puzzle to element in array
        puzzle[5] = "SAY SOMETHING"; //assign a puzzle to element in array
        puzzle[6] = "BREAK FREE"; //assign a puzzle to element in array
        puzzle[7] = "BEST DAY OF MY LIFE"; //assign a puzzle to element in array
        puzzle[8] = "BLACK WIDOW"; //assign a puzzle to element in array
        puzzle[9] = "BOOM CLAP"; //assign a puzzle to element in array
        puzzle[10] = "ME AND MY BROKEN HEART"; //assign a puzzle to element in array
        puzzle[11] = "A SKY FULL OF STARS"; //assign a puzzle to element in array
        puzzle[12] = "BLANK SPACE"; //assign a puzzle to element in array
        puzzle[13] = "SHE LOOKS SO PERFECT"; //assign a puzzle to element in array
        puzzle[14] = "STAY WITH ME"; //assign a puzzle to element in array
        puzzle[15] = "LIFE OF THE PARTY"; //assign a puzzle to element in array
        puzzle[16] = "ALL OF ME"; //assign a puzzle to element in array
        puzzle[17] = "DARK HORSE"; //assign a puzzle to element in array
        puzzle[18] = "TURN DOWN FOR WHAT"; //assign a puzzle to element in array
        puzzle[19] = "I'M NOT THE ONLY ONE"; //assign a puzzle to element in array
        puzzle[20] = "NOT A BAD THING"; //assign a puzzle to element in array
        puzzle[21] = "LOVE RUNS OUT"; //assign a puzzle to element in array
        puzzle[22] = "COUNTING STARS"; //assign a puzzle to element in array
        puzzle[23] = "LET IT GO"; //assign a puzzle to element in array
        puzzle[24] = "REALLY DON'T CARE"; //assign a puzzle to element in array
        do{ //this loop runs as long as the player wishes to play
            int round = 0; //set the round number as equal to 0
            int [] playerMoney = new int [3]; //declare an integer array to store the earnings won in each round for the player
            int [] compMoney = new int[3]; //declare an integer array to store the earnings won in each round for the computer
            int [] puzzlePlayed = {25,25,25}; //declare an integer array to determine if a puzzle has already been played
            while(round<3){ //this while loop runs 3 times, for each round in the game
                updateWheel(wheel, round); //for each round, the spaces on the wheel are updated
                final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //this String is only used to determine if a String is a letter, therefore, it is a constant
                final String vowels = "AEIOU"; //this String is only used to determine if a String is a vowel, therefore, it is a constant
                String [] lettersToChoose = {"B","C","D","F","G","H","J","K","L","M","N","P",
                                            "Q","R","S","T","V","W","X","Y","Z"}; //declaring an array of letters that can still be chosen after certain ones are guessed
                String [] vowelsToChoose = {"A", "E", "I", "O", "U"}; //declaring an array of vowels that can still be bought
                puzzlePlayed[round] = randomPuzzle(); //set the element in the puzzlePlayed array to a number generated from the randomPuzzle method
                boolean played = true; //declare boolean value to determine if the puzzle was played or not
                while(played){ //this while loop runs as long as the boolean value played is true
                    if(round==0){ //if it is the first round, the following statement will run
                        played = false; //since it is the first round, none of the puzzles could have been played yet, so the boolean value becomes false
                    }
                    else if(round==1 && puzzlePlayed[round-1]!=puzzlePlayed[round] && puzzlePlayed[round+1]!=puzzlePlayed[round]){
                    //if it's the second round and neither the first or last puzzle is the same as the puzzle chosen for the second round
                        played = false; //the boolean value becomes false
                    }
                    else if(round==2 && puzzlePlayed[round-1]!=puzzlePlayed[round] && puzzlePlayed[round-2]!=puzzlePlayed[round]){
                    //if it's the third round and neither the first or second puzzle is the same as the puzzle chosen for the third round
                        played = false; //the boolean value becomes false
                    }
                    else{ //if none of the conditions above are true, then two or more puzzles must be the same
                        puzzlePlayed[round] = randomPuzzle(); //the puzzzle will be chosen again by calling the random puzzle generator and reassigning it
                    }
                }
                String puzzleChosen = puzzle[puzzlePlayed[round]]; //once a proper puzzle has been chosen, the puzzle at that index becomes the puzzle for that round
                String [] letterboard = puzzleChosen.split(""); //a new String array is created by splitting the puzzle into individual characters
                convertLetterboard(letterboard, alphabet); //call the method to convert the letters into blanks for the players to guess
                System.out.println("This is the phrase you will be guessing."); //prints what the blanks printed below represent
                printArray(letterboard); //call the method to print out the letterboard
                boolean turn = false; //declare boolean value to determine whose turn it is
                boolean isSolved = false; //declare boolean value to determine whether or not the puzzle has been solved
                while(!isSolved){ //this loop runs as long as the puzzle is not solved
                    while(!turn){ //this loop runs as long as the turn is false, indicating the computer's turn
                        System.out.println("Computer's turn:"); //prints to the system to inform the player
                        int spinNum = wheel[generateSpin()]; //call the method to generate a number as an index of the space on a wheel, and stores the value in a variable
                        if(spinNum!=0 && spinNum!=-1){ //if the wheel is a normal value, meaning it is not -1 or 0
                            System.out.println("The wheel landed on " + spinNum); //prints what the wheel landed on
                        }
                        if(spinNum==0 || spinNum==-1){ //if the wheel landed on 0 or -1
                            turn = true; //the boolean value becomes true, meaning control moves to the player
                            if(spinNum==-1){ //if the wheel landed on -1
                                compMoney[round] = 0; //the computer loses all its current earnings
                                //prints to inform the player that the wheel landed on bankrupt, and that the computer has lost all its earnings in that round
                                System.out.println("The computer's spin landed on Bankrupt. The computer's earnings are now $" + compMoney[round]);
                            }
                            else{ //otherwise, the wheel landed on 0
                                System.out.println("The computer's spin landed on Lose a Turn. Your turn!"); //prints to inform the player that the computer lost its turn
                            }
                            break; //breaks the computer's turn loop
                        }
                        int compChoice = compGenChoice(); //calls the method to generate a number for one of the three options, and stores into variable 
                        boolean guessed = false; //declare boolean value to determine if a letter or phrase has been guessed
                        while(!guessed){ //this while loop runs as long as a letter or phrase has not been guessed    
                            if(compChoice==0){ //if the number generated was 0, the following statements will run
                                System.out.println("The computer has chosen to guess a letter."); //informs the player that the computer is going to guess a letter
                                int alphaIndex = compGenAlpha(); //call the method to generate a number for the letter to guess
                                String randomAlpha = alphabet.substring(alphaIndex, alphaIndex+1); //uses the number to allocate a letter in the alphabet String
                                System.out.println("The computer guessed: " + randomAlpha); //informs the player of the letter the computer guessed
                                if(vowels.contains(randomAlpha)){ //if the letter guessed is a vowel and was not bought yet by the computer
                                    compChoice=1; //the number becomes 1, so that they are redirected as if they had chosen to buy a vowel in the first place
                                }
                                else if(lettersToChoose(lettersToChoose,randomAlpha)){ //if the lettersToChoose array still contains the letter guessed
                                    guessed = true; //boolean value becomes true, so that the loop will not repeat again
                                    removeGuessedLetters(lettersToChoose, randomAlpha); //call the method to remove the letter that was just guessed from the array
                                    if(puzzleChosen.contains(randomAlpha)){ //if the letter guessed could be found in the puzzle, meaning that the guess was correct
                                        //call the method to find the number of times the letter appears in the puzzle, and store the value into a variable
                                        int frequency = frequency(puzzleChosen, randomAlpha); 
                                        if(frequency>0){ //if the letter appears at least once, the following statements will run
                                            compMoney[round] = compMoney[round] + frequency*spinNum; //the frequency multiplied by the value spun will be added to the computer's earnings
                                            updateLetterboard(puzzleChosen, letterboard, randomAlpha); //call the method to change the blanks in the letterboard into the letter that was guessed
                                        }
                                        System.out.println("This is the current letterboard."); //print what the next line contains
                                        printArray(letterboard); //call the method to print out what the letterboard looks like now
                                        if(noBlanks(letterboard)){ //call the method to check if blanks still remain in the letterboard
                                            isSolved = true; //if the above statement is true, the boolean value becomes true
                                            System.out.println("The computer guessed correctly."); //informs user that computer guessed correctly
                                            break; //breaks loop so that the computer does not have to play another turn
                                        }
                                    }
                                    else{ //if the letter is not found in the puzzle
                                        turn = true; //control moves to the player
                                        System.out.println("The computer guessed incorrectly. Your turn!"); //tells the player that the computer guessed incorrectly
                                    }
                                }
                                else{
                                    turn = true; //control moves to the player
                                    guessed = true; //boolean value becomes true, so that the loop will not repeat again
                                    System.out.println("The computer guessed a letter that was already guessed. Your turn!"); //informs user that computer guessed a letter that was already guessed
                                }
                            }
                            if(compChoice==1){ //otherwise, if the number generated is 1, is not an else as it will have to be checked again if a vowel was entered in first option
                                System.out.println("The computer has chosen to buy a vowel."); //informs the user that the computer wishes to buy a vowel
                                if(checkBuy(compMoney,round)){ //call the method to check if the computer has enough money to buy a vowel
                                    compMoney[round] = compMoney[round]-250; //subtracts 250 from the computer's earnings in that round, even if vowel was bought incorrectly, i.e. buys a vowel that was already bought
                                    int vowelIndex = compGenVowel(); //generates a random number for the vowel
                                    String randomVowel = vowels.substring(vowelIndex, vowelIndex+1); //using the number generated, gets a random vowel for the string of vowels
                                    System.out.println("The computer bought the vowel " + randomVowel); //informs the user of the vowel the computer has selected
                                    guessed = true; //boolean value becomes true, so that the loop will not repeat again
                                    if(vowelsToChoose(vowelsToChoose, randomVowel)){ //if the vowel chosen can still be bought
                                        removeBoughtVowels(vowelsToChoose, randomVowel); //call the method to remove the letter bought from the array of available vowels
                                        if(puzzleChosen.contains(randomVowel)){ //if the letter guessed could be found in the puzzle, meaning that the guess was correct
                                            //call the method to find the number of times the letter appears in the puzzle, and store the value into a variable
                                            int frequency = frequency(puzzleChosen, randomVowel); 
                                            if(frequency>0){ //if the letter appears at least once, the following statements will run
                                                compMoney[round] = compMoney[round] + frequency*spinNum; //the frequency multiplied by the value spun will be added to the computer's earnings
                                                updateLetterboard(puzzleChosen, letterboard, randomVowel); //call the method to change the blanks in the letterboard into the letter that was guessed
                                            }
                                            System.out.println("This is the current letterboard."); //print what the next line contains
                                            printArray(letterboard); //call the method to print out what the letterboard looks like now
                                            if(noBlanks(letterboard)){ //call the method to check if blanks still remain in the letterboard
                                                isSolved = true; //if the above statement is true, the boolean value becomes true
                                                System.out.println("The computer guessed correctly."); //informs user that computer guessed correctly
                                                break; //breaks loop so that the computer does not have to play another turn
                                            }
                                        }
                                    }
                                    else{ //otherwise, if the vowel has already been bought by the player or the computer itself
                                        System.out.println("The computer bought a vowel that was already bought."); //prints that the vowel was already bought
                                        guessed = true; //boolean value becomes true, so that the loop does not repeat
                                        turn = true; //boolean value becomes true, control moves to the player
                                    }
                                }
                                else{ //otherwise, if the computer does not have enough money
                                    System.out.println("Oops! The computer does not have enough money to buy a vowel."); //inform the player that the computer does not have enough money to buy a vowel
                                    compChoice = compGenChoice(); //regenerate a choice
                                }
                                System.out.println("The computer's earnings are $" + compMoney[round]); //informs the user of the computer's new earnings
                                System.out.println("These are the vowels you can now choose."); //informs the user of what is being printed in the next line
                                printArray(vowelsToChoose); //prints the vowels that are now available to be bought
                            }
                            else if(compChoice==2){ //otherwise, if the computer randomly chooses the third option
                                guessed = true; //boolean value becomes true, so that the loop will not repeat again
                                System.out.println("The computer has chosen to solve the puzzle."); //inform the player of the choice the computer has made
                                int win = compGenPercentage(); //calls the method to generate a random win rate for the computer
                                if(win<=5){ //if the number generated is less than or equal to 5, the following statements will run
                                    System.out.println("The computer guessed correctly."); //informs the player that the computer guessed correctly
                                    System.out.println("The phrase is " + puzzleChosen); //informs the player of what the phrase was that the computer guessed correctly
                                    isSolved = true; //boolean value becomes true, so that the user will not continue to play and already solved puzzle
                                    if(compMoney[round]<1000){ //if the computer's earnings are still less than 1000
                                        compMoney[round] = 1000; //the computer's earnings have a guarantee of at least $1000 in earnings
                                    }
                                    break; //system will break the loop so the computer does not have to play another turn
                                }
                                else{ //otherwise, if the number generated is greater than 5, the following statements will run
                                    System.out.println("The computer guessed incorrectly. Your turn!"); //informs the player that the computer guessed incorrectly
                                    turn = true; //boolean value becomes true, control moves to the player 
                                }
                            }
                        }
                    }
                    if(!isSolved){ //if the boolean value is false, meaning that the puzzle is not complete, the following statement will run
                        //call the method to print out the current letterboard, available letters, vowels, earnings of each payer, vowels bought by each player
                        displayGameState(letterboard, lettersToChoose, vowelsToChoose, compMoney, playerMoney, round);
                    }
                    while(turn && !isSolved){ //if is the user's turn and the puzzle is not solved
                        int spinNum = wheel[generateSpin()]; //call the method to generate an index of the space on the wheel and stores in a variable
                        if(spinNum!=0 && spinNum!=-1){
                            System.out.println("The wheel landed on " + spinNum); //informs the player of what the wheel landed on
                        }
                        if(spinNum==0 || spinNum==-1){ //if the index is 0 or -1, the following statements will run
                            turn = false; //boolean value becomes false, control moves to the computer
                            if(spinNum==-1){ //if index is -1, the following statement will run
                                playerMoney[round] = 0; //player's earnings are erased back to 0
                                System.out.println("You landed on Bankrupt! Your earnings are now $" + playerMoney[round]); //tells the player that the wheel landed on bankrupt
                            }
                            break; //breaks the loop
                        }
                        System.out.println("Your turn! Enter a number corresponding to the options below:"); //prompt user to enter a number for choice
                        printOptions(); //call the method to allow the user to refer to the three options they can choose
                        int playerChoice = input.nextInt(); //read and store user input regarding their choice
                        while(true){ //this loop runs until a break statements is called
                            if(playerChoice<1 || playerChoice>3){ //if the user entered a number less than 1 or greater than 3, the following statements will run
                                System.out.println("Input is invalid. Please enter again:"); //prompts the user to re-enter a value
                                playerChoice = input.nextInt(); //read and store user input again
                            }
                            else{ //otherwise, the user has entered correctly
                                break; //breaks loop
                            }
                        }
                        boolean guessed = false; //create boolean value to determine if a guess has been made to the letterboard
                        while(!guessed){
                            if(playerChoice==1){ //if the user entered 1, the following statements will run
                                System.out.println("Please enter a letter:"); //prompts user to enter a letter
                                String playerLetter = input.next().substring(0,1).toUpperCase(); //read and store user input, taking the first letter and changing all letters to uppercase, to avoid exceptions 
                                if(vowels.contains(playerLetter)){ //if the player guesses a vowel and has not bought it yet
                                    playerChoice=2; //changes the player's choice so that they can buy the vowel first
                                    System.out.println("You are being redirected to the vowel shop."); //informs user that they have to buy the vowel
                                }
                                else if(lettersToChoose(lettersToChoose,playerLetter)){ //otherwise, if the letter still exists in the array of letters available to guess
                                    guessed = true; //boolean value becomes true, so that the loop does not repeat
                                    removeGuessedLetters(lettersToChoose, playerLetter); //calls method to remove the letter guessed from array of available letters to guess
                                    if(puzzleChosen.contains(playerLetter)){ //if the letter guessed can be found in the puzzle
                                        int frequency = frequency(puzzleChosen, playerLetter); //call method to determine the number of times the letter appears in the puzzle and stores in a variable
                                        if(frequency>0){ //if the letter appears at least once in the string
                                            playerMoney[round] = playerMoney[round] + frequency*spinNum; //adds the product of the value from the wheel by the number of times the letter appeared to the player's earnings for that round
                                            updateLetterboard(puzzleChosen, letterboard, playerLetter); //call method to replace blanks with letter that player guessed correctly in the letterboard
                                            System.out.println("Your current earnings are: $" + playerMoney[round]); //informs player of their earnings after guessing correctly
                                        }
                                        System.out.println("This is the current letterboard."); //print what the next line contains
                                        printArray(letterboard); //calls method to print letterboard
                                        if(noBlanks(letterboard)){ //if the letterboard does not contain anymore blanks
                                            isSolved = true; //boolean value becomes true, so that the puzzle will not be played again by the computer as it is already solved
                                            System.out.println("Hooray! You guessed the phrase."); //informs the user that they have guessed correctly
                                            break; //system breaks loop, so that the player will not have to play another turn
                                        }
                                    }
                                    else{ //if the letter cannot be found in the puzzle
                                        turn = false; //boolean value becomes false, control moves to the computer
                                        System.out.println("You guessed incorrectly. It is now the computer's turn."); //informs player that their turn is over
                                    }
                                }
                                else{ //otherwise, the letter was already guessed
                                    turn = false; //control moves to the computer, boolean value becomes false
                                    guessed = true; //boolean value becomes true, so that the loop does not repeat
                                    System.out.println("This letter was already guessed. It is now the computer's turn."); //informs user that letter was already guessed
                                }
                            }
                            else if(playerChoice==2){ //if the user has chosen the second option, to buy a vowel
                                System.out.println("Welcome to the vowel shop! Please enter a vowel:"); //prompt user to enter a vowel to buy
                                String playerVowel = input.next().substring(0,1).toUpperCase(); //reads and stores user input, taking the first character and converting it to uppercase, to avoid any exceptions
                                while(true){ //this while loop runs until a break statement is called
                                    if(vowels.contains(playerVowel)){ //if the letter entered is a vowel, the following statement will run
                                        break; //break loop
                                    }
                                    else{ //otherwise, if the letter entered is a consonant
                                        System.out.println("Input is invalid. Please enter again:"); //prompt user to re-enter correctly
                                        playerVowel = input.next().substring(0,1).toUpperCase(); //read and store user input, taking the first character and converting to uppper case to avoid exceptions
                                    }
                                }
                                if(checkBuy(playerMoney, round)){ //if the method called shows that the player has enough money to buy a vowel
                                    playerMoney[round] = playerMoney[round]-250; //subtracts 250 from player's earnings, even if vowel was bought incorrectly, i.e. buys a vowel that was already bought
                                    if(vowelsToChoose(vowelsToChoose, playerVowel)){ //if the vowel can still be bought and the computer has not bought it
                                        removeBoughtVowels(vowelsToChoose, playerVowel); //removes the vowel just bought from the available vowels to buy array
                                        guessed = true; //boolean value becomes true, so that the loop does not repeat
                                        if(puzzleChosen.contains(playerVowel)){ //if the letter guessed could be found in the puzzle, meaning that the guess was correct
                                            //call the method to find the number of times the letter appears in the puzzle, and store the value into a variable
                                            int frequency = frequency(puzzleChosen, playerVowel); 
                                            if(frequency>0){ //if the letter appears at least once, the following statements will run
                                                compMoney[round] = compMoney[round] + frequency*spinNum; //the frequency multiplied by the value spun will be added to the computer's earnings
                                                updateLetterboard(puzzleChosen, letterboard, playerVowel); //call the method to change the blanks in the letterboard into the letter that was guessed
                                            }
                                            System.out.println("This is the current letterboard."); //prints what the next line contains
                                            printArray(letterboard); //call the method to print out what the letterboard looks like now
                                            if(noBlanks(letterboard)){ //if the letterboard does not contain anymore blanks
                                                isSolved = true; //boolean value becomes true, so that the puzzle will not be played again by the computer as it is already solved
                                                System.out.println("Hooray! You guessed the phrase."); //informs the user that they have guessed correctly
                                                break; //system breaks loop, so that the player will not have to play another turn
                                            }
                                        }
                                        else{ //if the vowel cannot be found in the puzzle
                                            turn = false; //boolean value becomes false, control moves to the computer
                                            System.out.println("You guessed incorrectly. It is now the computer's turn."); //informs player that their turn is over
                                        }
                                    }
                                    else{ //otherwise, if the vowel was already bought by either player
                                        System.out.println("You just tried to buy a vowel that was already bought."); //inform player that they tried to buy a vowel that was already bought
                                        guessed = true; //boolean value becomes true, so that the loop does not repeat
                                        turn = false; //boolean value becomes false, control moves to computer
                                    }
                                }
                                else{ //otherwise, if the player does not have enough money
                                    System.out.println("Oops! You don't have enough money to buy a vowel."); //inform player that they do not have enough money
                                    guessed = true; 
                                }
                                System.out.println("Your earnings are now $" + playerMoney[round]); //inform player of their current earnings
                                System.out.println("These are the vowels you can now choose."); //informs player of what the next line holds
                                printArray(vowelsToChoose); //prints the vowels that are still available to be bought
                            }
                            else if(playerChoice==3){ //otherwise, if the player entered 3
                                System.out.println("Please enter the complete phrase."); //prompts user to enter the complete phrase
                                input.nextLine(); //reads the rest of the line of the last input, otherwise nextLine() method wouldn't read the correct input
                                String completePhrase = input.nextLine().toUpperCase(); //reads a new line of input as the phrase the user enters and converts it to uppercase to avoid user errors
                                guessed = true; //boolean value becomes true, so that the loop does not repeat
                                if(completePhrase.equals(puzzleChosen)){ //if the phrase is the same as the puzzle chosen
                                    isSolved = true; //boolean value becomes true, so that the computer does not guess letters on a solved puzzle
                                    System.out.println("Hooray! You guessed the phrase."); //informs the user that they have guessed correctly
                                    if(playerMoney[round]<1000){ //if the player's earnings are less than 1000
                                        playerMoney[round] = 1000; //player's earnings becomes 1000, as it is a guarantee stated in the rules
                                    }
                                    System.out.println("Your current earnings are: $" + playerMoney[round]); //informs the user of their current earnings
                                    break; //breaks loop so that the player will not have to play another turn
                                }
                                else{ //otherwise, if the phrase entered is different
                                    System.out.println("You guessed incorrectly. It is now the computer's turn."); //inform the user that their guess was incorrect
                                    turn = false; //control moves to the computer, as an incorrect guess was made
                                }
                            }
                        }
                    } 
                    if(!isSolved){ //if the puzzle is not solved
                        //call method to print current letterboard, letters available to guess, vowels to available to buy, earnings for each player, vowels bought for each player
                        displayGameState(letterboard, lettersToChoose, vowelsToChoose, compMoney, playerMoney, round);
                    }
                } //this is 1 game
                round++; //1 is added to the round number
            }   
            int compTotalMoney = sumArray(compMoney); //call the method to calculate the sum or the earnings of the computer in all 3 rounds and stores in variable
            int playerTotalMoney = sumArray(playerMoney); //call the method to calculate the sum or the earnings of the player in all 3 rounds and stores in variable
            System.out.println("The computer won $" + compTotalMoney); //print out how much money the computer made
            System.out.println("The player won $" + playerTotalMoney); //print out how much money the player made
            if(compTotalMoney > playerTotalMoney){ //if the computer's total earnings is greater than the player's
                System.out.println("The winner is the computer. Better luck next time!"); //print that the computer won
            }
            else if(compTotalMoney < playerTotalMoney){ //if the computer's total earnings is less than the player's
                System.out.println("You are the winner. Congratulations!"); //print that the player won
            }
            else{ //otherwise, if none of the above cases are true, they must be equal
                System.out.println("It is a tie."); //prints that there is no winner
            }
            System.out.println("Do you wish to continue playing?(Y/N)"); //Asks user if the wish to continue playing
            String playAgainAnswer = input.next(); //Reads and stores user input on whether or not they wish to continue playing
            while(true){ //this loop will run until the user correctly answer whether or not they wish to continue playing
                if(playAgainAnswer.equalsIgnoreCase("N")){ //the following statements will run if the user enters the letter N, ignoring case
                    wishToPlay = false; //the boolean value of wishToPlay is changed to false, because the user does not wish to play
                    break; //the system will break out of this loop that will continue to ask user if they want to play, because it was answered correctly
                }
                else if(playAgainAnswer.equalsIgnoreCase("Y")){ //the following statements will run if the user enters the letter Y, ignoring case
                    System.out.println("Let's play again!"); //Prints "Let's play again"
                    break; //the system will break out of this loop that will continue to ask user if they want to play, because it was answered correctly
                }
                else{ //if the input was none of the above, the input must have been incorrect, so the following statements will run
                    System.out.println("Input is invalid. Please enter again: "); //Prompts user to re-enter
                    playAgainAnswer = input.next(); //Reads and stores new user input on whether or not they wish to play
                }
            }
        }while(wishToPlay); //checks that the user wishes to play
    }
}
