/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner; //import scanner
/* File name: GameOf21
 * Author: Samantha, Bill, Nicholas, Ryan
 * Teacher: Ms. Leung
 * Course: ICS3U1 - 03
 * Description: This program replicates the Game of 21. There are two players: the computer and the user.
   Deal a card from a deck of playing cards by generating a random number between 1 and 13. A 1 corresponds 
   to an Ace, numbers 2 through 10 to those cards, and 11 through 13 correspond to Jack, Queen, and King. 
   The Jack, Queen, and King have a value of 10 in the Game of 21. An Ace can have a value of 1 or 11. Allow the 
   player to stay with two cards or be given a third card. Announce the winner. Keep playing rounds until the player 
    says to stop (or when either the computer or the player reaches 21).
*/
public class TheGameOf21 {
    static Scanner input = new Scanner(System.in); //declare scanner
    static int[] cards = new int[52]; //there are a total of 52 cards in a deck, therefore, the array is declared to have 52 elements
    static int[] userCards; //the most cards the user can have is 11, therefore, the array is declared to have 11 elements, just in case
    static int[] computerCards; //the most cards the user can have is 11, therefore, the array is declared to have 11 elements, just in case
    static String[] cpuDialog = {"Load me up another card!", "Ya, I would like a card please", "Go big or go home, gimme another card!", "Of course, give me that card", "Umm.. Sure I will take a card", "Ah, maybe I really SHOULD take a card, so yes, card please", "I can't lose to that user, hit me with another card!","CARRRRRRRRD!", "Let me get another card", "Calculating.......Yes, I want a card", "A card, I shall ask for.", "Since you have comsci this semester, there is 1 moon orbiting the Earth, my name begins with C, and the first Element being Hydrogen, I would definetly want a card","You bet, I will get a card please" };
    static String[] cpuDialog2 = {"AHH, no more cards", "I don't want anymore cards...", "OH NO, NO MORE", "My luck is horrible today, no more cards please", "Pros don't need more cards", ":) I have so good cards I don't need anymore /wink"};
    static int lastIndex = 51; //declare integer for the last index visited of the deck
    static int userCardsIndex; //declare integer for the next index of the user deck
    static int cpuCardsIndex; //declare integer for the next index of the cpu deck
    public static void main (String[]args) throws Exception{ //this is the main entry point for the program to run
        System.out.print("Welcome to the Game of 21! Please enter your name: "); //Prompt the user to enter their name
        String name = input.nextLine(); //Stores the user's name
        try{ //Greets the user and tells them the rules of the game
            System.out.println("Welcome " + name + " to the Game of 21");
            Thread.sleep(1250);
            System.out.println("The general basics of the game are:");    
            Thread.sleep(1250);
            System.out.println("-----You will be dealt 2 cards before starting, an ace can be 1 or 11, all numbered cards follow their corresponding number, and all royals are worth 10.");
            Thread.sleep(1250);
            System.out.println("-----Your goal is to try to get 21 or as close to 21 without going over.");
            Thread.sleep(1250);
            System.out.println("-----You will have the option to recieve more cards to get you closer to a total of 21. You can stop whenever you want.");
            Thread.sleep(1250);
            System.out.println("-----Once all players are done receiving cards, whoever has 21 or is closest to 21 is the winner!");
        } 
        catch(Exception e){
            System.out.println("Whoops! You have an error!");
            //error has been encountered, deal with the error here, although this statement should never be reached
        }
        boolean wishToPlay = true; //Creates a boolean to determine whether or not to run the game again
        do{ //have a do loop so the game can run multiple times
            cards = new int[52]; //redeclare cards
            userCards = new int[11]; //Creates string arrays to store the cards of the user 
            computerCards = new int[11]; //Creates string arrays to store the cards of the computer
            userCardsIndex = 0; //resets the index of the userCards to 0
            cpuCardsIndex = 0; //resets the index of the cpuCards to 0
            lastIndex = 51; //redeclare last index of cards
            assignCards(); //calling this method creates the 52 cards 
            dealCards(); //calling this method deals two cards to both the computer and the player
            showCards(0); //shows the cards of the user
            userAceSwitch(); //checks and allows the user to determine the values of the Aces if there is any (detail see method) 
            while(true){ //continues the following until some code breaks it out       
                System.out.println("Do you want another card? Please enter (Y/N):"); //prompts the user to tell the program whether or not they want another card
                String want = input.next(); //read and store user input
                if(want.equalsIgnoreCase("Y")){ //if the user wants,                             
                    giveMoreCards(0); //give them another card     
                    showCards(0); //shows their cards again
                    userAceSwitch(); //again asks the use to determine the values of the aces 
                    if(sumCards()>21){ //checks, if the sum is already above 21, the game will end the user's turn
                        System.out.println("You have went over 21, ending turn...");  
                        break;  //exits the loop of the user to end their turn
                    }
                }
                else if(want.equalsIgnoreCase("N")){ //if they do not want a card, also ends the user's turn  
                    break;                                               
                }
                else{ //if they do not enter a correct response, ask again
                    System.out.println("You have to answer properly! ");   
                }
            }
            System.out.println("It's now the computer's turn!"); //print that it is now the computer's turn
            int fSum = 0; //declare fSum variable
            while(true){ //runs until break is called
                int amount = 0; //declare ace count variable
                int sum = 0; //declare sum variable
                for(int i = 0; i < computerCards.length; i++){ //runs for the length of computer cards
                    if( computerCards[i] != 1 && computerCards[i] != 14){ //if the value is not 1 or 14
                        if(computerCards[i] > 10 && computerCards[i] < 14){ //if the value is between 11 and 13
                            sum = sum + 10; //add 10 to sum
                        }
                        else{ //otherwise
                            sum = sum + computerCards[i]; //add the actual numerical value
                        }
                    }
                    else{ //otherwise, if the cards are 1 or 14
                        amount++; //add 1 to the ace counter
                    }
                }
                fSum = cpuSumAceSwitch( amount, sum); //call the method to determine the value of the ace
                if(fSum < 0){ //if fSum is less than 0
                    break; //break the loop
                }
                boolean take = cpuTake(fSum); //create boolean variable and call method to determine whether it is a good idea or not to take another card
                if(take){ //if boolean is true
                    int dialog = (int) (Math.random() * cpuDialog.length); //generates a random number within the dialogue array length
                    System.out.println("CPU: "+ cpuDialog[dialog]); //prints the dialogue
                    giveMoreCards(1); //deals another card to the cpu
                }
                else{ //otherwise boolean is false
                    int dialog2 = (int) (Math.random() * cpuDialog2.length);
                    System.out.println("CPU: "+ cpuDialog2[dialog2]);
                    break;
                }
            }
            System.out.println("The computer's turn is now over.");
            showCards(0); //shows the cards of the user
            showCards(1); //shows the cards of the computer                           
            int curSum = 0; //have another sum accumulater to find the sum if the computer went over 21 ( since the function returns -1)
            if(fSum < 0){
                for(int i = 0; i < computerCards.length; i++){
                    if(computerCards[i] > 10 && computerCards[i] < 14){ 
                        curSum = curSum + 10; //if its a royal card, add 10
                    }
                    else{
                        curSum = curSum + computerCards[i]; //or else just add the value of the card, you wouldn't add an ace as 11 because that would only make you go over even more
                    }
                }
                fSum = curSum; //store the sum as the final sum 
            }
            System.out.println("CPU has points: "+fSum); //shows the total amount the computer  has
            System.out.println("You have points: " + sumCards()); //shows the total amount the user has
            boolean cpuOver = false; //have boolean to store when the cpu or the user went over 21, which counts as nothing      
            boolean userOver = false; //have boolean to store when the user went over 21, which counts as nothing                                        
            if(fSum > 21){ //if computer's sum > 21
                cpuOver = true; //boolean is true
            }
            if(sumCards() > 21){ //if user sum is > 21
              userOver = true; //boolean is true
            }
            if(cpuOver && userOver){ //if both players went over
              System.out.println("You and the computer both went over 21, it's a tie!"); //print result
            }
            else if(cpuOver){ //if cpu went over
              System.out.println("You have won! Congratulations!"); //print result
            }
            else if(userOver){ //if user went over
              System.out.println("You have lost. Better luck next time!"); //print result
            }
            else if(sumCards() > fSum){ //if user sum > cpu sum
              System.out.println("You have won the game! Good Job!"); //print result
            }
            else if(fSum > sumCards()){ //if cpu sum > user sum
              System.out.println("The computer have won the game, better luck next time!"); //print result
            }
            else{ //otherwise
              System.out.println("What a coincidence, you have tied the computer!"); //print result
            }
            System.out.println("Do you wish to continue playing?(Y/N)"); //Asks user if the wish to continue playing
            String playAgainAnswer = input.next().substring(0,1); //Reads and stores user input on whether or not they wish to continue playing
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
        }while(wishToPlay); //runs the whole code again if the user wants to play again
        System.out.println("--------GAME OVER--------");
        input.close();
    }
    public static void dealCards() { //deals 2 cards to cpu and user
      for(int i = 0; i < 2; i++){ //runs twice
        userCards[i] = cards[lastIndex]; //assigns card from deck to user deck
        cards[lastIndex] = -1; //set the assigned card to an invalid number - takes the place of the vacated card presumably given to someone in a real-world scenario
        lastIndex--; //minus 1 from last index
        userCardsIndex++; //add 1 to user deck index
        computerCards[i] = cards[lastIndex]; //assigns card from deck to cpu deck
        cards[lastIndex] = -1; //set the assigned card to an invalid number - takes the place of the vacated card presumably given to someone in a real-world scenario
        lastIndex--; //minus 1 from last index
        cpuCardsIndex++; //add 1 to cpu deck index
      } 
    }
    public static void giveMoreCards(int target){ //deals another card to the player
        if(target==0){ //if target is 0
            userCards[userCardsIndex] = cards[lastIndex]; //assigns card from deck to user deck
            cards[lastIndex] = -1; //set the assigned card to an invalid number - takes the place of the vacated card presumably given to someone in a real-world scenario
            lastIndex--; //minus 1 from last index
            userCardsIndex++; //add 1 to user deck index               
        }
        else{
            computerCards[cpuCardsIndex] = cards[lastIndex]; //assigns card from deck to cpu deck
            cards[lastIndex] = -1; //set the assigned card to an invalid number - takes the place of the vacated card presumably given to someone in a real-world scenario
            lastIndex--; //minus 1 from last index
            cpuCardsIndex++; //add 1 to cpu deck index                   
        }
    }
    public static void assignCards(){ //assigns the initial values of the deck of cards
        int cardValue = 1; //value held inside the array
        int counter = 0; //index of the array of cards
        for(int i = 0; i < 13; i++){ //runs for each type of card
            for(int j = 0; j < 4; j++) { //runs 4 times for each type of card
                cards[counter] = cardValue; //element in array is set to the card value
                counter++; //add 1 to counter
            }
            cardValue++; //add 1 to value held inside the array 
        }
        shuffle(); //shuffles deck by calling the method
    }
    public static void shuffle() { //method created to shuffle the deck
        int rng1, rng2; //declare integers
        int temp = 0; //declare temp variable
        for(int i = 0; i < 100; i++) { //runs 100 times
          rng1 = (int) (Math.random() * 52); //generates an integer from o to 51
          rng2 = (int) (Math.random() * 52); //generates an integer from o to 51
          temp = cards[rng1]; //declare temp as first num
          cards[rng1] = cards[rng2]; //swap
          cards[rng2] = temp; //assign second num as temp
        }
    }
    public static void showCards(int target){ //create method to show cards
      if(target==0){ //if target is 0
        System.out.println("These are your cards: "); //print that these are the user's cards
        for(int i = 0; i < userCards.length; i++){ //runs for the length of the array
            if(userCards[i]==1 || userCards[i] == 14){ //if it is 11 or 14
                System.out.print("A "); //print ace
            }
            else if(userCards[i]>1 && userCards[i]<11){ //if it is a regular number
                System.out.print(userCards[i] + " "); //print the number
            }
            else if(userCards[i]>10){ //if it is greater than 10
                if(userCards[i]==11){ //if it is 11
                    System.out.print("J "); //print jack
                }
                else if(userCards[i]==12){ //if it is 12
                    System.out.print("Q "); //print queen
                }
                else if(userCards[i]==13){ //if it is 13
                    System.out.print("K "); //print king
                }
            }
        }
        System.out.println(); //print blank line
      }
      else if (target==1){ //if target is 1
        System.out.println("These are the computer's cards: "); //print that these are the cpu's cards
        for(int i = 0; i < computerCards.length; i++){ //runs for the length of the array
            if(computerCards[i]==1){ //if it is 11 or 14
                  System.out.print("A "); //print ace
            } 
            else if(computerCards[i]>1 && computerCards[i]<11){ //if it is a regular number
                System.out.print(computerCards[i] + " "); //print the number
            } 
            else if(computerCards[i]>10){ //if it is greater than 10
                if(computerCards[i]==11){ //if it is 11
                    System.out.print("J "); //print jack
                } 
                else if(computerCards[i]==12){ //if it is 12
                    System.out.print("Q "); //print queen
                } 
                else if(computerCards[i]==13){ //if it is 13
                    System.out.print("K "); //print king
                }
            }
        }
        System.out.println(); //print blank line
      }
    }
    public static int sumCards(){ //finds the total of all of the user's cards
        int sum = 0; //have a variable sum that only exists in this method
        for(int i = 0; i < userCards.length; i++){ //run for length of the array
            if( userCards[i] > 10 && userCards[i] < 14){ //if its a royal card, we know it worths 10
                sum = sum + 10; //add 10 to sum
            }
            else if( userCards[i] == 14 ){ //if its a 14, we know its an ace that got converted to a value of 11
                sum = sum + 11; //add 11 to sum
            }
            else{
                sum = sum + userCards[i]; //if its none of the above, add the card's value to the sum
            }
        }
        return sum;    //returns the sum of user's cards
    }
    public static int cpuSumAceSwitch (int amount, int sum){ //this function asks for the sum of the card values that are not aces and the number of aces
        if( sum > 21){ //if the sum is over 21 before any ace is added, it definetly went over and returns -1
            return -1;            
        }
        if( amount == 0){ //if the amount of ace is 0, then the sum can't be changed anyways
            return sum;
        }
        int chooseOne = cpuSumAceSwitch( amount - 1, sum + 1);  //finds the value that would result if we convert an ace to  1
        int chooseEle = cpuSumAceSwitch( amount - 1, sum + 11); //finds the value that would result if we convert an ace to 11
        return Math.max(chooseOne, chooseEle); //since the value will be really small if it went over 21 ( -1 ) we just find the maximum sum between choosing 1 and choosing 11
    }
    public static void userAceSwitch(){ //this function allows the user to determine the value of any aces
        for(int i = 0; i < userCards.length; i++){ //go through every card the user has
            if(userCards[i] == 1 || userCards[i] == 14){ //if the card has a value of 1 or converted 11 ( which we know are aces)
                System.out.println("You can choose the value of your ace: 1 or 11?"); //prompt the user to reset the value of that ace
                String changeAce = input.next(); //read and store input
                while(!changeAce.equals("1") && !changeAce.equals("11")){ //if the input is invalid we tell the user to enter again
                    System.out.println("You can't make it that value!"); //print statement
                    changeAce = input.next(); //reread and store user input
                }
                if(changeAce.equals("11")){ //if the user sets the value to 11, 
                    changeAce = "14"; //we store it as 14 to avoid confusion with jack
                }
                int intChangeAce = Integer.parseInt(changeAce); //convert integer to String
                userCards[i] = intChangeAce; //sets the value of that changed ace according to the user's input
            }
        }
    }
    public static boolean cpuTake(int value){ //this method returns whether or not the computer should take another card knowing the sum of its current cards
        if( value >= 19){ //if the current sum is greater or equal to 19, its too risky and the computer should not take another card
            return false;
        }
        else if( value >= 12){ //the computer will have a random decider to help decide whether or not it should take a card
            if( 21-value + Math.random()*10 > 11){ //the computer's sum of cards will also help to decide, so that the greater the value the less likely it will take the risk
                return true; //if these 2 value added together is greater than 11 it will take a card or else it will now
            }
            else{                        
                return false;
            }      
        }
        else{
            return true;     // or else if the current sum is less than 12 then the computer should definetly take a card
        }
    }  
}
