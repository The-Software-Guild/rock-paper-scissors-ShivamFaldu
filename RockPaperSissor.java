package Assignment;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RockPaperSissor {
    Scanner scanner = new Scanner(System.in);
    public static void main (String [] args){
        RockPaperSissor game = new RockPaperSissor();
        game.mainGame();

    }
    public void mainGame (){
        Boolean wants_To_Play= true;
        int max_Round ;
        int num_Of_Ties = 0;
        int user_Wins = 0;
        int comp_Wins = 0;
        String user_Choice;
        String comp_Choice;

        System.out.println("Welcome to Rock, Paper, Scissors");
        while (wants_To_Play){
            System.out.println("Lets play a game! How many round you wana go?");
            max_Round = numberOfRounds();

            for (int i = 0; i <max_Round ; i++) {
                System.out.println("Round "+(i+1));
                user_Choice= userChooseOption();
                comp_Choice = compChooseOptions();

                //Check againts all possible combinations with rock
                if(user_Choice.equals("rock")){
                    if (comp_Choice.equals("rock")){
                        num_Of_Ties++;
                        System.out.println("Thats a tie");
                    }else if (comp_Choice.equals("paper")){
                        comp_Wins++;
                        System.out.println("Computer wins that round");
                    }else if(comp_Choice.equals("scissors")){
                        user_Wins++;
                        System.out.println("User wins that round");
                    }

                }else if (user_Choice.equals("paper")){
                    if(comp_Choice.equals("rock")){
                        user_Wins++;
                        System.out.println("User wins that round");
                    }else if(comp_Choice.equals("paper")){
                        num_Of_Ties++;
                        System.out.println("Thats a tie");
                    }else if(comp_Choice.equals("scissors")){
                        comp_Wins++;
                        System.out.println("Computer wins that round");
                    }

                }else if (user_Choice.equals("scissors")){
                    if(comp_Choice.equals("rock")){
                        comp_Wins++;
                        System.out.println("Computer won that round");
                    }else if(comp_Choice.equals("paper")){
                        user_Wins++;
                        System.out.println("User won that round");
                    }else if(comp_Choice.equals("scissors")){
                        num_Of_Ties++;
                        System.out.println("That was a tie");
                    }
                }
            }
            System.out.println("Game Over");
            System.out.println("");
            System.out.println("Number of Ties: "+ num_Of_Ties);
            System.out.println("");
            System.out.println("Number of Wins for User: "+ user_Wins );
            System.out.println("");
            System.out.println("Number of Wins for the Computer "+ comp_Wins);
            System.out.println("");

            if (user_Wins>comp_Wins){
                System.out.println("The User has won....FOR FREEEEEDOMMM");
                System.out.println("");
            }else if (user_Wins<comp_Wins){
                System.out.println("The computer has won.....Skynet initiated!");
                System.out.println("");
            }else {
                System.out.println("There were no winners here today");
                System.out.println("");
            }
            System.out.println("Do you wish to test your metal again? Yes/No");
            String answer = scanner.nextLine().toLowerCase();

            while (!answer.equals("yes") && !answer.equals("no")){
                System.out.println("Sorry that is not a valid input....Choose Yes OR No");
                try {
                    answer = scanner.nextLine().toLowerCase();
                }catch (Exception ex){
                    answer = "";
                }
            }
            if(answer.equals("no")){
                wants_To_Play = false;
                System.out.println("Thank you for playing");
            }else {
                num_Of_Ties=0;
                user_Wins=0;
                comp_Wins=0;
            }
        }
    }


    //Method to determine how many rounds the user wants to play
    public int numberOfRounds (){
        int number_Of_Rounds=0;
        System.out.println("Choose a number between 1-10");
        try {
            number_Of_Rounds = Integer.parseInt(scanner.nextLine());
        }catch (Exception ex){
            number_Of_Rounds=0;
        }

        //This while loop runs if the users guess is not within the range and will keep running until the guess is within the range
        while (number_Of_Rounds<1 || number_Of_Rounds>10){
            System.out.println("Sorry thats not a valid input");
            System.out.println("Choose a number between 1-10");
            try {
                number_Of_Rounds = Integer.parseInt(scanner.nextLine());
            }catch (Exception ex){
                number_Of_Rounds=0;
            }

        }
        return number_Of_Rounds;
    }


    //Method to let the user choose their option
    public String userChooseOption (){
        //Hashset acts as a reference to check whether the input was valid
        Set<String> valid_Option = new HashSet<>();
        valid_Option.add("rock");
        valid_Option.add("paper");
        valid_Option.add("scissors");

        System.out.println("Please Choose Rock, Paper or Scissors");
        String temp_Choice = scanner.nextLine().toLowerCase();

        //if the users input is not within the given choices, the while loop will run until the correct choice has been achieved
        while (!valid_Option.contains(temp_Choice)){
            System.out.println("Sorry that's an invalid choice, please try again");
            System.out.println("Your choices are: Rock, Paper, Scissor");
            temp_Choice = scanner.nextLine().toLowerCase();
        }
        return temp_Choice;
    }


    //Method to determine the Computers choice
    public String compChooseOptions (){
        String [] choices = {"rock","paper","scissors"};
        int rand_Num = (int) (Math.random()*3);
        String temp_Comp_Choice = choices[rand_Num];
        return temp_Comp_Choice;
    }

}
