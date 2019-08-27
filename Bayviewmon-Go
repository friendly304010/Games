/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bayviewmongo;
import java.util.Scanner; //import Scanner
import java.util.Random; //import Random class
/* File name: BayviewmonGo
 * Author: Samantha Ouyang
 * Teacher: Ms. Leung
 * Course: ICS3U1 - 03
 * Description: This program replicates the game Pokemon Go. The player will encounter 
   5 different Bayviewmons of different values and will attempt to catch them. They will 
   have 15 balls in total. Some balls increase the chances of catching the Bayviewmons. 
   If you miss, you have the change to try and catch it again with another ball, or the Bayviewmon
   may have fled. When you have run out of balls, the program will print yout total points and your
   player rank. If the user wishes to play again, the program will run again.
*/
public class BayviewmonGo { //create class
    public static void main(String[] args) { //this is the entry point for the program to run
        Scanner input = new Scanner(System.in); //declare Scanner
        Random generate = new Random(); //declare Random class
        System.out.println("Welcome to Bayviewmon Go!"); //Prints "Welcome to Bayviewmon Go!"
        System.out.println("What is your name?"); //Asks for their name
        String name = input.next(); //Reads and stores user input for name
        System.out.println("Welcome to Bayviewmon Go, " + name + "."); //Prints "Welcome to Bayvewmon Go," and their name
        System.out.println("Let's play!"); //Prints "Let's play
        boolean wishToPlay = true; //declare boolean value wishToPlay
        while(wishToPlay){ //this while loop will run as long as wishToPlay is true, in other words, if the user wants to play. Each time this loop runs, a new game is started.
            int total = 0; //declare variable for total points
            int numBalls = 15; //declare variable for the number of balls remaining
            int numBoke = 0; //declare variable for the number of Bokeballs
            int numBreat = 0; //declare variable for the number of Breatballs
            int numBultra = 0; //declare variable for the number of Bultraballs
            for(int i = 1; i<=15; i++){ //this for loop will run as long as i is less than or equal to 15
                int n = generate.nextInt(3)+1; //a random number from 1 to 3 will be generated
                if(n==1)numBoke++; //if the number is 1, a Bokeball is added
                else if(n==2)numBreat++; //if the number is 2, a Breatball is added
                else numBultra++; //else, the number must be 3, so a Bultraball is added
            }
            System.out.println("You have " + numBoke + " Bokeballs, " + numBreat + " Breatballs, and " 
                    + numBultra + " Bultraballs."); //Prints the number of Bokeballs, Breatballs, Bultraballs, and the total number of balls remaining.
            do{ //this loop will run at least 1 time, in other words, this loop runs for each Bayviewmon that is encountered
                int num = generate.nextInt(5)+1; //a random number from 1 to 5 will be generated
                int monPoints = 0; //declares variable for the amount of points the Bayviewmon is worth
                if(num==1){ //if the number is 1, the following statements will run
                    System.out.println("A Baykachu has been encountered."); //Prints "A Baykachu has been encountered."
                    monPoints = 2; //the value of monPoints is changed to 2
                }
                else if(num==2){ //if the number is 2, the following statements will run
                    System.out.println("A Charmandview has been encountered."); //Prints "A Charmandview has been encountered."
                    monPoints = 3; //the value of monPoints is changed to 3
                }
                else if(num==3){ //if the number is 3, the following statements will run
                    System.out.println("A Bulbabay has been encountered."); //Prints "A Bulbabay has been encountered."
                    monPoints = 2; //the value of monPoints is changed to 2
                }
                else if(num==4){ //if the number is 4, the following statements will run
                    System.out.println("A Squirtew has been encountered."); //Prints "A Squirtew has been encountered."
                    monPoints = 4; //the value of monPoints is changed to 4
                }
                else{ //else, the number must be 5, so the following statements will run
                    System.out.println("An Eevay has been encountered."); //Prints "An Eevay has been encountered."
                    monPoints = 5; //the value of monPoints is changed to 5
                }
                boolean isEncountered = true; //declare boolean value isEncountered
                while(isEncountered && numBalls>0){ //this while loop will run as long as isEncountered is true. As long as the Bayviewmon has not been captured or has fled.
                    System.out.println("Which ball would you like to throw?"); //Asks user which ball they would like to throw
                    String ballChoice = input.next(); //Reads and stores user input of which ball they choose to throw
                    while(true){ //this loop will run until a ball is chosen correctly, of which the program will be told to break
                        if(ballChoice.equalsIgnoreCase("Bokeball")&&numBoke>0){ //the following statements will run if the user types the letters in Bokeball, ignoring case, and if the number of Bokeballs is greater than 0
                            numBoke--; //1 is subtracted from the number of Bokeballs
                            break; //because a ball was chosen correctly and there are still Bokeballs left, the system will break out of this loop
                        }
                        else if(ballChoice.equalsIgnoreCase("Breatball")&&numBreat>0){ //the following statements will run if the user types Breatball, ignoring case, and if the number of Breatballs is greater than 0
                            numBreat--; //1 is subtracted from the number of Breatballs
                            break; //because a ball was chosen correctly and there are still Bokeballs left, the system will break out of this loop
                        }
                        else if(ballChoice.equalsIgnoreCase("Bultraball")&&numBultra>0){ //the following statements will run if the user types Bultraball, ignoring case, and if the number of Bultraballs is greater than 0
                            numBultra--; //1 is subtracted from the number of Bultraballs
                            break; //because a ball was chosen correctly and there are still Bultraballs left, the system will break out of this loop
                        }
                        else{ //if the user's input was invalid or there were no more balls left of the chosen ball type, the following statements will run
                            System.out.println("Input is invalid. Please enter again: "); //Prompts user to re-enter value
                            ballChoice = input.next(); //Reads and stores new user input of which ball they choose to throw
                        }
                    }
                    numBalls--; //once a ball is correctly chosen, 1 is subtracted from the total number of balls
                    int percent = generate.nextInt(100)+1; //generates a random number from 1 to 100
                    if(ballChoice.equalsIgnoreCase("Bokeball")){ //if the user had chosen Bokeball
                        if(percent<=60){ //if the number is less than or equal to 60, the Bayviewmon has been caught, and the following statements will run
                            total += monPoints; //the Bayviewmon's points will be added to the total points
                            System.out.println("You caught the Bayviewmon!"); //Prints "You caught the Bayviewmon!"
                            isEncountered = false; //because the Bayviewmon was caught, the boolean value is now false, so that the loop will not run again in attempt to catch the same Bayviewmon
                        }
                        else if(percent<=80){ //if the number is not less than or equal to 60, but is less than or equal to 80, the Bayviewmon has been caught, and the following statements will run
                            System.out.println("The Bayviewmon fled."); //Prints "The Bayviewmon fled."
                            isEncountered = false; //because the Bayviewmon fled, the boolean value is now false, so that the loop will not run again in attempt to catch the same Bayviewmon
                        }
                        else{ //if the number is none of the following, therefore must be greater than 80 but less than or equal to 100, the Bayviewmon dodged the ball, and the following statements will run
                            System.out.println("The Bayviewmon dodged the ball. "
                                    + "Catch it again while it's still here!"); //Informs the user that the Bayviewmon dodged the ball
                        }
                    }
                    else if(ballChoice.equalsIgnoreCase("Breatball")){ //if the user had chosen Breatball
                        if(percent<=70){ //if the number is less than or equal to 70, the Bayviewmon has been caught, and the following statements will run
                            total += monPoints; //the Bayviewmon's points will be added to the total points
                            System.out.println("You caught the Bayviewmon!"); //Prints "You caught the Bayviewmon!"
                            isEncountered = false; //because the Bayviewmon was caught, the boolean value is now false, so that the loop will not run again in attempt to catch the same Bayviewmon
                        }
                        else if(percent<=85){ //if the number is not less than or equal to 70, but is less than or equal to 85, the Bayviewmon has been caught, and the following statements will run
                            System.out.println("The Bayviewmon fled."); //Prints "The Bayviewmon fled."
                            isEncountered = false; //because the Bayviewmon fled, the boolean value is now false, so that the loop will not run again in attempt to catch the same Bayviewmon
                        }
                        else{ //if the number is none of the following, therefore must be greater than 85 but less than or equal to 100, the Bayviewmon dodged the ball, and the following statements will run
                            System.out.println("The Bayviewmon dodged the ball. "
                                    + "Catch it again while it's still here!"); //Informs the user that the Bayviewmon dodged the ball
                        }
                    }
                    else { //because the ball type was none of the above, it must be a Bultraball
                        if(percent<=80){ //if the number is less than or equal to 80, the Bayviewmon has been caught, and the following statements will run
                            total += monPoints; //the Bayviewmon's points will be added to the total points
                            System.out.println("You caught the Bayviewmon!"); //Prints "You caught the Bayviewmon!"
                            isEncountered = false; //because the Bayviewmon was caught, the boolean value is now false, so that the loop will not run again in attempt to catch the same Bayviewmon
                        }
                        else if(percent<=90){ //if the number is not less than or equal to 80, but is less than or equal to 90, the Bayviewmon has been caught, and the following statements will run
                            System.out.println("The Bayviewmon fled."); //Prints "The Bayviewmon fled."
                            isEncountered = false; //because the Bayviewmon fled, the boolean value is now false, so that the loop will not run again in attempt to catch the same Bayviewmon
                        }
                        else{ //if the number is none of the following, therefore must be greater than 90 but less than or equal to 100, the Bayviewmon dodged the ball, and the following statements will run
                            System.out.println("The Bayviewmon dodged the ball. "
                                    + "Catch it again while it's still here!"); //Informs the user that the Bayviewmon dodged the ball
                        }
                    }
                    System.out.println("You have " + numBoke + " Bokeballs, " + numBreat + " Breatballs, "
                            + "and " + numBultra + " Bultraballs left, to a total of " + 
                            numBalls + " balls left."); //Prints the number of Bokeballs, Breatballs, Bultraballs, and total balls left.
                }
                System.out.println("You currently have " + total + " points."); //Prints the total amount of points
            }while(numBalls>0); //the do-while loop will run as long as the number of balls left is greater than 0
            System.out.println("You scored a total of " + total + " points."); //Prints the total amount of points accumulated when the game is over
            if(total>=20){ //if the total points was greater than or equal to 20, the following statements will run
                System.out.println("You are an excellent Bayviewmon catcher."); //Informs user that they are an excellent Bayviewmon catcher
            }
            else if(total>=15){ //if the total points was not greater than or equal to 20, but is greater than or equal to 15, the following statements will run
                System.out.println("You are a decent Bayviewmon catcher."); //Informs user that they are a decent Bayviewmon catcher
            }
            else{ //if the total points was not within either of the above ranges, it must be less than 15, so the following statements will run
                System.out.println("You need a bit more practice at catching Bayviewmons."); //Informs user that they need a bit more practice at catching Bayviewmons
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
        }
    } 
}
