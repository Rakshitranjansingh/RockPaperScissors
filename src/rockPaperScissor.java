import java.util.Random;

public class rockPaperScissor {
    //all the choices for that a computer can choose
    private static final String[] computerChoices={"Rock", "Paper","Scissors"};

    public String getComputerChoice() {
        return computerChoice;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    private String computerChoice;
    private int computerScore, playerScore;
    //random to generate the randomly generated computer choice
    private Random random;

    //constructor to initialize the random object
    public rockPaperScissor(){
        random=new Random();
    }

    //main function to call and play game
    public String playRockPaperScissor(String playerChoice){
        //generate the computer choice
        computerChoice=computerChoices[random.nextInt(computerChoices.length)];

        String result;

        //find the result
        if(computerChoice.equals("Rock")){
            if(playerChoice.equals("Paper")){
                result="Player Wins";
                playerScore++;
            }else if(playerChoice.equals("Scissors")){
                result="Computer Wins";
                computerScore++;
            }else{
                result="Draws";
            }
        } else if(computerChoice.equals("Paper")){
            if(playerChoice.equals("Scissors")){
                result="Player Wins";
                playerScore++;
            }else if(playerChoice.equals("Rock")){
                result="Computer Wins";
                computerScore++;
            }else{
                result="Draws";
            }
        } else {
            //computer choice is scissors
            if(playerChoice.equals("Rock")){
                result="Player Wins";
                playerScore++;
            }else if(playerChoice.equals("Paper")){
                result="Computer Wins";
                computerScore++;
            }else{
                result="Draws";
            }
        }
        return result;
    }


}
