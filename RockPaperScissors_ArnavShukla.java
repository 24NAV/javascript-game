import java.util.Scanner;

/**
 *
 * @author Arnav Shukla
 * Section 002
 * 
 */
public class RockPaperScissors_ArnavShukla{
    
    //These are class constants (all methods in the class can see them). DO NOT CHANGE THEM!
    static final int ROCK = 123, PAPER = 124, SCISSORS = 125, YOU_WIN = 201, COMP_WIN = 202, DRAW = 203;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userInput;
        int yourScore=0, compScore=0;
        int currentResult;

        System.out.println("========================");
        System.out.println("ROCK-PAPER-SCISSORS GAME");
        System.out.println("========================");
        System.out.println("\n Let's get started!");

        do {
            //calling the playOneGame method
            currentResult = playOneGame(scan);
            
            if (currentResult == YOU_WIN)
                yourScore++;
            else if(currentResult == COMP_WIN)
                compScore++;
                
            printScores(yourScore,compScore);//printing the score
            
            System.out.print("Do you wish to play again? (y or n): ");
            userInput = scan.next();

        } while (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes"));
        
        System.out.println("========GAME OVER=======");
        System.out.println("       FINAL_SCORE:");
        printScores(yourScore,compScore);//printing the final score
    }


    /**
    This method "plays" the game.
    The input parameter is the Scanner object created in main()
    The method returns the int result of the game -- it should be one of the CONSTANTS!
    */
    private static int playOneGame(Scanner scan) {
        int yourChoice, compChoice;
        
        //===================== These are just temporary.
        yourChoice = ROCK; // REMOVE THESE LINES ONCE YOU
        compChoice = ROCK; // START WORKING ON THE PROGRAM.
        //======================
        
        //1. Prompt the user and use scan to read her input (R, P, or S)
        //...
        System.out.print("Rock,Paper,or Scissors (R,P,S):");
        String userChoice = scan.next();

        
        //2. Use a while loop to continue asking for user input if it is not 
        // one of the three above ("r", "p", or "s", ignoring case) 
        //...
        while(!userChoice.equalsIgnoreCase("r")&&!userChoice.equalsIgnoreCase("p")&&!userChoice.equalsIgnoreCase("s")){
         System.out.println("ZZZZZRRTTT!Sorry,that entry is invalid.\nTry again.");   
         System.out.println("Rock,Paper,or Scissors (R,P,S):");
         userChoice = scan.next();
        }

        
        //3. Once the user input is satisfactory 
        //print out the choice (e.g. "You chose Rock!"),
        //translate it to one of the int constants (ROCK, PAPER, or SCISSORS),
        //and assign to yourChoice variable (e.g. yourChoice = ROCK)
        //...
        if (userChoice.equalsIgnoreCase("r")) {
            System.out.println("You chose Rock!");
            yourChoice = ROCK;
        }
        
        else if(userChoice.equalsIgnoreCase("p")) {
            System.out.println("You chose Paper!");
            yourChoice = PAPER;
        }
        
        else{
            System.out.println("You chose Scissors!");
            yourChoice =SCISSORS;
            
        }

        
        //4. Use Math.random() to randomly generate computer's choice
        //One way to do it: split the range between 0 and 1 into
        // three equal intervals and if the random number is in one of them
        // assign a corresponding constant to compChoice. There are other ways to do it.
        //Print out computer's choice as well.
        //...
        int comp= (int)(Math.random()*3)+1;
        if (comp==1){
            System.out.println("Computer chose Rock!");
            compChoice=ROCK;
        }
        
        else if(comp ==2){
            System.out.println("Computer chose Paper!");
            compChoice=PAPER;
        }
        
        else {
            System.out.println("Computer chose Scissors!");
            compChoice=SCISSORS;
            
        }

        
        //Call the method whoWins using yourChoice and compChoice as parameters
        int gameResult = whoWins(yourChoice, compChoice);      
        
        //return the game result to main() (just re-returning the results from whoWins):
        return gameResult;
    }


    /**
    This method takes two int parameters yourChoice and compChoice,
    and returns the result of the game.
    
    It will return YOU_WIN if you win, COMP_WIN if computer wins 
    and DRAW if it is a draw. (Remember, these are constants defined in this class)
    
    In addition, the method prints out the corresponding description of
    the result of the game e.g. "It's a draw!!", 
    or "Scissors cut Paper! You WIN!".
    or "Rock is covered by Paper! You lose :(", and so on.
    */
    private static int whoWins(int yourChoice, int compChoice) {
       if (yourChoice == ROCK){
           if(compChoice == PAPER){
            System.out.println("Rock is covered by Paper! you lose :(");
            return COMP_WIN;
       } 
       else if (compChoice == SCISSORS){
            System.out.println("Rock breaks the scissors! you win :)");
               return YOU_WIN;
       }
       }
       else if (yourChoice == PAPER){
            if(compChoice == ROCK){
            System.out.println("Rock is covered by Paper! you win :)");
            return YOU_WIN;
       }     
       else if (compChoice == SCISSORS){
               System.out.println("scissors cut paper! you lose :(");
               return COMP_WIN;
       }
       }
       else if (yourChoice == SCISSORS){
            if(compChoice == ROCK){
            System.out.println("Rock breaks scissors! you lose :(");
            return COMP_WIN;
       } 
       else if (compChoice == PAPER){
              System.out.println(" scissors cut paper ! you win :)");
              return YOU_WIN;
       }
       }
     
            System.out.println("It's a draw!!");
            return DRAW;
        }

        

    /**
    This method takes in yourScore and compScore as parameters and prints
    them out in a formatted way, as shown in the project description.
    */
    private static void printScores(int yourScore, int compScore) {
        System.out.printf("%s:%s\n","You","Comp");
        System.out.print("SCORE:-------");
        System.out.printf("\n|%d:%d|\n",yourScore, compScore);
        System.out.print("----------\n");
  
    }

}