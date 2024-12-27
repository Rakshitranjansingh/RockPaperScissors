import javax.swing.*;

public class Main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //instantiate the RockPaperScissors GUI
                RockPaperScissorGUI rockPaperScissorGUI=new RockPaperScissorGUI();

                //Display The GUI
                rockPaperScissorGUI.setVisible(true);


            }
        });
    }
}