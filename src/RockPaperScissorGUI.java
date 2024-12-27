import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissorGUI  extends JFrame implements ActionListener {
    //plays button
    JButton rockButton, paperButton, scissorButton,rulesButton;

    //computer choice
    JLabel computerChoice;


    JLabel computerScoreLabel, playersScoreLabel;


    //create the main game object to use here
    rockPaperScissor RockPaperScissors=new rockPaperScissor();



    public RockPaperScissorGUI(){
        //invoke JFrame and give heading to the GUI
        super("Rock, Paper, Scissors");

        //set the size of the GUI
        setSize(450, 574);


        //set layout to Null so that we can use the easy layout management and simple set x and y
        setLayout(null);

        //load the GUI in the center of the Screen everytime we run the GUI
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //add GUI component
        addGUIComponents();
    }

    public void addGUIComponents(){


        //create computer score label
        computerScoreLabel=new JLabel("Computer:0");

        //set x, y and height/width of the above score
        computerScoreLabel.setBounds(0, 43, 450 , 30);

        //set the fount and format for the score
        computerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));

        // place the text in the center
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // add to GUI
        add(computerScoreLabel);

        //create computer choice
        computerChoice=new JLabel("@@");
        computerChoice.setBounds(175, 118, 98, 81);
        computerChoice.setFont(new Font("Dialog", Font.PLAIN, 18));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);

        //create a black boarder around it
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.black));
        add(computerChoice);

        //add for players
        playersScoreLabel=new JLabel("NinjaPlayer:0");
        playersScoreLabel.setBounds(0,290,450, 30);
        playersScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
        playersScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playersScoreLabel);

        //rockButton
        rockButton=new JButton("Rock");
        rockButton.setBounds(40,387, 105, 81);
        rockButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        rockButton.addActionListener(this);
        add(rockButton);

        //paperButton
        paperButton= new JButton("Paper");
        paperButton.setBounds(175,387, 105, 81);
        paperButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        paperButton.addActionListener(this);
        add(paperButton);

        //scissorButton
        scissorButton= new JButton("Scissors");
        scissorButton.setBounds(305,387, 105, 81);
        scissorButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        scissorButton.addActionListener(this);
        add(scissorButton);

        //Rules for the game
        rulesButton= new JButton("Rules");
        rulesButton.setBounds(175,0, 60, 30);
        rulesButton.setFont(new Font("Dialog", Font.BOLD, 9));
        rulesButton.addActionListener(this);
        rulesButton.setBackground(Color.GREEN);
        add(rulesButton);

//        showDialog("test Message");
    }
    private void showRules(){
        JDialog rulesDialog=new JDialog(this, "Rules", true);
        rulesDialog.setSize(400,350);
        rulesDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        rulesDialog.setResizable(true);
        String message="<html> Rock win, Scissors lose; <br> Scissors win, Paper lose; <br> Paper win, Rock lose; <br> when both same it is Draw! </html>";
        JLabel rule=new JLabel(message);
        rule.setFont(new Font("Dialog", Font.BOLD, 18));
        rule.setHorizontalAlignment(SwingConstants.CENTER);
        rulesDialog.add(rule, BorderLayout.CENTER);

        rulesDialog.setLocationRelativeTo(this);
        rulesDialog.setVisible(true);
    }

    private void showDialog(String message){
        JDialog resultDialog= new JDialog(this, "Result", true);
        resultDialog.setSize(227,120);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);

        //message label
        JLabel resultLabel=new JLabel(message);
        resultLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultLabel, BorderLayout.CENTER);

        //try Again Button
        JButton tryAgainButton=new JButton("try Again?");
        tryAgainButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //reset computer choice
                computerChoice.setText("?");

                //close dialog box
                resultDialog.dispose();
            }
        });

        resultDialog.add(tryAgainButton, BorderLayout.SOUTH);

        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //get playersChoice
        String playerChoice=e.getActionCommand();

        if(playerChoice.equals("Rules")){
            showRules();
        }else{
            //store the result for playing the game
            String result = RockPaperScissors.playRockPaperScissor(playerChoice);

            //load computer choice
            computerChoice.setText(RockPaperScissors.getComputerChoice());

            //update scores
            computerScoreLabel.setText("Computer: "+ RockPaperScissors.getComputerScore());
            playersScoreLabel.setText("NinjaPlayer: "+RockPaperScissors.getPlayerScore());

            showDialog(result);
        }


    }
}
